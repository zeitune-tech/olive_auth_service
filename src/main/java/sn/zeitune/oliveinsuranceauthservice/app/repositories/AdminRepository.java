package sn.zeitune.oliveinsuranceauthservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sn.zeitune.oliveinsuranceauthservice.entities.Admin;
import java.util.Optional;
import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, Long>, JpaSpecificationExecutor<Admin> {
    Optional<Admin> findByUuid(UUID uuid);
}
