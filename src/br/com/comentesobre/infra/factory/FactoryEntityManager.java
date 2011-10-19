package br.com.comentesobre.infra.factory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@ApplicationScoped
@Component
public class FactoryEntityManager implements ComponentFactory<EntityManagerFactory> {
	
	private EntityManagerFactory factory;
	
	@PostConstruct
	public void init() {
		factory =  Persistence.createEntityManagerFactory("ComenteSobrePostgres");
	}
	
	@Override
	public EntityManagerFactory getInstance() {
		return factory;
	}
	
	@PreDestroy
	public void end() {
		factory.close();
	}
}
