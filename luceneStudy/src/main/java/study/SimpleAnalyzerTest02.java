package study;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * create at 2019年4月7日20:53:25，
 * <p>
 * {@link SimpleAnalyzer#close()} 在最后调用这点毋庸置疑
 * </p>
 * <p>
 * {@link TokenStream#close()} 必须在for循环内调用，
 * 'reset()', 'end()', 'close()' 都要调用。
 * </p>
 */
public class SimpleAnalyzerTest02 {
    public static void main(String[] args) throws IOException {
        Set<String> wordSet = new HashSet<>();

        SimpleAnalyzer analyzer = new SimpleAnalyzer();

        File localFile = new File("F:\\wxgtest\\66", "chaptersContent01.txt");
        List<String> lines = Files.readLines(localFile, Charsets.UTF_8);

        if (lines != null) {
            try {
                for (String text : lines) {
                    TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(text));
                    CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);

                    try {
                        tokenStream.reset();
                        while (tokenStream.incrementToken()) {
                            wordSet.add(charTermAttribute.toString());
                        }
                        tokenStream.end();
                    } finally {
                        tokenStream.close();
                    }

                }
            } finally {
                analyzer.close();
            }
        }

        if (wordSet.size() > 0) {
            StringBuilder ss = new StringBuilder();
            for (String word : wordSet) {
                ss.append(word).append(", ");
            }
            Files.write(ss.toString().getBytes(Charsets.UTF_8),
                    new File("F:\\wxgtest\\66", "chaptersWords01.txt"));
        }

    }
}
