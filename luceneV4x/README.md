
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
  String text = "hello";
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

