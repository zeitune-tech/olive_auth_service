package sn.zeitune.oliveinsuranceauthservice.app.utils;

import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.PermissionRequest;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;

import java.util.List;

public class PermissionTemplates {

    public static List<PermissionRequest> companyUserPermissions() {
        return List.of(
                new PermissionRequest("VIEW_MANAGEMENT_ENTITY", "permissions.view_own_company_details", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("UPDATE_MANAGEMENT_ENTITY", "permissions.update_own_company_details", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),

                new PermissionRequest("VIEW_PRODUCTS", "permissions.view_products", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("CREATE_PRODUCTS", "permissions.create_products", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("UPDATE_PRODUCTS", "permissions.update_products", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("DELETE_PRODUCTS", "permissions.delete_products", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("AFFILIATE_PRODUCTS", "permissions.affiliate_products", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),

                new PermissionRequest("VIEW_COMPANY_LEVEL_ORGANIZATION", "permissions.view_company_level_organization", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("CREATE_COMPANY_LEVEL_ORGANIZATION", "permissions.create_company_level_organization", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("UPDATE_COMPANY_LEVEL_ORGANIZATION", "permissions.update_company_level_organization", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("DELETE_COMPANY_LEVEL_ORGANIZATION", "permissions.delete_company_level_organization", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),

                new PermissionRequest("VIEW_POINTS_OF_SALE", "permissions.view_points_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("CREATE_POINTS_OF_SALE", "permissions.create_points_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("UPDATE_POINTS_OF_SALE", "permissions.update_points_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("DELETE_POINTS_OF_SALE", "permissions.delete_points_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),

                new PermissionRequest("VIEW_BROKERS", "permissions.view_brokers", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("VIEW_MARKET_LEVEL_ORGANIZATION", "permissions.view_market_level_organization", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),

                new PermissionRequest("VIEW_USER", "permissions.view_user_company", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("CREATE_USER", "permissions.create_user_company", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("UPDATE_USER", "permissions.update_user_company", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("DELETE_USER", "permissions.delete_user_company", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("VIEW_USER_POINT_OF_SALE", "permissions.view_user_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("CREATE_USER_POINT_OF_SALE", "permissions.create_user_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("UPDATE_USER_POINT_OF_SALE", "permissions.update_user_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("DELETE_USER_POINT_OF_SALE", "permissions.delete_user_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),

                new PermissionRequest("CREATE_PROFILE", "permissions.create_profile_company", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("UPDATE_PROFILE", "permissions.update_profile_company", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("DELETE_PROFILE", "permissions.delete_profile_company", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("CREATE_PROFILE_POINT_OF_SALE", "permissions.create_profile_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("UPDATE_PROFILE_POINT_OF_SALE", "permissions.update_profile_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY),
                new PermissionRequest("DELETE_PROFILE_POINT_OF_SALE", "permissions.delete_profile_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.COMPANY)
        );
    }

    public static List<PermissionRequest> marketUserPermissions() {
        return List.of(
                new PermissionRequest("VIEW_MANAGEMENT_ENTITY", "permissions.view_own_market", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION),
                new PermissionRequest("UPDATE_MANAGEMENT_ENTITY", "permissions.update_own_market", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION),

                new PermissionRequest("VIEW_PRODUCTS", "permissions.view_products", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION),
                new PermissionRequest("CREATE_PRODUCTS", "permissions.create_products", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION),
                new PermissionRequest("UPDATE_PRODUCTS", "permissions.update_products", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION),
                new PermissionRequest("DELETE_PRODUCTS", "permissions.delete_products", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION),

                new PermissionRequest("VIEW_COMPANIES", "permissions.view_companies", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION),
                new PermissionRequest("VIEW_LINKED_COMPANIES", "permissions.view_linked_companies", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION),

                new PermissionRequest("VIEW_USER", "permissions.view_user_company", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION),
                new PermissionRequest("CREATE_USER", "permissions.create_user_company", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION),
                new PermissionRequest("UPDATE_USER", "permissions.update_user_company", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION),
                new PermissionRequest("DELETE_USER", "permissions.delete_user_company", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION),

                new PermissionRequest("CREATE_PROFILE", "permissions.create_profile_company", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION),
                new PermissionRequest("UPDATE_PROFILE", "permissions.update_profile_company", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION),
                new PermissionRequest("DELETE_PROFILE", "permissions.delete_profile_company", ManagementEntityType.MARKET_LEVEL_ORGANIZATION, ManagementEntityType.MARKET_LEVEL_ORGANIZATION)
        );
    }

    public static List<PermissionRequest> pointOfSaleUserPermissions() {
        return List.of(
                new PermissionRequest("VIEW_MANAGEMENT_ENTITY", "permissions.view_own_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),
                new PermissionRequest("UPDATE_MANAGEMENT_ENTITY", "permissions.update_own_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),

                new PermissionRequest("VIEW_PRODUCTS", "permissions.view_products", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),

                new PermissionRequest("VIEW_USER", "permissions.view_user_company", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),
                new PermissionRequest("CREATE_USER", "permissions.create_user_company", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),
                new PermissionRequest("UPDATE_USER", "permissions.update_user_company", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),
                new PermissionRequest("DELETE_USER", "permissions.delete_user_company", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),

                new PermissionRequest("CREATE_PROFILE", "permissions.create_profile_company", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),
                new PermissionRequest("UPDATE_PROFILE", "permissions.update_profile_company", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),
                new PermissionRequest("DELETE_PROFILE", "permissions.delete_profile_company", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE)
        );
    }
    
    public static List<PermissionRequest> brokerUserPermissions() {
        return List.of(
            new PermissionRequest("VIEW_MANAGEMENT_ENTITY", "permissions.view_own_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),
            new PermissionRequest("UPDATE_MANAGEMENT_ENTITY", "permissions.update_own_point_of_sale", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),

            new PermissionRequest("VIEW_PRODUCTS", "permissions.view_products", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),

            new PermissionRequest("VIEW_USER", "permissions.view_user_company", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),
            new PermissionRequest("CREATE_USER", "permissions.create_user_company", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),
            new PermissionRequest("UPDATE_USER", "permissions.update_user_company", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),
            new PermissionRequest("DELETE_USER", "permissions.delete_user_company", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),

            new PermissionRequest("CREATE_PROFILE", "permissions.create_profile_company", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),
            new PermissionRequest("UPDATE_PROFILE", "permissions.update_profile_company", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE),
            new PermissionRequest("DELETE_PROFILE", "permissions.delete_profile_company", ManagementEntityType.COMPANY, ManagementEntityType.POINT_OF_SALE)


            new PermissionRequest("VIEW_COMPANIES", "permissions.view_companies", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE),
                new PermissionRequest("VIEW_LINKED_COMPANIES", "permissions.view_linked_companies", ManagementEntityType.POINT_OF_SALE, ManagementEntityType.POINT_OF_SALE)
        );
    }
}
