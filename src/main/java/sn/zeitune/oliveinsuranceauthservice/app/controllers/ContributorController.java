package sn.zeitune.oliveinsuranceauthservice.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ContributorRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.ContributorResponse;
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
}
