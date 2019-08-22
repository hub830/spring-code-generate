package test;

import java.io.StringReader;
import org.junit.jupiter.api.Test;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;

class TestTest {

  @Test
  final void testMain() {
//    com.sun.tools.javadoc.Main.execute(args)
    String classText = "public class Dummy{\n" + "//Comment\n" + "}";
    StringReader reader = new StringReader(classText);
//    ParseResult<CompilationUnit> compilationUnit = JavaParser.parse(classText);

    /*    for (Comment comment : compilationUnit.getAllContainedComments()) {
        System.out.println(comment.getContent());
    }*/
  }

}
