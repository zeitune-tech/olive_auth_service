package sn.zeitune.oliveinsuranceauthservice.app.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.AdminRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.AdminResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Admin;
import sn.zeitune.oliveinsuranceauthservice.app.mappers.AdminMapper;
import sn.zeitune.oliveinsuranceauthservice.app.services.AdminService;
import sn.zeitune.oliveinsuranceauthservice.app.specifications.AdminSpecifications;

import java.util.UUID;

@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/me")
    public ResponseEntity<AdminResponse> getMe(
            Authentication authentication
    ) {
        if (authentication == null) {
            return ResponseEntity.badRequest().build();
        }
        var user = (Admin) authentication.getPrincipal();
        return ResponseEntity.ok(
                AdminMapper.map(user)
        );
    }

    @PostMapping
    public ResponseEntity<AdminResponse> create(@RequestBody AdminRequest request) {
        return ResponseEntity.ok(adminService.createAdmin(request));
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<AdminResponse> update(
            @PathVariable UUID uuid,
            @RequestBody AdminRequest request
    ) {
        return ResponseEntity.ok(adminService.updateAdmin(uuid, request));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<AdminResponse> getByUuid(@PathVariable UUID uuid) {
        return ResponseEntity.ok(adminService.getAdminByUuid(uuid));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<AdminResponse>> searchAdmins(
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String email,
            Pageable pageable
    ) {
        var spec = AdminSpecifications.hasFirstname(firstname)
                .and(AdminSpecifications.hasLastname(lastname))
                .and(AdminSpecifications.hasEmail(email));

        return ResponseEntity.ok(adminService.searchAdmins(spec, pageable));
    }
}
