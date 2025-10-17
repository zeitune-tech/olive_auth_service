package sn.zeitune.oliveinsuranceauthservice.app.enums.permissions.attestation;

import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.PermissionRequest;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;
import sn.zeitune.oliveinsuranceauthservice.app.enums.Module;

public enum CompanyAttestationModulePermissions {
    VIEW_ATTESTATION_REFERENCES("permissions.view_attestation_references", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ATTESTATIONS),
    VIEW_ATTESTATION_BATCHES_AND_STOCK("permissions.view_attestation_batches_and_stock", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ATTESTATIONS),
    VIEW_ATTESTATION_STOCK("permissions.view_attestation_stock", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ATTESTATIONS);



    private final String description;
    private final ManagementEntityType managementEntityLevel;
    private final ManagementEntityType managementEntityType;
    private final Module module;

    CompanyAttestationModulePermissions(String description, ManagementEntityType managementEntityLevel, ManagementEntityType managementEntityType, Module module) {
        this.description = description;
        this.managementEntityLevel = managementEntityLevel;
        this.managementEntityType = managementEntityType;
        this.module = module;
    }

    public PermissionRequest toPermissionRequest() {
        return PermissionRequest.builder()
                .name(this.name())
                .description(this.description)
                .level(this.managementEntityLevel)
                .type(this.managementEntityType)
                .module(this.module)
                .build();
    }
}
