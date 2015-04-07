package org.guice.start.client;

import com.google.inject.*;
import org.guice.start.biz.UserService;
import org.guice.start.intergration.WebModule;
import org.guice.start.model.User;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/7
 * Time: 11:43
 */
public class Client2 {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new WebModule());
        UserService userService = injector.getInstance(UserService.class);


        User user = new User();
        user.setUserId(12);
        user.setUserName("krisjin");
        userService.addUser(user);


        Map<Key<?>, Binding<?>> bindingMap = injector.getBindings();


        Iterator<Map.Entry<Key<?>, Binding<?>>> bindingIterator = bindingMap.entrySet().iterator();

        while (bindingIterator.hasNext()) {

            Map.Entry<Key<?>, Binding<?>> entry = bindingIterator.next();

            Key<?> key = entry.getKey();
            Binding<?> binding = entry.getValue();
            Object inter = binding.getSource();
            Provider dd = injector.getProvider(key);
           Class[] type =binding.getProvider().getClass().getInterfaces();


            System.out.println("Interface class:[" + entry.getKey().getTypeLiteral().getType().toString() + "]" + inter);
        }


    }
}
