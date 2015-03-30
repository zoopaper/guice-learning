package org.guice.start.biz.internal;

import com.google.inject.Inject;
import org.guice.start.biz.UserService;
import org.guice.start.data.UserDao;
import org.guice.start.model.User;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/3/30
 * Time: 19:17
 */
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    public void addUser(User user) {

        userDao.addUser(user);

    }


}
