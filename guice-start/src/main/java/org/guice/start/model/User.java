package org.guice.start.model;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/3/30
 * Time: 19:13
 */
public class User {

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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{userId:").append(this.userId).append(";userName:").append(this.getUserName()).append("}");
        return stringBuilder.toString();
    }
}
