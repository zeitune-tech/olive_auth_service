package sn.zeitune.oliveinsuranceauthservice.app.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ProfileRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.PermissionResponse;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.ProfileResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Employee;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Permission;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Profile;
import sn.zeitune.oliveinsuranceauthservice.app.services.ProfileService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/app/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;


    @GetMapping("/permissions")
    public ResponseEntity<List<PermissionResponse>> getPermissions(
            Authentication authentication
    ) {
        Employee employee = (Employee) authentication.getPrincipal();
        Optional<Profile> profile = employee.getProfiles().stream().findFirst();
        if (profile.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Permission> permission = profile.get().getPermissionsList().stream().findFirst();
        return permission.map(value -> ResponseEntity.ok(profileService.getPermissions(
                value.getType()
        ))).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping
    public ResponseEntity<ProfileResponse> create(
            @Valid @RequestBody ProfileRequest request,
            Authentication authentication
    ) {
        Employee employee = (Employee) authentication.getPrincipal();
        return ResponseEntity.ok(profileService.create(request, employee.getManagementEntity()));
    }


    @PutMapping("/{uuid}")
    public ResponseEntity<ProfileResponse> update(
            @PathVariable UUID uuid,
            @RequestBody ProfileRequest request
    ) {
        return ResponseEntity.ok(profileService.update(uuid, request));
    }


    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        profileService.delete(uuid);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<ProfileResponse> getByUuid(@PathVariable UUID uuid) {
        return ResponseEntity.ok(profileService.getByUuid(uuid));
    }


    @GetMapping
    public ResponseEntity<List<ProfileResponse>> getAll(
            Authentication authentication
    ) {
        return ResponseEntity.ok(profileService.getAll(
                ((Employee) authentication.getPrincipal()).getManagementEntity()
        ));
    }


    @GetMapping("/paged")
    public ResponseEntity<Page<ProfileResponse>> getAllPaged(Pageable pageable) {
        return ResponseEntity.ok(profileService.getAll(pageable));
    }


    @GetMapping("/management-entity/{managementEntity}")
    public ResponseEntity<List<ProfileResponse>> getAllByManagementEntity(
            @PathVariable UUID managementEntity
    ) {
        return ResponseEntity.ok(profileService.getAllByManagementEntity(managementEntity));
    }


    @GetMapping("/management-entity/{managementEntity}/paged")
    public ResponseEntity<Page<ProfileResponse>> getAllByManagementEntityPaged(
            @PathVariable UUID managementEntity,
            Pageable pageable
    ) {
        return ResponseEntity.ok(profileService.getAllByManagementEntity(managementEntity, pageable));
    }
}
