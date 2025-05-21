package sn.zeitune.oliveinsuranceauthservice.app.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.RestrictionRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.RestrictionResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Employee;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Restriction;
import sn.zeitune.oliveinsuranceauthservice.app.exceptions.NotFoundException;
import sn.zeitune.oliveinsuranceauthservice.app.mappers.RestrictionMapper;
import sn.zeitune.oliveinsuranceauthservice.app.repositories.EmployeeRepository;
import sn.zeitune.oliveinsuranceauthservice.app.repositories.RestrictionRepository;
import sn.zeitune.oliveinsuranceauthservice.app.services.RestrictionService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RestrictionServiceImpl implements RestrictionService {

    private final RestrictionRepository restrictionRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public RestrictionResponse createRestriction(UUID employeeUuid, RestrictionRequest request) {
        Employee employee = employeeRepository.findByUuid(employeeUuid)
                .orElseThrow(() -> new NotFoundException("Employé introuvable"));

        Restriction restriction = RestrictionMapper.map(request, null);
        restriction.setEmployee(employee);

        return RestrictionMapper.map(restrictionRepository.save(restriction));
    }

    @Override
    public RestrictionResponse updateRestriction(UUID uuid, RestrictionRequest request) {
        Restriction restriction = restrictionRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Restriction introuvable"));

        Restriction updated = RestrictionMapper.map(request, restriction);
        return RestrictionMapper.map(restrictionRepository.save(updated));
    }

    @Override
    public void deleteRestriction(UUID uuid) {
        Restriction restriction = restrictionRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Restriction introuvable"));
        restrictionRepository.delete(restriction);
    }

    @Override
    public RestrictionResponse getRestrictionByUuid(UUID uuid) {
        Restriction restriction = restrictionRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Restriction introuvable"));
        return RestrictionMapper.map(restriction);
    }

    @Override
    public List<RestrictionResponse> getRestrictionsByEmployee(UUID employeeUuid) {
        Employee employee = employeeRepository.findByUuid(employeeUuid)
                .orElseThrow(() -> new NotFoundException("Employé introuvable"));

        return employee.getRestrictions()
                .stream()
                .map(RestrictionMapper::map)
                .collect(Collectors.toList());
    }
}
