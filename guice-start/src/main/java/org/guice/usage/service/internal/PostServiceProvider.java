package org.guice.usage.service.internal;

import com.google.inject.Provider;
import org.guice.usage.service.IPostService;


/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 12:38
 */
public class PostServiceProvider implements Provider<IPostService> {


    public IPostService get() {
        return new IPostService() {

            public void post() {
                System.out.println("post service provider............success");
            }
        };
    }
}
