package org.guice.usage.service.internal;

import org.guice.usage.service.IService;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 8:31
 */
public class ServiceB implements IService {
    public void list() {
        System.out.println("invoking.........");
    }
}
