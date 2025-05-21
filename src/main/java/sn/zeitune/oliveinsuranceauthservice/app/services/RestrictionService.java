package sn.zeitune.oliveinsuranceauthservice.app.services;

import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.RestrictionRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.RestrictionResponse;

import java.util.List;
import java.util.UUID;

public interface RestrictionService {

    RestrictionResponse createRestriction(UUID employeeUuid, RestrictionRequest request);

    RestrictionResponse updateRestriction(UUID uuid, RestrictionRequest request);

    void deleteRestriction(UUID uuid);

    RestrictionResponse getRestrictionByUuid(UUID uuid);

    List<RestrictionResponse> getRestrictionsByEmployee(UUID employeeUuid);
}
