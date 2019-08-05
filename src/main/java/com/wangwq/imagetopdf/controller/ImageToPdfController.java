package com.wangwq.imagetopdf.controller;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;
import com.wangwq.imagetopdf.service.HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.Document;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description: get multiple images
 * @Author: wangwq
 * @CreateDate: 2019/08/04 22:16
 */
@Component
@RestController
@RequestMapping(value = "api/")
public class ImageToPdfController {

    String url = "imageurl";
    String path = "./file/";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @Description: use interface to get iamge
     * @Author: wangwq
     * @CreateDate: 2019/08/04 22:20
     */
    @GetMapping(value = "getimage")
    public String getImage() throws IOException {
        HttpClient client = new HttpClient();
        logger.info("start load image...");

        for(int i = 1; i< 69; i++) {
            String imgurl = url + i + ".jpg";
            HttpEntity httpEntity = client.getImageDataByGet(imgurl, "");
            byte[] b = EntityUtils.toByteArray(httpEntity);
            FileOutputStream fos = new FileOutputStream(path + i + ".jpg");
            fos.write(b);
            fos.close();
        }

        logger.info("loading end!");
        return "loading success";
    }

    /**
     * @Description: Generating PDF by reading pictures in batche
     * @Author: wangwq
     * @CreateDate: 2019/08/05 08:57
     */
    public static void toPdf(String imageFoldPath, String pdfPath) throws DocumentException {
        try {
            String imagepath = null;
            FileOutputStream fos = new FileOutputStream(pdfPath);
            Document doc = new Document(null, 0, 0, 0, 0);
            PdfWriter.getInstance(doc, fos);
            BufferedImage img =null;
            Image image =null;
            File file = new File(imageFoldPath);
            File[] files = file.listFiles();
            doc.setPageSize(new Rectangle(1600, 9900));

            for(int i = 1; i < 12; i++) {
                imagepath = imageFoldPath + i + ".jpg";
                doc.setPageSize(new Rectangle(1600,900));
                image = Image.getInstance(imagepath);
                doc.open();
                doc.add(image);
            }
            doc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws DocumentException {
        long starttime = System.currentTimeMillis();

        String imgpath = "./file/";
        String pdfpath = "./file/image.pdf";
        toPdf(imgpath, pdfpath);

        long endtime = System.currentTimeMillis();

        int time = (int)((endtime - starttime)/1000);

        System.out.println("The program runs: " + time + "s");
    }
}
