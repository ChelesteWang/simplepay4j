package com.applcn.wechat.core.utils;

import com.applcn.wechat.core.annotation.XmlNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * xml工具
 * @author dayaoguai
 */
public class XmlUtil {

    private static final String DEFAULT_ENCODING = "UTF-8";

    private static final String PREFIX_XML = "<xml>";

    private static final String SUFFIX_XML = "</xml>";

    private static final String PREFIX_CDATA = "<![CDATA[";

    private static final String SUFFIX_CDATA = "]]>";

    /**
     * pojo转换成xml
     * 默认加上CDATA,不加上空字段
     * @param obj 待转化的对象
     * @return xml格式字符串
     * @throws Exception JAXBException
     */
    public static String pojoToXml(Object obj) throws Exception {
        return pojoToXml(obj, true);
    }

    /**
     * pojo转换成xml
     *
     * @param obj 待转化的对象
     * @param isAddCDATA 是否加入
     * @return xml格式字符串
     * @throws Exception JAXBException
     */
    public static String pojoToXml(Object obj, boolean isAddCDATA) throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuffer strbuff = new StringBuffer(PREFIX_XML);
        for (Field item:fields) {
            item.setAccessible(true);
            String name;
            if(item.isAnnotationPresent(XmlNode.class)){
                name = item.getAnnotation(XmlNode.class).value();
            }else{
                name = item.getName();
            }

            if (item.get(obj) != null) {
                String value = item.get(obj).toString();
                strbuff.append("<").append(name).append(">");

                if (isAddCDATA) {
                    strbuff.append(PREFIX_CDATA);
                    strbuff.append(value);
                    strbuff.append(SUFFIX_CDATA);
                } else {
                    strbuff.append(value);
                }
                strbuff.append("</").append(name).append(">");
            }
        }
        strbuff.append(SUFFIX_XML);
        return strbuff.toString();
    }

    /**
     * xml转换成pojo  TODO 待完善
     *
     * @param xml xml格式字符串
     * @param t 待转化的对象
     * @return 转化后的对象
     * @throws Exception JAXBException
     */
    public static <T> T xmlToPojo(String xml, Class<T> t) throws Exception {
        T obj = t.newInstance();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        InputStream stream = new ByteArrayInputStream(xml.getBytes(DEFAULT_ENCODING));
        Document doc = documentBuilder.parse(stream);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getDocumentElement().getChildNodes();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                for (Field item:fields) {
                    String name;
                    if(item.isAnnotationPresent(XmlNode.class)){
                        name = item.getAnnotation(XmlNode.class).value();
                    }else{
                        name = item.getName();
                    }

                    if(name.equals(element.getNodeName()) && element.getTextContent() != null){
                        Method method;
                        String value = element.getTextContent();
                        String genericType = item.getGenericType().toString();
                        String className = item.getType().getName();
                        String methodName = item.getName().substring(0, 1).toUpperCase() + item.getName().substring(1);
                        method = obj.getClass().getMethod("set" + methodName, Class.forName(className));

                        if("class java.lang.String".equals(genericType)){
                            method.invoke(obj,  value);
                        }

                        if("class java.lang.Integer".equals(genericType)){
                            method.invoke(obj,  Integer.parseInt(value));
                        }

                        if("class java.lang.Long".equals(genericType)){
                            method.invoke(obj,  Long.parseLong(value));
                        }

                    }
                }
            }
        }
        stream.close();
        return obj;
    }

    /**
     * map转xml, 单层无嵌套
     * @param map
     * @param
     * @return
     */
    public static String mapToXml(Map<String, String> map, boolean isAddCDATA) {
        StringBuffer strbuff = new StringBuffer(PREFIX_XML);
        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                strbuff.append("<").append(entry.getKey()).append(">");
                if (isAddCDATA) {
                    strbuff.append(PREFIX_CDATA);
                    if (null != entry.getValue()) {
                        strbuff.append(entry.getValue());
                    }
                    strbuff.append(SUFFIX_CDATA);
                } else {
                    if (null != entry.getValue()) {
                        strbuff.append(entry.getValue());
                    }
                }
                strbuff.append("</").append(entry.getKey()).append(">");
            }
        }
        return strbuff.append(SUFFIX_XML).toString();
    }

    /**
     * xml转map 默认编码UTF-8
     * @param xml 待转化对象
     * @return
     */
    public static Map<String, String> xmlToMap(String xml) {
        return xmlToMap(xml, DEFAULT_ENCODING);
    }

    /**
     * xml转map
     * @param xml 待转化对象
     * @param encoding 编码
     * @return
     */
    public static Map<String, String> xmlToMap(String xml, String encoding) {
        try {
            Map<String, String> data = new HashMap<>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(xml.getBytes(encoding));
            Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            stream.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}