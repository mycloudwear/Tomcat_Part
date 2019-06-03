package com.mycloudwear.webtools;

import java.util.Base64;

/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * This class is a tool which is used to decode the image encoded by Base64.
 */
public class DecodeTool {

    public DecodeTool(){}

    public String Base64Decoder(String str) {
        byte[] data = Base64.getDecoder().decode(str);
        String decode = null;
        decode = new String(data);
        return decode;
    }
}
