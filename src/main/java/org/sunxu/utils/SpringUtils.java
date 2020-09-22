package org.sunxu.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {
//    这个工具类是从容器中把bean取出来
    public static Object getBean(String name) {
        String s = "applicationContext.xml";
        ApplicationContext conf = new ClassPathXmlApplicationContext(s);
        Object bean = conf.getBean(name);
        return bean;
    }

}
