package org.guice.usage;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.name.Names;

import java.util.HashMap;
import java.util.Map;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/15
 * Time: 16:16
 */
public class Module1 extends AbstractModule {

    @Override
    protected void configure() {
        //Named注解注入
        bind(Map.class).annotatedWith(Names.named(ConstantKey.USER_KEY)).to(HashMap.class);

        //接口注入
        bind(Service.class).to(ServiceA.class).asEagerSingleton();


        bind(String.class).toInstance("krisjin");

        //禁止绑定自己
        //bind(HashMap.class).to(HashMap.class);

        bind(Service.class).toProvider(new Provider<Service>() {
            public Service get() {
                return null;
            }
        });

    }

}
