package br.com.comentesobre.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_COMT")
public class Comentario implements Serializable {
	
	private static final long serialVersionUID = 4110959267362650829L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "NUM_IDEN_COMT", nullable = false)
	private Integer numeroId;
	
	@ManyToOne
	@JoinColumn(name = "NUM_IDEN_VIST", nullable = false)
	private Visitante visitante;
	
	@Column(name = "DSC_PALA_CHAV", nullable = false)
	private String palavraChave;
	
	@Column(name = "DSC_COMT")
	private String comentario;

	public Integer getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(Integer numeroId) {
		this.numeroId = numeroId;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public String getPalavraChave() {
		return palavraChave;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((numeroId == null) ? 0 : numeroId.hashCode());
		result = prime * result
				+ ((visitante == null) ? 0 : visitante.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (numeroId == null) {
			if (other.numeroId != null)
				return false;
		} else if (!numeroId.equals(other.numeroId))
			return false;
		if (visitante == null) {
			if (other.visitante != null)
				return false;
		} else if (!visitante.equals(other.visitante))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentario [numeroId=" + numeroId + ", visitante=" + visitante
				+ ", palavraChave=" + palavraChave + ", comentario="
				+ comentario + "]";
	}	
}
