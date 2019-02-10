package com.applcn.example.annotation;

import java.lang.annotation.*;

/**
 * model中的参数若被标记上此注解将不会被不定长参数赋值
 * @author dayaoguai
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Exclude {
}
