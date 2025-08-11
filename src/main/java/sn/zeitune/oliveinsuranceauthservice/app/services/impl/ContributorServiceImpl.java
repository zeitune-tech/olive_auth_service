package sn.zeitune.oliveinsuranceauthservice.app.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ContributorRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.UserRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.ContributorResponse;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.UserResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Contributor;
import sn.zeitune.oliveinsuranceauthservice.app.mappers.ContributorMapper;
import sn.zeitune.oliveinsuranceauthservice.app.repositories.ContributorRepository;
import sn.zeitune.oliveinsuranceauthservice.app.services.ContributorService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ContributorServiceImpl implements ContributorService {

    private final ContributorRepository contributorRepository;

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
    public void delete(UUID uuid) {
        Contributor contributor = contributorRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Contributor not found"));
        contributorRepository.delete(contributor);
    }
}
