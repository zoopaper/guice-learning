package org.guice.usage;

import com.google.inject.*;
import org.guice.usage.service.IUserService;

/**
 * Guice提供了一个方式（Provider<T>），允许自己提供构造对象的方式.
 * 这种场景也有不少
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 10:29
 */
public class ProviderInstanceDemo {

    @Inject
    private static IUserService userService;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bind(IUserService.class).toProvider(new Provider<IUserService>() {

                    public IUserService get() {


                        return new IUserService() {
                            public void list() {
                                System.out.println("to provider instance...........");
                            }
                        };
                    }
                });

                binder.requestStaticInjection(ProviderInstanceDemo.class);
            }
        });

        ProviderInstanceDemo.userService.list();
    }
}
