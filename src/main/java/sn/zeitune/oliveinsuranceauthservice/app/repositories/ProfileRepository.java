package sn.zeitune.oliveinsuranceauthservice.app.repositories;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Profile;

import java.util.*;

public interface ProfileRepository extends JpaRepository<Profile, Long>, JpaSpecificationExecutor<Profile> {
    Optional<Profile> findByUuid(UUID uuid);
    List<Profile> findAllByManagementEntity(UUID managementEntity);
    Page<Profile> findAllByManagementEntity(UUID managementEntity, Pageable pageable);

    List<Profile> findAllByUuidIn(Collection<UUID> uuid);

    boolean existsByName(String name);
}
