package org.guice.usage.dal;

import com.google.inject.ImplementedBy;
import org.guice.usage.dal.internal.UserDaoImpl;

/**
 * 使用注解注入，不用手动去关联实现类，需要在接口中关联实现类
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 8:45
 */
@ImplementedBy(UserDaoImpl.class)
public interface IUserDao {
    public void list();
}
