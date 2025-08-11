package sn.zeitune.oliveinsuranceauthservice.app.services.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ProfileUpdate;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ProfileUpdatePermissionsRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ProfileRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.PermissionResponse;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.ProfileResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Permission;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Profile;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;
import sn.zeitune.oliveinsuranceauthservice.app.exceptions.ConflictException;
import sn.zeitune.oliveinsuranceauthservice.app.exceptions.NotFoundException;
import sn.zeitune.oliveinsuranceauthservice.app.mappers.PermissionMapper;
import sn.zeitune.oliveinsuranceauthservice.app.mappers.ProfileMapper;
import sn.zeitune.oliveinsuranceauthservice.app.repositories.PermissionRepository;
import sn.zeitune.oliveinsuranceauthservice.app.repositories.ProfileRepository;
import sn.zeitune.oliveinsuranceauthservice.app.services.ProfileService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public ProfileResponse create(ProfileRequest request, UUID managementEntity) {
        Profile profile = ProfileMapper.map(request, null);
        if (profileRepository.existsByName(profile.getName())) {
            throw new ConflictException("Profile with the same name already exists");
        }
        profile.setManagementEntity(managementEntity);
        return getProfileResponse(request, profile);
    }

    private ProfileResponse getProfileResponse(ProfileRequest request, Profile profile) {
        Set<Permission> permissions = new HashSet<>();
        if (request.permissions() != null) {
            for (UUID permissionId : request.permissions()) {
                Permission permission = permissionRepository.findByUuid(permissionId)
                        .orElseThrow(() -> new NotFoundException("Permission not found for UUID: " + permissionId));
                permissions.add(permission);
            }
        }
        profile.setPermissions(permissions);
        profile = profileRepository.save(profile);
        return ProfileMapper.map(profile);
    }

    @Override
    public ProfileResponse update(UUID uuid, ProfileUpdate request) {
        Profile profile = profileRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Profile not found for UUID: " + uuid));

        if (request.name() != null) {
            if (profileRepository.existsByName(request.name())) {
                throw new ConflictException("Profile with the same name already exists");
            }
            profile.setName(request.name());
        }

        if (request.description() != null) {
            profile.setDescription(request.description());
        }

        return  ProfileMapper.map(profileRepository.save(profile));
    }

    @Override
    public ProfileResponse updatePermissions(UUID uuid, ProfileUpdatePermissionsRequest request) {

        Profile profile = profileRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Profile not found for UUID: " + uuid));

        Set<Permission> permissions = new HashSet<>();
        if (request.permissions() != null) {
            for (UUID permissionId : request.permissions()) {
                Permission permission = permissionRepository.findByUuid(permissionId)
                        .orElseThrow(() -> new NotFoundException("Permission not found for UUID: " + permissionId));
                permissions.add(permission);
            }
        }
        profile.setPermissions(permissions);
        profile = profileRepository.save(profile);
        return ProfileMapper.map(profile);
    }

    @Override
    public void delete(UUID uuid) {
        Profile profile = profileRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Profile not found for UUID: " + uuid));
        profileRepository.delete(profile);
    }

    @Override
    @Transactional(readOnly = true)
    public ProfileResponse getByUuid(UUID uuid) {
        Profile profile = profileRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Profile not found for UUID: " + uuid));
        return ProfileMapper.map(profile);
    }

    @Override
    public List<ProfileResponse> getAll(UUID managementEntity) {
        return profileRepository.findAllByManagementEntity(
                managementEntity
        ).stream()
        .map(ProfileMapper::map)
        .collect(Collectors.toList());
    }

    @Override
    public Page<ProfileResponse> getAll(Pageable pageable) {
        return profileRepository.findAll(pageable)
                .map(ProfileMapper::map);
    }

    @Override
    public List<ProfileResponse> getAllByManagementEntity(UUID managementEntity) {
        List<Profile> profiles = profileRepository.findAllByManagementEntity(managementEntity);
        return profiles.stream()
                .map(ProfileMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProfileResponse> getAllByManagementEntity(UUID managementEntity, Pageable pageable) {
        Page<Profile> profiles = profileRepository.findAllByManagementEntity(managementEntity, pageable);
        return profiles.map(ProfileMapper::map);
    }

    @Override
    public List<PermissionResponse> getPermissions(ManagementEntityType level, ManagementEntityType type) {

        List<Permission> permissions = permissionRepository.findAllByLevelAndType(level, type);
        return permissions.stream()
                .map(PermissionMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<PermissionResponse> getPermissions(ManagementEntityType type) {
        return permissionRepository.findAllByType(type).stream()
                .map(PermissionMapper::map)
                .collect(Collectors.toList());
    }
}