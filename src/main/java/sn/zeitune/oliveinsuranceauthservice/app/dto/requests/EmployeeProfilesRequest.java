package sn.zeitune.oliveinsuranceauthservice.app.dto.requests;

import java.util.Set;
import java.util.UUID;

public record EmployeeProfilesRequest (
        Set<UUID> profileIds
) {
}
