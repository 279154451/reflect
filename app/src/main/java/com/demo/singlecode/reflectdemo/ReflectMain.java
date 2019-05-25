package com.demo.singlecode.reflectdemo;

import com.demo.singlecode.reflectdemo.proxy.ACosmeticFactory;
import com.demo.singlecode.reflectdemo.proxy.BCosmeticFactory;
import com.demo.singlecode.reflectdemo.proxy.CosmeticProxy;
import com.demo.singlecode.reflectdemo.proxy.FactoryInterface;
import com.demo.singlecode.reflectdemo.proxy.Lipstick;
import com.demo.singlecode.reflectdemo.proxy.Mask;
import com.demo.singlecode.reflectdemo.proxy.ProxyCompany;

/**
 * 创建时间：2019/5/20
 * 创建人：singleCode
 * 功能描述：
 **/
public class ReflectMain {

    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException,IllegalAccessException{
//        //实例的标准用法
//        ReflectBean bean = new ReflectBean();
//        bean.setName("大家好，我是韦小宝");
//        /*
//        *Java中我们至少可以通过如下三种方式获取到一个类的Class对象。前两种都是在知道这个类具体是什么类的情况下获取到的，
//        * 第三种是只通过类名，利用ClassLoader来获取的，目前很多的框架都是通过这种方式来加载一个类对象
//         */
//        Class beanClass1 = ReflectBean.class;
//        Class beanClass2 = bean.getClass();
//        Class beanClass3 =  Class.forName("com.demo.singlecode.reflectdemo.Bean.ReflectBean");
//
//        /**
//         * 如果只拿到Class对象对于调用者来说没有什么实质性意义，我们需要通过Class对象来获取到类对象才能够调用方法修改属性等。
//         * 有人是不是又懵了，咋又是Class对象，又是类对象呢？
//         * 大家可以这样来理解，Class对象只是用来保存这个类的信息，供虚拟机使用。而类对象可以看成是一个实体，能够实现某种功能，供调用者使用。
//         */
//        ReflectBean newBean = (ReflectBean) beanClass1.newInstance();
//        newBean.setName("大家好，才是真的好");
//        /**
//         * Java中创建一个对象实例，我们首先需要知道这个类的构造函数，然后调用构造函数创建对象
//         * Java中的每个类都有至少一个构造方法，如果我们现在只有一个Class对象，那么如何通过Class对象来获取这些构造方法呢？JDK为我们提供了方法
//         */
//        /**
//         * 获取这个Class对象所在类的所有构造函数的构造器
//         */
//       Constructor[] constructors = beanClass3.getConstructors();
//       for(Constructor constructor :constructors){
//           System.out.println(constructor);
//       }
//
//        /**
//         * 获取某个带参数的构造函数的构造器
//         */
//        try {
//            Constructor<ReflectBean> constructor = beanClass3.getConstructor(String.class);
//            System.out.println(constructor);
//            //这里需要注意，构造函数里面的参数类型是什么类型，我们就传什么类型的Class，不需要进行转型等操作
//            Constructor<ReflectBean> constructor2 = beanClass3.getConstructor(String.class,int.class);
//            System.out.println(constructor2);
//            /*
//             *获取到构造器后，如何创建一个对象呢,Class对象可以通过newInstance的方式来创建类对象，构造器同样有类似的方法
//             */
//           ReflectBean bean1 = constructor2.newInstance("爱你呀",18);//需要传入这个构造器所对应的构造函数的实参
//           System.out.println(bean1.getName());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        /*
//        *那么这里我们就讲了三种创建类对象的方式，分别是：
//        *  1、new的方式创建类对象
//        *  2、通过Class对象调用newInstance获取类对象
//        *  3、通过构造器调用构造方法获取类对象
//         */
//
//        /**
//         * 现在我们构造器也取到了，也能创建类对象了，那么接下来就是调用这个类对象的方法了，但是我们如何获取这个类中的方法并调用呢?
//         * JDK同样为我们提供了API
//         */
//        /**
//         *获取所有非私有方法
//         */
//        Method[] methods = beanClass3.getMethods();
//        for(Method method :methods){
//            System.out.println(" "+method.getName());
//        }
//        /**
//         * 那么我想获取所有方法，包括私有方法怎么办呢？
//         */
//        Method[]  methods1 = beanClass3.getDeclaredMethods();
//        for(Method method:methods1){
//            System.out.println(" declare Method :"+method.getName());
//        }
//        /**
//         * 上面都是获取所有方法，那么我想想获取构造器一样，获取指定方法怎么办呢
//         * 第一个参数是，将要获取的方法的方法名，后面是这个方法所对应的参数列表中各个参数所对应的参数类型的Class
//         */
//        try {
//            Method method = beanClass3.getMethod("setName", String.class);//指定的方法只能是非私有的方法
//            System.out.println("single public method :"+method.getName());
//            Method method1 = beanClass3.getDeclaredMethod("setCode");//指定的方法可以是私有方法
//            System.out.println("single private method :"+method1.getName());
//
//            /**
//             * 现在方法我们也取到了，类对象我们也取到了，那么如何调用这个方法呢，看过源码的应该知道，Method中有一个invoke方法，
//             * 调用这个invoke方法我们就可以实现对当前Class所在的类中的方法的调用，这也是通过反射调用方法的最后一步
//             */
//
//            Object object = beanClass3.newInstance();
//            /**8
//             * 第一个参数是这个类对象的实例，后面是该方法所对应的实参
//             */
//            method.invoke(object,"求包养");
//            /**
//             * 如果该方法是私有方法我们必须加上setAccessible(true)打开访问权限
//             */
//            method1.setAccessible(true);
//            method1.invoke(object);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        /**
//         * Java类对象中除了方法，还有字段（如变量、常量等）。如果我想访问或修改这些属性怎么办呢
//         */
//        /**
//         * 同理，这里只能够获取非私有的字段
//         */
//        Field[] fields = beanClass3.getFields();
//
//        /**
//         * 获取当前类对象的所有字段包括私有字段
//         */
//        Field[] fields1 = beanClass3.getDeclaredFields();
//
//        try {
//            /**
//             * 获取指定的非私有字段，参数为字段名称
//             */
//            Field field = beanClass3.getField("name");
//
//            /**
//             * 获取指定的字段，包括私有字段，参数为字段名称
//             */
//            Field field1 = beanClass3.getDeclaredField("code");
//
//            /**
//             * 如果我想修改某个字段的值怎么办呢
//             */
//            Object object = beanClass3.newInstance();
//
//            /**
//             * 访问字段
//             */
//            field.set(object,"小慈");
//            Object value = field.get(object);
//            System.out.println("public field :"+value);
//            /**
//             * 如果该字段是私有字段，我们必须加上setAccessible(true)打开访问权限
//             */
//            field1.setAccessible(true);
//            field1.set(object,18);
//            Object value1= field1.get(object);
//            System.out.println("private field :"+value1);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }


        /**
         *    静态代理模式
         */
//        //代理品牌A
//        ACosmeticFactory factoryA = new ACosmeticFactory();
//        CosmeticProxy proxyA = new CosmeticProxy(factoryA);//代理A
//        Lipstick lipsticka = (Lipstick) proxyA.SellCosmetic("com.demo.singlecode.reflectdemo.proxy.Lipstick");
//        lipsticka.onBecomeBeautiful();
//        Mask maska = (Mask) proxyA.SellCosmetic("com.demo.singlecode.reflectdemo.proxy.Mask");
//        maska.onBecomeBeautiful();
//
//        //代理品牌B
//        BCosmeticFactory factoryB = new BCosmeticFactory();
//        CosmeticProxy proxyB = new CosmeticProxy(factoryB);//代理B
//        Lipstick lipstickb = (Lipstick) proxyB.SellCosmetic("com.demo.singlecode.reflectdemo.proxy.Lipstick");
//        lipstickb.onBecomeBeautiful();
//        Mask maskb = (Mask) proxyB.SellCosmetic("com.demo.singlecode.reflectdemo.proxy.Mask");
//        maskb.onBecomeBeautiful();

        /**
         * 动态代理模式
         */
        ProxyCompany company = new ProxyCompany();//代理公司
        //输入需要的品牌，返回负责这个品牌的代理人员
        FactoryInterface proxyA = (FactoryInterface) company.getProxyInstance(ACosmeticFactory.class);
        //输入化妆品名称，返回化妆品
        Mask maskA = (Mask) proxyA.SellCosmetic("com.demo.singlecode.reflectdemo.proxy.Mask");
        maskA.onBecomeBeautiful();

        FactoryInterface proxyB = (FactoryInterface) company.getProxyInstance(BCosmeticFactory.class);
        Mask maskB = (Mask) proxyB.SellCosmetic("com.demo.singlecode.reflectdemo.proxy.Mask");
        maskB.onBecomeBeautiful();

    }
}
