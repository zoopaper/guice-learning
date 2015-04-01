package org.guice.example01;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/4/1
 * Time: 12:53
 */
public class Client {

    public static void main(String[] args) {

        Injector inject = Guice.createInjector(new InjectorModule());
        IDal url = inject.getInstance(IDal.class);

        System.out.println(url.getUrl()+"\n"+url.getPort());
        System.out.println(url.getDao());

    }
}
