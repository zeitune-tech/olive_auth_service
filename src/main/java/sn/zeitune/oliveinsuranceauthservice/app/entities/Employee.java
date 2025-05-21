package sn.zeitune.oliveinsuranceauthservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee extends User {

    @OneToMany(mappedBy = "employee")
    private List<Restriction> restrictions;

    /// External entity
    private UUID managementEntity;
}
