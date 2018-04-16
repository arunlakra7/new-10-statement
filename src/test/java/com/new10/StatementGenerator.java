package com.new10;

import com.new10.exception.New10Exception;
import com.new10.exception.New10Reason;
import com.new10.xmlpojo.Stmt;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class StatementGenerator {

	public static Stmt generate(final String fileName) {
		try {

			final File file = new File("src/" + fileName);
			final JAXBContext jaxbContext = JAXBContext.newInstance(Stmt.class);

			final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (Stmt) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			throw new New10Exception(New10Reason.XML_PARSING_EXCEPTION, "Could not unmarshall xml file");
		}
	}
}
