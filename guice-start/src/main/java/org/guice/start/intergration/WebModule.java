package org.guice.start.intergration;

import com.google.inject.Binder;
import com.google.inject.Module;
import org.guice.start.biz.UserService;
import org.guice.start.biz.internal.UserServiceImpl;
import org.guice.start.data.UserDao;
import org.guice.start.data.internal.UserDaoImpl;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/7
 * Time: 11:38
 */
public class WebModule implements Module {
    public void configure(Binder binder) {
        binder.bind(UserDao.class).to(UserDaoImpl.class);
        binder.bind(UserService.class).to(UserServiceImpl.class).asEagerSingleton();

    }
}
