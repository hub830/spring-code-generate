package top.lemna.freemarker.code.generate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerGenerator {
  Configuration configuration;


  public FreemarkerGenerator(String templatePath) throws IOException {
    super();
    this.configuration = new Configuration(Configuration.getVersion());
    configuration.setDirectoryForTemplateLoading(new File(templatePath));
  }

  public void generator(Map<String, Object> dataMap, String templateName, String outFilePath,
      String outFileName) throws IOException, TemplateException {
    Writer out = null;
    Template template = configuration.getTemplate(templateName);
    File docFile = new File(outFilePath);
    docFile.mkdirs();
    out =
        new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFilePath + outFileName)));
    template.process(dataMap, out);
    out.flush();
  }
}
