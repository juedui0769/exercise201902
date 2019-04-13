package java.lang;

/**
 * create at 2019年4月13日13:05:48，
 */
public final class String {
    public String() {
        System.out.println("custom java.lang.String print");
    }

    /**
     *
<pre>
错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
public static void main(String[] args)
否则 JavaFX 应用程序类必须扩展javafx.application.Application

Process finished with exit code 1
</pre>
     * @param args
     */
    public static void main(String[] args) {
        String s = new String();

    }
}
