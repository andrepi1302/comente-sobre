package br.com.comentesobre.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_VIST")
public class Visitante implements Serializable {
	
	private static final long serialVersionUID = 1704895379884439075L;

	@Id
	@Column(name = "NUM_IDEN_VIST", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer numeroId;
	
	@Column(name = "DSC_MAIL", nullable = false)
	private String email;

	public Integer getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(Integer numeroId) {
		this.numeroId = numeroId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((numeroId == null) ? 0 : numeroId.hashCode());
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
		Visitante other = (Visitante) obj;
		if (numeroId == null) {
			if (other.numeroId != null)
				return false;
		} else if (!numeroId.equals(other.numeroId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Visitante [numeroId=" + numeroId + ", email=" + email + "]";
	}
}
