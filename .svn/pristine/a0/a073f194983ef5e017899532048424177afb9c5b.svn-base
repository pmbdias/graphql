package br.gov.mg.fazenda.graphqlweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.gov.mg.fazenda.graphqlweb.model.ModelInternoIf;
import br.gov.mg.fazenda.graphqlweb.model.impl.ModelInternoPrimarioImpl;
import br.gov.mg.fazenda.graphqlweb.model.impl.ModelInternoSecundarioImpl;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class ModelInternoService {

	@GraphQLQuery(name = "modelInternoAll")
	public List<ModelInternoIf> getHierarquiaIfs() {

		List<ModelInternoIf> list = new ArrayList<>();

		ModelInternoPrimarioImpl primario = new ModelInternoPrimarioImpl();
		primario.setCor("verde");
		primario.setDescricao("primario");
		primario.setAtributoUnicoPrimario("teste primario");
		list.add(primario);

		ModelInternoSecundarioImpl secundario = new ModelInternoSecundarioImpl();
		secundario.setCor("azul");
		secundario.setDescricao("secundario");
		secundario.setAtributoUnicoSecundario("teste secundario");
		list.add(secundario);

		return list;
	}

}