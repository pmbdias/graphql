package br.gov.mg.fazenda.graphqlejb.ejb;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless(name = TesteFacade.JNDI_NAME, mappedName = TesteFacade.JNDI_NAME)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class TesteFacadeBean implements TesteFacadeLocal, TesteFacadeRemote {

	@Resource
	private SessionContext context;

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public void teste() {
		System.out.println("chamou o EJB");
	}

}