package com.applcn.wechat.core.annotation;

import java.lang.annotation.*;

/**
 * xml节点名注解
 * @author dayaoguai
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlNode {

    String value();
}
