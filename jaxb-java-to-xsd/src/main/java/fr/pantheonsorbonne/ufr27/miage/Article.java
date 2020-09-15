package fr.pantheonsorbonne.ufr27.miage;

import com.sun.xml.txw2.annotation.XmlAttribute;

public class Article {

	@XmlAttribute
	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;

	}

	@XmlAttribute
	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	String denomination;
	double prixUnitaire;

}
