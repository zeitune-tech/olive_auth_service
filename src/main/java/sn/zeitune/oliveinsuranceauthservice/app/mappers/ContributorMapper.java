package sn.zeitune.oliveinsuranceauthservice.app.mappers;

import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ContributorRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.ContributorResponse;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.ContributorTypeResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Contributor;
import sn.zeitune.oliveinsuranceauthservice.app.enums.UserRole;

public class ContributorMapper {


    public static Contributor map(ContributorRequest request) {
        return Contributor.builder()
                .level(request.level())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .password("P@sser123")
                .role(UserRole.USER)
                .build();
    }

    public static ContributorResponse map(Contributor contributor) {
        return new ContributorResponse(
                contributor.getUuid(),
                contributor.getFirstname(),
                contributor.getLastname(),
                contributor.getEmail(),
                contributor.getLevel(),
                contributor.getManagementEntity(),
                ContributorTypeResponse.builder()
                        .build()
        );
    }
}
