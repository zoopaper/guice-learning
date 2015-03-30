package org.guice.start.client;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.guice.start.biz.internal.HelloSort;
import org.guice.start.biz.internal.HelloSort2;
import org.guice.start.intergration.SortServiceModule;
import org.guice.start.intergration.SortServiceModule2;

/**
 * User : jinguishi@tianler.com
 * Date: 15-3-30
 * Time: 下午10:22
 */
public class SortClient2 {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new SortServiceModule2());
        HelloSort2 helloSort = injector.getInstance(HelloSort2.class);
        helloSort.sort();
    }
}
