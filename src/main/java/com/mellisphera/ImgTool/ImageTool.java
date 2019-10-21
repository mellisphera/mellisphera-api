/* Copyright 2018-present Mellisphera
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */ 



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
    public ImageTool(String base64, String userId){
        this.base64 = base64.split(",");
        this.userId = userId;
        this.getExtension();

    }

    public ImageTool(){}


   private void getExtension() {
        switch (this.base64[0]) {//check image's extension
            case "data:image/jpeg;base64":
                this.extension = "jpeg";
                break;
            case "data:image/png;base64":
                this.extension = "png";
                break;
            case "data:image/svg;base64":
                this.extension = "svg";
                break;
            default://should write cases for more images types
                this.extension = "jpg";
                break;
        }
    }

    public void convertToFile() {
        byte[] data = DatatypeConverter.parseBase64Binary(this.base64[1]);
        this.fileName = this.userId + "-" + new Date().getTime() + "." + this.extension;
        this.pathFile = server_path + this.fileName;
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
