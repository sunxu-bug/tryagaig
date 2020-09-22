package org.sunxu.aop;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service("aopDemp")
public class AopDemp {

    public void qianzhifangfa(JoinPoint joinPoint) throws Exception {
        Sunxu sunxu = hasSunxu(joinPoint);
        if (sunxu != null) {
            String name = sunxu.name();
            String opt = sunxu.opt();
            System.out.println("qianzhifangfa" + name + "==" + opt);
        }
    }

    public void houzhifangfa(JoinPoint joinPoint) throws Exception {
        Sunxu sunxu = hasSunxu(joinPoint);
        if (sunxu != null) {
            String name = sunxu.name();
            String opt = sunxu.opt();
            System.out.println("houzhifangfa" + name + "==" + opt);
        }
    }

    public Sunxu hasSunxu(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class<?>[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    // B方法
                    Sunxu kl = method.getAnnotation(Sunxu.class);
                    return kl;
                }
            }
        }
        return null;
    }

}
