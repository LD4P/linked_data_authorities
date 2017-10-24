package edu.uiowa.slis.GeoNames.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Loader {
    protected static Logger logger = Logger.getLogger(Loader.class);

    public static void main(String[] args) throws IOException {
	PropertyConfigurator.configure("log4j.info");
	BufferedReader reader = new BufferedReader(new FileReader(args[0]));
	FileOutputStream out = new FileOutputStream(new File("/usr/local/RAID/geonames.nt"));
	String buffer = null;
	int count = 0;
	
	while ((buffer = reader.readLine()) != null) {
	    if (++count % 2 == 0) {
		logger.debug("processing xml: " + buffer);
		Model model = ModelFactory.createDefaultModel() ;
		model.read(new StringReader(buffer), null, "RDF/XML");
		model.write(out, "N-TRIPLE");
	    } else {
		logger.info("skipping: " + buffer);
	    }
	}
	reader.close();
    }
}
