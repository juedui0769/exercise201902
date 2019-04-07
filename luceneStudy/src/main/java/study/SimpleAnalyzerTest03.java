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
 * create at 2019年4月7日21:13:23 ,
 * <p>
 * 只是将 {@link SimpleAnalyzerTest02} 中的代码稍加修改，而已。
 * </p>
 */
public class SimpleAnalyzerTest03 {

    public static void main(String[] args) throws IOException {
        SimpleAnalyzerTest03 sat = new SimpleAnalyzerTest03();

        // new File("F:\\wxgtest\\66", "chaptersContent01.txt");
        File sourceFile = new File("F:\\wxgtest\\66", "appendixContent01.txt");
        // new File("F:\\wxgtest\\66", "chaptersWords01.txt");
        File saveFile = new File("F:\\wxgtest\\66", "appendixWords01.txt");

        sat.obtainAndSaveWordsFromFile(sourceFile, saveFile);
    }

    /**
     * 从本地文件中获取文本，解析出单词，然后保存到本地文件中。
     * @param sourceFile
     * @param saveFile
     * @throws IOException
     */
    public void obtainAndSaveWordsFromFile(File sourceFile, File saveFile) throws IOException {
        Set<String> wordSet = new HashSet<>();

        SimpleAnalyzer analyzer = new SimpleAnalyzer();

        List<String> lines = Files.readLines(sourceFile, Charsets.UTF_8);

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
            Files.write(ss.toString().getBytes(Charsets.UTF_8), saveFile);
        }
    }
}
