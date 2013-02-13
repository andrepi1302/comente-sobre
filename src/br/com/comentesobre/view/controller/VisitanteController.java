package br.com.comentesobre.view.controller;

import java.util.regex.Pattern;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.comentesobre.constantes.Constantes;
import br.com.comentesobre.persistencia.dao.VisitanteDao;
import br.com.comentesobre.persistencia.entidades.Comentario;
import br.com.comentesobre.persistencia.entidades.Visitante;

@Resource
public class VisitanteController {
	
	private VisitanteDao visitanteDao;
	private Result result;
	private Validator validator;
	
	public VisitanteController(VisitanteDao visitanteDao, Result result, Validator validator) {
		this.visitanteDao = visitanteDao;
		this.result = result; 
		this.validator = validator;
	}
	
	@Get
	@Path("/")
	public void formularioVisitante() {
		System.out.println("######################TESTE");
	}
	
	@Post
	@Path("/")
	public void validarFormulario(Visitante visitante, Comentario comentario) {
		
		if(visitante == null || visitante.getEmail().isEmpty()) {
			validator.add( new ValidationMessage("Comentarista, para seguirmos em frente é necessário colocar o seu email!", "visitante.email") );
		} else if(!Pattern.matches(Constantes.REGEX_EMAIL, visitante.getEmail())) {
			validator.add( new ValidationMessage("Comentarista, o seu email não é válido", "visitante.email") );
		}
		
		if(comentario == null || comentario.getPalavraChave().isEmpty()) {
			validator.add( new ValidationMessage("Comentarista, a palavra chave é de suma importancia para inserirmos o comentário", "comentario.palavraChave") );
		}
		validator.onErrorUsePageOf( this ).formularioVisitante();
		
		result.redirectTo( this ).processarFormulario(visitante, comentario);
	}
	
	@Path("/{comentario.palavraChave}")
	public void processarFormulario(Visitante visitante, Comentario comentario) {
		
		Visitante visitanteBanco = visitanteDao.procurarPeloEmail(visitante);
		if(visitanteBanco != null) { 
			comentario.setVisitante( visitanteBanco );
		} else {
			visitanteDao.persistir( visitante );
			comentario.setVisitante( visitante );
		}
		comentario.setPalavraChave( comentario.getPalavraChave().toLowerCase() );
		
		result.forwardTo( ComentarioController.class ).formularioAdicionarComentario(comentario);
	}
}
