package com.m2i.tp.appliSpringJpa.entity.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class LigneCommandePk implements Serializable {
	private Integer numCommande;
	private Integer numLigne;
	
	public LigneCommandePk() {
		super();
	}

	public LigneCommandePk(Integer numCommande, Integer numLigne) {
		super();
		this.numCommande = numCommande;
		this.numLigne = numLigne;
	}
	
	@Override
	public String toString() {
		return "LigneCommandePk [numCommande=" + numCommande + ", numLigne=" + numLigne + "]";
	}
	public Integer getNumCommande() {
		return numCommande;
	}
	public void setNumCommande(Integer numCommande) {
		this.numCommande = numCommande;
	}
	public Integer getNumLigne() {
		return numLigne;
	}
	public void setNumLigne(Integer numLigne) {
		this.numLigne = numLigne;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numCommande, numLigne);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneCommandePk other = (LigneCommandePk) obj;
		return Objects.equals(numCommande, other.numCommande) && Objects.equals(numLigne, other.numLigne);
	}
	
	
	
	
}
