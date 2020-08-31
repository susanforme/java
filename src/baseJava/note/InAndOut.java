package baseJava.note;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class InAndOut {
  public static void main(final String[] args) {
    // 文件的写入
    try {
      // 相对路径报错文件不存在,文件名则会在根目录创建
      final PrintWriter out = new PrintWriter("baseJava/hello.txt", StandardCharsets.UTF_8);
      // 像使用System.out一样使用
      out.println("wo ai ni");
      out.close();
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }
}