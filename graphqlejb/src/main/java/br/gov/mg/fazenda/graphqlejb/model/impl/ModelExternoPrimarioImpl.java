package br.gov.mg.fazenda.graphqlejb.model.impl;

import br.gov.mg.fazenda.graphqlejb.model.ModelExternoIf;
import io.leangen.graphql.annotations.types.GraphQLType;

@GraphQLType(name = "ModelExternoPrimario")
public class ModelExternoPrimarioImpl implements ModelExternoIf {

	private String cor;

	private String descricao;

	private String atributoUnicoPrimario;

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAtributoUnicoPrimario() {
		return atributoUnicoPrimario;
	}

	public void setAtributoUnicoPrimario(String atributoUnicoPrimario) {
		this.atributoUnicoPrimario = atributoUnicoPrimario;
	}

}