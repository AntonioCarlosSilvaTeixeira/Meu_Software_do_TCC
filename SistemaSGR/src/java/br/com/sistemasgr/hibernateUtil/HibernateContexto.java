
package br.com.sistemasgr.hibernateUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Antonio Carlos
 */
public class HibernateContexto implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent evento) {
        HibernateUtil.getFabricaDeSessoes();     
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil.getFabricaDeSessoes().close();
    }
    
}
