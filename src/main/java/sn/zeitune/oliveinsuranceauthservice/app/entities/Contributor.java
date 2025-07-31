package sn.zeitune.oliveinsuranceauthservice.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ContributorLevel;

import java.util.UUID;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "apporteurs")
public class Contributor extends User {

    @ManyToOne(fetch = FetchType.LAZY)
    private ContributorType contributorType;

    private ContributorLevel level;
    UUID managementEntity;
}
