package org.guice.start.intergration;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.guice.start.annotation.UseSort;
import org.guice.start.biz.Sort;
import org.guice.start.biz.SortService;
import org.guice.start.biz.internal.*;

import javax.inject.Named;

/**
 * User : jinguishi@tianler.com
 * Date: 15-3-30
 * Time: 下午10:22
 */
public class SortServiceModule2 extends AbstractModule {

    @Override
    protected void configure() {
        bind(Sort.class).annotatedWith(Names.named("half")).to(HalfSort.class);
        bind(Sort.class).to(BubbleSortImpl.class);
        bind(SortService.class).to(HelloSort2.class);
    }
}
