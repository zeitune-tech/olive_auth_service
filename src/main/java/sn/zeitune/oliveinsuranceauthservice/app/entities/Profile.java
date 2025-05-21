package sn.zeitune.oliveinsuranceauthservice.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;

import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "profils")
public class Profile implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_prof")
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
    private ManagementEntityType level;

    @Column(name = "code_entite")
    private UUID managementEntity;

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "profils_permission",
            joinColumns = @JoinColumn(name = "code_prof"),
            inverseJoinColumns = @JoinColumn(name = "code_perm")
    )
    private Set<Permission> permissions = new HashSet<>();

    @Override
    public String getAuthority() {
        return this.name;
    }

    public Collection<GrantedAuthority> getPermissions() {
        if (permissions == null || permissions.isEmpty()) {
            return new HashSet<>();
        }
        return new HashSet<>(permissions);
    }

    @JsonIgnore
    public List<Permission> getPermissionsList() {
        return new ArrayList<>(permissions);
    }
}

