package top.lemna.freemarker.code.generate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import freemarker.template.TemplateException;
import top.lemna.freemarker.code.generate.util.JavaParserUtils;

public class MyGenerator {
  private final String className;

  private final String domainName;

  private final String templatePath;

  private final String basePackage;

  private final String outPath;

  private final String artifactName;

  public MyGenerator(String className, String basePackage, String outPath, String templatePath) {
    super();
    this.className = className;
    this.templatePath = templatePath;
    this.outPath = outPath;
    this.basePackage = basePackage;
    this.artifactName = getArtifactName(basePackage);
    this.domainName = getDomainName(className);
  }

  public void generator() throws Exception {
    List<JavaField> list = JavaParserUtils.parserJava(className);

    // 生成 Repository
    generatorRepository(list);
    // 生成 Service
    generatorService(list);
    // 生成 Command
    generatorAddCommand(list);
    generatorEditCommand(list);
    generatorQueryCommand(list);
    // 生成 Specification
    generatorSpecification(list);
    // 生成 Controller
    generatorController(list);
  }

  private void generatorRepository(List<JavaField> list) throws IOException, TemplateException {
    String templateName = "persistence/Repository.ftl";
    String outFilePath = outPath + "/persistence/repository/";
    String outFileName = domainName + "Repository.java";
    Map<String, Object> dataMap = new HashMap<String, Object>();
    dataMap.put("classPath", basePackage);
    dataMap.put("domain", domainName);
    dataMap.put("fieldList", list);
    FreemarkerGenerator fg = new FreemarkerGenerator(templatePath);
    fg.generator(dataMap, templateName, outFilePath, outFileName);
  }

  private void generatorService(List<JavaField> list) throws IOException, TemplateException {
    String templateName = "persistence/Service.ftl";
    String outFilePath = outPath + "/persistence/service/";
    String outFileName = domainName + "Service.java";
    Map<String, Object> dataMap = new HashMap<String, Object>();
    dataMap.put("classPath", basePackage);
    dataMap.put("domain", domainName);
    dataMap.put("fieldList", list);
    FreemarkerGenerator fg = new FreemarkerGenerator(templatePath);
    fg.generator(dataMap, templateName, outFilePath, outFileName);
  }

  private void generatorAddCommand(List<JavaField> list) throws IOException, TemplateException {
    String templateName = "web/AddCommand.ftl";
    String outFilePath = outPath + "/web/command/";
    String outFileName = domainName + "AddCommand.java";
    Map<String, Object> dataMap = new HashMap<String, Object>();
    dataMap.put("classPath", basePackage);
    dataMap.put("domain", domainName);
    dataMap.put("fieldList", list);
    FreemarkerGenerator fg = new FreemarkerGenerator(templatePath);
    fg.generator(dataMap, templateName, outFilePath, outFileName);
  }

  private void generatorEditCommand(List<JavaField> list) throws IOException, TemplateException {
    String templateName = "web/EditCommand.ftl";
    String outFilePath = outPath + "/web/command/";
    String outFileName = domainName + "EditCommand.java";
    Map<String, Object> dataMap = new HashMap<String, Object>();
    dataMap.put("classPath", basePackage);
    dataMap.put("domain", domainName);
    dataMap.put("fieldList", list);
    FreemarkerGenerator fg = new FreemarkerGenerator(templatePath);
    fg.generator(dataMap, templateName, outFilePath, outFileName);
  }


  private void generatorQueryCommand(List<JavaField> list) throws IOException, TemplateException {
    String templateName = "web/QueryCommand.ftl";
    String outFilePath = outPath + "/web/command/";
    String outFileName = domainName + "QueryCommand.java";
    Map<String, Object> dataMap = new HashMap<String, Object>();
    dataMap.put("classPath", basePackage);
    dataMap.put("domain", domainName);
    dataMap.put("fieldList", list);
    FreemarkerGenerator fg = new FreemarkerGenerator(templatePath);
    fg.generator(dataMap, templateName, outFilePath, outFileName);
  }


  private void generatorSpecification(List<JavaField> list) throws IOException, TemplateException {
    String templateName = "web/Specification.ftl";
    String outFilePath = outPath + "/web/specification/";
    String outFileName = domainName + "Specification.java";
    Map<String, Object> dataMap = new HashMap<String, Object>();
    dataMap.put("classPath", basePackage);
    dataMap.put("domain", domainName);
    dataMap.put("fieldList", list);
    FreemarkerGenerator fg = new FreemarkerGenerator(templatePath);
    fg.generator(dataMap, templateName, outFilePath, outFileName);
  }

  private void generatorController(List<JavaField> list) throws IOException, TemplateException {
    String templateName = "web/Controller.ftl";
    String outFilePath = outPath + "/web/controller/";
    String outFileName = domainName + "Controller.java";
    Map<String, Object> dataMap = new HashMap<String, Object>();
    dataMap.put("classPath", basePackage);
    dataMap.put("domain", domainName);
    dataMap.put("artifact", artifactName);
    dataMap.put("fieldList", list);
    FreemarkerGenerator fg = new FreemarkerGenerator(templatePath);
    fg.generator(dataMap, templateName, outFilePath, outFileName);
  }

  static String getDomainName(String className) {
    return className.replaceAll("\\\\", "/")
        .substring(className.lastIndexOf("/"), className.lastIndexOf(".")).replaceAll("/", "");
  }

  static String getArtifactName(String basePackage) {
    return basePackage
        .substring(basePackage.lastIndexOf(".")+1);
  }
}
