package kz.kaznu.parser.spiders;

import kz.kaznu.parser.utils.URLUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yerzhan.khibatkhanuly on 2/1/18.
 */
public class ContactSpider {

    private final Logger logger = LoggerFactory.getLogger(ContactSpider.class);

    public String findAndGetContactWebPageContent(String url) throws IOException {
        StringBuilder allContactPagesContent = new StringBuilder();
        try {
            System.out.println("URL = " + url);
            Document doc = getDocumentByUrl(url);

            Set<String> contactUrls = new HashSet<>();

            if(doc.text().toLowerCase().contains("contact")) {
                Elements elements = doc.select("a");
                for (Element element : elements) {
                    if(element.text().toLowerCase().contains("contact") || element.text().toLowerCase().contains("about")) {
                        String contactUrl = URLUtils.addURLPrefixIfNeedIt(url, element.attr("href"));
                        contactUrls.add(contactUrl);
                    }
                }
                for (String contactUrl : contactUrls) {
                    Document contactDoc = getDocumentByUrl(contactUrl);
                    allContactPagesContent.append(" ").append(contactDoc.text());
                }
            } else {
//                logger.info("This web page not have contact page: " + url);
            }
            return allContactPagesContent.toString();
        } catch (Exception e) {
//            logger.error("Error in page parsing!", e);
            e.printStackTrace();
            return null;
        }
    }

    private Document getDocumentByUrl(String url) throws IOException {
        return Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                .header("Accept-Language", "en")
                .timeout(20000)
                .followRedirects(true)
                .get();
    }
}
