package lr10.ex1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class ex1xml {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.newDocument();
            Element rootElement = document.createElement("library");
            document.appendChild(rootElement);

            Element book1 = document.createElement("book");
            rootElement.appendChild(book1); // Добавляем book как дочерний элемент library

            Element title1 = document.createElement("title");
            title1.appendChild(document.createTextNode("Война и мир")); // Исправлено: добавляем текст в title
            book1.appendChild(title1); // Добавляем title как дочерний элемент book

            Element author1 = document.createElement("author");
            author1.appendChild(document.createTextNode("Лев Толстой"));
            book1.appendChild(author1);

            Element year1 = document.createElement("year");
            year1.appendChild(document.createTextNode("1869"));
            book1.appendChild(year1);

            Element book2 = document.createElement("book");
            rootElement.appendChild(book2); // Добавляем book как дочерний элемент library

            Element title2 = document.createElement("title");
            title2.appendChild(document.createTextNode("Война и мир")); // Исправлено: добавляем текст в title
            book2.appendChild(title2); // Добавляем title как дочерний элемент book

            Element author2 = document.createElement("author");
            author2.appendChild(document.createTextNode("Лев Толстой"));
            book2.appendChild(author2);

            Element year2 = document.createElement("year");
            year2.appendChild(document.createTextNode("1869"));
            book2.appendChild(year2);

            document.setXmlStandalone(true);
            document.normalizeDocument();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("src/main/java/lr10/ex1/example.xml"));
            transformer.transform(source, streamResult);
            System.out.println("XML created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
