package org.guice.usage;

import java.io.Serializable;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/15
 * Time: 16:20
 */
public class User implements Serializable {

    private String userName;

    private int userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
