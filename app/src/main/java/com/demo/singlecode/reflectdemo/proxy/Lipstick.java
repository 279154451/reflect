package com.demo.singlecode.reflectdemo.proxy;

/**
 * 创建时间：2019/5/25
 * 创建人：singleCode
 * 功能描述：口红
 **/
public class Lipstick implements CosmeticInterface {
    @Override
    public void onBecomeBeautiful() {
        System.out.println("涂了口红变漂亮啦！");
    }
}
