package com.applcn.wechat.core.utils;

import com.applcn.wechat.core.annotation.XmlNode;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * map工具
 * @author dayaoguai
 */
public class MapUtil {

    /**
     * 对象转map
     * @param object
     * @return
     * @throws Exception
     */
    public static Map<String, String> pojoToMap(Object object) throws Exception {
        Field[] fields = object.getClass().getDeclaredFields();
        Map<String, String> map = new HashMap<>(fields.length);
        for (Field item : fields) {
            String key = item.getName().getClass().getAnnotation(XmlNode.class).value();
            String value = item.get(object).toString();
            map.put(key, value);
        }
        return map;
    }

    /**
     * map转java对象
     * @param map
     * @param t
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T mapToPojo(Map<String, String> map, Class<T> t) throws Exception {
        T object = t.newInstance();
        Field[] fields = t.getDeclaredFields();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            for (Field item : fields) {
                String name;
                if (item.isAnnotationPresent(XmlNode.class)) {
                    name = item.getAnnotation(XmlNode.class).value();
                } else {
                    name = item.getName();
                }
                if (entry.getKey().equals(name)) {
                    Method method;
                    String value = entry.getValue();
                    String genericType = item.getGenericType().toString();
                    String className = item.getType().getName();
                    String methodName = item.getName().substring(0, 1).toUpperCase() + item.getName().substring(1);
                    method = object.getClass().getMethod("set" + methodName, Class.forName(className));

                    if("class java.lang.String".equals(genericType)){
                        method.invoke(object,  value);
                    }

                    if("class java.lang.Integer".equals(genericType)){
                        method.invoke(object,  Integer.parseInt(value));
                    }

                    if("class java.lang.Long".equals(genericType)){
                        method.invoke(object,  Long.parseLong(value));
                    }
                }
            }
        }
        return object;
    }
}
