package com.demo.singlecode.reflectdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建时间：2019/5/25
 * 创建人：singleCode
 * 功能描述：代购公司
 **/
public class ProxyCompany implements InvocationHandler {
    private Object factory;//持有真实对象

    public Object getProxyInstance(Class<?> factoryClass){
        try {
            factory = factoryClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
//        返回代理对象
        return Proxy.newProxyInstance(factoryClass.getClassLoader(),factory.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(factory,args);//通过反射调用被代理对象的方法，result即为接口的真实实现类的返回值
        return result;
    }
}
