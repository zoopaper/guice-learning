package org.guice.usage;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.guice.usage.service.IUserService;
import org.guice.usage.service.internal.UserService;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 9:44
 */
public class SetterInjectDemo {

    private IUserService userService;

    @Inject
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }


    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(IUserService.class).to(UserService.class);
            }
        });

        SetterInjectDemo setterInjectDemo = injector.getInstance(SetterInjectDemo.class);

        setterInjectDemo.userService.list();

    }
}
