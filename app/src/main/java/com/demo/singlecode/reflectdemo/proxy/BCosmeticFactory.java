package com.demo.singlecode.reflectdemo.proxy;

/**
 * 创建时间：2019/5/25
 * 创建人：singleCode
 * 功能描述：
 **/
public class BCosmeticFactory implements FactoryInterface {
    @Override
    public Object SellCosmetic(String name) {
        System.out.println("B 商家卖出一个 "+name+" 化妆品");
        Object object = null;
        try {
            Class cosmeticClass = Class.forName(name);
            object = cosmeticClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            return object;
        }
    }

    @Override
    public void productDetail(Class<?> o, String methodName) {

    }

}
