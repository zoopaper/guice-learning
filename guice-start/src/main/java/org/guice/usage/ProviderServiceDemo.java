package org.guice.usage;

import com.google.inject.*;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import org.guice.usage.service.IApiService;
import org.guice.usage.service.internal.OtherApiServiceProvider;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 11:52
 */
public class ProviderServiceDemo {


    @Inject
    @Named("other")
    private IApiService otherService;

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bind(IApiService.class).annotatedWith(Names.named("other")).toProvider(OtherApiServiceProvider.class).in(Scopes.SINGLETON);

            }
        });
        ProviderServiceDemo providerServiceDemo = injector.getInstance(ProviderServiceDemo.class);
        ProviderServiceDemo providerServiceDemo2 = injector.getInstance(ProviderServiceDemo.class);
        providerServiceDemo.otherService.push();

        System.out.println(providerServiceDemo.hashCode() +"\n"+providerServiceDemo2.hashCode());


    }
}
