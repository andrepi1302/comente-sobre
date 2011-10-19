package br.com.comentesobre.infra.transacional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;

@RequestScoped
@Intercepts
public class ControleTransacional implements Interceptor {
	
	private EntityManager entityManager;
	private final static Logger logger = Logger.getLogger(ControleTransacional.class);  
	
	public ControleTransacional(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public boolean accepts(ResourceMethod method) {
		return true;
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object object) throws InterceptionException {
		
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			
			transaction.begin();
			stack.next(method, object);
			transaction.commit();
			
		} catch(Exception exception) {
			transaction.rollback();
			logger.error(exception.getMessage(), exception);
			throw new InterceptionException(exception);
		} 
	}
}
