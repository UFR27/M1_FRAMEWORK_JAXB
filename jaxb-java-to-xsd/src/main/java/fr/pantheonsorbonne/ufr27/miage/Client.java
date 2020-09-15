package fr.pantheonsorbonne.ufr27.miage;

import javax.xml.bind.annotation.XmlElement;

import com.sun.xml.txw2.annotation.XmlAttribute;

public class Client {

	@XmlElement(required = true)
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@XmlElement(required = true)
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@XmlAttribute
	public boolean isPersonneMorale() {
		return isPersonneMorale;
	}

	public void setPersonneMorale(boolean isPersonneMorale) {
		this.isPersonneMorale = isPersonneMorale;
	}

	String fname;
	String lname;
	String addresse;
	int zipCode;
	boolean isPersonneMorale;

}
