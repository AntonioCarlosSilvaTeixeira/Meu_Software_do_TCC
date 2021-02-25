
package br.com.sistemasgr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Antonio Carlos
 */
@Entity //anotação para gera as tabelas no banco de dados atraves do hibernate
public class Tipo extends GenericDomain{
    
    @Column(length = 50, nullable = false) //anotação para o tamanho do campo a 50 caracteria e dizer que ele é not null
                                           //ou seja não pode ser vazio
    private String nome;
    
    @Column(length = 50)
    private String funcao;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
