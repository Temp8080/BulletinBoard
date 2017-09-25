package ua.com.callboard.utils.profiling;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Temp on 07.09.2017.
 */
public class ProfilingBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> beans = new HashMap<>();

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        for (Method m : beanClass.getDeclaredMethods()) {
            if(m.isAnnotationPresent(Profiling.class)) {
                System.out.println("postProcessBeforeInitialization");
                beans.put(beanName, beanClass);
                return bean;
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beans.containsKey(beanName)) {
            System.out.println("postProcessAfterInitialization");
            final Class beanClass = beans.get(beanName);
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (beanClass.getDeclaredMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(Profiling.class)) {
                        System.out.println("Start profiling for method " + method.getName());
                        long start = System.nanoTime();
                        Object result = method.invoke(bean, args);
                        System.out.println("End profiling for method " + method.getName() + " with time: " + (System.nanoTime() - start));
                        return result;
                    }
                    return method.invoke(bean, args);
                }
            });
        }
        return bean;
    }
}
