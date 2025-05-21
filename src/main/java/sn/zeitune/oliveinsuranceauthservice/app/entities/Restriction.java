package sn.zeitune.oliveinsuranceauthservice.app.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import sn.zeitune.oliveinsuranceauthservice.app.enums.RestrictionType;

import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restrictions")
@Inheritance(strategy = InheritanceType.JOINED)
public class Restriction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "code_rest")
    private Long id;

    @Column(name = "uuid", updatable = false, nullable = false, unique = true)
    private UUID uuid;

    @PrePersist
    public void generateUuid() {
        if (this.uuid == null) {
            this.uuid = UUID.randomUUID();
        }
    }

    private RestrictionType restrictionType;

    @ManyToOne
    @JoinColumn(name = "code_utilisateur")
    private Employee employee;

    @Column(name = "code_entite")
    private UUID managementEntity;
}

