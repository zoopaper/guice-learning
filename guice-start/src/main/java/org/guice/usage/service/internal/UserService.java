package org.guice.usage.service.internal;

import com.google.inject.Inject;
import org.guice.usage.dal.IUserDao;
import org.guice.usage.service.IUserService;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 9:09
 */
public class UserService implements IUserService {

    @Inject
    IUserDao userDao;

    public void list() {
        userDao.list();

    }
}
