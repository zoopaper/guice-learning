package org.guice.start.intergration;

import com.google.inject.AbstractModule;
import org.guice.start.biz.UserService;
import org.guice.start.biz.internal.UserServiceImpl;
import org.guice.start.data.UserDao;
import org.guice.start.data.internal.SubUserDaoImpl;
import org.guice.start.data.internal.UserDaoImpl;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/3/30
 * Time: 19:25
 */
public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserDao.class).to(UserDaoImpl.class).asEagerSingleton();
        bind(UserService.class).to(UserServiceImpl.class).asEagerSingleton();
        bind(UserDaoImpl.class).to(SubUserDaoImpl.class).asEagerSingleton();
    }
}
