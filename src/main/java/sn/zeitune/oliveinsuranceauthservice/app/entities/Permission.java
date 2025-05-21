package sn.zeitune.oliveinsuranceauthservice.app.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import sn.zeitune.oliveinsuranceauthservice.app.enums.*;
import sn.zeitune.oliveinsuranceauthservice.app.enums.Module;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "permissions")
public class Permission implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_perm")
    private Long id;

    @Column(name = "uuid", updatable = false, nullable = false, unique = true)
    private UUID uuid;

    @PrePersist
    public void generateUuid() {
        if (this.uuid == null) {
            this.uuid = UUID.randomUUID();
        }
    }

    private String name;
    private String description;
    private ManagementEntityType type;
    private ManagementEntityType level;
    private Module module;

    @Override
    public String getAuthority() {
        return this.name;
    }
}