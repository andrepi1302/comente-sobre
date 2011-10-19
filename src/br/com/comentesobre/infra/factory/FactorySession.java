package br.com.comentesobre.infra.factory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@RequestScoped
public class FactorySession implements ComponentFactory<EntityManager> {
	
	private EntityManager entityManager;
	private EntityManagerFactory factory;
	
	public FactorySession(EntityManagerFactory factory) {
		this.factory = factory; 
	}
	
	@PostConstruct
	public void init() {
		entityManager = factory.createEntityManager();
	}
	
	@Override
	public EntityManager getInstance() {
		return entityManager;
	}
	
	@PreDestroy
	public void end() {
		entityManager.close();
	}
}
