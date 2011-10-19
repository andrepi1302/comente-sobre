package br.com.comentesobre.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;
import br.com.comentesobre.persistencia.entidades.Comentario;

@Component
public class ComentarioDao extends BaseDataAccessObject<Comentario, Integer> {
	
	public ComentarioDao(EntityManager entityManager) {		
		super(entityManager, Comentario.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Comentario> procurarPelaPalavraChave(String palavraChave) {
		List<Comentario> listaRetorno = new ArrayList<Comentario>();
		
		String stringQuery = "SELECT c FROM Comentario c WHERE palavraChave = :palavraChave";
		Query query = super.getEntityManager().createQuery(stringQuery);
		query.setParameter("palavraChave", palavraChave);
		
		listaRetorno = (List<Comentario>) query.getResultList();
		return listaRetorno;
	}
}
