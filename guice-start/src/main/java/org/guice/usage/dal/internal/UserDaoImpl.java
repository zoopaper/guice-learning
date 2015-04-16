package org.guice.usage.dal.internal;

import com.google.common.collect.Lists;
import org.guice.usage.dal.IUserDao;

import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 8:47
 */
public class UserDaoImpl implements IUserDao {

    public void list() {

        List srcList = Lists.newArrayList();

        String[] destArr =new String[2];

        srcList.add("Obj1");
        srcList.add("Obj2");


        System.arraycopy(srcList.toArray(), 0, destArr, 0, 2);
        System.out.println("copy list size:" + destArr.length);
    }

    public static void main(String[] args) {
        new UserDaoImpl().list();
    }
}
