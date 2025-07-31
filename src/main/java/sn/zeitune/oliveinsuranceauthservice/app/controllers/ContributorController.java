package sn.zeitune.oliveinsuranceauthservice.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ContributorRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ContributorTypeRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.ContributorResponse;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.ContributorTypeResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Employee;
import sn.zeitune.oliveinsuranceauthservice.app.services.ContributorService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/app/contributors")
@RequiredArgsConstructor
public class ContributorController {

    private final ContributorService contributorService;

    @GetMapping
    public ResponseEntity<List<ContributorResponse>> getAllContributors(Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.badRequest().build();
        }

        UUID managementEntity = ((Employee) authentication.getPrincipal()).getManagementEntity();
        List<ContributorResponse> contributors = contributorService.getAll(managementEntity);

        return ResponseEntity.ok(contributors);
    }

    @GetMapping("/types")
    public ResponseEntity<List<ContributorTypeResponse>> getAllContributorTypes(Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.badRequest().build();
        }

        UUID managementEntity = ((Employee) authentication.getPrincipal()).getManagementEntity();
        List<ContributorTypeResponse> contributorTypes = contributorService.getAllContributorTypes(managementEntity);

        return ResponseEntity.ok(contributorTypes);
    }

    @PostMapping
    public ResponseEntity<ContributorResponse> createContributor(
            Authentication authentication,
            @RequestBody ContributorRequest request
    ) {
        if (authentication == null) {
            return ResponseEntity.badRequest().build();
        }

        UUID managementEntity = ((Employee) authentication.getPrincipal()).getManagementEntity();
        ContributorResponse contributorResponse = contributorService.create(request, managementEntity);

        return ResponseEntity.ok(contributorResponse);
    }

    @PostMapping("/types")
    public ResponseEntity<ContributorTypeResponse> createContributorType(
            Authentication authentication,
            @RequestBody ContributorTypeRequest request
    ) {
        if (authentication == null) {
            return ResponseEntity.badRequest().build();
        }

        UUID managementEntity = ((Employee) authentication.getPrincipal()).getManagementEntity();
        ContributorTypeResponse contributorTypeResponse = contributorService.createContributorType(request, managementEntity);

        return ResponseEntity.ok(contributorTypeResponse);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ContributorResponse> getContributorByUuid(
            Authentication authentication,
            @PathVariable UUID uuid) {
        if (authentication == null) {
            return ResponseEntity.badRequest().build();
        }

        ContributorResponse contributorResponse = contributorService.getByUuid(uuid);

        return ResponseEntity.ok(contributorResponse);
    }

    @GetMapping("/types/{uuid}")
    public ResponseEntity<ContributorTypeResponse> getContributorTypeByUuid(
            Authentication authentication,
            @PathVariable UUID uuid) {
        if (authentication == null) {
            return ResponseEntity.badRequest().build();
        }

        ContributorTypeResponse contributorTypeResponse = contributorService.getContributorTypeByUuid(uuid);

        return ResponseEntity.ok(contributorTypeResponse);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteContributor(
            Authentication authentication,
            @PathVariable UUID uuid) {
        if (authentication == null) {
            return ResponseEntity.badRequest().build();
        }

        contributorService.delete(uuid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/types/{uuid}")
    public ResponseEntity<ContributorTypeResponse> updateContributorType(
            Authentication authentication,
            @PathVariable UUID uuid,
            @RequestBody ContributorTypeRequest request) {
        if (authentication == null) {
            return ResponseEntity.badRequest().build();
        }

        UUID managementEntity = ((Employee) authentication.getPrincipal()).getManagementEntity();
        ContributorTypeResponse updatedContributorType = contributorService.updateContributorType(request, managementEntity, uuid);

        return ResponseEntity.ok(updatedContributorType);
    }
}
