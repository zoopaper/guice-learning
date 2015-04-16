package org.guice.usage;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.guice.usage.service.IUserService;
import org.guice.usage.service.internal.UserService;

import javax.inject.Inject;

/**
 * 实例变量属性注入
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 10:03
 */
public class InstanceFieldInjectDemo {


    @Inject
    private IUserService userService;

    public static void main(String[] args) {
        final InstanceFieldInjectDemo instanceFieldInjectDemo = new InstanceFieldInjectDemo();
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(IUserService.class).to(UserService.class);
//                binder().requestInjection(instanceFieldInjectDemo);

            }
        });
        injector.injectMembers(instanceFieldInjectDemo);
        instanceFieldInjectDemo.userService.list();

    }
}
