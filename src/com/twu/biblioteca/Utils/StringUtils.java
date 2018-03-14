package com.twu.biblioteca.Utils;

import javax.swing.text.MaskFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String formatString(String string, String mask) throws Exception {
        MaskFormatter mf = new MaskFormatter(mask);
        mf.setValueContainsLiteralCharacters(false);
        mf.setAllowsInvalid(false);
        return mf.valueToString(string);
    }

    public static boolean containsOnlyNumbers(String text)
    {
        Pattern pattern = Pattern.compile("\\d*(\\.\\d{0,3})?");
        Matcher matcher = pattern.matcher(text);
        boolean isMatch = matcher.matches();
        return isMatch;
    }

    public static String centralizeString(String str, int size){
        int totalSpaces = size - str.length();
        if(totalSpaces <= 0) return str.substring(0, size);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalSpaces/2 ; i++) {
            sb.append(" ");
        }

        sb.append(str);

        for (int i = 0; i < totalSpaces/2 ; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }
}
