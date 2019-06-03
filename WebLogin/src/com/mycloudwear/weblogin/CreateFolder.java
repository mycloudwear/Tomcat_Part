package com.mycloudwear.weblogin;

import com.mycloudwear.library.DecodeTool;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * This class create several personal folders in the website and stored the data of users.
 */
public class CreateFolder extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String encryptedPhone = request.getParameter("phone");
        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        System.out.println("coming...");
        String libraryPath = "/Users/hephaest/UserPhotoLibrary";
        String matchPath = libraryPath + "/" + phoneNumber + "/MatchResults";
        String userAlbumPath = libraryPath + "/" + phoneNumber + "/UserAlbum";
        //Create a folder of the account information of user.
        File dir = new File(libraryPath, phoneNumber);
        dir.mkdirs();
        //Create a folder which stores the matching result images of the users.
        File matchFile = new File(libraryPath + "/" + phoneNumber, "MatchResults");
        matchFile.mkdirs();
        //Create a folder which stores the txt file with matching result lists.
        File matchHTML = new File(matchPath, "matchResult.txt");
        matchHTML.createNewFile();
        //Create a folder which is the album of the user.
        File albumFile = new File(libraryPath + "/" + phoneNumber, "UserAlbum");
        albumFile.mkdirs();
        //Create a folder which stores the top images in the album.
        File topFile = new File(userAlbumPath, "Tops");
        topFile.mkdirs();
        //Create a folder which stores the txt file with top images list.
        File topHTML = new File(userAlbumPath + "/Tops", "topList.txt");
        topHTML.createNewFile();
        //Create a folder which stores the pants images in the album.
        File pantFile = new File(userAlbumPath, "Pants");
        pantFile.mkdirs();
        //Create a folder which stores the txt file with pants images list.
        File pantHTML = new File(userAlbumPath + "/Pants", "pantList.txt");
        pantHTML.createNewFile();
        //Create a folder which stores the skirt images in the album.
        File skirtFile = new File(userAlbumPath, "Skirts");
        skirtFile.mkdirs();
        //Create a folder which stores the txt file with skirt images list.
        File skirtHTML = new File(userAlbumPath + "/Skirts", "skirtList.txt");
        skirtHTML.createNewFile();
        //Create a folder which stores the portrait images of the user.
        File portraitFile = new File(libraryPath + "/" + phoneNumber, "UserPortrait");
        portraitFile.mkdirs();
    }
}
