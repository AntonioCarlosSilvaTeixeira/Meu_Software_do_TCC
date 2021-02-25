package br.com.sistemasgr.hibernateUtil;

import br.com.sistemasgr.bean.LoginBean;
import br.com.sistemasgr.domain.Pessoa;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.omnifaces.util.Faces;

/**
 *
 * @author Antonio Carlos
 */
public class AutenticacaoListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent pe) {

        String paginaAtual = Faces.getViewId();
    
        boolean ehPaginaDeLogin = paginaAtual.contains("Login.xhtml");
        if (!ehPaginaDeLogin) {
            LoginBean loginbean = Faces.getSessionAttribute("loginBean");
            
            if (loginbean == null) {
                Faces.navigate("/Login.xhtml");
                return;
            }
            Pessoa pesLogado = loginbean.getPessoalogado();
            if (pesLogado == null) {
                Faces.navigate("/Login.xhtml");
            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
