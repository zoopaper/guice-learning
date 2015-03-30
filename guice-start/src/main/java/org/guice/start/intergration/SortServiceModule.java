package org.guice.start.intergration;

import com.google.inject.AbstractModule;
import org.guice.start.annotation.UseSort;
import org.guice.start.biz.Sort;
import org.guice.start.biz.SortService;
import org.guice.start.biz.internal.BubbleSortImpl;
import org.guice.start.biz.internal.HelloSort;
import org.guice.start.biz.internal.QuickSortImpl;

/**
 * User : jinguishi@tianler.com
 * Date: 15-3-30
 * Time: 下午10:22
 */
public class SortServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Sort.class).annotatedWith(UseSort.class).to(QuickSortImpl.class);
        bind(Sort.class).to(BubbleSortImpl.class);
        bind(SortService.class).to(HelloSort.class);
    }
}
