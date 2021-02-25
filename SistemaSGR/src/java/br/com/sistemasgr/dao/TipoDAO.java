
package br.com.sistemasgr.dao;

import br.com.sistemasgr.domain.Tipo;
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
public class TipoDAO extends GenericDAO<Tipo>{
    public List<Tipo> listarTipoporFuncao(String funcao) {

        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Tipo.class);

            consulta.add(Restrictions.eq("funcao", funcao));
            consulta.addOrder(Order.asc("nome"));

            List<Tipo> resultado = consulta.list();
            return resultado;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
