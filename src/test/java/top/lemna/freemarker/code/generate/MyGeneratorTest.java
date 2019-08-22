package top.lemna.freemarker.code.generate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MyGeneratorTest {
  MyGenerator myGenerator;

  private String className;

  private String templatePath;

  private String basePackage;

  private String outPath;

  @BeforeEach
  void setup() throws Exception {
    className =
        "D:/workspace/shashou/shashou2/src/main/java/top/lemna/shashou/dictionary/persistence/domain/TestDictionary.java";
    basePackage = "top.lemna.shashou.dictionary";
    templatePath = "freemarker/main/resources/template";
    outPath = "src/main/java/top/lemna/shashou/dictionary";
    myGenerator = new MyGenerator(className, basePackage, outPath, templatePath);
  }

  @Test
  final void testGenerator() throws Exception {
    myGenerator.generator();
  }

  // @Test
  public void testGetDomainName() throws Exception {

    className = className.replaceAll("\\\\", "/");
    className = className.substring(className.lastIndexOf("/"), className.lastIndexOf("."));
    className = className.replaceAll("/", "");
    System.out.println(className);
  }

}
