package com.demo.singlecode.reflectdemo.proxy;

/**
 * 创建时间：2019/5/25
 * 创建人：singleCode
 * 功能描述：化妆品代理
 **/
public class CosmeticProxy implements FactoryInterface {
    public FactoryInterface factory;//代理持有真实对象的引用。

    public CosmeticProxy(FactoryInterface factory) {
        this.factory = factory;
    }

    @Override
    public Object SellCosmetic(String name) {
        return factory.SellCosmetic(name);
    }

    @Override
    public void productDetail(Class<?> o, String methodName) {
        factory.productDetail(o,methodName);
    }

    /**
     * 售后服务，7天无理由退货
     */
    public void  salesService(){
        System.out.println("7天无理由退货，嗯，重新包装一下，卖给下一个倒霉蛋");
    }
}
