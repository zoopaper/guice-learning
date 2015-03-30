package org.guice.start.biz.internal;

import com.google.inject.Inject;
import org.guice.start.annotation.UseSort;
import org.guice.start.biz.Sort;
import org.guice.start.biz.SortService;

/**
 * User : jinguishi@tianler.com
 * Date: 15-3-30
 * Time: 下午10:33
 */
public class HelloSort implements SortService {

    Sort sort;

    @Inject
    public HelloSort(@UseSort Sort sort) {
        this.sort = sort;
    }

    public void sort() {
        sort.sort();
    }
}
