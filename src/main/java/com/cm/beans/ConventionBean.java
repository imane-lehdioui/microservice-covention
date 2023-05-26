package com.cm.beans;

import com.cm.entity.SuiveeExec;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ConventionBean {

	private long id;
	private String numSubvention;//رقم الإتفاقية
	private String nomAssociation;//اسم الجمعية
	private Date anneeSingConvention;//  تاريخ توقيع الإتفاقية
	private Date anneeAcquisition;// تاريخ المصادقة
	private String objetConvention;//موضوع الإتفاقية
	private String champActivite;
	private String natureActivite;
	private String cible;
	private String activite_de_rayonnement;
	private String local;
	private Long duree;//مدة الإتفاقية
	private Long nombreRenouvelle;// عدد مرات التجديد
	private String natureSubvention; //نوع الدعم
	private double montantDemande;//مبلغ الدعم
	private List<SuiveeExec> suiveeExec; //تتبع إنجاز النشاط
	private String arrondissement;

	public ConventionBean(long id, String numSubvention, String nomAssociation, Date anneeSingConvention, Date anneeAcquisition, String objetConvention, String champActivite, String natureActivite, String cible, String activite_de_rayonnement, String local, Long duree, Long nombreRenouvelle, String natureSubvention, double montantDemande, List<SuiveeExec> suiveeExec, String arrondissement) {
		this.id = id;
		this.numSubvention = numSubvention;
		this.nomAssociation = nomAssociation;
		this.anneeSingConvention = anneeSingConvention;
		this.anneeAcquisition = anneeAcquisition;
		this.objetConvention = objetConvention;
		this.champActivite = champActivite;
		this.natureActivite = natureActivite;
		this.cible = cible;
		this.activite_de_rayonnement = activite_de_rayonnement;
		this.local = local;
		this.duree = duree;
		this.nombreRenouvelle = nombreRenouvelle;
		this.natureSubvention = natureSubvention;
		this.montantDemande = montantDemande;
		this.suiveeExec = suiveeExec;
		this.arrondissement = arrondissement;
	}

	public ConventionBean() {

	}

	public String getArrondissement() {
		return arrondissement;
	}

	public void setArrondissement(String arrondissement) {
		this.arrondissement = arrondissement;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumSubvention() {
		return numSubvention;
	}

	public void setNumSubvention(String numSubvention) {
		this.numSubvention = numSubvention;
	}

	public String getNomAssociation() {
		return nomAssociation;
	}

	public void setNomAssociation(String nomAssociation) {
		this.nomAssociation = nomAssociation;
	}

	public Date getAnneeSingConvention() {
		return anneeSingConvention;
	}

	public void setAnneeSingConvention(Date anneeSingConvention) {
		this.anneeSingConvention = anneeSingConvention;
	}

	public Date getAnneeAcquisition() {
		return anneeAcquisition;
	}

	public void setAnneeAcquisition(Date anneeAcquisition) {
		this.anneeAcquisition = anneeAcquisition;
	}

	public String getObjetConvention() {
		return objetConvention;
	}

	public void setObjetConvention(String objetConvention) {
		this.objetConvention = objetConvention;
	}

	public String getChampActivite() {
		return champActivite;
	}

	public void setChampActivite(String champActivite) {
		this.champActivite = champActivite;
	}

	public String getNatureActivite() {
		return natureActivite;
	}

	public void setNatureActivite(String natureActivite) {
		this.natureActivite = natureActivite;
	}

	public String getCible() {
		return cible;
	}

	public void setCible(String cible) {
		this.cible = cible;
	}

	public String getActivite_de_rayonnement() {
		return activite_de_rayonnement;
	}

	public void setActivite_de_rayonnement(String activite_de_rayonnement) {
		this.activite_de_rayonnement = activite_de_rayonnement;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Long getDuree() {
		return duree;
	}

	public void setDuree(Long duree) {
		this.duree = duree;
	}



	public Long getNombreRenouvelle() {
		return nombreRenouvelle;
	}

	public void setNombreRenouvelle(Long nombreRenouvelle) {
		this.nombreRenouvelle = nombreRenouvelle;
	}

	public String getNatureSubvention() {
		return natureSubvention;
	}

	public void setNatureSubvention(String natureSubvention) {
		this.natureSubvention = natureSubvention;
	}

	public double getMontantDemande() {
		return montantDemande;
	}

	public void setMontantDemande(double montantDemande) {
		this.montantDemande = montantDemande;
	}

	public List<SuiveeExec> getSuiveeExec() {
		return suiveeExec;
	}

	public void setSuiveeExec(List<SuiveeExec> suiveeExec) {
		this.suiveeExec = suiveeExec;
	}
}
