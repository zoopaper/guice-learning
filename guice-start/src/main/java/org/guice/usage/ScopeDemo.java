package org.guice.usage;

import com.google.inject.*;
import org.guice.usage.service.IApiService;
import org.guice.usage.service.internal.IosApiServiceImpl;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 15:43
 */
public class ScopeDemo {


    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new Module() {

            public void configure(Binder binder) {
                binder.bind(IApiService.class).to(IosApiServiceImpl.class).in(Scopes.SINGLETON);
            }
        });


        IApiService apiService = injector.getInstance(IApiService.class);
        IApiService apiService2 = injector.getInstance(IApiService.class);

        System.out.println(apiService.hashCode());
        System.out.println(apiService2.hashCode());
    }
}
