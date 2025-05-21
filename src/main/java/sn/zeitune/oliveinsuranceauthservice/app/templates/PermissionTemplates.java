package sn.zeitune.oliveinsuranceauthservice.app.templates;

import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.PermissionRequest;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;
import sn.zeitune.oliveinsuranceauthservice.app.enums.Module;

import java.util.List;

public class PermissionTemplates {

    public static List<PermissionRequest> companyUserAdministrationPermissions() {
        return List.of(
                new PermissionRequest("VIEW_MANAGEMENT_ENTITIES", "permissions.view_own_company_details", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_MANAGEMENT_ENTITIES", "permissions.update_own_company_details", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),

                new PermissionRequest("VIEW_PRODUCTS", "permissions.view_products", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("CREATE_PRODUCTS", "permissions.create_products", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_PRODUCTS", "permissions.update_products", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("DELETE_PRODUCTS", "permissions.delete_products", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("AFFILIATE_PRODUCTS", "permissions.affiliate_products", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),

                new PermissionRequest("VIEW_COMPANY_LEVEL_ORGANIZATIONS", "permissions.view_company_level_organization", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("CREATE_COMPANY_LEVEL_ORGANIZATIONS", "permissions.create_company_level_organization", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_COMPANY_LEVEL_ORGANIZATIONS", "permissions.update_company_level_organization", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("DELETE_COMPANY_LEVEL_ORGANIZATIONS", "permissions.delete_company_level_organization", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),

                new PermissionRequest("VIEW_POINTS_OF_SALE", "permissions.view_points_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("CREATE_POINTS_OF_SALE", "permissions.create_points_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_POINTS_OF_SALE", "permissions.update_points_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("DELETE_POINTS_OF_SALE", "permissions.delete_points_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),

                new PermissionRequest("VIEW_BROKERS", "permissions.view_brokers", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("VIEW_MARKET_LEVEL_ORGANIZATIONS", "permissions.view_market_level_organization", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),

                new PermissionRequest("VIEW_USERS", "permissions.view_user_company", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("CREATE_USERS", "permissions.create_user_company", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_USERS", "permissions.update_user_company", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("DELETE_USERS", "permissions.delete_user_company", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("VIEW_USERS_POINTS_OF_SALE", "permissions.view_user_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("CREATE_USERS_POINTS_OF_SALE", "permissions.create_user_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_USERS_POINTS_OF_SALE", "permissions.update_user_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("DELETE_USERS_POINTS_OF_SALE", "permissions.delete_user_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),

                new PermissionRequest("CREATE_PROFILES", "permissions.create_profile_company", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_PROFILES", "permissions.update_profile_company", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("DELETE_PROFILES", "permissions.delete_profile_company", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("CREATE_PROFILES_POINTS_OF_SALE", "permissions.create_profile_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_PROFILES_POINTS_OF_SALE", "permissions.update_profile_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("DELETE_PROFILES_POINTS_OF_SALE", "permissions.delete_profile_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ADMINISTRATION)
        );
    }

    public static List<PermissionRequest> marketUserAdministrationPermissions() {
        return List.of(
                new PermissionRequest("VIEW_MANAGEMENT_ENTITIES", "permissions.view_own_markets", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_MANAGEMENT_ENTITIES", "permissions.update_own_markets", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ADMINISTRATION),

                new PermissionRequest("VIEW_PRODUCTS", "permissions.view_products", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ADMINISTRATION),
                new PermissionRequest("CREATE_PRODUCTS", "permissions.create_products", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_PRODUCTS", "permissions.update_products", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ADMINISTRATION),
                new PermissionRequest("DELETE_PRODUCTS", "permissions.delete_products", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ADMINISTRATION),

                new PermissionRequest("VIEW_COMPANIES", "permissions.view_companies", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ADMINISTRATION),
                new PermissionRequest("VIEW_LINKED_COMPANIES", "permissions.view_linked_companies", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ADMINISTRATION),

                new PermissionRequest("VIEW_USERS", "permissions.view_users", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ADMINISTRATION),
                new PermissionRequest("CREATE_USERS", "permissions.create_users", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_USERS", "permissions.update_users", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ADMINISTRATION),
                new PermissionRequest("DELETE_USERS", "permissions.delete_users", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ADMINISTRATION),

                new PermissionRequest("CREATE_PROFILES", "permissions.create_profiles", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_PROFILES", "permissions.update_profiles", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ADMINISTRATION),
                new PermissionRequest("DELETE_PROFILES", "permissions.delete_profiles", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ADMINISTRATION)
        );
    }


    public static List<PermissionRequest> pointOfSaleUserAdministrationPermissions() {
        return List.of(
                new PermissionRequest("VIEW_MANAGEMENT_ENTITIES", "permissions.view_own_points_of_sale", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_MANAGEMENT_ENTITIES", "permissions.update_own_points_of_sale", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ADMINISTRATION),

                new PermissionRequest("VIEW_PRODUCTS", "permissions.view_products", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ADMINISTRATION),

                new PermissionRequest("VIEW_USERS", "permissions.view_users_company", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("CREATE_USERS", "permissions.create_users_company", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_USERS", "permissions.update_users_company", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("DELETE_USERS", "permissions.delete_users_company", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ADMINISTRATION),

                new PermissionRequest("CREATE_PROFILES", "permissions.create_profiles_company", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_PROFILES", "permissions.update_profiles_company", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ADMINISTRATION),
                new PermissionRequest("DELETE_PROFILES", "permissions.delete_profiles_company", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ADMINISTRATION)
        );
    }


    public static List<PermissionRequest> brokerUserAdministrationPermissions() {
        return List.of(
                new PermissionRequest("VIEW_MANAGEMENT_ENTITIES", "permissions.view_own_points_of_sale", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_MANAGEMENT_ENTITIES", "permissions.update_own_points_of_sale", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ADMINISTRATION),

                new PermissionRequest("VIEW_PRODUCTS", "permissions.view_products", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ADMINISTRATION),

                new PermissionRequest("VIEW_USERS", "permissions.view_users_company", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ADMINISTRATION),
                new PermissionRequest("CREATE_USERS", "permissions.create_users_company", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_USERS", "permissions.update_users_company", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ADMINISTRATION),
                new PermissionRequest("DELETE_USERS", "permissions.delete_users_company", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ADMINISTRATION),

                new PermissionRequest("CREATE_PROFILES", "permissions.create_profiles_company", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ADMINISTRATION),
                new PermissionRequest("UPDATE_PROFILES", "permissions.update_profiles_company", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ADMINISTRATION),
                new PermissionRequest("DELETE_PROFILES", "permissions.delete_profiles_company", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ADMINISTRATION),

                new PermissionRequest("VIEW_COMPANIES", "permissions.view_companies", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ADMINISTRATION),
                new PermissionRequest("VIEW_LINKED_COMPANIES", "permissions.view_linked_companies", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ADMINISTRATION)
        );
    }

    public static List<PermissionRequest> companyUserSettingsPermissions() {
        return List.of(
                new PermissionRequest("VIEW_COVERAGES", "permissions.view_coverages", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),
                new PermissionRequest("CREATE_COVERAGES", "permissions.create_coverages", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),
                new PermissionRequest("UPDATE_COVERAGES", "permissions.update_coverages", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),
                new PermissionRequest("DELETE_COVERAGES", "permissions.delete_coverages", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),

                new PermissionRequest("VIEW_COVERAGES_REFERENCES", "permissions.view_coverages_references", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),

                new PermissionRequest("CREATE_COVERAGE_DURATIONS", "permissions.create_coverage_durations", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),
                new PermissionRequest("UPDATE_COVERAGE_DURATIONS", "permissions.update_coverage_durations", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),
                new PermissionRequest("DELETE_COVERAGE_DURATIONS", "permissions.delete_coverage_durations", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),
                new PermissionRequest("VIEW_COVERAGE_DURATIONS", "permissions.view_coverage_durations", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),

                new PermissionRequest("CREATE_INSURED_REGISTRIES", "permissions.create_insured_registries", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),
                new PermissionRequest("UPDATE_INSURED_REGISTRIES", "permissions.update_insured_registries", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),
                new PermissionRequest("DELETE_INSURED_REGISTRIES", "permissions.delete_insured_registries", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),
                new PermissionRequest("VIEW_INSURED_REGISTRIES", "permissions.view_insured_registries", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),

                new PermissionRequest("CREATE_PRODUCTION_REGISTRIES", "permissions.create_production_registries", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),
                new PermissionRequest("UPDATE_PRODUCTION_REGISTRIES", "permissions.update_production_registries", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),
                new PermissionRequest("DELETE_PRODUCTION_REGISTRIES", "permissions.delete_production_registries", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),
                new PermissionRequest("VIEW_PRODUCTION_REGISTRIES", "permissions.view_production_registries", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),

                new PermissionRequest("CREATE_CLOSURES", "permissions.create_closures", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),
                new PermissionRequest("UPDATE_CLOSURES", "permissions.update_closures", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),
                new PermissionRequest("DELETE_CLOSURES", "permissions.delete_closures", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS),
                new PermissionRequest("VIEW_CLOSURES", "permissions.view_closures", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.SETTINGS)
        );
    }

    public static List<PermissionRequest> marketUserSettingsPermissions() {
        return List.of(
                new PermissionRequest("VIEW_COVERAGES", "permissions.view_coverages", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),
                new PermissionRequest("CREATE_COVERAGES", "permissions.create_coverages", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),
                new PermissionRequest("UPDATE_COVERAGES", "permissions.update_coverages", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),
                new PermissionRequest("DELETE_COVERAGES", "permissions.delete_coverages", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),

                new PermissionRequest("CREATE_COVERAGE_DURATIONS", "permissions.create_coverage_durations", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),
                new PermissionRequest("UPDATE_COVERAGE_DURATIONS", "permissions.update_coverage_durations", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),
                new PermissionRequest("DELETE_COVERAGE_DURATIONS", "permissions.delete_coverage_durations", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),
                new PermissionRequest("VIEW_COVERAGE_DURATIONS", "permissions.view_coverage_durations", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),

                new PermissionRequest("CREATE_INSURED_REGISTRIES", "permissions.create_insured_registries", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),
                new PermissionRequest("UPDATE_INSURED_REGISTRIES", "permissions.update_insured_registries", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),
                new PermissionRequest("DELETE_INSURED_REGISTRIES", "permissions.delete_insured_registries", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),
                new PermissionRequest("VIEW_INSURED_REGISTRIES", "permissions.view_insured_registries", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),

                new PermissionRequest("CREATE_PRODUCTION_REGISTRIES", "permissions.create_production_registries", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),
                new PermissionRequest("UPDATE_PRODUCTION_REGISTRIES", "permissions.update_production_registries", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),
                new PermissionRequest("DELETE_PRODUCTION_REGISTRIES", "permissions.delete_production_registries", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),
                new PermissionRequest("VIEW_PRODUCTION_REGISTRIES", "permissions.view_production_registries", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),

                new PermissionRequest("CREATE_CLOSURES", "permissions.create_closures", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),
                new PermissionRequest("UPDATE_CLOSURES", "permissions.update_closures", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),
                new PermissionRequest("DELETE_CLOSURES", "permissions.delete_closures", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS),
                new PermissionRequest("VIEW_CLOSURES", "permissions.view_closures", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.SETTINGS)
        );
    }


    public static List<PermissionRequest> companyUserAttestationPermissions() {
        return List.of(
                new PermissionRequest("VIEW_ATTESTATIONS", "permissions.view_attestations", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ATTESTATIONS),

                new PermissionRequest("VIEW_ATTESTATIONS_DEMANDS", "permissions.view_attestations_demands", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ATTESTATIONS),
                new PermissionRequest("CREATE_ATTESTATIONS_DEMANDS_TO_MARKET_LEVEL_ORGANIZATION", "permissions.create_attestations_demands", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ATTESTATIONS),
                new PermissionRequest("UPDATE_ATTESTATIONS_DEMANDS", "permissions.update_attestations_demands", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ATTESTATIONS),
                new PermissionRequest("DELETE_ATTESTATIONS_DEMANDS", "permissions.delete_attestations_demands", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ATTESTATIONS),

                new PermissionRequest("DELIVER_ATTESTATIONS_TO_POINTS_OF_SALE", "permissions.deliver_attestations", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY, Module.ATTESTATIONS),
                new PermissionRequest("REVOKE_ATTESTATIONS_TO_POINT_OF_SALE", "permissions.revoke_attestations", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ATTESTATIONS),

                new PermissionRequest("VIEW_REVOKED_ATTESTATIONS", "permissions.revoke_attestations", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ATTESTATIONS)
        );
    }


    public static List<PermissionRequest> pointsOfSaleUserAttestationPermissions() {
        return List.of(
                new PermissionRequest("VIEW_ATTESTATIONS", "permissions.view_attestations", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ATTESTATIONS),

                new PermissionRequest("VIEW_ATTESTATIONS_DEMANDS", "permissions.view_attestations_demands", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ATTESTATIONS),
                new PermissionRequest("CREATE_ATTESTATIONS_DEMANDS_TO_COMPANY", "permissions.create_attestations_demands", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ATTESTATIONS),
                new PermissionRequest("DELETE_ATTESTATIONS_DEMANDS", "permissions.delete_attestations_demands", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ATTESTATIONS),

                new PermissionRequest("DELIVER_ATTESTATIONS_TO_INSURED", "permissions.deliver_attestations", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ATTESTATIONS),
                new PermissionRequest("REVOKE_ATTESTATIONS_TO_INSURED", "permissions.revoke_attestations", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.COMPANY, Module.ATTESTATIONS)
        );
    }


    public static List<PermissionRequest> brokerUserAttestationPermissions() {
        return List.of(
                new PermissionRequest("VIEW_ATTESTATIONS", "permissions.view_attestations", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ATTESTATIONS),

                new PermissionRequest("VIEW_ATTESTATIONS_DEMANDS", "permissions.view_attestations_demands", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ATTESTATIONS),
                new PermissionRequest("CREATE_ATTESTATIONS_DEMANDS_TO_COMPANY", "permissions.create_attestations_demands", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ATTESTATIONS),
                new PermissionRequest("DELETE_ATTESTATIONS_DEMANDS", "permissions.delete_attestations_demands", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ATTESTATIONS),

                new PermissionRequest("DELIVER_ATTESTATIONS_TO_INSURED", "permissions.deliver_attestations", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ATTESTATIONS),
                new PermissionRequest("REVOKE_ATTESTATIONS_TO_INSURED", "permissions.revoke_attestations", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE, Module.ATTESTATIONS)
        );
    }


    public static List<PermissionRequest> marketUserAttestationPermissions() {
        return List.of(
                new PermissionRequest("VIEW_ATTESTATIONS", "permissions.view_attestations", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ATTESTATIONS),

                new PermissionRequest("VIEW_ATTESTATIONS_DEMANDS", "permissions.view_attestations_demands", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ATTESTATIONS),
                new PermissionRequest("UPDATE_ATTESTATIONS_DEMANDS", "permissions.update_attestations_demands", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ATTESTATIONS),
                new PermissionRequest("DELETE_ATTESTATIONS_DEMANDS", "permissions.delete_attestations_demands", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ATTESTATIONS),

                new PermissionRequest("CREATE_ATTESTATIONS", "permissions.create_attestations", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ATTESTATIONS),
                new PermissionRequest("DELIVER_ATTESTATIONS_TO_COMPANY", "permissions.distribute_attestations", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ATTESTATIONS),
                new PermissionRequest("REVOKE_ATTESTATIONS_TO_COMPANY", "permissions.revoke_attestations", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ATTESTATIONS),

                new PermissionRequest("VIEW_REVOKED_ATTESTATIONS", "permissions.revoke_attestations", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION, Module.ATTESTATIONS)
        );
    }

}
