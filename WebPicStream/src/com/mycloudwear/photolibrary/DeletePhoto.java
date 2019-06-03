package com.mycloudwear.photolibrary;

import com.mycloudwear.webtools.DeleteFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * remote server send the delete photo request.
 */
public class DeletePhoto extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)  {
        String list = request.getParameter("list");
        List<String> filePath = Arrays.asList(list.split(","));
        String phoneNumber = filePath.get(0);
        String imgAddr = null;
        String rootPath = "/Users/hephaest/UserPhotoLibrary/" + phoneNumber + "/MatchResults/";
        File photos = new File(rootPath);
        DeleteFile.deleteFileUnderDir(photos);
        File file = new File(rootPath, "matchResult.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> realPath = filePath.subList(1,filePath.size());
        try {
            FileOutputStream fos = new FileOutputStream(file);
            if(!list.isEmpty()){
                for(String path : realPath){
                    imgAddr = path + "\n";
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

}
