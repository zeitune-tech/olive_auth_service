package sn.zeitune.oliveinsuranceauthservice.app.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ContributorRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ContributorTypeRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.ContributorResponse;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.ContributorTypeResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Contributor;
import sn.zeitune.oliveinsuranceauthservice.app.entities.ContributorType;
import sn.zeitune.oliveinsuranceauthservice.app.mappers.ContributorMapper;
import sn.zeitune.oliveinsuranceauthservice.app.repositories.ContributorRepository;
import sn.zeitune.oliveinsuranceauthservice.app.repositories.ContributorTypeRepository;
import sn.zeitune.oliveinsuranceauthservice.app.services.ContributorService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ContributorServiceImpl implements ContributorService {

    private final ContributorRepository contributorRepository;
    private final ContributorTypeRepository contributorTypeRepository;

    @Override
    public ContributorResponse create(ContributorRequest request, UUID managementEntity) {
        Contributor contributor = ContributorMapper.map(request);
        contributor.setManagementEntity(managementEntity);
        Contributor savedContributor = contributorRepository.save(contributor);
        return ContributorMapper.map(savedContributor);
    }

    @Override
    public ContributorResponse getByUuid(UUID uuid) {
        return contributorRepository.findByUuid(uuid)
                .map(ContributorMapper::map)
                .orElseThrow(() -> new RuntimeException("Contributor not found"));
    }

    @Override
    public List<ContributorResponse> getAll(UUID managementEntity) {
        return contributorRepository.findByManagementEntity(managementEntity)
                .stream()
                .map(ContributorMapper::map)
                .toList();
    }

    @Override
    public ContributorTypeResponse createContributorType(ContributorTypeRequest request, UUID managementEntity) {
        // Assuming ContributorType is a valid entity and ContributorTypeMapper exists
        ContributorType contributorType = ContributorType.builder()
                .label(request.label())
                .build();
        contributorType.setManagementEntity(managementEntity);

        ContributorType savedContributorType = contributorTypeRepository.save(contributorType);

        return ContributorTypeResponse.builder()
                .id(savedContributorType.getUuid())
                .label(savedContributorType.getLabel())
                .build();
    }

    @Override
    public ContributorTypeResponse updateContributorType(ContributorTypeRequest request, UUID managementEntity, UUID uuid) {
        ContributorType contributorType = contributorTypeRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Contributor Type not found"));

        contributorType.setLabel(request.label());
        contributorType.setManagementEntity(managementEntity);

        ContributorType updatedContributorType = contributorTypeRepository.save(contributorType);

        return ContributorTypeResponse.builder()
                .id(updatedContributorType.getUuid())
                .label(updatedContributorType.getLabel())
                .build();
    }

    @Override
    public ContributorTypeResponse getContributorTypeByUuid(UUID uuid) {
        return contributorTypeRepository.findByUuid(uuid)
                .map(contributorType -> ContributorTypeResponse.builder()
                        .id(contributorType.getUuid())
                        .label(contributorType.getLabel())
                        .build())
                .orElseThrow(() -> new RuntimeException("Contributor Type not found"));
    }

    @Override
    public List<ContributorTypeResponse> getAllContributorTypes(UUID managementEntity) {
        return contributorTypeRepository.findByManagementEntity(managementEntity)
                .stream()
                .map(contributorType -> ContributorTypeResponse.builder()
                        .id(contributorType.getUuid())
                        .label(contributorType.getLabel())
                        .build())
                .toList();
    }

    @Override
    public void delete(UUID uuid) {
        Contributor contributor = contributorRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Contributor not found"));
        contributorRepository.delete(contributor);
    }
}
