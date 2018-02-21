package kz.kaznu.parser;

import kz.kaznu.parser.models.Company;
import kz.kaznu.parser.ner.NamedEntityRecognizer;
import kz.kaznu.parser.spiders.ContactSpider;
import kz.kaznu.parser.utils.GsonUtils;
import kz.kaznu.parser.utils.ZipCodeUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by yerzhan.khibatkhanuly on 2/1/18.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        NamedEntityRecognizer ner = new NamedEntityRecognizer();
        ContactSpider spider = new ContactSpider();

//        final String urlWithContacts = "https://www.highwinds.com/company/contact-us/";
//        String content = spider.findAndGetContactWebPageContent(urlWithContacts);
//        ner.analyzeText(content);

        for (Company company : GsonUtils.readCompaniesFromFile()) {
            String content = spider.findAndGetContactWebPageContent("http://" + company.getDomain());
            List<String> list = ZipCodeUtils.extractZipCodes(content);
//            ner.analyzeText(content);
            System.out.println(list);
        }
    }
}
