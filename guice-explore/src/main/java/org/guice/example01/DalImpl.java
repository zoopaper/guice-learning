package org.guice.example01;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/1
 * Time: 13:04
 */
public class DalImpl implements IDal {

    @Inject
    @Named("JDBC URL")
    private String url;

    @Inject
    @Named("Port")
    private int port;

    @Inject
    @Named("mysql")
    private IDao daoInstance;

    @Inject
    @Named("oracle")
    private IDao oracleInstance;

    public String getUrl() {
        return url;
    }

    public int getPort() {

        return port;
    }


    public String getDao() {
        return oracleInstance.getInstance();
    }


}
