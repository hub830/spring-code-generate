package top.lemna.freemarker.code.generate;

import java.util.Set;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JavaField {
  private String name;
  private String type;
  private String comment;
  private Set<String> annotations;

  public JavaField(String name, String type, String comment, Set<String> annotations) {
    super();
    this.name = name;
    this.type = type;
    this.comment = comment;
    this.annotations = annotations;
  }
}
