package sn.zeitune.oliveinsuranceauthservice.app.initializer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.InterServiceUserRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.EmployeeResponse;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;
import sn.zeitune.oliveinsuranceauthservice.app.services.AdminService;
import sn.zeitune.oliveinsuranceauthservice.app.services.EmployeeService;
import sn.zeitune.oliveinsuranceauthservice.app.services.PermissionService;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserInitializer implements CommandLineRunner {

    private final PermissionService permissionService;
    private final AdminService adminService;
    private final EmployeeService employeeService;
    @Value("${olive.marketLevel.pool-tpv}")
    UUID poolTPVUuid;
    @Value("${olive.company.amsa}")
    UUID amsaUuid;
    @Value("${olive.company.sonam}")
    UUID sonamUuid;


    @Override
    public void run(String... args) {
        permissionService.init();
        adminService.init();
        if (!isAlreadyInit()) {
            log.info("------- User Initialization started -------");
            createPoolTPVAdminUser();
            createAdminUsers();
            log.info("------- User Initialization completed -------");
        } else {
            log.info("------- User Initialization skipped -------");
        }
    }

    private void createPoolTPVAdminUser() {
        try {
            InterServiceUserRequest poolTPV = InterServiceUserRequest.builder()
                    .email("pooltpv@gmail.com")
                    .name("Pool Transports Publics de Voyageurs")
                    .managementEntity(poolTPVUuid)
                    .accessLevel(ManagementEntityType.MARKET_LEVEL_ORGANIZATION)
                    .type(ManagementEntityType.MARKET_LEVEL_ORGANIZATION)
                    .build();
            EmployeeResponse poolTPVEmployeeResponse = employeeService.createAdminUserForEntity(poolTPV);
        } catch (Exception e) {
            log.error("Error during super admin pooltpv initialization", e);
        }
    }

    private void createAdminUsers() {
        try {
            InterServiceUserRequest amsa = InterServiceUserRequest.builder()
                    .email("amsa@gmail.com")
                    .name("AMSA Assurances")
                    .managementEntity(amsaUuid)
                    .accessLevel(ManagementEntityType.COMPANY)
                    .type(ManagementEntityType.COMPANY)
                    .build();
            EmployeeResponse amsaEmployeeResponse = employeeService.createAdminUserForEntity(amsa);
        } catch (Exception e) {
            log.error("Error during super admin amsa initialization", e);
        }


        try {
            InterServiceUserRequest sonam = InterServiceUserRequest.builder()
                    .email("sonam@gmail.com")
                    .name("SONAM Assurances")
                    .managementEntity(sonamUuid)
                    .accessLevel(ManagementEntityType.COMPANY)
                    .type(ManagementEntityType.COMPANY)
                    .build();
            EmployeeResponse sonamEmployeeResponse = employeeService.createAdminUserForEntity(sonam);
        } catch (Exception e) {
            log.error("Error during super admin sonam initialization", e);
        }
    }


    private boolean isAlreadyInit() {
        try {
            EmployeeResponse amsa = employeeService.getEmployeeByUuid(amsaUuid);
            EmployeeResponse poolTPV = employeeService.getEmployeeByUuid(poolTPVUuid);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
