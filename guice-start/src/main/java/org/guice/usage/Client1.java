package org.guice.usage;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 *
 *
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/15
 * Time: 16:17
 */
public class Client1 {


    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module1());
        Service serviceA = injector.getInstance(Service.class);
        Service serviceB = injector.getInstance(Service.class);

        System.out.println(serviceA.hashCode() + "\n" + serviceB.hashCode());
    }


}
