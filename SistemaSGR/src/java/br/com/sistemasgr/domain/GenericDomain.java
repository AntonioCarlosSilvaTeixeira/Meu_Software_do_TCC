
package br.com.sistemasgr.domain;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Antonio Carlos
 */
@MappedSuperclass //essa anotação serve para o hibernate não gerar uma tabela dessa classe
public class GenericDomain implements Serializable{
    
    @Id //anotação para dizer pro banco que esse atributo é uma chave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) // anotação para o banco controlar a inserção da chave primaria
    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString(){
        return String.format("%s[codigo=%d]", getClass().getSimpleName(), getCodigo());
    }
}
