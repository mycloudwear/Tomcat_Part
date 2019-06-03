package com.mycloudwear.photolibrary;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * This class updates the matching result at the server.
 */
public class UpdateResult extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)  {
        String list = request.getParameter("list");
        List<String> infoList = Arrays.asList(list.split(","));
        String phoneNumber  = infoList.get(0);
        String fileName  = infoList.get(1);
        String encryptedImg  = infoList.get(2);
        String path = "/Users/hephaest/UserPhotoLibrary/" + phoneNumber + "/MatchResults/";
        // Base64
        try {
            byte[] imageByteArray = Base64.decode(encryptedImg);
            FileOutputStream imageOutFile = new FileOutputStream(path + fileName + ".jpg");
            imageOutFile.write(imageByteArray);
            imageOutFile.close();
        } catch (Base64DecodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
