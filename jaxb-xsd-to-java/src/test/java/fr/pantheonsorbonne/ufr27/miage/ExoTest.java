package fr.pantheonsorbonne.ufr27.miage;



import static org.junit.Assert.assertTrue;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class ExoTest {

	@Test
	public void exo1() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
		Unmarshaller unMarshaller = context.createUnmarshaller();
		

		JAXBElement p = (JAXBElement) unMarshaller.unmarshal(new File("src/test/resources/p1.xml"));
		Universite u = (Universite) p.getValue();
		
		assertTrue(u.getFac().get(0).getFiliere().getParcours().get(0).getDiplome().getType().equals(TypeDiplome.M));

	}

}
