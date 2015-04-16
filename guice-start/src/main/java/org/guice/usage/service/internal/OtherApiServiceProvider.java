package org.guice.usage.service.internal;

import com.google.inject.Provider;
import org.guice.usage.service.IApiService;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 11:40
 */
public class OtherApiServiceProvider implements Provider<IApiService> {

    public IApiService get() {
        return new IApiService() {
            public void push() {
                System.out.println("other api service provider..............");
            }
        };
    }
}
