package com.zxx.serial;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/04/21
 */
@Data
public class PersonTransit implements Serializable {
    private Long id;
    private String name;
    private Boolean male;
    private List<PersonTransit> friends;
    private transient Address address;

    /**
     * 自定义序列化写方法
     */
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(address.getDetail());
    }

    /**
     * 自定义序列化读方法
     */
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        this.setAddress(new Address((String)ois.readObject()));
    }
}
