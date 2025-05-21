package sn.zeitune.oliveinsuranceauthservice.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.RestrictionRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.RestrictionResponse;
import sn.zeitune.oliveinsuranceauthservice.app.services.RestrictionService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/app/restrictions")
@RequiredArgsConstructor
public class RestrictionController {

    private final RestrictionService restrictionService;


    @PostMapping("/employee/{employeeUuid}")
    public ResponseEntity<RestrictionResponse> createRestriction(
            @PathVariable UUID employeeUuid,
            @RequestBody RestrictionRequest request
    ) {
        RestrictionResponse response = restrictionService.createRestriction(employeeUuid, request);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{uuid}")
    public ResponseEntity<RestrictionResponse> updateRestriction(
            @PathVariable UUID uuid,
            @RequestBody RestrictionRequest request
    ) {
        RestrictionResponse response = restrictionService.updateRestriction(uuid, request);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteRestriction(@PathVariable UUID uuid) {
        restrictionService.deleteRestriction(uuid);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<RestrictionResponse> getRestriction(@PathVariable UUID uuid) {
        RestrictionResponse response = restrictionService.getRestrictionByUuid(uuid);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/employee/{employeeUuid}")
    public ResponseEntity<List<RestrictionResponse>> getRestrictionsByEmployee(@PathVariable UUID employeeUuid) {
        List<RestrictionResponse> restrictions = restrictionService.getRestrictionsByEmployee(employeeUuid);
        return ResponseEntity.ok(restrictions);
    }
}
