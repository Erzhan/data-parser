package kz.kaznu.parser;

import kz.kaznu.parser.models.Company;
import kz.kaznu.parser.ner.NamedEntityRecognizer;
import kz.kaznu.parser.spiders.ContactSpider;
import kz.kaznu.parser.utils.GsonUtils;

import java.io.IOException;

/**
 * Created by yerzhan.khibatkhanuly on 2/1/18.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        NamedEntityRecognizer ner = new NamedEntityRecognizer();
        ContactSpider spider = new ContactSpider();

        for (Company company : GsonUtils.readCompaniesFromFile()) {
            String content = spider.findAndGetContactWebPageContent("http://" + company.getDomain());
//            ner.analyzeText(content);
        }
    }
}
