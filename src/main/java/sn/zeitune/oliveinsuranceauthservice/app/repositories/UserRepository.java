package sn.zeitune.oliveinsuranceauthservice.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sn.zeitune.oliveinsuranceauthservice.app.enums.UserRole;
import sn.zeitune.oliveinsuranceauthservice.app.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    boolean existsByEmail(String email);
    Optional<User> findByUuid(UUID uuid);
    Optional<User> findByEmail(String username);
    Optional<User> findByEmailAndRole(String email, UserRole userRole);
}
