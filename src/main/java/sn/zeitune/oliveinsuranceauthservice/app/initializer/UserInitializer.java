package sn.zeitune.oliveinsuranceauthservice.app.initializer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.EmployeeRequest;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;
import sn.zeitune.oliveinsuranceauthservice.app.services.AdminService;
import sn.zeitune.oliveinsuranceauthservice.app.services.EmployeeService;
import sn.zeitune.oliveinsuranceauthservice.app.services.PermissionService;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
//public class UserInitializer implements CommandLineRunner {
public class UserInitializer implements CommandLineRunner {

    private final PermissionService permissionService;
    private final AdminService adminService;
    private final EmployeeService employeeService;

    // @Override
    // public void run(String... args) throws Exception {
    //     // permissionService.init();
    // }

   @Override
   public void run(String... args) {
       permissionService.init();
       adminService.init();

       Optional<UUID> managementEntityOpt = employeeService.findManagementEntityByName("amsa");
       if (managementEntityOpt.isEmpty()) {
           log.warn("No management entity found for name 'amsa'. Skipping default employee creation.");
           return;
       }
       UUID managementEntityId = managementEntityOpt.get();

       try {
           employeeService.createEmployee(
                   EmployeeRequest.builder()
                           .firstname("Default")
                           .lastname("Employee")
                           .email("amsa2@gmail.com")
                           .password("P@ssw0rd")
                           .profiles(Set.of())
                           .accessLevel(ManagementEntityType.COMPANY)
                           .managementEntity(managementEntityId)
                           .build()
           );
           log.info("Default employee for 'amsa' ensured/created.");
       } catch (Exception e) {
           log.warn("Could not create default employee for 'amsa': {}", e.getMessage());
       }
   }
}
