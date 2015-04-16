package org.guice.usage;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import org.guice.usage.dal.IUserDao;
import org.guice.usage.guice.Module1;
import org.guice.usage.service.IService;
import org.guice.usage.service.IUserService;
import org.guice.usage.service.internal.ServiceB;
import org.guice.usage.service.internal.UserService;

/**
 * 上面我们并没有使用Guice获取一个StaticFieldInjectDemo实例（废话），实际上static字段（属性）是类相关的，因此我们需要请求静态注入服务。
 * 但是一个好处是在外面看起来我们的服务没有Guice绑定，甚至client不知道（或者不关心）服务的注入过程。
 * <p/>
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/15
 * Time: 16:17
 */
public class Client {


    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module1());
        IService IServiceA = injector.getInstance(IService.class);
        IService IServiceB = injector.getInstance(IService.class);

        System.out.println(IServiceA.hashCode() + "\n" + IServiceB.hashCode());


        Injector injector1 = Guice.createInjector();

        IService IService = injector1.getInstance(ServiceB.class);


        IService.list();


        Injector injector2 = Guice.createInjector();
        IUserDao userDao = injector2.getInstance(IUserDao.class);

        userDao.list();


        Injector injector3 = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                //设置生成的实例是否为单例模式
                bind(IUserService.class).to(UserService.class).in(Scopes.SINGLETON);
            }
        });

        IUserService userService = injector3.getInstance(IUserService.class);
        userService.list();

        IUserService userService2 = injector3.getInstance(IUserService.class);

        System.out.println(userService.hashCode() + "\n" + userService2.hashCode());

    }


}
