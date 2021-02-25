
package br.com.sistemasgr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Antonio Carlos
 */
@Entity //anotação para gera as tabelas no banco de dados atraves do hibernate
public class Local extends GenericDomain{
    
    @Column(length = 50, nullable = false) //anotação para o tamanho do campo a 50 caracteria e dizer que ele é not null
                                           //ou seja não pode ser vazio
    private String nome;
    
    @Column(length = 10, nullable = false)
    private String numero_local;
     
    public String getNumero_local() {
        return numero_local;
    }

    public void setNumero_local(String numero_local) {
        this.numero_local = numero_local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
