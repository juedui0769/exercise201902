
> lucene 4.x
>
> 电脑上有本 Lucene 的书，但是一直没看完。
>
> 可以在'思否'上搜索`lucene`, 或者'知乎'、'Osc'……

## 大材小用

- 我想从英文文档中提取出英文单词，做成单词本。网络搜索解题思路，
    - 一种办法是: 使用正则表达式
    - 另一种方法: 使用分词工具。('分词'其实是针对中日韩文字的，英文的'分词'，参考 <https://www.zhihu.com/question/29940957> , 英文词干提取(Stemming), 词性还原(Lemmatisation))
- `SimpleAnalyzer` 就可以达到简单的提取单词的作用，但是如何使用lucene中的API，我有点怵。
- 参考 <https://segmentfault.com/a/1190000004422101> 中的写法，基本的用法如下：
- ```
  SimpleAnalyzer analyzer = new SimpleAnalyzer();
  String text = "Lucene is a Java full-text search engine. "
      + "Lucene is not a complete application, "
      + "but rather a code library and API that can easily "
      + "be used to add search capabilities to applications.";
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
  ```
- 如上, 'analyzer'和'steam'都需要`close`的

## github安全警告

- ```
  <dependency>
    <groupId>org.apache.lucene</groupId>
    <artifactId>lucene-core</artifactId>
    <version>[7.1.0,)</version>
  </dependency>
  ```
- <https://nvd.nist.gov/vuln/detail/CVE-2017-12629>
- 提交代码后，github弹出警告，建议使用Lucene 7.1.0以上的版本
- 我暂时不修改lucene版本，因为我这里的代码都是测试代码，从网上搜罗过来的。而且修改了之后，和我这个module的标题`luceneV4x`有些不符。

### 提交时也能看到提醒

> remote: Resolving deltas: 100% (3/3), completed with 3 local objects.
> remote:
> remote: GitHub found 1 vulnerability on juedui0769/exercise201902's default branch (1 high). To find out more, visit:
> remote:      https://github.com/juedui0769/exercise201902/network/alerts
> remote:
> To https://github.com/juedui0769/exercise201902.git






