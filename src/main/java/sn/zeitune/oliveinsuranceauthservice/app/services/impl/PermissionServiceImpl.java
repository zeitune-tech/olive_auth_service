package sn.zeitune.oliveinsuranceauthservice.app.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.PermissionRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.PermissionResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Permission;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;
import sn.zeitune.oliveinsuranceauthservice.app.exceptions.NotFoundException;
import sn.zeitune.oliveinsuranceauthservice.app.mappers.PermissionMapper;
import sn.zeitune.oliveinsuranceauthservice.app.repositories.PermissionRepository;
import sn.zeitune.oliveinsuranceauthservice.app.services.PermissionService;
import sn.zeitune.oliveinsuranceauthservice.app.templates.PermissionTemplates;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    public PermissionResponse createPermission(PermissionRequest request) {
        Permission permission = PermissionMapper.map(request, null);
        return PermissionMapper.map(permissionRepository.save(permission));
    }

    @Override
    public PermissionResponse updatePermission(UUID uuid, PermissionRequest request) {
        Permission existing = permissionRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Permission introuvable avec UUID: " + uuid));

        Permission updated = PermissionMapper.map(request, existing);
        return PermissionMapper.map(permissionRepository.save(updated));
    }

    @Override
    public void deletePermission(UUID uuid) {
        Permission permission = permissionRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Permission introuvable avec UUID: " + uuid));
        permissionRepository.delete(permission);
    }

    @Override
    public PermissionResponse getPermissionByUuid(UUID uuid) {
        Permission permission = permissionRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Permission introuvable avec UUID: " + uuid));
        return PermissionMapper.map(permission);
    }

    @Override
    public List<PermissionResponse> getAllPermissions() {
        return permissionRepository.findAll()
                .stream()
                .map(PermissionMapper::map)
                .collect(Collectors.toList());
    }

    public void init() {
        List<PermissionRequest> allPermissions = Stream.of(
                PermissionTemplates.companyUserAdministrationPermissions(),
                PermissionTemplates.companyUserSettingsPermissions(),
                PermissionTemplates.companyUserAttestationPermissions(),
                PermissionTemplates.marketUserAdministrationPermissions(),
                PermissionTemplates.marketUserSettingsPermissions(),
                PermissionTemplates.marketUserAttestationPermissions(),
                PermissionTemplates.pointOfSaleUserAdministrationPermissions(),
                PermissionTemplates.pointsOfSaleUserAttestationPermissions(),
                PermissionTemplates.brokerUserAdministrationPermissions(),
                PermissionTemplates.brokerUserAttestationPermissions(),
                PermissionTemplates.companyUserInsuredsPermissions(),
                PermissionTemplates.pointOfSaleUserInsuredsPermissions(),
                PermissionTemplates.brokerUserInsuredsPermissions()
        ).flatMap(Collection::stream).toList();

        allPermissions.forEach(permissionRequest -> {
            Permission existingPermission = permissionRepository.findByNameAndTypeAndLevel(
                    permissionRequest.name(),
                    permissionRequest.type(), permissionRequest.level())
                    .orElse(null);

            if (existingPermission != null) {
                if (existingPermission.getModule() == null) {
                    existingPermission.setModule(permissionRequest.module());
                    permissionRepository.save(existingPermission);
                }
                return;
            }


            permissionRepository.save(Permission.builder()
                    .name(permissionRequest.name())
                    .description(permissionRequest.description())
                    .type(permissionRequest.type())
                    .level(permissionRequest.level())
                    .module(permissionRequest.module())
                    .build()
            );
        });
    }
}
