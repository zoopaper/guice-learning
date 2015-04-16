package org.guice.usage;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import org.guice.usage.service.IApiService;
import org.guice.usage.service.internal.AndriodApiSerivceImpl;
import org.guice.usage.service.internal.IosApiServiceImpl;
import org.guice.usage.service.internal.OtherApiServiceProvider;

/**
 * 使用Named来标注我们的服务应该使用什么样的注解，当然前提是我们已经将相应的服务与注解关联起来了
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 11:33
 */
public class NoAnnotationMultiInterfaceServiceDemo {


    @Inject
    @Named("andriod")
    private static IApiService andriodService;


    @Inject
    @Named("ios")
    private static IApiService iosService;

    @Inject
    @Named("other")
    private static IApiService otherService;

    public static void main(String[] args) {

        Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bind(IApiService.class).annotatedWith(Names.named("andriod")).to(AndriodApiSerivceImpl.class);
                binder.bind(IApiService.class).annotatedWith(Names.named("ios")).to(IosApiServiceImpl.class);
                binder.bind(IApiService.class).annotatedWith(Names.named("other")).toProvider(OtherApiServiceProvider.class);
                binder.requestStaticInjection(NoAnnotationMultiInterfaceServiceDemo.class);
            }
        });

        NoAnnotationMultiInterfaceServiceDemo.andriodService.push();
        NoAnnotationMultiInterfaceServiceDemo.iosService.push();
        NoAnnotationMultiInterfaceServiceDemo.otherService.push();

    }

}
