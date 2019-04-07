package CoreNLP;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.IOException;

/**
 * copy at 2019年4月7日15:56:25，
 * copy form : <a href="https://github.com/stanfordnlp/CoreNLP/blob/master/examples/sample-maven-project/src/main/java/edu/stanford/nlp/StanfordCoreNLPEnglishTestApp.java">github sample code</a>
 * <p>
 * 运行失败, 我把'pom.xml'中的那个990MB的依赖注释掉了。
 * </p>
 */
public class StanfordCoreNLPEnglishTestApp {
    public static void main(String[] args) throws IOException {
        String[] englishArgs = new String[]{"-file",
                "sample-english.txt", "-outputFormat",
                "text", "-props", "english.properties"};
        StanfordCoreNLP.main(englishArgs);
    }
}
