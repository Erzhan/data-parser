package kz.kaznu.parser.spiders;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by yerzhan.khibatkhanuly on 2/1/18.
 */
public class ContactSpider {

    public String findAndGetContactWebPageContent(String url) throws IOException {
        Document doc = Jsoup
                .connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                .timeout(20000)
                .followRedirects(true)
                .get();
        System.out.println("Title = " + doc.title());
        return doc.text();
    }

}
