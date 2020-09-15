package fr.pantheonsorbonne.ufr27.miage;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Panier {

	@XmlElementWrapper(required = true)
	@XmlElement(name = "article")
	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	List<Article> articles;
	double total;

}
