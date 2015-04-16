package org.guice.usage.service.internal;

import org.guice.usage.service.IApiService;
import org.guice.usage.service.IUserService;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 10:55
 */
public class IosApiServiceImpl implements IApiService ,IUserService {
    public void push() {
        System.out.println("ios push.........");
    }

    public void list() {
        System.out.println("ios list.........");
    }
}
