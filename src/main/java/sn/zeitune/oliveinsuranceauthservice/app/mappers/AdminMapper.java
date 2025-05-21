package sn.zeitune.oliveinsuranceauthservice.mappers;

import sn.zeitune.oliveinsuranceauthservice.dto.requests.AdminRequest;
import sn.zeitune.oliveinsuranceauthservice.dto.responses.AdminResponse;
import sn.zeitune.oliveinsuranceauthservice.entities.Admin;

import java.util.stream.Collectors;

public class AdminMapper {

    public static Admin map(AdminRequest request) {
        if (request == null) {
            return null;
        }
        Admin admin = new Admin();
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
                .id(admin.getId())
                .uuid(admin.getUuid())
                .firstName(admin.getFirstname())
                .lastName(admin.getLastname())
                .email(admin.getEmail())
                .profiles(admin.getProfiles() != null ?
                        admin.getProfiles().stream().map(ProfileMapper::map).collect(Collectors.toSet())
                        : null)
                .build();
    }
}
