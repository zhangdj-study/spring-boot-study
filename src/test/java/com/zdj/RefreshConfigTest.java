package com.zdj;

import javax.tools.DocumentationTool;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdj
 * @date 2020/12/10
 */
public class RefreshConfigTest {

    public static void main(String[] args) {

        //class文件生成目录
        String targetPath = "D:\\generate\\target";

        //源文件目录
        String sourcePath = "D:\\generate\\source";
        File sourceFile = new File(sourcePath);
        List<File> sourceFiles = new ArrayList<File>();
        compiler(sourceFile, targetPath, sourceFiles);
        boolean result = compilerJavaFile(sourceFiles, targetPath);
        System.out.println("compiler finish!" + result);
    }

    /**
     * 递归获取java文件
     *
     * @param file       需要编译的文件夹
     * @param targetPath 编译后class类文件存放目录
     */
    public static void compiler(File file, String targetPath, List<File> sourceFiles) {
        File targetDir = new File(targetPath);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }
        if (file != null && file.exists()) {
            File[] listFiles = file.listFiles();
            if (null == listFiles || listFiles.length == 0) {
                return;
            }
            for (File file2 : listFiles) {
                // 判断是否是文件夹
                 if (file2.isDirectory()) {
                 compiler(file2, targetPath, sourceFiles);
                 } else {
                     if (file2.getName().endsWith(".java")) {
                         //将源文件目录中的Java文件加入集合中
                          sourceFiles.add(file2);
                     }
                 }
            }
        } else {
            System.out.println("传入格式未知文件");
        }
    }

    /**
     * 编译java文件
     *
     * @param sourceFile
     * @param targerPath
     * @return
     */
    public static boolean compilerJavaFile(List<File> sourceFile, String targerPath) {
        StandardJavaFileManager fileManager = getJavaCompiler().getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(sourceFile);
        return getJavaCompiler().getTask(null, fileManager, null, null, null, compilationUnits).call();
    }

    private static DocumentationTool getJavaCompiler() {
        return null;
    }


}
