package top.lemna.freemarker.code.generate.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.type.Type;
import top.lemna.freemarker.code.generate.JavaField;

public class JavaParserUtils {

  public static List<JavaField> parserJava(String fileName) throws Exception {
    FileInputStream in = new FileInputStream(fileName);
    CompilationUnit compilationUnit = StaticJavaParser.parse(in);
    List<JavaField> fieldList = parserJava(compilationUnit.findAll(FieldDeclaration.class));
    return fieldList;
  }

  private static List<JavaField> parserJava(List<FieldDeclaration> list) {
    List<JavaField> fieldList = new ArrayList<JavaField>();
    for (FieldDeclaration f : list) {
      JavaField field = parserJava(f);
      if (!field.getName().equals("serialVersionUID")) {
        fieldList.add(field);
      }
    }
    return fieldList;
  }

  private static JavaField parserJava(FieldDeclaration fieldDeclaration) {
    // 注释
    String comment = getComment(fieldDeclaration);

    // 类型
    Type elementType = fieldDeclaration.getElementType();
    // 名称
    SimpleName name = fieldDeclaration.getVariables().get(0).getName();
    // 注解
    NodeList<AnnotationExpr> annotations = fieldDeclaration.getAnnotations();
    Set<String> set = new HashSet<>();
    for (AnnotationExpr annotationExpr : annotations) {
      set.add(annotationExpr.toString().replaceAll(" ", ""));
    }

    return new JavaField(name.toString(), elementType.toString(), comment, set);
  }

  private static String getComment(FieldDeclaration fieldDeclaration) {

    Optional<Comment> commentOptional = fieldDeclaration.getComment();
    if (!commentOptional.isPresent()) {
      return null;
    }
    Comment comment = commentOptional.get();
    String result = comment.getContent();
    return result.replaceAll("(\r\n|\r|\n|\n\r|\\*|/)", "").trim();
  }
}
