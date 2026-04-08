package lr10.ex1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ex1NewsParser {
    private static final String URL = "http://fat.urfu.ru/index.html";
    private static final String FILE_PATH = "src/main/java/lr10/ex1/news_output.txt";
    private static final int MAX_RETRIES = 3;

    public static void main(String[] args) {
        Document doc = null;
        int attempts = 0;

        // Попытка подключения с повторами
        while (attempts < MAX_RETRIES) {
            try {
                doc = Jsoup.connect(URL).timeout(10 * 1000).get();
                System.out.println("Страница успешно загружена.");
                break;
            } catch (IOException e) {
                attempts++;
                System.err.println("Ошибка при подключении к сайту: " + e.getMessage());
                if (attempts < MAX_RETRIES) {
                    System.out.println("Попытка переподключения... (" + attempts + "/" + MAX_RETRIES + ")");
                    try {
                        Thread.sleep(2000); // задержка перед повтором
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        System.err.println("Поток был прерван.");
                        return;
                    }
                } else {
                    System.err.println("Не удалось подключиться после " + MAX_RETRIES + " попыток.");
                    return;
                }
            }
        }

        if (doc == null) {
            System.err.println("Документ не был загружен.");
            return;
        }

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            Elements newsParent = doc.select("table[width=\"80%\"] > tbody");

            if (newsParent.isEmpty()) {
                System.err.println("Не удалось найти блок с новостями.");
                return;
            }

            List<org.jsoup.nodes.Node> nodes = newsParent.get(0).childNodes();
            boolean foundAny = false;

            for (int i = 0; i < nodes.size(); i++) {
                if (i % 2 != 0 && i >= 3) { // нечётные индексы, начиная с 3
                    Element node = (Element) nodes.get(i);

                    Elements titleElements = node.getElementsByClass("blocktitle");
                    Elements dateElements = node.getElementsByClass("blockdate");

                    if (!titleElements.isEmpty() && !dateElements.isEmpty()) {
                        String theme = titleElements.get(0).text();
                        String date = dateElements.get(0).text();

                        System.out.println("Theme: " + theme);
                        System.out.println("Date: " + date + "\n");

                        // Запись в файл
                        writer.write("Theme: " + theme + "\n");
                        writer.write("Date: " + date + "\n");
                        writer.write("-".repeat(40) + "\n");

                        foundAny = true;
                    }
                }
            }

            if (!foundAny) {
                System.out.println("Новости не найдены.");
                writer.write("Новости не найдены.\n");
            } else {
                System.out.println("Данные успешно сохранены в файл: " + FILE_PATH);
            }

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}