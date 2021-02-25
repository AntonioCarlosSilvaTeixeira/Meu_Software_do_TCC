package br.com.sistemasgr.dao;

import br.com.sistemasgr.domain.OrdServico;
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
public class OrdServicoDAO extends GenericDAO<OrdServico> {

    public List<OrdServico> listarAtivos(int codigo) {

        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(OrdServico.class);

            consulta.add(Restrictions.eq("pessoa.codigo", codigo));
            consulta.add(Restrictions.eq("situacao", "Ativo"));

            consulta.addOrder(Order.desc("data"));
            consulta.addOrder(Order.desc("hora"));

            List<OrdServico> resultado = consulta.list();
            return resultado;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
    public List<OrdServico> listarAndamentos(int codigo) {

        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(OrdServico.class);

            consulta.add(Restrictions.eq("pessoa.codigo", codigo));
            consulta.add(Restrictions.eq("situacao", "Em andamento"));

            consulta.addOrder(Order.desc("data"));
            consulta.addOrder(Order.desc("hora"));

            List<OrdServico> resultado = consulta.list();
            return resultado;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public List<OrdServico> listarAtendidos(int codigo) {

        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(OrdServico.class);

            consulta.add(Restrictions.eq("pessoa.codigo", codigo));
            consulta.add(Restrictions.eq("situacao", "Atendido"));

            consulta.addOrder(Order.desc("data"));
            consulta.addOrder(Order.desc("hora"));

            List<OrdServico> resultado = consulta.list();
            return resultado;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    public List<OrdServico> listarAtivosTodos() {

        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(OrdServico.class);

            consulta.add(Restrictions.eq("situacao", "Ativo"));

            consulta.addOrder(Order.desc("data"));
            consulta.addOrder(Order.desc("hora"));

            List<OrdServico> resultado = consulta.list();
            return resultado;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    public List<OrdServico> listarTodosAtendidos() {

        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(OrdServico.class);

            consulta.add(Restrictions.eq("situacao", "Atendido"));

            consulta.addOrder(Order.desc("data"));
            consulta.addOrder(Order.desc("hora"));

            List<OrdServico> resultado = consulta.list();
            return resultado;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
    public List<OrdServico> listarTodosEmAndamento() {

        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(OrdServico.class);

            consulta.add(Restrictions.eq("situacao", "Em Andamento"));

            consulta.addOrder(Order.desc("data"));
            consulta.addOrder(Order.desc("hora"));

            List<OrdServico> resultado = consulta.list();
            return resultado;

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
