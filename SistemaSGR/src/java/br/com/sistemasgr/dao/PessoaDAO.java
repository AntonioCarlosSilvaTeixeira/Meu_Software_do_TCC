package br.com.sistemasgr.dao;

import br.com.sistemasgr.domain.Pessoa;
import br.com.sistemasgr.hibernateUtil.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Antonio Carlos
 */
public class PessoaDAO extends GenericDAO<Pessoa> {

    public Pessoa Autenticar(String funcao, String cpf, String senha) {

        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Pessoa.class);

            consulta.add(Restrictions.eq("funcao", funcao));
            consulta.add(Restrictions.eq("cpf", cpf));
            consulta.add(Restrictions.eq("senha", senha));
            
            Pessoa resultado = (Pessoa) consulta.uniqueResult();
            
            return resultado;
            
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
