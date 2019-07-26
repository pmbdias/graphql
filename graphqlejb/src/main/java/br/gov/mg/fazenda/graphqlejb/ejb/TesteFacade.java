package br.gov.mg.fazenda.graphqlejb.ejb;

public interface TesteFacade {

	/**
	 * Nome do JNDI para acesso � fachada.
	 */
	String JNDI_NAME = "TesteFacade";

	void teste();

}