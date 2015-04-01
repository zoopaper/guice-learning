package org.guice.start.client;

import com.google.inject.*;
import org.guice.start.biz.UserService;
import org.guice.start.data.UserDao;
import org.guice.start.intergration.ServiceModule;
import org.guice.start.model.User;

import java.util.Map;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/3/30
 * Time: 19:12
 */
public class Client {


    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new ServiceModule());

        UserService userService = injector.getInstance(UserService.class);

        User user = new User();

        user.setUserId(100);
        user.setUserName("krisjin");
        userService.addUser(user);


        Map<Key<?>, Binding<?>> tt = injector.getBindings();
        Provider<UserDao> userDaoProvider = injector.getProvider(UserDao.class);
        tt.entrySet();

    }

}
