package sn.zeitune.oliveinsuranceauthservice.app.dto.requests;

import java.util.List;
import java.util.UUID;

public record ProfileUpdatePermissionsRequest(
        List<UUID> permissions
) {
}
