package fr.pantheonsorbonne.ufr27.miage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.sun.xml.bind.api.JAXBRIContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@Test
	public void shouldAnswerWithTrue() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);

		Unmarshaller unmarshaller = context.createUnmarshaller();

		Object o = unmarshaller.unmarshal(new File("src/test/resources/po.xml"));
		assertTrue(o instanceof JAXBElement);
		PurchaseOrderType order = ((JAXBElement<PurchaseOrderType>) o).getValue();

		assertEquals("Alice Smith", order.getShipTo().getName());
	}

	@Test
	public void unMarshallValidate() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);

		Unmarshaller unmarshaller = context.createUnmarshaller();

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema employeeSchema = sf.newSchema(new File("src/main/xsd/po.xsd"));
		unmarshaller.setSchema(employeeSchema);

		try {
			Object o = unmarshaller.unmarshal(new File("src/test/resources/po2.xml"));
			fail();
		} catch (UnmarshalException e) {
			SAXParseException saxexp = (SAXParseException) (e.getCause());

			assertEquals(4, saxexp.getLineNumber());
		}

	}
}
