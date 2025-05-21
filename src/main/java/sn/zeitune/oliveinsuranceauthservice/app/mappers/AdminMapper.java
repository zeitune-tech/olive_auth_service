package sn.zeitune.oliveinsuranceauthservice.app.mappers;

import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.AdminRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.AdminResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Admin;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Profile;

import java.util.Set;
import java.util.stream.Collectors;

public class AdminMapper {

    public static Admin map(AdminRequest request, Admin admin) {
        if (request == null) {
            return admin;
        }
        if (admin == null) {
            admin = new Admin();
        }
        admin.setFirstname(request.firstname());
        admin.setLastname(request.lastname());
        admin.setEmail(request.email());
        admin.setPassword(request.password());

        return admin;
    }

    public static AdminResponse map(Admin admin) {
        if (admin == null) {
            return null;
        }
        return AdminResponse.builder()
                .id(admin.getUuid())
                .firstName(admin.getFirstname())
                .lastName(admin.getLastname())
                .email(admin.getEmail())
                .profiles(admin.getProfiles() != null ?
                        admin.getProfiles().stream().map(ProfileMapper::map).collect(Collectors.toSet())
                        : null)
                .build();
    }
}
