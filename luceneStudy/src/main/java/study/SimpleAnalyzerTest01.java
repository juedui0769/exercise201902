package study;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
import java.io.StringReader;

/**
 * create at 2019年4月7日20:39:57,
 * <p>
 * {@link SimpleAnalyzer#tokenStream(String, String)} 中的第一个参数'fieldName'在这个例子中可以随意指定。
 * </p>
 * <p>
 * {@link SimpleAnalyzer} 来自 'org.apache.lucene:lucene-analyzers-common:7.2.0'
 * </p>
 */
public class SimpleAnalyzerTest01 {
    public static void main(String[] args) throws IOException {
        SimpleAnalyzer analyzer = new SimpleAnalyzer();
        String text = "Lucene is a Java full-text search engine. " +
                "Lucene is not a complete application, " +
                "but rather a code library and API that can " +
                "easily be used to add search capabilities to applications.";
        TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(text));
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        try {
            tokenStream.reset();
            while (tokenStream.incrementToken()) {
                System.out.println(charTermAttribute.toString());
            }
            tokenStream.end();
        } finally {
            tokenStream.close();
            analyzer.close();
        }
    }
}
