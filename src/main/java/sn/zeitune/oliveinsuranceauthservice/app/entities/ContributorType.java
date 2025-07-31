package sn.zeitune.oliveinsuranceauthservice.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "type_apporteurs")
public class ContributorType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "code_util")
    private Long id;

    @Column(name = "uuid", updatable = false, nullable = false, unique = true)
    private UUID uuid;


    @PrePersist
    public void generateUuid() {
        if (this.uuid == null) {
            this.uuid = UUID.randomUUID();
        }
    }

    @Column(name = "libelle")
    private String label;

    @Column(name = "entite_gestion")
    private UUID managementEntity;
}
