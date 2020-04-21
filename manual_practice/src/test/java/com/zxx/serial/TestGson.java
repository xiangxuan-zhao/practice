package com.zxx.serial;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2020/04/21
 */
public class TestGson {
    /**
     * 验证GSON序列化类型错误
     */
    @Test
    public void testGSON() {
        Map<String, Object> map = new HashMap<>();
        final String name = "name";
        final String id = "id";
        map.put(name, "张三");
        map.put(id, 20L);
        Gson gson = new Gson();
        String jsonString = gson.toJson(map);

        Map<String, Object> mapGSON = gson.fromJson(jsonString, Map.class);
        // 正确
        Assert.assertEquals(map.get(name), mapGSON.get(name));
        // 不等  map.get(id)为Long类型 mapGSON.get(id)为Double类型
        Assert.assertNotEquals(map.get(id).getClass(), mapGSON.get(id).getClass());
        Assert.assertNotEquals(map.get(id), mapGSON.get(id));
        System.out.println(jsonString + " [][][]" + mapGSON);
    }
}
