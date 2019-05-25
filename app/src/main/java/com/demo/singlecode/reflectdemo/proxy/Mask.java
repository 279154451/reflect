package com.demo.singlecode.reflectdemo.proxy;

/**
 * 创建时间：2019/5/25
 * 创建人：singleCode
 * 功能描述：面膜
 **/
public class Mask implements CosmeticInterface {
    @Override
    public void onBecomeBeautiful() {
        System.out.println("敷了面膜变漂亮啦！");
    }
}
