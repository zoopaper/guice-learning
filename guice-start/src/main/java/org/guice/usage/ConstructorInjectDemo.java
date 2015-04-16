package org.guice.usage;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.guice.usage.service.IUserService;
import org.guice.usage.service.internal.UserService;

/**
 * <p/>
 * 构造函数注入的好处是可以保证只有一个地方来完成属性注入，
 * 这样可以确保在构造函数中完成一些初始化工作（尽管不推荐这么做）。
 * 当然构造函数注入的缺点是类的实例化与参数绑定了，限制了实例化类的方式。
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 9:35
 */
public class ConstructorInjectDemo {

    private IUserService userService;

    @Inject
    public ConstructorInjectDemo(IUserService userService) {

        this.userService = userService;

    }

    public void list() {
        userService.list();
    }


    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(IUserService.class).to(UserService.class);
            }
        });

        ConstructorInjectDemo constructorInjectDemo = injector.getInstance(ConstructorInjectDemo.class);
        constructorInjectDemo.list();

    }
}
