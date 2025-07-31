package sn.zeitune.oliveinsuranceauthservice.app.services;

import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ContributorRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ContributorTypeRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.ContributorResponse;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.ContributorTypeResponse;

import java.util.List;
import java.util.UUID;

public interface ContributorService {

    ContributorResponse create(ContributorRequest request, UUID managementEntity);
    ContributorResponse getByUuid(UUID uuid);
     List<ContributorResponse> getAll(UUID managementEntity);

     ContributorTypeResponse createContributorType(ContributorTypeRequest request, UUID managementEntity);
     ContributorTypeResponse updateContributorType(ContributorTypeRequest request, UUID managementEntity, UUID uuid);
    ContributorTypeResponse getContributorTypeByUuid(UUID uuid);
    List<ContributorTypeResponse> getAllContributorTypes(UUID managementEntity);

     void delete(UUID uuid);
}
