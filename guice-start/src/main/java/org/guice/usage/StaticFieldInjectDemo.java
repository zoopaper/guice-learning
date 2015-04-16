package org.guice.usage;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.guice.usage.service.IUserService;
import org.guice.usage.service.internal.UserService;

import javax.inject.Inject;

/**
 * 我们并没有使用Guice获取一个StaticFieldInjectDemo实例（废话），实际上static字段（属性）是类相关的，因此我们需要请求静态注入服务。
 * 但是一个好处是在外面看起来我们的服务没有Guice绑定，甚至client不知道（或者不关心）服务的注入过程。
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 9:49
 */
public class StaticFieldInjectDemo {

    @Inject
    private static IUserService userService;


    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(IUserService.class).to(UserService.class);
                binder().requestStaticInjection(StaticFieldInjectDemo.class);
            }
        });
        StaticFieldInjectDemo.userService.list();
    }
}
