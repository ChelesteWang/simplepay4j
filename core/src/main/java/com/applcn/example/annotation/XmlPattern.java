package com.applcn.example.annotation;

import java.lang.annotation.*;

/**
 * xml节点名称用正则表达式匹配
 * 用于处理xxx_$n或xxx_$n_$m之类的数据
 * @author dayaoguai
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlPattern {

    String value();
}
