package test;

import java.io.FileInputStream;
import java.util.List;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class Test {

    public static void main(String[] args) throws Exception{
        FileInputStream in = new FileInputStream("D:\\workspace\\shashou\\shashou2\\src\\main\\java\\top\\lemna\\shashou\\dictionary\\persistence\\domain\\TestDictionary.java");

        // parse the file
        CompilationUnit compilationUnit = StaticJavaParser.parse(in);

    /*        List<Comment> list = compilationUnit.getAllContainedComments();
        for (Comment comment : list) {
          System.out.println(comment);
        }*/

        List<FieldDeclaration> list2 = compilationUnit.findAll(FieldDeclaration.class);
        for (FieldDeclaration f : list2) {
//          System.out.println(f.getComment());
//          System.out.println(f.getCommonType());
//          System.out.println(f.getElementType());
//        System.out.println(f.getVariables().get(0).getName());
        System.out.println(f.getAnnotations());
          System.out.println("------------------------------------");
        }
    /*    compilationUnit.findAll(FieldDeclaration.class).stream()
        .filter(f -> f.isFieldDeclaration())
        .forEach(f -> System.out.println("Check field at line " +
            f.getRange().map(r -> r.begin.line).orElse(-1)));
        // prints the resulting compilation unit to default system output
    //        System.out.println(cu.toString());
    
        compilationUnit.accept(new MethodVisitor(), null);*/
    }


    private static class MethodVisitor extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(MethodDeclaration n, Void arg) {
            /* here you can access the attributes of the method.
             this method will be called for all methods in this
             CompilationUnit, including inner class methods */
            System.out.println("method:"+n.getName());
            super.visit(n, arg);
        }

        @Override
        public void visit(ClassOrInterfaceDeclaration n, Void arg) {
            System.out.println("class:"+n.getName());
            System.out.println("extends:"+n.getExtendedTypes());
            System.out.println("implements:"+n.getImplementedTypes());

            super.visit(n, arg);
        }

        @Override
        public void visit(PackageDeclaration n, Void arg) {
            System.out.println("package:"+n.getName());
            super.visit(n, arg);
        }
    }
}
