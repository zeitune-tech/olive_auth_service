package sn.zeitune.oliveinsuranceauthservice.app.enums.permissions.attestation;

import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.PermissionRequest;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;
import sn.zeitune.oliveinsuranceauthservice.app.enums.Module;

public enum ManagementEntityAttestationModulePermissions {
    CREATE_ATTESTATION_REFERENCE("permissions.create_attestation_reference", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, sn.zeitune.oliveinsuranceauthservice.app.enums.Module.ATTESTATIONS),
    VIEW_ATTESTATION_REFERENCES("permissions.view_attestation_references", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, sn.zeitune.oliveinsuranceauthservice.app.enums.Module.ATTESTATIONS),

    VIEW_ATTESTATION_BATCHES_AND_STOCK("permissions.view_attestation_batches_and_stock", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ATTESTATIONS),

    CREATE_ATTESTATION_BATCH("permissions.create_attestation_batch", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, sn.zeitune.oliveinsuranceauthservice.app.enums.Module.ATTESTATIONS),
    VIEW_ATTESTATION_BATCHES("permissions.view_attestation_batches", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, sn.zeitune.oliveinsuranceauthservice.app.enums.Module.ATTESTATIONS),

    VIEW_ATTESTATION_STOCK("permissions.view_attestation_stock", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, sn.zeitune.oliveinsuranceauthservice.app.enums.Module.ATTESTATIONS);




    private final String description;
    private final ManagementEntityType managementEntityLevel;
    private final ManagementEntityType managementEntityType;
    private final sn.zeitune.oliveinsuranceauthservice.app.enums.Module module;

    ManagementEntityAttestationModulePermissions(String description, ManagementEntityType managementEntityLevel, ManagementEntityType managementEntityType, Module module) {
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
