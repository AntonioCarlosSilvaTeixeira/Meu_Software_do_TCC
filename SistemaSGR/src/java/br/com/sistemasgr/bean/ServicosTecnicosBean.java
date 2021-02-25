package br.com.sistemasgr.bean;

import br.com.sistemasgr.dao.FuncaoDAO;
import br.com.sistemasgr.dao.LocalDAO;
import br.com.sistemasgr.dao.OrdServicoDAO;
import br.com.sistemasgr.dao.PessoaDAO;
import br.com.sistemasgr.dao.ServicoDAO;
import br.com.sistemasgr.dao.TipoDAO;
import br.com.sistemasgr.domain.Funcao;
import br.com.sistemasgr.domain.Local;
import br.com.sistemasgr.domain.OrdServico;
import br.com.sistemasgr.domain.Pessoa;
import br.com.sistemasgr.domain.Servico;
import br.com.sistemasgr.domain.Tipo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

/**
 *
 * @author Antonio
 */
@ManagedBean
@ViewScoped
public class ServicosTecnicosBean implements Serializable {

    private Pessoa pessoa;
    private Local local;
    private Tipo tipo;
    private Servico servico;
    private OrdServico osd;
    private Funcao funcao;
    private List<OrdServico> oslistas;
    private List<Tipo> tipos;
    private List<Funcao> funcoes;
    private String senhaAtual, novaSenha, confirmaSenha, funcao1;
    private Date data;

    LoginBean logado = Faces.getSessionAttribute("loginBean");

    public void listarAtivos() {
        try {
            OrdServicoDAO osdao = new OrdServicoDAO();
            oslistas = osdao.listarAtivosTodos();
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao tentar listar requisções ativas!");
            e.printStackTrace();
        }
    }

    public void listarAtendidos() {
        try {
            OrdServicoDAO osdao = new OrdServicoDAO();
            oslistas = osdao.listarTodosAtendidos();
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao tentar listar requisções atendidas!");
            e.printStackTrace();
        }
    }

    public void listarEmAndamentos() {
        try {
            OrdServicoDAO osdao = new OrdServicoDAO();
            oslistas = osdao.listarTodosEmAndamento();
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao tentar listar requisções em andamento!");
            e.printStackTrace();
        }
    }

    public void listarFuncoes() {
        try {
            FuncaoDAO funcaodao = new FuncaoDAO();
            funcoes = funcaodao.listar();
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao tentar listar as funções!");
            e.printStackTrace();
        }
    }

    public void sair() {
        logado = null;
        logado = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("loginBean");
        Faces.invalidateSession();
        Faces.navigate("/Login.xhtml");
    }

    public void novo() {
        try {
            servico = new Servico();
            tipo = new Tipo();
            local = new Local();
            pessoa = new Pessoa();
            funcao = new Funcao();
            listarFuncoes();
            
            tipos = new ArrayList<>();
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao instanciar uma nova instância!");
            e.printStackTrace();
        }
    }

    public void salvarServico() {
        try {
            ServicoDAO servdao = new ServicoDAO();
            servdao.salvar(servico);
            Messages.addGlobalInfo("Tipo salvo com sucesso.");
            novo();
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao cadastrar um novo tipo!");
            e.printStackTrace();
        }
    }

    public void salvarFuncao() {
        try {
            FuncaoDAO funcaodao = new FuncaoDAO();
            funcaodao.salvar(funcao);
            Messages.addGlobalInfo("Função cadastrada com sucesso.");
            novo();
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao cadastrar uma nova Funcção!");
            e.printStackTrace();
        }
    }

    public void salvarTipo() {
        try {
            TipoDAO tipodao = new TipoDAO();
            tipodao.salvar(tipo);
            Messages.addGlobalInfo("Serviço cadastrada com sucesso.");
            novo();
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao cadastrar um nova Serviço!");
            e.printStackTrace();
        }
    }

    public void salvarLocal() {
        try {
            LocalDAO localdao = new LocalDAO();
            localdao.salvar(local);
            Messages.addGlobalInfo("Local cadastrada com sucesso.");
            novo();
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao cadastrar um nova Local!");
            e.printStackTrace();
        }
    }

    public void salvarPessoa() {
        try {
            pessoa.setSenha(pessoa.getCpf());
            PessoaDAO pesdao = new PessoaDAO();
            pesdao.salvar(pessoa);
            Messages.addGlobalInfo("Pessoa cadastrada com sucesso.");
            novo();
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao cadastrar uma nova Pessoa!");
            e.printStackTrace();
        }
    }

    public void excluirAtivos(ActionEvent evento) {
        try {
            osd = (OrdServico) evento.getComponent().getAttributes().get("selecionado");

            OrdServicoDAO osdao = new OrdServicoDAO();
            osdao.excluir(osd);

            oslistas = osdao.listarAtivosTodos();

            Messages.addGlobalInfo("Ordem de serviço removida com sucesso.");
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao excluir a ordem de serviço!");
            e.printStackTrace();
        }
    }

    public void excluirAtendidos(ActionEvent evento) {
        try {
            osd = (OrdServico) evento.getComponent().getAttributes().get("selecionado");

            OrdServicoDAO osdao = new OrdServicoDAO();
            osdao.excluir(osd);

            oslistas = osdao.listarTodosAtendidos();

            Messages.addGlobalInfo("Ordem de serviço removida com sucesso.");
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao excluir a ordem de serviço!");
            e.printStackTrace();
        }
    }

    public void excluirAndamento(ActionEvent evento) {
        try {
            osd = (OrdServico) evento.getComponent().getAttributes().get("selecionado");

            OrdServicoDAO osdao = new OrdServicoDAO();
            osdao.excluir(osd);

            oslistas = osdao.listarTodosEmAndamento();

            Messages.addGlobalInfo("Ordem de serviço removida com sucesso.");
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao excluir a ordem de serviço!");
            e.printStackTrace();
        }
    }

    public void editarAtivos(ActionEvent evento) {
        osd = (OrdServico) evento.getComponent().getAttributes().get("selecionado");
    }

    public void editarAndamento(ActionEvent evento) {
        osd = (OrdServico) evento.getComponent().getAttributes().get("selecionado");
    }

    public void editarSalvarAtivos() {
        try {
            OrdServicoDAO osdao = new OrdServicoDAO();
            osd.setTecnico(logado.getPessoalogado().getNome());
            osdao.editar(osd);

            oslistas = osdao.listarAtivosTodos();

            Messages.addGlobalInfo("Ordem de serviço editada com sucesso.");
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao editar a ordem de serviço!");
            e.printStackTrace();
        }
    }

    public void editarSalvarAndamento() {
        try {
            OrdServicoDAO osdao = new OrdServicoDAO();
            String data1 = (new java.text.SimpleDateFormat("dd/MM/yyyy").format(data));
            osd.setResolvidoEm(data1);
            osdao.editar(osd);
            oslistas = osdao.listarTodosEmAndamento();
            Messages.addGlobalInfo("Ordem de serviço editada com sucesso.");
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao editar a ordem de serviço!");
            e.printStackTrace();
        }
    }

    public void editarSenha() {

        try {
            PessoaDAO pesDAO = new PessoaDAO();
            String pesSenha = logado.getPessoalogado().getSenha();

            if (pesSenha.equals(senhaAtual)) {
                if (novaSenha.equals(confirmaSenha)) {
                    logado.getPessoalogado().setSenha(novaSenha);
                    pesDAO.editar(logado.getPessoalogado());
                    Messages.addGlobalInfo("Senha alterada com sucesso.");
                } else {
                    Messages.addGlobalWarn("Verifique os dados algo está incorreto!");
                }
            } else {
                Messages.addGlobalWarn("Verifique os dados algo está incorreto!");
            }
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao alterar a senha!");
            e.printStackTrace();
        }
    }

    public boolean temPermissoes(List<String> permissoes) {
        for (String permissao : permissoes) {
            if (logado.getPessoalogado().getFuncao().equals(permissao)) {
                return true;
            }
        }
        return false;
    }
    
    public void popular() {
        funcao1 = tipo.getFuncao();
        if (funcao1 != null) {
            TipoDAO tipodao = new TipoDAO();
            tipos = tipodao.listarTipoporFuncao(funcao1);
        }
    }

    public List<OrdServico> getOslistas() {
        return oslistas;
    }

    public void setOslistas(List<OrdServico> oslistas) {
        this.oslistas = oslistas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    public OrdServico getOsd() {
        return osd;
    }

    public void setOsd(OrdServico osd) {
        this.osd = osd;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public List<Funcao> getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(List<Funcao> funcoes) {
        this.funcoes = funcoes;
    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFuncao1() {
        return funcao1;
    }

    public void setFuncao1(String funcao1) {
        this.funcao1 = funcao1;
    }
}
