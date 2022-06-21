/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package tiagoDev.cobranca.model;

import lombok.Getter;

/**
 *
 * @author tiagolopes
 */
@Getter
public enum StatusTipoTitulo {
    RECEITA("Receita"),
    DESPESA("Despesa");

    private String descricaoTipoTitulo;

    private StatusTipoTitulo(String descricaoTipoTitulo) {
        this.descricaoTipoTitulo = descricaoTipoTitulo;
    }
}
