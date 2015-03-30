package org.guice.start.data.internal;

import org.guice.start.model.User;

/**
 * User : jinguishi@tianler.com
 * Date: 15-3-30
 * Time: 下午9:58
 */
public class SubUserDaoImpl extends UserDaoImpl {

    @Override
    public void addUser(User user) {
        System.out.println("sub");
        user.setUserId(200);
        user.setUserName("DanShan");
        super.addUser(user);
    }
}
