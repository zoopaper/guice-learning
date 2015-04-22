package org.guice.usage;

import com.google.inject.*;
import org.guice.usage.service.IApiService;
import org.guice.usage.service.internal.AndriodApiSerivceImpl;
import org.guice.usage.service.internal.IosApiServiceImpl;

/**
 * 如果不能从Guice容器中获取一个Service服务那么就使用默认的AndriodApiSerivceImpl，否则就是用获取的服务.
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/22
 * Time: 10:47
 */
public class OptionalInjectionDemo {

    @Inject(optional = true)
    private IApiService apiService = new AndriodApiSerivceImpl();


    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(IApiService.class).to(IosApiServiceImpl.class);
            }
        });
        OptionalInjectionDemo injectionDemo = injector.getInstance(OptionalInjectionDemo.class);
        injectionDemo.apiService.push();
    }

}
