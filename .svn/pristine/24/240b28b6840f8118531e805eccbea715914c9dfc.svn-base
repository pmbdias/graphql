package br.gov.mg.fazenda.graphqlweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.gov.mg.fazenda.graphqlejb.model.ModelExternoIf;
import br.gov.mg.fazenda.graphqlejb.model.impl.ModelExternoPrimarioImpl;
import br.gov.mg.fazenda.graphqlejb.model.impl.ModelExternoSecundarioImpl;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class ModelExternoService {

	@GraphQLQuery(name = "modelExternoAll")
	public List<ModelExternoIf> getHierarquiaIfs() {

		List<ModelExternoIf> list = new ArrayList<>();

		ModelExternoPrimarioImpl primario = new ModelExternoPrimarioImpl();
		primario.setCor("verde");
		primario.setDescricao("primario");
		primario.setAtributoUnicoPrimario("teste primario");
		list.add(primario);

		ModelExternoSecundarioImpl secundario = new ModelExternoSecundarioImpl();
		secundario.setCor("azul");
		secundario.setDescricao("secundario");
		secundario.setAtributoUnicoSecundario("teste secundario");
		list.add(secundario);

		return list;
	}

}