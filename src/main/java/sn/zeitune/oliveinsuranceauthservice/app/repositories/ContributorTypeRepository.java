package sn.zeitune.oliveinsuranceauthservice.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Contributor;
import sn.zeitune.oliveinsuranceauthservice.app.entities.ContributorType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContributorTypeRepository extends JpaRepository<ContributorType, Long>, JpaSpecificationExecutor<ContributorType> {

    Optional<ContributorType> findByUuid(UUID uuid);
    List<ContributorType> findByManagementEntity(UUID managementEntity);

}
