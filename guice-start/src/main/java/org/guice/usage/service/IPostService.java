package org.guice.usage.service;

import com.google.inject.ProvidedBy;
import org.guice.usage.service.internal.PostServiceProvider;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/16
 * Time: 12:37
 */
//@ProvidedBy(PostServiceProvider.class)
public interface IPostService {
    public void post();
}
