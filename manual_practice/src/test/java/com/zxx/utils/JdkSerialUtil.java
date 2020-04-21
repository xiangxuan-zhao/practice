package com.zxx.utils;

import java.io.*;

/**
 * @author Administrator
 * @date 2020/04/21
 */
public class JdkSerialUtil {

    public static <T> void writeObject(File file, T data) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));) {
            objectOutputStream.writeObject(data);
            objectOutputStream.flush();
        }
    }

    public static <T> void writeObject(ByteArrayOutputStream outputStream, T data) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);) {
            objectOutputStream.writeObject(data);
            objectOutputStream.flush();
        }
    }

    public static <T> T readObject(File file) throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fin);
        return (T) objectInputStream.readObject();
    }

    public static <T> T readObject(ByteArrayInputStream inputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return (T) objectInputStream.readObject();
    }
}
