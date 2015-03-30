package org.guice.start.client;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.guice.start.biz.UserService;
import org.guice.start.intergration.ServiceModule;
import org.guice.start.model.User;

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
        
    }

}
