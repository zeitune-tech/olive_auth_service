package sn.zeitune.oliveinsuranceauthservice.app.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.zeitune.oliveinsuranceauthservice.app.services.AdminService;
import sn.zeitune.oliveinsuranceauthservice.app.services.PermissionService;

@Component
@RequiredArgsConstructor
public class UserInitializer implements CommandLineRunner {

    private final PermissionService permissionService;
    private final AdminService adminService;

    @Override
    public void run(String... args) {
        permissionService.init();
        adminService.init();
    }
}
