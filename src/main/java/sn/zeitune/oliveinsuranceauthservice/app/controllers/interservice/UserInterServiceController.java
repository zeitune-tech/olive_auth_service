package sn.zeitune.oliveinsuranceauthservice.app.controllers.interservice;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.InterServiceUserRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.EmployeeResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Employee;
import sn.zeitune.oliveinsuranceauthservice.app.services.EmployeeService;

@RestController
@RequestMapping("/interservices/users")
@RequiredArgsConstructor
public class UserInterServiceController {

    private final EmployeeService employeeService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from UserInterServiceController");
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> createAdminUser(
            @RequestBody @Valid InterServiceUserRequest employee
    ) {
        EmployeeResponse employeeResponse = employeeService.createAdminUserForEntity(employee);
        return ResponseEntity.ok(employeeResponse);
    }
}
