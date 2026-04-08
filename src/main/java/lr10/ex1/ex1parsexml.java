package lr10.ex1;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex1parsexml {
    private static Document doc;
    private static final String FILE_PATH = "src/main/java/lr10/ex1/example.xml";

    public static void main(String[] args) {
        try {
            File inputFile = new File(FILE_PATH);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n=== Меню ===");
                System.out.println("1. Вывести все фильмы");
                System.out.println("2. Добавить фильм");
                System.out.println("3. Найти фильмы по автору");
                System.out.println("4. Найти фильмы по году");
                System.out.println("5. Удалить фильм по названию");
                System.out.println("6. Выход");
                System.out.print("Выберите действие: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // очистка буфера

                switch (choice) {
                    case 1 -> printAllMovies();
                    case 2 -> addMovie(scanner);
                    case 3 -> searchByAuthor(scanner);
                    case 4 -> searchByYear(scanner);
                    case 5 -> deleteMovie(scanner);
                    case 6 -> {
                        saveToFile();
                        System.out.println("Изменения сохранены. Выход.");
                        return;
                    }
                    default -> System.out.println("Неверный выбор.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Вывод всех фильмов
    private static void printAllMovies() {
        NodeList nodeList = doc.getElementsByTagName("movie");
        System.out.println("\n=== Все фильмы ===");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.printf("Название: %s%n", getElementText(element, "title"));
                System.out.printf("Автор: %s%n", getElementText(element, "author"));
                System.out.printf("Год: %s%n", getElementText(element, "year"));
                System.out.println("-".repeat(30));
            }
        }
    }

    // Универсальный метод получения текста из элемента
    private static String getElementText(Element parent, String tagName) {
        NodeList list = parent.getElementsByTagName(tagName);
        if (list.getLength() > 0 && list.item(0).hasChildNodes()) {
            return list.item(0).getTextContent().trim();
        }
        return "не указано";
    }

    // Добавление нового фильма
    private static void addMovie(Scanner scanner) {
        System.out.print("Введите название фильма: ");
        String title = scanner.nextLine();
        System.out.print("Введите автора (режиссёра): ");
        String author = scanner.nextLine();
        System.out.print("Введите год выпуска: ");
        String year = scanner.nextLine();

        Element movie = doc.createElement("movie");

        Element titleElem = doc.createElement("title");
        titleElem.appendChild(doc.createTextNode(title));
        movie.appendChild(titleElem);

        Element authorElem = doc.createElement("author");
        authorElem.appendChild(doc.createTextNode(author));
        movie.appendChild(authorElem);

        Element yearElem = doc.createElement("year");
        yearElem.appendChild(doc.createTextNode(year));
        movie.appendChild(yearElem);

        doc.getDocumentElement().appendChild(movie);
        System.out.println("Фильм добавлен (сохранится при выходе).");
    }

    // Поиск по автору
    private static void searchByAuthor(Scanner scanner) {
        System.out.print("Введите автора для поиска: ");
        String author = scanner.nextLine().trim().toLowerCase();
        List<Element> results = getMoviesAsStream().stream()
                .filter(el -> getElementText(el, "author").toLowerCase().contains(author))
                .toList();
        printResults(results, "по автору");
    }

    // Поиск по году
    private static void searchByYear(Scanner scanner) {
        System.out.print("Введите год для поиска: ");
        String year = scanner.nextLine().trim();
        List<Element> results = getMoviesAsStream().stream()
                .filter(el -> getElementText(el, "year").equals(year))
                .toList();
        printResults(results, "по году");
    }

    // Удаление фильма по названию
    private static void deleteMovie(Scanner scanner) {
        System.out.print("Введите название фильма для удаления: ");
        String title = scanner.nextLine().trim().toLowerCase();
        List<Element> foundMovies = getMoviesAsStream().stream()
                .filter(el -> getElementText(el, "title").toLowerCase().contains(title))
                .toList();

        if (foundMovies.isEmpty()) {
            System.out.println("Фильм не найден.");
            return;
        }

        for (Element movie : foundMovies) {
            Node parent = movie.getParentNode();
            parent.removeChild(movie);
            System.out.println("Фильм '" + getElementText(movie, "title") + "' удалён.");
        }
    }

    // Преобразуем NodeList в Stream<Element>
    private static List<Element> getMoviesAsStream() {
        NodeList nodeList = doc.getElementsByTagName("movie");
        List<Element> list = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                list.add((Element) node);
            }
        }
        return list;
    }

    // Вывод результатов поиска
    private static void printResults(List<Element> results, String criteria) {
        System.out.printf("\n=== Результаты поиска %s ===\n", criteria);
        if (results.isEmpty()) {
            System.out.println("Фильмы не найдены.");
        } else {
            for (Element el : results) {
                System.out.printf("Название: %s%n", getElementText(el, "title"));
                System.out.printf("Автор: %s%n", getElementText(el, "author"));
                System.out.printf("Год: %s%n", getElementText(el, "year"));
                System.out.println("-".repeat(30));
            }
        }
    }

    // Сохранение документа в файл
    private static void saveToFile() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
        System.out.println("Данные сохранены в файл: " + FILE_PATH);
    }
}