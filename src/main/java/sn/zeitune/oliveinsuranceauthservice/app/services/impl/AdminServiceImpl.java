package sn.zeitune.oliveinsuranceauthservice.app.services.impl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.AdminRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.AdminResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Admin;
import sn.zeitune.oliveinsuranceauthservice.app.enums.UserRole;
import sn.zeitune.oliveinsuranceauthservice.app.mappers.AdminMapper;
import sn.zeitune.oliveinsuranceauthservice.app.repositories.AdminRepository;
import sn.zeitune.oliveinsuranceauthservice.app.repositories.UserRepository;
import sn.zeitune.oliveinsuranceauthservice.app.services.AdminService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void init() {
        Admin adminUser = Admin.builder()
                .firstname("Admin")
                .lastname("Admin")
                .email("admin@zeitune.com")
                .role(UserRole.ADMIN)
                .password(passwordEncoder.encode("P@sser123"))
                .build();

        if (userRepository.findByEmail(adminUser.getEmail()).isPresent()) {
            return;
        }
        userRepository.save(adminUser);
    }

    @Override
    public AdminResponse createAdmin(AdminRequest request) {
        Admin admin = AdminMapper.map(request, null);
        admin = adminRepository.save(admin);
        return AdminMapper.map(admin);
    }

    @Override
    public AdminResponse updateAdmin(UUID uuid, AdminRequest request) {
        Admin admin = adminRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Admin not found for UUID: " + uuid));
        AdminMapper.map(request, admin);
        admin = adminRepository.save(admin);
        return AdminMapper.map(admin);
    }


    @Override
    public AdminResponse getAdminByUuid(UUID uuid) {
        Admin admin = adminRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Admin not found for UUID: " + uuid));
        return AdminMapper.map(admin);
    }

    @Override
    public Page<AdminResponse> searchAdmins(Specification<Admin> spec, Pageable pageable) {
        return adminRepository.findAll(spec, pageable)
                .map(AdminMapper::map);
    }
}
