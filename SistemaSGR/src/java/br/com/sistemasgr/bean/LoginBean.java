package br.com.sistemasgr.bean;

import br.com.sistemasgr.dao.FuncaoDAO;
import br.com.sistemasgr.dao.PessoaDAO;
import br.com.sistemasgr.domain.Funcao;
import br.com.sistemasgr.domain.Pessoa;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

/**
 *
 * @author Antonio Carlos
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private Pessoa pes, pessoalogado;
    private List<Funcao> funcoes;

    @PostConstruct
    public void novo() {
        pes = new Pessoa();
        try {
            FuncaoDAO funcaodao = new FuncaoDAO();
            funcoes = funcaodao.listar();
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao tentar listar as funções!");
            e.printStackTrace();
        }
    }

    public void login() {
        try {
            PessoaDAO pesdao = new PessoaDAO();
            pessoalogado = pesdao.Autenticar(pes.getFuncao(), pes.getCpf(), pes.getSenha());

            if (pessoalogado == null) {
                Messages.addGlobalWarn("Cpf ou Senha invalidos!");
            } else {
                switch (pessoalogado.getFuncao()) {
                    case "":
                        Faces.redirect("./faces/Tecnico.xhtml");
                        break;
                    case "Técnico":
                        Faces.redirect("./faces/Tecnico.xhtml");
                        break;
                    default:
                        Faces.redirect("./faces/Principal.xhtml");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            Messages.addGlobalError(e.getMessage());
        }
    }

    public Pessoa getPes() {
        return pes;
    }

    public void setPes(Pessoa pes) {
        this.pes = pes;
    }

    public Pessoa getPessoalogado() {
        return pessoalogado;
    }

    public void setPessoalogado(Pessoa pessoalogado) {
        this.pessoalogado = pessoalogado;
    }

    public List<Funcao> getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(List<Funcao> funcoes) {
        this.funcoes = funcoes;
    }
}
