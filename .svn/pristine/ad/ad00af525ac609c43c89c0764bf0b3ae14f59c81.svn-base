package org.mountcloud.graphql;

import java.io.IOException;
import java.util.Map;

import org.mountcloud.graphql.request.query.DefaultGraphqlQuery;
import org.mountcloud.graphql.request.query.GraphqlQuery;
import org.mountcloud.graphql.response.GraphqlResponse;

public class GraphqlClientMain {

	private static GraphqlClient clientGraphql = GraphqlClient.buildGraphqlClient("http://localhost:7001/protocolographql/graphql");

	public static void main(String[] args) {

		System.out.println("####### ModelExterno ########");
		getModelExterno();

		System.out.println();
		System.out.println("######## ModelInterno #######");
		getModelInterno();
	}

	private static void queryPossibleTypes(String pInterfaceName) {

		GraphqlQuery queryp = new DefaultGraphqlQuery("__type");
		queryp.addParameter("name", pInterfaceName);
		queryp.addResultAttributes("name, possibleTypes { name } ");

		executeQuery(queryp);
	}

	private static void executeQuery(GraphqlQuery pGraphqlQuery) {

		try {
			System.out.println();
			System.out.println("## " + pGraphqlQuery.getRequestName());
			System.out.println(pGraphqlQuery.toString());
			GraphqlResponse response = clientGraphql.doQuery(pGraphqlQuery);

			//this map is graphql result
			Map data = response.getData();
			System.out.println(data.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void getModelExterno() {

		GraphqlQuery queryModelExternoAllSimples = new DefaultGraphqlQuery("modelExternoAll");		
		queryModelExternoAllSimples.addResultAttributes("cor, "
				+ "descricao ");

		executeQuery(queryModelExternoAllSimples);

		GraphqlQuery queryModelExternoAllCompleta = new DefaultGraphqlQuery("modelExternoAll");		
		queryModelExternoAllCompleta.addResultAttributes("cor, "
				+ "descricao "
				+ "... on ModelExternoPrimario{atributoUnicoPrimario}, "
				+ "... on ModelExternoSecundario{atributoUnicoSecundario}"
				);

		executeQuery(queryModelExternoAllCompleta);

		queryPossibleTypes("ModelExterno");
	}

	public static void getModelInterno() {

		GraphqlQuery queryModelInternoAllSimples = new DefaultGraphqlQuery("modelInternoAll");		
		queryModelInternoAllSimples.addResultAttributes("cor, "
				+ "descricao ");

		executeQuery(queryModelInternoAllSimples);

		GraphqlQuery queryModelInternoAllCompleta = new DefaultGraphqlQuery("modelInternoAll");		
		queryModelInternoAllCompleta.addResultAttributes("cor, "
				+ "descricao "
				+ "... on ModelInternoPrimario{atributoUnicoPrimario}, "
				+ "... on ModelInternoSecundario{atributoUnicoSecundario}"
				);

		executeQuery(queryModelInternoAllCompleta);

		queryPossibleTypes("ModelInterno");
	}

}