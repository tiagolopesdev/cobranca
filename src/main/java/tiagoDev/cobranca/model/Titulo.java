/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiagoDev.cobranca.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.function.BinaryOperator;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author tiago
 */
@Entity
public class Titulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @NotBlank(message = "Descrição obrigatória!")
    @Size(max = 60, message = "A descrição não pode conter mais de 60 caracteres")
    private String descricao;
    
    @NotNull(message = "Data de vencimento obrigatória")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    @NotNull(message = "Valor obrigatório!")
    @DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
    @DecimalMax(value = "9999999.99", message = "Valor não pode ser maior que 9.999.999,99")
    @NumberFormat(pattern = "#,##0.00")
    private Double valor;
    
    @Enumerated(EnumType.STRING)
    private StatusTitulo status;
        
    @Enumerated(EnumType.STRING)
    private StatusTipoTitulo statusTipoTitulo;
    
    @ManyToOne
    private Cartao cartao;

    public Titulo() {
    }

    public Titulo(String descricao, Date dataVencimento, Double valor,
            StatusTitulo status, StatusTipoTitulo statusTipoTitulo,
            Cartao cartao) {        
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.status = status;
        this.statusTipoTitulo = statusTipoTitulo;
        this.cartao = cartao;
    }
    
    public boolean isPendente(){
        return StatusTitulo.PENDENTE.equals(this.status);
    }
    
    public boolean isDespesa(){
        return StatusTipoTitulo.DESPESA.equals(this.statusTipoTitulo);
    }
    
    public Double sumTipoTitulo(List<Titulo> allTipoTitulo, Enum tipoTitulo){
        BinaryOperator<Double> soma = (ac, n) -> ac + n;
        Double result = allTipoTitulo.stream()
                .filter(a -> a.getStatusTipoTitulo() == tipoTitulo)
                .map(a -> a.getValor())
                .reduce(soma).get();        
        return result;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public StatusTitulo getStatus() {
		return status;
	}

	public void setStatus(StatusTitulo status) {
		this.status = status;
	}

	public StatusTipoTitulo getStatusTipoTitulo() {
		return statusTipoTitulo;
	}

	public void setStatusTipoTitulo(StatusTipoTitulo statusTipoTitulo) {
		this.statusTipoTitulo = statusTipoTitulo;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
}
