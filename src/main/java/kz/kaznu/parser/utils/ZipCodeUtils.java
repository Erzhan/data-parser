package kz.kaznu.parser.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yerzhan.khibatkhanuly on 2/20/18.
 */
public class ZipCodeUtils {
    public static List<String> extractZipCodes(String text) {
        List<String> zipCodes = new ArrayList<>();
        String regex = "(\\d{5}-\\d{4})|(\\d{5})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()) {
            zipCodes.add(matcher.group());
        }
        return zipCodes;
    }
}
