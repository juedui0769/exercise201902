package lucene.test;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;

/**
 * copy at 2019年4月7日16:25:58，
 * copy from : <a href="https://blog.csdn.net/ceclar123/article/details/10150839">csdn,</a>
 */
public class SimpleAnalyzerTest {

    public static void main(String[] args) {
        try {
            // 要处理的文本
            // "lucene分析器使用分词器和过滤器构成一个“管道”，文本在流经这个管道后成为可以进入索引的最小单位，
            // 因此，一个标准的分析器有两个部分组成，
            // 一个是分词器tokenizer,它用于将文本按照规则切分为一个个可以进入索引的最小单位。
            // 另外一个是TokenFilter，它主要作用是对切出来的词进行进一步的处理（如去掉敏感词、英文大小写转换、单复数处理）等。
            // lucene中的Tokenstram方法首先创建一个tokenizer对象处理Reader对象中的流式文本，
            // 然后利用TokenFilter对输出流进行过滤处理";
            String text = "The Lucene PMC is pleased to announce the release of the Apache Solr Reference Guide for Solr 4.4.";

            // 简单分词器(以非字母符来分割文本信息，并将语汇单元统一为小写形式，并去掉数字类型的字符)
            SimpleAnalyzer sa = new SimpleAnalyzer(Version.LUCENE_44);

            TokenStream ts = sa.tokenStream("field", text);
            CharTermAttribute ch = ts.addAttribute(CharTermAttribute.class);

            ts.reset();
            while (ts.incrementToken()) {
                System.out.println(ch.toString());
            }
            ts.end();
            ts.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
