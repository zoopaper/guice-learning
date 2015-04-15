package org.guice.usage;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.Map;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/15
 * Time: 16:24
 */
public class ServiceA implements Service {

    @Inject
    @Named(ConstantKey.USER_KEY)
    Map conf;

    public void list() {

        System.out.println(conf.size());

    }
}
