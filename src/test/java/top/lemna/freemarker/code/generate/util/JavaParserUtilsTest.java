package top.lemna.freemarker.code.generate.util;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import top.lemna.freemarker.code.generate.JavaField;


@ExtendWith(MockitoExtension.class)
class JavaParserUtilsTest {

  private String fileName;
  
  @BeforeEach
  void setup()throws Exception{
    fileName = "D:\\workspace\\shashou\\shashou2\\src\\main\\java\\top\\lemna\\shashou\\dictionary\\persistence\\domain\\TestDictionary.java";
  }
  
  @Test
  final void testParserJava() throws Exception {
    List<JavaField> list = JavaParserUtils.parserJava(fileName);
    for (JavaField javaField : list) {
      System.out.println(javaField);
    }
  }

}
