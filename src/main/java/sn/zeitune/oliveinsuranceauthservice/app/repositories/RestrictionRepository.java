package sn.zeitune.oliveinsuranceauthservice.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Restriction;
import java.util.Optional;
import java.util.UUID;

public interface RestrictionRepository extends JpaRepository<Restriction, Long>, JpaSpecificationExecutor<Restriction> {
    Optional<Restriction> findByUuid(UUID uuid);
}
