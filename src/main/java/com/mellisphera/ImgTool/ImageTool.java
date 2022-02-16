package com.mellisphera.ImgTool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;

@Service
public class ImageTool {

    private static final String CLIENT_PATH = "./assets/client/";
    @Value("${mellisphera.app.img.pathServer}")
    private String server_path;
    private String[] base64;
    private String extension;
    private String userId;
    private String fileName;
    private String pathFile;
    public void setConf(String base64, String userId){
        this.base64 = base64.split(",");
        this.userId = userId;
	    //this.server_path = "/apiwatch/production/imgClient/";
        this.getExtension();
    }


   private void getExtension() {
        switch (this.base64[0]) {//check image's extension
            case "data:image/jpeg;base64":
                this.extension = "jpeg";
                break;
            case "data:image/png;base64":
                this.extension = "png";
                break;
            default://should write cases for more images types
                this.extension = "jpg";
                break;
        }
    }

    public void convertToFile() {
        byte[] data = DatatypeConverter.parseBase64Binary(this.base64[1]);
        this.fileName = this.userId + "-" + new Date().getTime() + "." + this.extension;
        this.pathFile = this.server_path + this.fileName;
        File file = new File(this.pathFile);
	try{
            BufferedImage bufferedImg = ImageIO.read(new ByteArrayInputStream(data));
            ImageIO.write(bufferedImg, this.extension, file);
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("convert " + this.pathFile + " -resize 800 " + this.pathFile);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPath() {
        return this.pathFile;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getPathClient() {
        return CLIENT_PATH + this.fileName;
    }

}
