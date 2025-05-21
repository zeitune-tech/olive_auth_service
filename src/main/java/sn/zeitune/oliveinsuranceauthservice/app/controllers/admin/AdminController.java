package sn.zeitune.oliveinsuranceauthservice.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.AdminRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.AdminResponse;
import sn.zeitune.oliveinsuranceauthservice.app.services.AdminService;
import sn.zeitune.oliveinsuranceauthservice.app.specifications.AdminSpecifications;

import java.util.UUID;

@RestController
@RequestMapping("/api/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

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
