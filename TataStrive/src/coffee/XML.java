package coffee;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;

public class XML {
    public static void main(String[] args) {
        try {
            // Adjust path if necessary—ensure the XML file is in the correct folder
            File file = new File("src/Transfer.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            String title = doc.getElementsByTagName("title").item(0).getTextContent();
            System.out.println("Book Title: " + title);
            String author = doc.getElementsByTagName("author").item(0).getTextContent();
            System.out.println("Book Author: " + author);
        } catch (Exception e) {
            e.printStackTrace(); // Provides detailed error info
        }
    }
}