package com.mycloudwear.webtools;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * This class gets the txt file which is stored the all paths of the required type of clothes at the website.
 */
public class FileHelper {

    public static byte[] getTxt(String encryptedPhone, String path){
        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        File txt = new File("/Users/hephaest/UserPhotoLibrary/" + phoneNumber + path);
        try {
            FileInputStream in = new FileInputStream(txt);
            byte[] data = new byte[in.available()];
            in.read(data);
            in.close();
            return data;
        } catch (IOException e) {
            e.getStackTrace();
        }
        return new byte[0];
    }

    public static void updatePhoto(String encryptedPhone, String path, String fileName, String encryptedImg){
        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        String absolutae_path = "/Users/hephaest/UserPhotoLibrary/" + phoneNumber + path;
        // Base64
        try {
            byte[] imageByteArray = Base64.decode(encryptedImg);
            FileOutputStream imageOutFile = new FileOutputStream(absolutae_path + fileName);
            imageOutFile.write(imageByteArray);
            imageOutFile.close();
        } catch (Base64DecodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static void updateList(String encryptedPhone, String target_path, String list){
        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        String imgAddr = null;

        String rootPath = "/Users/hephaest/UserPhotoLibrary/" + phoneNumber + target_path;
        List<String> fileNameList = Arrays.asList(list.split(","));
        try {
            FileOutputStream fos = new FileOutputStream(rootPath);
            if(!list.isEmpty()){
                for(String path : fileNameList){
                    imgAddr = path + "\r\n";
                    fos.write(imgAddr.getBytes());
                }
            }
            else fos.write("".getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] getPhoto(String encryptedPhone, String path, String imgPath){
        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        File img = new File("/Users/hephaest/UserPhotoLibrary/" + phoneNumber + path + imgPath);
        ByteArrayOutputStream img_stream = new ByteArrayOutputStream();
        try {
            BufferedImage bi = ImageIO.read(img);
            ImageIO.write(bi, "jpg", img_stream);
            byte[] bytes = img_stream.toByteArray();
            img_stream.close();
            return bytes;
        } catch (IOException e) {
            e.getStackTrace();
        }
        return new byte[0];
    }

    public static void deleteFile(String encryptedPhone, String path, String targetPath){
        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        String absolute_path = "/Users/hephaest/UserPhotoLibrary/" + phoneNumber + path + targetPath;
        File targetFile = new File(absolute_path);
        targetFile.delete();
    }
}
