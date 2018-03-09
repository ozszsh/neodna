package com.dna.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by peng on 18/3/9.
 */
public class SerializeUtil {
    private static Logger logger = LogManager.getLogger(SerializeUtil.class.getName());

    public static byte[] toByteArray(Object obj){
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try{
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        }catch(Exception e){
            logger.error(e.getStackTrace(),e.getCause());
        }
        return bytes;
    }

    public static Object toObject(byte[] bytes){
        ByteArrayInputStream bais = null;
        try{
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        }catch(Exception e){
            logger.error(e.getStackTrace(),e.getCause());
            return null;
        }

    }
}
