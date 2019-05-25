package com.demo.singlecode.reflectdemo.Bean;

/**
 * 创建时间：2019/5/20
 * 创建人：singleCode
 * 功能描述：
 **/
public class ReflectBean {
    public String name;
    private int code;

    public ReflectBean(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public ReflectBean() {
    }

    public ReflectBean(String name) {
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    private void setCode(){

    }
}
