
package br.com.sistemasgr.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Antonio Carlos
 */
@Entity //anotação para gera as tabelas no banco de dados atraves do hibernate
public class Log_servico extends GenericDomain{
    
    @Temporal(TemporalType.DATE) //anotação para fala que é um campo do tipo data
    private Date dataa;
    
    
    @Column(length = 50, nullable = false) //anotação para o tamanho do campo a 50 caracteria e dizer que ele é not null
                                           //ou seja não pode ser vazio
    private String servico, descricao;
    
    @ManyToOne //anotação para dizer pro banco que é um relacionamento
               //que pessoas tem são varios tecnico mas um tecnico é uma unica pessoa
    @JoinColumn(nullable = false) //anotação para manytoone que não pode ser vazio
    private OrdServico ord_servico; //chave estrangeira
    
    @ManyToOne //anotação para dizer pro banco que é um relacionamento
               //que pessoas tem são varios tecnico mas um tecnico é uma unica pessoa
    @JoinColumn(nullable = false) //anotação para manytoone que não pode ser vazio
    private Tecnico tecnico; //chave estrangeira

    public Date getDataa() {
        return dataa;
    }

    public void setDataa(Date dataa) {
        this.dataa = dataa;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public OrdServico getOrd_servico() {
        return ord_servico;
    }

    public void setOrd_servico(OrdServico ord_servico) {
        this.ord_servico = ord_servico;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
            
}
