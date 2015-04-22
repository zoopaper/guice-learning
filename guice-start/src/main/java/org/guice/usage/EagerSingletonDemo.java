package org.guice.usage;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * 立即初始化
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/22
 * Time: 10:35
 */
public class EagerSingletonDemo {


    public EagerSingletonDemo() {
        System.out.println("constuctor:" + System.nanoTime());
    }

    private void doing() {
        System.out.println("doing     :" + System.nanoTime());
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(EagerSingletonDemo.class).asEagerSingleton();
            }
        });
        EagerSingletonDemo eagerSingletonDemo = injector.getInstance(EagerSingletonDemo.class);
        eagerSingletonDemo.doing();
    }
}
