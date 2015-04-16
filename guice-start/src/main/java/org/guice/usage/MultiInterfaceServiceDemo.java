package org.guice.usage;

import com.google.inject.*;
import org.guice.usage.annotation.Andriod;
import org.guice.usage.annotation.Ios;
import org.guice.usage.service.IApiService;
import org.guice.usage.service.internal.AndriodApiSerivceImpl;
import org.guice.usage.service.internal.IosApiServiceImpl;

/**
 * 使用注解实现多接口服务实现
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 10:50
 */
public class MultiInterfaceServiceDemo {

    @Inject
    @Andriod
    private static IApiService andriodService;


    @Inject
    @Ios
    private static IApiService iosService;

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bind(IApiService.class).annotatedWith(Andriod.class).to(AndriodApiSerivceImpl.class);
                binder.bind(IApiService.class).annotatedWith(Ios.class).to(IosApiServiceImpl.class);
//                binder.bind(IUserService.class).annotatedWith(Ios.class).to(IosApiServiceImpl.class);

                //静态属性注入
                binder.requestStaticInjection(MultiInterfaceServiceDemo.class);
            }
        });

        MultiInterfaceServiceDemo multiInterfaceServiceDemo = injector.getInstance(MultiInterfaceServiceDemo.class);

//        multiInterfaceServiceDemo.andriodService.push();
//        multiInterfaceServiceDemo.iosService.push();

        MultiInterfaceServiceDemo.andriodService.push();
        MultiInterfaceServiceDemo.iosService.push();
    }


}

