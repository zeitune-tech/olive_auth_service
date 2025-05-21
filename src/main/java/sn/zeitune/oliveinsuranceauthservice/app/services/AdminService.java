package sn.zeitune.oliveinsuranceauthservice.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.AdminRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.AdminResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Admin;

import java.util.UUID;

public interface AdminService {

    void init();
    AdminResponse createAdmin(AdminRequest request);
    AdminResponse updateAdmin(UUID uuid, AdminRequest request);
    AdminResponse getAdminByUuid(UUID uuid);
    Page<AdminResponse> searchAdmins(Specification<Admin> spec, Pageable pageable);
}