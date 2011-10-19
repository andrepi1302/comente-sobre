package br.com.comentesobre.infra.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *  Factory para cria��o de conex�es <br/>
 *  Classe n�o mais Utilizada, foi pensada quando iriamos utilizar Factory puro */

@Deprecated
public class ConnectionFactory {
	
	private static EntityManagerFactory entityManagerFactory;
	
	static {		
		entityManagerFactory = Persistence.createEntityManagerFactory("ComenteSobre");
	}
	
	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
