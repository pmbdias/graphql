package br.gov.mg.fazenda.graphqlweb.model;

import io.leangen.graphql.annotations.types.GraphQLInterface;

@GraphQLInterface(name = "ModelInterno", implementationAutoDiscovery=true, 
//scanPackages = {"br.gov.mg.fazenda.graphqlejb.ejb", "br.gov.mg.fazenda.graphqlejb.model", "br.gov.mg.fazenda.graphqlejb.model.impl"}
scanPackages = {"br.gov.mg.fazenda.graphqlweb"}
)
public interface ModelInternoIf {

	public String getCor();

	public String getDescricao();

}