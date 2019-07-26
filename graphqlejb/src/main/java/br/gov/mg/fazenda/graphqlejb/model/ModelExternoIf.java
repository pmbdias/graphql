package br.gov.mg.fazenda.graphqlejb.model;

import io.leangen.graphql.annotations.types.GraphQLInterface;

@GraphQLInterface(name = "ModelExterno", implementationAutoDiscovery=true, 
//scanPackages = {"br.gov.mg.fazenda.graphqlejb.ejb", "br.gov.mg.fazenda.graphqlejb.model", "br.gov.mg.fazenda.graphqlejb.model.impl"}
scanPackages = {"br.gov.mg.fazenda.graphqlejb"}
)
public interface ModelExternoIf {

	public String getCor();

	public String getDescricao();

}