
package br.com.sistemasgr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Antonio
 */
@Entity //anotação para gera as tabelas no banco de dados atraves do hibernate
public class Funcao extends GenericDomain{
    
    @Column(length = 50, nullable = false)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
