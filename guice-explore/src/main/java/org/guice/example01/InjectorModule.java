package org.guice.example01;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/1
 * Time: 12:54
 */
public class InjectorModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(String.class).annotatedWith(Names.named("JDBC URL")).toInstance("jdbc:mysql://localhost/test");

        bind(Integer.class).annotatedWith(Names.named("Port")).toInstance(3306);

        bind(IDao.class).annotatedWith(Names.named("mysql")).to(MysqlDaoImpl.class);

        bind(IDao.class).annotatedWith(Names.named("oracle")).to(OracleDaoImpl.class);


        bind(IDal.class).to(DalImpl.class);

    }
}
