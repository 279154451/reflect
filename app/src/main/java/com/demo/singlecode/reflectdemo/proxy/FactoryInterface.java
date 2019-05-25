package com.demo.singlecode.reflectdemo.proxy;

/**
 * 创建时间：2019/5/25
 * 创建人：singleCode
 * 功能描述：卖接口
 **/
public interface FactoryInterface {
    Object SellCosmetic(String name);

    /**
     * 查询产品说明
     * @param o
     * @param methodName
     */
    void productDetail(Class<?> o,String methodName);
}
