package com.cm.beans;

import java.util.Date;

public class ConventionBean {

	private Date dateEffet;
	private Date dateFin;
	private long idAssociation;
	private String objet;
	private Date dateSignature;
	private long duree;
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

	public long getDuree() {
		return duree;
	}

	public void setDuree(long duree) {
		this.duree = duree;
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

}
