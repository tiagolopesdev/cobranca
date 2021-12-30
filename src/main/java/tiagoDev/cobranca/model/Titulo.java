/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiagoDev.cobranca.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author tiago
 */
@Entity
@Getter
@Setter
public class Titulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String descricao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusTitulo status;

    public Titulo(String descricao, Date dataVencimento, BigDecimal valor, StatusTitulo status) {
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Titulo other = (Titulo) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

}
