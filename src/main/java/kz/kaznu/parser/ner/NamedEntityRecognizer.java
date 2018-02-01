package kz.kaznu.parser.ner;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.List;
import java.util.Properties;

/**
 * Created by yerzhan.khibatkhanuly on 2/1/18.
 */
public class NamedEntityRecognizer {

    public void analyzeText(String text) {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        pipeline.annotate(document);

        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);

        for(CoreMap sentence: sentences) {
            for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);
//                String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
//                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
//                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                String location = token.get(CoreAnnotations.LocationAnnotation.class);
                System.out.println("location = " + location);
//                if(ne.equalsIgnoreCase("location")) {
//                    System.out.println(word);
//                }

//                System.out.println("word = " + word);
//                System.out.println("pos = " + pos);
//                System.out.println("ne = " + ne);
            }
        }
    }

}
