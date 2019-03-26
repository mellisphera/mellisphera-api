package com.mellisphera.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FlowerITSAP")
public class FlowerITSAP {
	
	public int periodemin;
	public int periodemax;
	public String periodemind;
	public String periodemaxd;
	public String interet_pollen;
	public String interet_nectar;
	public String indice_confiance;
	
	public FlowerITSAP() {
	}
	
	public FlowerITSAP(int periodemin, int periodemax, String interet_pollen, String interet_nectar,
			String indice_confiance) {
		super();
		this.periodemin = periodemin;
		this.periodemax = periodemax;
		this.interet_pollen = interet_pollen;
		this.interet_nectar = interet_nectar;
		this.indice_confiance = indice_confiance;
	}

	public int getPeriodemin() {
		return periodemin;
	}

	public void setPeriodemin(int periodemin) {
		this.periodemin = periodemin;
	}

	public int getPeriodemax() {
		return periodemax;
	}

	public void setPeriodemax(int periodemax) {
		this.periodemax = periodemax;
	}

	public String getInteret_pollen() {
		return interet_pollen;
	}

	public void setInteret_pollen(String interet_pollen) {
		this.interet_pollen = interet_pollen;
	}

	public String getInteret_nectar() {
		return interet_nectar;
	}

	public void setInteret_nectar(String interet_nectar) {
		this.interet_nectar = interet_nectar;
	}

	public String getIndice_confiance() {
		return indice_confiance;
	}

	public void setIndice_confiance(String indice_confiance) {
		this.indice_confiance = indice_confiance;
	}

	@Override
	public String toString() {
		return "FlowerITSAP [periodemin=" + periodemin + ", periodemax=" + periodemax
				+ ", interet_pollen=" + interet_pollen + ", interet_nectar=" + interet_nectar + ", indice_confiance="
				+ indice_confiance + "]";
	}

	public String getPeriodemind() {
		return periodemind;
	}

	public void setPeriodemind(String periodemind) {
		this.periodemind = periodemind;
	}

	public String getPeriodemaxd() {
		return periodemaxd;
	}

	public void setPeriodemaxd(String periodeminf) {
		this.periodemaxd = periodeminf;
	}
	
	
	
}
