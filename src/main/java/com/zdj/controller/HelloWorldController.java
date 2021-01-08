package com.zdj.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Properties;

/**
 * @author zhangdj
 * @date 2019/10/10
 */
@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("test")
    public void download(HttpServletResponse response) throws Exception{
        response.setContentType("application/octet-stream");
        String fileName = "是的阿萨德.pdf";
//        response.setHeader("Content-Disposition",
//                "inline;fileName=\"" + fileName);
        response.setHeader("Content-Disposition",
                "inline;fileName=\"" + new String(fileName.getBytes("UTF-8"), "ISO8859-1") + "\"");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, bos);
        document.open();
        //写"拜访对象信息"标题并且画线
        Paragraph paragraph = new Paragraph("拜访对象信息");
        document.add(paragraph);
        document.close();
        OutputStream outputStream = response.getOutputStream();
        bos.writeTo(outputStream);
        outputStream.flush();
    }

    @GetMapping("getConfig")
    public String getConfig() {
        String key = "list";
        String filePath = "D:/white.properties";
        String value="";
        Properties p = new Properties();
        InputStream is = null;
        try {
            //下面为动态获取
            is = new FileInputStream(filePath);
            p.load(is);
            value=p.getProperty(key);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
        }
        return value;
    }
}
