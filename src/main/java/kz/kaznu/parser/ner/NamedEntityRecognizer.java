package kz.kaznu.parser.ner;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by yerzhan.khibatkhanuly on 2/1/18.
 */
public class NamedEntityRecognizer {

    private final Logger logger = LoggerFactory.getLogger(NamedEntityRecognizer.class);

    public void analyzeText(String text) {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        pipeline.annotate(document);

        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        StringBuilder s = new StringBuilder();
        List<String> contacts = new ArrayList<>();

        for(CoreMap sentence: sentences) {
            for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);

                if(ne.equals("LOCATION") || ne.equals("NUMBER")) {
                    s.append(" ").append(word);
                } else {
                    if(StringUtils.isNotBlank(s.toString())) {
                        contacts.add(s.toString());
                    }
                    s = new StringBuilder();
                }
            }
        }

        System.out.println("Addresses:");
        for (String contact : contacts) {
            System.out.println("\t" + contact);
        }
    }

}
