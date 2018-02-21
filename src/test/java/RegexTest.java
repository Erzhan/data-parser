import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yerzhan.khibatkhanuly on 2/18/18.
 */
public class RegexTest {

    @Test
    public void testRegex() {

        String text = "Company, 18540 Main Ave., City, ST 12345, Company 18540 Main Ave. City ST 12345-0000, " +
                "Company 18540 Main Ave. City State 12345, Company, 18540 Main Ave., City, ST 12345 USA, Company, " +
                "One Main Ave Suite 18540, City, ST 12345";

        String regex = "(\\d{5}-\\d{4})|(\\d{5})";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}
