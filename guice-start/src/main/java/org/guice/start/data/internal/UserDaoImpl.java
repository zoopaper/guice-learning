package org.guice.start.data.internal;

import org.guice.start.data.UserDao;
import org.guice.start.model.User;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/3/30
 * Time: 19:15
 */
public class UserDaoImpl implements UserDao {

    public void addUser(User user) {

        System.out.println("Add User :"+user.toString());

    }

}
