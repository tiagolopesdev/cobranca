/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiagoDev.cobranca.model;

import lombok.Getter;

/**
 *
 * @author tiago
 */
@Getter
public enum StatusTitulo {

    PENDENTE("Pendente"),
    RECEBIDO("Recebido");

    private String descricao;

    private StatusTitulo(String descricao) {
        this.descricao = descricao;
    }

}
