package br.com.sistemasgr.bean;

import br.com.sistemasgr.dao.LocalDAO;
import br.com.sistemasgr.dao.OrdServicoDAO;
import br.com.sistemasgr.dao.PessoaDAO;
import br.com.sistemasgr.dao.ServicoDAO;
import br.com.sistemasgr.dao.TipoDAO;
import br.com.sistemasgr.domain.Local;
import br.com.sistemasgr.domain.OrdServico;
import br.com.sistemasgr.domain.Servico;
import br.com.sistemasgr.domain.Tipo;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

/**
 *
 * @author Antonio Carlos
 */
@ManagedBean
@ViewScoped
public class OrdServicoBean implements Serializable {

    private OrdServico ordservico;
    private Tipo tipo;

    private List<Tipo> tipos;
    private List<Local> locais;
    private List<Servico> servicos;
    private List<OrdServico> oslistas;
    private String senhaAtual, novaSenha, confirmaSenha;

    LoginBean logado = Faces.getSessionAttribute("loginBean");

    public void habilitarBTNSalvar() {
        ordservico.getLocal();
        ordservico.getTipo();
        ordservico.getServico();
        ordservico.getObservacao();
    }

    public void novo() {
        try {
            ordservico = new OrdServico();
            tipo = new Tipo();

            TipoDAO tipodao = new TipoDAO();
            tipos = tipodao.listarTipoporFuncao(logado.getPessoalogado().getFuncao());

            LocalDAO localdao = new LocalDAO();
            locais = localdao.listar();

            servicos = new ArrayList<>();
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao listar");
            e.printStackTrace();
        }
    }

    public void salvar() {
        try {
            dataHora();
            OrdServicoDAO osdao = new OrdServicoDAO();
            osdao.salvar(ordservico);
            Messages.addGlobalInfo("Ordem de Serviço salva com sucesso.");
            novo();
        } catch (Exception e) {
            Messages.addGlobalError("Erro ao tentar salvar a ordem de serviço!");
            e.printStackTrace();
        }
    }

    public void dataHora() {

        String data = (new java.text.SimpleDateFormat("dd/MM/yyyy")
                .format(new java.util.Date(System.currentTimeMillis())));

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        java.util.Date hora = Calendar.getInstance().getTime();
        String horaf = sdf.format(hora);

        ordservico.setData(data);
        ordservico.setHora(horaf);
        ordservico.setPessoa(logado.getPessoalogado());
        ordservico.setSituacao("Ativo");
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

    public void listarAtivos() {
        try {
            OrdServicoDAO osdao = new OrdServicoDAO();
            oslistas = osdao.listarAtivos(logado.getPessoalogado().getCodigo());

        } catch (Exception e) {
            Messages.addGlobalError("Erro ao tentar listar suas requisções ativas!");
            e.printStackTrace();
        }
    }

    public void listarAndamentos() {
        try {
            OrdServicoDAO osdao = new OrdServicoDAO();
            oslistas = osdao.listarAndamentos(logado.getPessoalogado().getCodigo());

        } catch (Exception e) {
            Messages.addGlobalError("Erro ao tentar listar suas requisções em andamento!");
            e.printStackTrace();
        }
    }

    public void listarAtendidos() {
        try {
            OrdServicoDAO osdao = new OrdServicoDAO();
            oslistas = osdao.listarAtendidos(logado.getPessoalogado().getCodigo());

        } catch (Exception e) {
            Messages.addGlobalError("Erro ao tentar listar sua requisções atendidas!");
            e.printStackTrace();
        }
    }

    public void popular() {
        tipo = ordservico.getTipo();
        if (tipo != null) {
            ServicoDAO servdao = new ServicoDAO();
            servicos = servdao.listarServicoPorTipo(tipo.getCodigo());
        }
    }

    public void sair() {
        logado = null;
        logado = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("loginBean");
        Faces.invalidateSession();
        Faces.navigate("/Login.xhtml");
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    public List<Local> getLocais() {
        return locais;
    }

    public void setLocais(List<Local> locais) {
        this.locais = locais;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public OrdServico getOrdservico() {
        return ordservico;
    }

    public void setOrdservico(OrdServico ordservico) {
        this.ordservico = ordservico;
    }

    public List<OrdServico> getOslistas() {
        return oslistas;
    }

    public void setOslistas(List<OrdServico> oslistas) {
        this.oslistas = oslistas;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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
}
