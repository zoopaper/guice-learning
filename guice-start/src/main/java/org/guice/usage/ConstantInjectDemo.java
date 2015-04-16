package org.guice.usage;

import com.google.inject.*;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import java.util.Properties;

/**
 * 绑定常量
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 14:28
 */
public class ConstantInjectDemo {

    @Inject
    @Named("age")
    private int age;

    @Inject
    @Named("name")
    private String name;

    @Inject
    @Named("say")
    private String say;

    @Inject
    @Named("confKey")
    private String confKey;

    public static void main(String[] args) {


        Injector injector = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                Properties properties =new Properties();

                properties.setProperty("say","你好啊");
                properties.setProperty("confKey","kkkkkk");

                binder.bindConstant().annotatedWith(Names.named("age")).to(123);
                binder.bindConstant().annotatedWith(Names.named("name")).to("krisjin");

                Names.bindProperties(binder,properties);
            }
        });

        ConstantInjectDemo constantInjectDemo = injector.getInstance(ConstantInjectDemo.class);

        System.out.println(constantInjectDemo.age);
        System.out.println(constantInjectDemo.name);
        System.out.println(constantInjectDemo.say);
        System.out.println(constantInjectDemo.confKey);


    }
}
