/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package tiagoDev.cobranca.model;

public enum StatusTipoTitulo {

	RECEITA("Receita"), DESPESA("Despesa");

	private String descricaoTipoTitulo;

	private StatusTipoTitulo(String descricaoTipoTitulo) {
		this.descricaoTipoTitulo = descricaoTipoTitulo;
	}
}
