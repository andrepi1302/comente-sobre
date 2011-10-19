package br.com.comentesobre.view.controller;

import java.io.Serializable;
import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.comentesobre.persistencia.dao.ComentarioDao;
import br.com.comentesobre.persistencia.dao.VisitanteDao;
import br.com.comentesobre.persistencia.entidades.Comentario;
import br.com.comentesobre.persistencia.entidades.Visitante;

@Resource
public class ComentarioController implements Serializable {
	
	private static final long serialVersionUID = 8580431870964578467L;
	private ComentarioDao comentarioDao;
	private VisitanteDao visitanteDao;
	private Result result;
	private Validator validator;
	
	public ComentarioController(ComentarioDao comentarioDao, VisitanteDao visitanteDao, Result result, Validator validator) {
		this.comentarioDao = comentarioDao;
		this.visitanteDao = visitanteDao;
		this.result = result;
		this.validator = validator;
	}
	
	@Get
	public Comentario formularioAdicionarComentario(Comentario comentario) {
		return comentario;
	}
	
	/**
	 * Método que grava o formulário de comentário
	 * @param comentario - Comentário vindo da tela.
	 */
	@Post
	@Path("/{comentario.palavraChave}/apresentacao")
	public void gravarComentario(Comentario comentario) {
		
		if(comentario == null || comentario.getComentario().isEmpty()) {
			validator.add( new ValidationMessage("O comentário não pode ficar em branco!", "") ); 
		}
		validator.onErrorUsePageOf( this ).formularioAdicionarComentario(comentario);
		
		Visitante visitanteBanco = null; 
		if(comentario.getVisitante() != null) {
			visitanteBanco = visitanteDao.procurarPeloId(comentario.getVisitante().getNumeroId());
		}
		if(visitanteBanco != null) {
			comentario.setVisitante(visitanteBanco);
		}
		comentarioDao.persistir( comentario );
		
		result.redirectTo( this ).apresentarComentarios(comentario);
	}
	
	/**
	 * Método que busca no banco os comentarios relacionados.
	 * @param comentario -  Comentário vindo da tela.
	 * @return - Lista de comentários relacionados que será apresentada em tela.
	 */
	@Get
	@Path("/{comentario.palavraChave}/apresentacao")
	public List<Comentario> apresentarComentarios(Comentario comentario) {
		List<Comentario> comentarios = comentarioDao.procurarPelaPalavraChave(comentario.getPalavraChave());
		result.include("palavraChave", comentario.getPalavraChave());
		result.include("visitante", comentario.getVisitante());
		return comentarios;
	}
}
