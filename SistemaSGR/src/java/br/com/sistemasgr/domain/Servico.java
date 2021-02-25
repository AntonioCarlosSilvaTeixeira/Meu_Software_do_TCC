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
public class Servico extends GenericDomain {

    @Column(length = 50, nullable = false) //anotação para o tamanho do campo a 50 caracteria e dizer que ele é not null
    //ou seja não pode ser vazio
    private String nome;

    @ManyToOne // uma pessoa tem varias ordem de serviço mas uma ordem de serviço só tem uma pessoa
    @JoinColumn(nullable = false)
    private Tipo tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
