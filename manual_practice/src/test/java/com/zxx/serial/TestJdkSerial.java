package com.zxx.serial;

import com.zxx.utils.JdkSerialUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Administrator
 * @date 2020/04/21
 */
public class TestJdkSerial {
    @Test
    public void testJDKSerialOverwrite() throws IOException, ClassNotFoundException {
        PersonTransit person = new PersonTransit();
        person.setId(1L);
        person.setName("张三");
        person.setMale(true);
        person.setFriends(new ArrayList<PersonTransit>());

        Address address = new Address("某某小区xxx栋yy号");
        person.setAddress(address);
        File file = new File("testJdk.txt");
        // 序列化
        JdkSerialUtil.writeObject(file, person);
        // 反序列化
        PersonTransit personTransit = JdkSerialUtil.readObject(file);
        // 判断是否相等
        Assert.assertEquals(personTransit.getName(), person.getName());
        Assert.assertEquals(personTransit.getAddress().getDetail(), person.getAddress().getDetail());
    }
}
