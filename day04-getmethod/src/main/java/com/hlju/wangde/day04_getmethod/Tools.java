package com.hlju.wangde.day04_getmethod;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by XiaoDe on 2017/6/5 16:56.
 *
 * @author XiaoDe.
 *         Project Name is LearnAndroidProject.
 */

public class Tools {
    public static String getTextFromStream(InputStream is){
        byte[] bytes = new byte[1024];
        int len;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try{
            while((len = is.read())!= -1){
                byteArrayOutputStream.write(bytes, 0,len);
            }
            String text = new String(byteArrayOutputStream.toByteArray());
            return text;
        }catch (Exception e){e.printStackTrace();}

        return null;
    }
}
