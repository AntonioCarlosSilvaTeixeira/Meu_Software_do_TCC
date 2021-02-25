
package br.com.sistemasgr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Antonio Carlos
 */
@Entity //anotação para gera as tabelas no banco de dados atraves do hibernate
public class OrdServico extends GenericDomain{
    
     //anotação para o tamanho do campo a 50 caracteria e dizer que ele é not null ou seja não pode ser vazio
    @Column(length = 100, nullable = false)                                      
    private String observacao;
    
    @Column(length = 100)                                      
    private String descrição;
    
    @Column(length = 50)                                      
    private String tecnico;
    
    @Column(length = 50, nullable = false)                                      
    private String situacao;
    
    @ManyToOne // uma pessoa tem varias ordem de serviço mas uma ordem de serviço só tem uma pessoa
    @JoinColumn(nullable = false)
    private Servico servico;
    
    @ManyToOne // uma pessoa tem varias ordem de serviço mas uma ordem de serviço só tem uma pessoa
    @JoinColumn(nullable = false)
    private Local local;
    
    @ManyToOne // uma pessoa tem varias ordem de serviço mas uma ordem de serviço só tem uma pessoa
    @JoinColumn(nullable = false)
    private Tipo tipo;
    
    @Column(length = 10)
    private String data, resolvidoEm;
    
    @Column(length = 10)
    private String hora;
    
    @ManyToOne // uma pessoa tem varias ordem de serviço mas uma ordem de serviço só tem uma pessoa
    @JoinColumn(nullable = false) //anotação para manytoone que não pode ser vazio
    private Pessoa pessoa;//vai ser usada como chave estrangeira de pessoa
    
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }  

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }
    
    public String getResolvidoEm() {
        return resolvidoEm;
    }

    public void setResolvidoEm(String resolvidoEm) {
        this.resolvidoEm = resolvidoEm;
    }
}
