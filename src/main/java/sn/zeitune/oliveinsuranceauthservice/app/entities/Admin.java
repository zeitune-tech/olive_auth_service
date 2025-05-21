package sn.zeitune.oliveinsuranceauthservice.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import sn.zeitune.oliveinsuranceauthservice.app.enums.UserRole;

@Getter
@Setter
@Entity
@SuperBuilder
@Table(name = "admins")
public class Admin extends User {

    public Admin() {
        super();
        this.setRole(UserRole.ADMIN);
    }
}
