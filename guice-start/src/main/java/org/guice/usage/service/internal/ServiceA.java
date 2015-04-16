package org.guice.usage.service.internal;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.guice.usage.ConstantKey;
import org.guice.usage.service.IService;

import java.util.Map;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/15
 * Time: 16:24
 */
public class ServiceA implements IService {

    @Inject
    @Named(ConstantKey.USER_KEY)
    Map conf;

    public void list() {

        System.out.println(conf.size());

    }
}
