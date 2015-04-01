package org.guice.example01;

import com.google.inject.name.Named;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/1
 * Time: 13:01
 */
public interface IDal {

    public String getUrl();

    public int getPort();

    public String getDao();
}
