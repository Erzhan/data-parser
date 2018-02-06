package kz.kaznu.parser.utils;

public class URLUtils {
    public static String addURLPrefixIfNeedIt(String url, String path) {
        if(path.contains("http")) return path;
        return url + "/" + path;
    }
}
