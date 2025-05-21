package sn.zeitune.oliveinsuranceauthservice.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee extends User {

    @OneToMany(mappedBy = "employee")
    private List<Restriction> restrictions;

    private ManagementEntityType accessLevel;

    /// External entity
    private UUID managementEntity;
}
