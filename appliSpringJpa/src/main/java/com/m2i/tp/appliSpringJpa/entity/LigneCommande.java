package com.m2i.tp.appliSpringJpa.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.m2i.tp.appliSpringJpa.entity.pk.LigneCommandePk;

@Entity
@Table(name = "ligne_commande")
public class LigneCommande {
	
	@EmbeddedId
	private LigneCommandePk pk;
	
	@Column(name="ref_produit")
	private String refProduit;
	
	private Integer quantite;
	
	@Column(name="prix_unitaire")
	private Double prixUnitaire;

}
