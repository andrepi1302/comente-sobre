package br.com.comentesobre.persistencia.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.ioc.Component;
import br.com.comentesobre.persistencia.entidades.Visitante;

@Component
public class VisitanteDao extends BaseDataAccessObject<Visitante, Integer> {
	
	private final static Logger logger = Logger.getLogger(VisitanteDao.class);
	
	public VisitanteDao(EntityManager entityManager) {
		super(entityManager, Visitante.class);
	}
	
	public Visitante procurarPeloEmail(Visitante visitante) {
		Query query = super.getEntityManager().createQuery("SELECT v FROM Visitante v WHERE email = :email");
		query.setParameter("email", visitante.getEmail());
		
		Visitante visitanteRetorno = null;
		try {
			visitanteRetorno = (Visitante) query.getSingleResult();
		} catch(NoResultException exception) {
			logger.info(exception.getMessage(), exception);
		}
		
		return visitanteRetorno;
	}
}
