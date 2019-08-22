package test;

import java.io.FileInputStream;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class Test2 {

    public static void main(String[] args) throws Exception{ 
      String aaa = "aaaaa";
      System.out.println(JSON.toJSONString(aaa));
    }

 
}
