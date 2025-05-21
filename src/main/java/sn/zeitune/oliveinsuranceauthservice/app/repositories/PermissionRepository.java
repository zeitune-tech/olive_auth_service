package sn.zeitune.oliveinsuranceauthservice.app.repositories;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Permission;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PermissionRepository extends JpaRepository<Permission, Long>, JpaSpecificationExecutor<Permission> {
    Optional<Permission> findByUuid(UUID uuid);

    boolean existsByNameAndTypeAndLevel(@NotBlank(message = "Le nom ne doit pas être vide") String name, ManagementEntityType type, ManagementEntityType level);

    Optional<Permission> findByNameAndTypeAndLevel(@NotBlank(message = "Le nom ne doit pas être vide") String name, ManagementEntityType type, ManagementEntityType level);

    List<Permission> findAllByLevelAndType(ManagementEntityType level, ManagementEntityType type);

    Permission findOneByNameAndTypeAndLevel(String name, @NotNull(message = "Name") ManagementEntityType type, @NotNull(message = "Access level cannot be null") ManagementEntityType managementEntityType);

    List<Permission> findAllByType(ManagementEntityType type);
}
