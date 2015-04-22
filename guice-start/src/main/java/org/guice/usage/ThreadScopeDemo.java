package org.guice.usage;

import com.google.inject.*;
import org.guice.usage.service.IApiService;
import org.guice.usage.service.internal.IosApiServiceImpl;

import java.util.concurrent.TimeUnit;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 16:05
 */
public class ThreadScopeDemo {


    static class ThreadServiceSingleScope implements Scope {

        static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

        @Override
        public <T> Provider<T> scope(Key<T> key, final Provider<T> unscoped) {

            return new Provider<T>() {
                @Override
                public T get() {
                    T instance = (T) threadLocal.get();
                    if (instance == null) {
                        instance = unscoped.get();
                        threadLocal.set(instance);
                    }

                    return instance;
                }

            };
        }

        @Override
        public String toString() {
            return "Scopes.ThreadServiceScope";
        }
    }


    static class Prototype implements Scope{


        @Override
        public <T> Provider<T> scope(Key<T> key, Provider<T> unscoped) {
            return unscoped;
        }


    }


    public static void main(String[] args) {

        final Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(IApiService.class).to(IosApiServiceImpl.class).in(new Prototype());
            }
        });

        for (int i = 0; i < 3; i++) {
            new Thread("Thread-" + i) {
                @Override
                public void run() {
                    for (int t = 0; t < 3; t++) {
                        IApiService apiService = injector.getInstance(IApiService.class);
                        String s = String.format("%s-%d:%d", getName(), t, apiService.hashCode());
                        System.out.println(s);
                        try {
                            TimeUnit.MILLISECONDS.sleep(50L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();

        }

    }
}
