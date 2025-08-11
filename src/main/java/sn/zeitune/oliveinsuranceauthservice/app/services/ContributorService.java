package sn.zeitune.oliveinsuranceauthservice.app.services;

import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ContributorRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.ContributorResponse;

import java.util.List;
import java.util.UUID;

public interface ContributorService {

    ContributorResponse create(ContributorRequest request, UUID managementEntity);
    ContributorResponse getByUuid(UUID uuid);
     List<ContributorResponse> getAll(UUID managementEntity);
     void delete(UUID uuid);
}
