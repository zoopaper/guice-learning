package org.guice.usage;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 16:05
 */
public class ThreadScopeDemo {


    static class ThreadServiceScope implements Scope {

        static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

        public <T> Provider<T> scope(Key<T> key, final Provider<T> unscoped) {

            return new Provider<T>() {
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
    }
}
