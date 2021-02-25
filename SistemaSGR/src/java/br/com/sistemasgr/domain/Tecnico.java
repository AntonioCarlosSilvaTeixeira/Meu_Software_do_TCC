
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
public class Tecnico extends GenericDomain{
    @Column(length = 30, nullable = false) //anotação para o tamanho do campo a 50 caracteria e dizer que ele é not null
                                           //ou seja não pode ser vazio
    private String cargo;
    
    @ManyToOne //anotação para dizer pro banco que é um relacionamento
               //que pessoas tem são varios tecnico mas um tecnico é uma unica pessoa
    @JoinColumn(nullable = false) //anotação para manytoone que não pode ser vazio
    private Pessoa pesssoa; //vai ser usada como chave estrangeira de pessoa

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Pessoa getPesssoa() {
        return pesssoa;
    }

    public void setPesssoa(Pessoa pesssoa) {
        this.pesssoa = pesssoa;
    }
}
