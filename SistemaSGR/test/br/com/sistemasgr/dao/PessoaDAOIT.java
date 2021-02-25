package br.com.sistemasgr.dao;

import br.com.sistemasgr.domain.Pessoa;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Antonio Carlos
 */
public class PessoaDAOIT {

    @Test
    @Ignore
    public void salvar() {

        Pessoa pes = new Pessoa();
        pes.setNome("Antonio");
        pes.setCelular("123456789");
        pes.setCpf("987456");
        pes.setEndereco("Antonio Moura");
        pes.setFone("34235600");
        pes.setFuncao("TI");
        pes.setMasp("45");
        pes.setRa("10-13652");
        pes.setRg("mg18.78662.98");

        PessoaDAO pesDAO = new PessoaDAO();
        pesDAO.salvar(pes);
    }

    @Test
    @Ignore
    public void listar() {

        PessoaDAO pesDAO = new PessoaDAO();
        List<Pessoa> resultado = pesDAO.listar();

        for (Pessoa pes : resultado) {
            System.out.println(pes.getNome() + " - " + pes.getRa());
        }
    }

    @Test
    @Ignore
    public void buscar() {

        PessoaDAO pesDAO = new PessoaDAO();
        Pessoa pes = pesDAO.buscar(1);

        if (pes == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro encontrado:");
            System.out.println(pes.getCodigo() + " - " + pes.getNome());
        }
    }

    @Test
    @Ignore
    public void excluir() {

        PessoaDAO pesDAO = new PessoaDAO();
        Pessoa pes = pesDAO.buscar(1);

        if (pes == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            pesDAO.excluir(pes);
            System.out.println("Registro encontrado:");
            System.out.println(pes.getCodigo() + " - " + pes.getNome());
        }
    }

    @Test
    @Ignore
    public void editar() {

        PessoaDAO pesDAO = new PessoaDAO();
        Pessoa pes = pesDAO.buscar(1);

        if (pes == null) {
            System.out.println("Nenhum registro encontrado");
        } else {
            System.out.println("Registro - Antes:");
            System.out.println(pes.getCodigo() + " - " + pes.getNome());

            pes.setNome("Santa Catarina");

            pesDAO.editar(pes);

            System.out.println("Registro - Depois:");
            System.out.println(pes.getCodigo() + " - " + pes.getNome());
        }
    }

    @Test
    @Ignore
    public void autenticar() {

        String ra = "1", cpf = "222222";

        PessoaDAO pesdao = new PessoaDAO();

        //Pessoa pes = pesdao.Autenticar(ra, cpf);

        //System.out.println("Usuario autenticado " + pes.getNome());
    }
}
