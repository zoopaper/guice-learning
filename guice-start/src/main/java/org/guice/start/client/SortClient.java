package org.guice.start.client;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.guice.start.biz.internal.HelloSort;
import org.guice.start.intergration.SortServiceModule;

/**
 * User : jinguishi@tianler.com
 * Date: 15-3-30
 * Time: 下午10:22
 */
public class SortClient {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new SortServiceModule());
        HelloSort helloSort = injector.getInstance(HelloSort.class);
        helloSort.sort();
    }
}
