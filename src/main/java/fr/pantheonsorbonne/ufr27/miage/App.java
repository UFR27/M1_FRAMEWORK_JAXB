package fr.pantheonsorbonne.ufr27.miage;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws JAXBException {
		InputStream is = App.class.getClassLoader().getResourceAsStream("po.xml");

		JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);

		Unmarshaller unmarshaller = context.createUnmarshaller();
		JAXBElement<PurchaseOrderType> pojo = (JAXBElement<PurchaseOrderType>) unmarshaller.unmarshal(is);
		PurchaseOrderType order = pojo.getValue();
		
		String stringPojo = new ReflectionToStringBuilder(order, new RecursiveToStringStyle()).toString();
		System.out.println(stringPojo);


	}
}
