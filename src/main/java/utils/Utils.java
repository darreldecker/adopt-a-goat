package utils;

import java.util.regex.Pattern;

public class Utils {

    public static boolean isValidEmail(String email) {
        // Validates if the given string follows a valid email format
        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }
}
