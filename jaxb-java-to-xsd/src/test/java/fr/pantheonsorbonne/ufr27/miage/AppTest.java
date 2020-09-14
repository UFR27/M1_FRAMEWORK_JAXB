package fr.pantheonsorbonne.ufr27.miage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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
	public void marshall() throws JAXBException {

		Course course = new Course();
		course.setName("name");

		Student s1 = new Student();
		s1.setName("s1");
		s1.setGrade(15.0);

		Student s2 = new Student();
		s2.setName("s2");
		s2.setGrade(9.0);

		course.setStudents(Arrays.asList(s1, s2));

		JAXBContext context = JAXBContext.newInstance(Course.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter writer = new StringWriter();

		marshaller.marshal(course, writer);

		assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
				+ "<tns:course xmlns:tns=\"http://miage.ufr27.pantheonsorbonne.fr\">\n"
				+ "    <tns:name>name</tns:name>\n" + "    <tns:students>\n" + "        <tns:student>\n"
				+ "            <tns:grade>15.0</tns:grade>\n" + "            <tns:name>s1</tns:name>\n"
				+ "        </tns:student>\n" + "        <tns:student>\n" + "            <tns:grade>9.0</tns:grade>\n"
				+ "            <tns:name>s2</tns:name>\n" + "        </tns:student>\n" + "    </tns:students>\n"
				+ "</tns:course>\n", writer.toString());

	}

	@Test
	public void marshallValidation() throws JAXBException {

		Course course = new Course();
		course.setName("name");

		Student s1 = new Student();
		s1.setName("s1");
		s1.setGrade(15.0);

		Student s2 = new Student();
		s2.setName("s2");
		s2.setGrade(9.0);

		Student s3 = new Student();
		s3.setGrade(11.0);

		course.setStudents(Arrays.asList(s1, s2, s3));

		JAXBContext context = JAXBContext.newInstance(Course.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter writer = new StringWriter();

		marshaller.marshal(course, writer);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Course>> violations = validator.validate(course);
		assertEquals(2, violations.size());
		// we have to violations:
		// student s3 has no name
		// student s2 has grade < 10

	}

}
