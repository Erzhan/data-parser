package kz.kaznu.parser.spiders;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by yerzhan.khibatkhanuly on 2/1/18.
 */
public class ContactSpider {
    public String findAndGetContactWebPageContent(String url) throws IOException {
        try {
            Document doc = Jsoup
                    .connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                    .header("Accept-Language", "en")
                    .timeout(20000)
                    .followRedirects(true)
                    .get();
            if(doc.text().toLowerCase().contains("contact")) {
                System.out.println("This page have contact or about page: " + url);
                Elements elements = doc.select("a");
                for (Element element : elements) {
                    if(element.text().toLowerCase().contains("contact") || element.text().toLowerCase().contains("about")) {
                        System.out.println(element.attr("href"));
                    }
                }
            } else {
                System.out.println("This web page not have contact page: " + url);
            }
            return doc.text();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
