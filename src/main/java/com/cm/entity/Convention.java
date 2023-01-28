package com.cm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "conv_convention")
public class Convention {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String objet;
	private Date dateSignature;
	private Date dateEffet;
	private Date dateFin;
	private String comite_Suivi;
	private String oblig_conseil;
	private String montant_aide_conseil;
	private long idAssociation;
	
	private Date creationDate;
	private Date updateDate;
	private String createurUser;

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateurUser() {
		return createurUser;
	}

	public void setCreateurUser(String createurUser) {
		this.createurUser = createurUser;
	}

	// added 08.08.20
	// @Column(nullable =true)
	private long duree;

	@ManyToOne
	@JoinColumn(name = "TYPCONV_id", nullable = true)
	private TypeConvention typeConvention;
/*
	@ManyToOne
	@JoinColumn(name = "STATCONV_id", nullable = true)
	private StatutConvention statutConvention;
*/
	public Convention() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Convention(String objet, Date dateSignature, Date dateEffet, Date dateFin, String comite_Suivi,
			 String oblig_conseil, String montant_aide_conseil, long idAssociation,
			TypeConvention typeConvention, long duree, Date creationDate,
			Date updateDate, String createurUser) {
		super();
		this.objet = objet;
		this.dateSignature = dateSignature;
		this.dateEffet = dateEffet;
		this.dateFin = dateFin;
		this.comite_Suivi = comite_Suivi;
		this.oblig_conseil = oblig_conseil;
		this.montant_aide_conseil = montant_aide_conseil;
		this.idAssociation = idAssociation;
		this.typeConvention = typeConvention;
		//this.statutConvention = statutConvention;
		this.duree = duree;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.createurUser = createurUser;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public Date getDateSignature() {
		return dateSignature;
	}

	public void setDateSignature(Date dateSignature) {
		this.dateSignature = dateSignature;
	}

	public Date getDateEffet() {
		return dateEffet;
	}

	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public long getIdAssociation() {
		return idAssociation;
	}

	public void setIdAssociation(long idAssociation) {
		this.idAssociation = idAssociation;
	}

	public TypeConvention getTypeConvention() {
		return typeConvention;
	}

	public void setTypeConvention(TypeConvention typeConvention) {
		this.typeConvention = typeConvention;
	}
/*
	public StatutConvention getStatutConvention() {
		return statutConvention;
	}

	public void setStatutConvention(StatutConvention statutConvention) {
		this.statutConvention = statutConvention;
	}
*/
	public long getDuree() {
		return duree;
	}

	public void setDuree(long duree) {
		this.duree = duree;
	}

	public String getComite_Suivi() {
		return comite_Suivi;
	}

	public void setComite_Suivi(String comite_Suivi) {
		this.comite_Suivi = comite_Suivi;
	}

	public String getOblig_conseil() {
		return oblig_conseil;
	}

	public void setOblig_conseil(String oblig_conseil) {
		this.oblig_conseil = oblig_conseil;
	}

	public String getMontant_aide_conseil() {
		return montant_aide_conseil;
	}

	public void setMontant_aide_conseil(String montant_aide_conseil) {
		this.montant_aide_conseil = montant_aide_conseil;
	}

	
	
}