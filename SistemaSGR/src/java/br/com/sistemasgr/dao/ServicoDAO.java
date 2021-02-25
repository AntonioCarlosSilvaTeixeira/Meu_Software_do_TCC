
package br.com.sistemasgr.dao;

import br.com.sistemasgr.domain.Servico;
import br.com.sistemasgr.hibernateUtil.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Antonio Carlos
 */
public class ServicoDAO extends GenericDAO<Servico>{
    
     public List<Servico> listarServicoPorTipo(int codigo) {

        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Servico.class);

            consulta.add(Restrictions.eq("tipo.codigo", codigo));
            consulta.addOrder(Order.asc("nome"));

            List<Servico> resultado = consulta.list();
            return resultado;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
