package com.member_level.member_level.util;

import java.util.Date;
import java.util.Map;

/**
 * The type Helper.
 */
public class Helper {
    /**
     * Is numeric boolean.
     *
     * @param strNum the str num
     * @return the boolean
     */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Convert with iteration string.
     *
     * @param map the map
     * @return the string
     */
    public static String convertMapWithIteration(Map<String, ?> map) {
        StringBuilder mapAsString = new StringBuilder();
        for (String key : map.keySet()) {
            mapAsString.append(map.get(key) + ", ");
        }
        mapAsString.delete(mapAsString.length() - 2, mapAsString.length());
        return mapAsString.toString();
    }
    public static String replacePlaceHolders(String message, String tier, String memberPercentages, String dob, int beans, Date tierExpireDate){
        if (message == null){
            return null;
        }

        message = message.replace("[tier]",tier);
        message = message.replace("[member_percentage]",memberPercentages);
        message = message.replace("[golden_member_expired_date]",tierExpireDate.toString());
        message = message.replace("[dob]",dob);
        return message;
    }

}
