package org.guice.usage;

import com.google.inject.*;
import org.guice.usage.service.IPostService;
import org.guice.usage.service.internal.PostServiceProvider;

/**
 * @ProvidedBy 自动注入，不使用Module手动关联
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 12:44
 */
public class ProviderInterfaceInjectDemo {

//    @Inject
//    private IPostService postService;


    @Inject
    private Provider<IPostService> provider;

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bind(IPostService.class).toProvider(PostServiceProvider.class);
            }
        });
        ProviderInterfaceInjectDemo providerInterfaceInjectDemo = injector.getInstance(ProviderInterfaceInjectDemo.class);
        providerInterfaceInjectDemo.provider.get().post();
//        ProviderInterfaceInjectDemo providerInterfaceInjectDemo = Guice.createInjector().getInstance(ProviderInterfaceInjectDemo.class);
//        providerInterfaceInjectDemo.postService.post();
    }

}
