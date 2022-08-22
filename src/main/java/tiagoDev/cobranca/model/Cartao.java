/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiagoDev.cobranca.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tiagolopes
 */
@Entity
@Getter
@Setter
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "Ops! Qual o nome do cartão?")
    private String name;

    public Cartao(String name) {        
        this.name = name;
    }

    @OneToMany(mappedBy = "cartao")
    private List<Titulo> titulo;
    
    public Cartao() {
    }

}
