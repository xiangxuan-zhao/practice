package com.zxx.serial;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2020/04/21
 */
public class TestFaseJson {
    /**
     * 验证FatJson序列化类型错误
     */
    @Test
    public void testFastJson() {
        Map<String, Object> map = new HashMap<>();
        final String name = "name";
        final String id = "id";
        map.put(name, "张三");
        map.put(id, 20L);
        JSONObject json = new JSONObject(map);
        String fastJsonString = json.toJSONString();
        Map<String, Object> mapFastJson = json.parseObject(fastJsonString, Map.class);
        System.out.println(fastJsonString + " [][][]" + mapFastJson);
        // 正确
        Assert.assertEquals(map.get(name), mapFastJson.get(name));
        // 错误  map.get(id)为Long类型 mapFastJson.get(id)为Integer类型
        Assert.assertNotEquals(map.get(id).getClass(), mapFastJson.get(id).getClass());
        Assert.assertNotEquals(map.get(id), mapFastJson.get(id));
    }
}
