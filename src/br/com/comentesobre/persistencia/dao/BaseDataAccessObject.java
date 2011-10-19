package br.com.comentesobre.persistencia.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

public class BaseDataAccessObject<T, ID extends Serializable> {
	
	private EntityManager entityManager;
	private Class<T> clazz;
	
	public BaseDataAccessObject(EntityManager entityManager, Class<T> clazz) {
		this.entityManager = entityManager;
		this.clazz = clazz;
	}
	
	/**
	 * Método que persiste somente um objeto por vez
	 * @param entidade Objeto a ser persistido
	 */
	public void persistir(T entidade) {
		entityManager.persist( entidade );
	}
	
	/**
	 * Método que grava um bloco de informações
	 * @param entidades Colecao de entidades que serao gravadas
	 */
	public void persistirTudo(Collection<T> entidades) {
		
		for(T object : entidades) {
			entityManager.persist( object );
		}
		entityManager.flush();
	}
	
	/**
	 * Remove do banco de dados a entidade passada por parametro
	 * @param entidade Entidade a ser removida
	 */
	public void remover(T entidade) {
		entityManager.remove( entidade );
	}
	
	/**
	 * Método que retorna uma instancia do objeto conforme o ID.
	 * @param id Numero do registro a ser buscado
	 * @return Retorna a instancia, em modo EAGER, da classe declarada
	 */
	public T procurarPeloId(ID id) {
		return entityManager.find(clazz, id);
	}
	
	/**
	 * Método que retorna uma lista de todos os objetos, sem parametros
	 * @return Colecao de objetos da entidade referenciada
	 */
	@SuppressWarnings("unchecked")
	public List<T> procurarTudo() {
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
