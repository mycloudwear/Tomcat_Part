package com.mycloudwear.webtools;

import java.io.File;

public interface DeleteFile {

    static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //Find the deleted file by recursion.
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    static void deleteFileUnderDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //Find the deleted file by recursion.
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));

            }
        }
    }
}
