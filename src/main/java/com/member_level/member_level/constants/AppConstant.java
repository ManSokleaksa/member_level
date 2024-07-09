package com.member_level.member_level.constants;

public final class AppConstant {
    public static final int ERROR_CODE_ONE = 1;
    public static final int ERROR_CODE_ZERO = 0;
    public static final int RESPONSE_CODE_ONE = 1;
    public static final int RESPONSE_CODE_ZERO = 0;

    public static final String DATE_FORMAT = "dd.MM.yyyy";
    public static final String DATE_TIME_FORMAT = "dd.MM.yyyy HH:mm:ss";

    public static final String SUCCESS = "Success";
    public static final String ACCOUNT_LOCK = "The account is locked.";
    public static final String UNAUTHORIZED = "You are not authorized to access this resource.";
    public static final String UNAUTHORIZED_ERROR = "Unauthorized error: {}";
    public static final String CANNOT_SET_AUTH = "Cannot set user authentication: {}";
    public static final String NOT_FOUND_USERNAME = "User with username of {0} is not found";
    public static final String INVALID_JWT_SIGN = "The JWT signature is invalid.";
    public static final String INVALID_JWT_TOKEN = "Invalid JWT token: {}";
    public static final String JWT_EXPIRED = "The JWT token has expired.";
    public static final String JWT_UNSUPPORTED = "JWT token is unsupported: {}";
    public static final String JWT_EMPTY = "JWT claims string is empty: {}";
    public static final String JWT_REVOKED = "The JWT token has been revoked.";
    public static final String VALIDATION_ERROR = "Validation error. Check 'errors' field for details";
    public static final String UNKNOWN_ERROR = "Unknown error occurred";
    public static final String METHOD_ARGUMENT_NOT_VALID = "MethodArgumentNotValid exception";
    public static final String FIELD_NOT_VALIDATED = "Field is not validated";

    public static final String LOGGED_IN_USER = "User logged in (username: {})";
    public static final String ALREADY_EXISTS = "Requested element already exists";
    public static final String ALREADY_EXISTS_USER_NAME = "User with the same username already exists";
    public static final String ALREADY_EXISTS_USER_EMAIL = "User with the same email already exists";
    public static final String ALREADY_EXISTS_USER_PHONE = "User with the same phone number already exists";
    public static final String ALREADY_EXISTS_NAME = "Requested element with the same name already exists";
    public static final String NOT_FOUND = "Requested element is not found";
    public static final String NOT_FOUND_RECORD = "Not found any record";
    public static final String CREATED_USER = "User is created (username: {})";
    public static final String NOT_VERIFY_OTP = "User not yet verify OTP.";

    public static final String LOGIN_SUCCESSFUL = "Login Successful.";
    public static final String DELETE_SUCCESSFUL = "Successfully Deleted.";

    public static final String EXCEPTION_NULL = "Exception message cannot be null.";
    public static final String INTERNAL_SERVER_ERROR = "Unknown internal server error.";
    public static final String INCORRECT_USERNAME_PASSWORD = "The username or password is incorrect.";
    public static final String EMAIL_NOT_NULL = "Email cannot be null.";
    public static final String PHONE_NOT_NULL = "Phone Number cannot be null.";
    public static final String OTP_EXPIRED = "OTP expired.";
    public static final String OTP_INVALID = "OTP is invalid.";
    public static final String INVALID_HEADER = "Invalid or missing Authorization header.";
    public static final String INVALID_REFRESH_TOKEN = "Invalid or expired refresh token.";
    public static final String CONFIRMED_PASSWORD_NOT_MATCHED = "Confirmed Password not matched.";
    public static final String RESET_PASSWORD_FAILED = "Reset Password Failed.";
    public static final String RESEND_TOO_FREQUENT = "Resend request is too frequent. Please wait before requesting again.";
    public static final String SEND_FAILED = "Send request failed.";

    public static final String USER_NOT_FOUND = "User not found.";
    public static final String USER_NOT_VERIFY = "User is not verified.";

    public static final String MENU_NOT_FOUND = "Menu not found.";
    public static final String MENU_CREATION_SUCCESSFUL = "Menu Create Successful.";
    public static final String MENU_UPDATE_SUCCESSFUL = "Menu Update Successful.";
    public static final String MENU_DELETE_SUCCESSFUL = "Menu Delete Successful.";

    public static final String MENU_TYPE_NOT_FOUND = "Menu Type not found.";
    public static final String MENU_TYPE_CREATION_SUCCESSFUL = "Menu Type Create Successful.";
    public static final String MENU_TYPE_UPDATE_SUCCESSFUL = "Menu Type Update Successful.";
    public static final String MENU_TYPE_DELETE_SUCCESSFUL = "Menu Type Delete Successful.";

    public static final String CATEGORY_NOT_FOUND = "Category not found.";
    public static final String CATEGORY_CREATION_SUCCESSFUL = "Category Create Successful.";
    public static final String CATEGORY_UPDATE_SUCCESSFUL = "Category Update Successful.";
    public static final String CATEGORY_DELETE_SUCCESSFUL = "Category Delete Successful.";

    public static final String GROUP_NOT_FOUND = "Group not found.";
    public static final String GROUP_CREATION_SUCCESSFUL = "Group Create Successful.";
    public static final String GROUP_UPDATE_SUCCESSFUL = "Group Update Successful.";
    public static final String GROUP_DELETE_SUCCESSFUL = "Group Delete Successful.";

    public static final String MENU_OUTLET_NOT_FOUND = "Menu Outlet not found.";
    public static final String MENU_OUTLET_CREATION_SUCCESSFUL = "Menu Outlet Create Successful.";
    public static final String MENU_OUTLET_UPDATE_SUCCESSFUL = "Menu Outlet Update Successful.";
    public static final String MENU_OUTLET_DELETE_SUCCESSFUL = "Menu Outlet Delete Successful.";

    public static final String MENU_ADDON_NOT_FOUND = "Menu Addon not found.";
    public static final String MENU_ADDON_CREATION_SUCCESSFUL = "Menu Addon Create Successful.";
    public static final String MENU_ADDON_UPDATE_SUCCESSFUL = "Menu Addon Update Successful.";
    public static final String MENU_ADDON_DELETE_SUCCESSFUL = "Menu Addon Delete Successful.";

    public static final String ADDON_NOT_FOUND = "Addon not found.";
    public static final String ADDON_CREATION_SUCCESSFUL = "Addon Create Successful.";
    public static final String ADDON_UPDATE_SUCCESSFUL = "Addon Update Successful.";
    public static final String ADDON_DELETE_SUCCESSFUL = "Addon Delete Successful.";

    public static final String MENU_MODIFIER_NOT_FOUND = "Menu Modifier not found.";
    public static final String MENU_MODIFIER_CREATION_SUCCESSFUL = "Menu Modifier Create Successful.";
    public static final String MENU_MODIFIER_UPDATE_SUCCESSFUL = "Menu Modifier Update Successful.";
    public static final String MENU_MODIFIER_DELETE_SUCCESSFUL = "Menu Modifier Delete Successful.";

    public static final String MODIFIER_NOT_FOUND = "Modifier not found.";
    public static final String MODIFIER_CREATION_SUCCESSFUL = "Modifier Create Successful.";
    public static final String MODIFIER_UPDATE_SUCCESSFUL = "Modifier Update Successful.";
    public static final String MODIFIER_DELETE_SUCCESSFUL = "Modifier Delete Successful.";

    public static final String MODIFIER_GROUP_NOT_FOUND = "Modifier Group not found.";
    public static final String MODIFIER_GROUP_CREATION_SUCCESSFUL = "Modifier Group Create Successful.";
    public static final String MODIFIER_GROUP_UPDATE_SUCCESSFUL = "Modifier Group Update Successful.";
    public static final String MODIFIER_GROUP_DELETE_SUCCESSFUL = "Modifier Group Delete Successful.";

    public static final String PRICE_NOT_FOUND = "Price not found.";
    public static final String PRICE_CREATION_SUCCESSFUL = "Price Create Successful.";
    public static final String PRICE_UPDATE_SUCCESSFUL = "Price Update Successful.";
    public static final String PRICE_DELETE_SUCCESSFUL = "Price Delete Successful.";

    public static final String SIZE_NOT_FOUND = "Size not found.";
    public static final String SIZE_CREATION_SUCCESSFUL = "Size Create Successful.";
    public static final String SIZE_UPDATE_SUCCESSFUL = "Size Update Successful.";
    public static final String SIZE_DELETE_SUCCESSFUL = "Size Delete Successful.";
}
