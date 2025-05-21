package sn.zeitune.oliveinsuranceauthservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sn.zeitune.oliveinsuranceauthservice.enums.UserRole;
import sn.zeitune.oliveinsuranceauthservice.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    boolean existsByEmail(String email);
    Optional<User> findByUuid(UUID uuid);
    Optional<User> findByEmail(String username);
    Optional<User> findByEmailAndRole(String email, UserRole userRole);
}
