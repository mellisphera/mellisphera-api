package com.apiwatch.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FlowerINRA")
public class FlowerINRA {

	public String autre;
	public String butineur;
	public String famille;
	public int flomax;
	public int flomin;
	public String flomind;
	public String flomaxd;
	public String flomindate;
	public String flomaxdate;
	public String forme;
	public String francais;
	public String genre;
	public int idplante;
	public String latin;
	public int pol_equ;
	public int pol_pol;
	public String remarq;
	public String ressource;
	
	public FlowerINRA() {
	}
	
	public FlowerINRA(String autre, String butineur, String famille, int flomax, int flomin, String flomind, String flomaxd,
			String flomindate, String flomaxdate, String forme, String francais, String genre, int idplante,
			String latin, int pol_equ, int pol_pol, String remarq, String ressource) {
		super();
		this.autre = autre;
		this.butineur = butineur;
		this.famille = famille;
		this.flomax = flomax;
		this.flomin = flomin;
		this.flomind = flomind;
		this.flomaxd = flomaxd;
		this.flomindate = flomindate;
		this.flomaxdate = flomaxdate;
		this.forme = forme;
		this.francais = francais;
		this.genre = genre;
		this.idplante = idplante;
		this.latin = latin;
		this.pol_equ = pol_equ;
		this.pol_pol = pol_pol;
		this.remarq = remarq;
		this.ressource = ressource;
	}

	public String getAutre() {
		return autre;
	}

	public void setAutre(String autre) {
		this.autre = autre;
	}

	public String getButineur() {
		return butineur;
	}

	public void setButineur(String butineur) {
		this.butineur = butineur;
	}

	public String getFamille() {
		return famille;
	}

	public void setFamille(String famille) {
		this.famille = famille;
	}

	public int getFlomax() {
		return flomax;
	}

	public void setFlomax(int flomax) {
		this.flomax = flomax;
	}

	public int getFlomin() {
		return flomin;
	}

	public void setFlomin(int flomin) {
		this.flomin = flomin;
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	public String getFrancais() {
		return francais;
	}

	public void setFrancais(String francais) {
		this.francais = francais;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getIdplante() {
		return idplante;
	}

	public void setIdplante(int idplante) {
		this.idplante = idplante;
	}

	public String getLatin() {
		return latin;
	}

	public void setLatin(String latin) {
		this.latin = latin;
	}

	public int getPol_equ() {
		return pol_equ;
	}

	public void setPol_equ(int pol_equ) {
		this.pol_equ = pol_equ;
	}

	public int getPol_pol() {
		return pol_pol;
	}

	public void setPol_pol(int pol_pol) {
		this.pol_pol = pol_pol;
	}

	public String getRemarq() {
		return remarq;
	}

	public void setRemarq(String remarq) {
		this.remarq = remarq;
	}

	public String getRessource() {
		return ressource;
	}

	public void setRessource(String ressource) {
		this.ressource = ressource;
	}
	
	@Override
	public String toString() {
		return "FleurTheorique [autre=" + autre + ", butineur=" + butineur + ", famille=" + famille + ", flomax="
				+ flomax + ", flomin=" + flomin + ", forme=" + forme + ", francais=" + francais + ", genre=" + genre
				+ ", idplante=" + idplante + ", latin=" + latin + ", pol_equ=" + pol_equ + ", pol_pol=" + pol_pol
				+ ", remarq=" + remarq + ", ressource=" + ressource + "]";
	}

	public String getFlomind() {
		return flomind;
	}

	public void setFlomind(String flomind) {
		this.flomind = flomind;
	}

	public String getFlomaxd() {
		return flomaxd;
	}

	public void setFlomaxd(String flomaxd) {
		this.flomaxd = flomaxd;
	}

	public String getFlomindate() {
		return flomindate;
	}

	public void setFlomindate(String flomindate) {
		this.flomindate = flomindate;
	}

	public String getFlomaxdate() {
		return flomaxdate;
	}

	public void setFlomaxdate(String flomaxdate) {
		this.flomaxdate = flomaxdate;
	}

	
}
