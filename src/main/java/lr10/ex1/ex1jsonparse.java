package lr10.ex1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ex1jsonparse {
    private static JSONObject jsonObject;
    private static JSONArray movieArray;
    private static final String FILE_PATH = "src/main/java/lr10/ex1/example.json";

    public static void main(String[] args) {
        try {
            // Загружаем JSON из файла
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader(FILE_PATH);
            jsonObject = (JSONObject) parser.parse(reader);
            movieArray = (JSONArray) jsonObject.get("movie");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Меню ===");
            System.out.println("1. Вывести все фильмы");
            System.out.println("2. Добавить фильм");
            System.out.println("3. Найти фильмы по автору");
            System.out.println("4. Удалить фильм по названию");
            System.out.println("5. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1 -> printAllMovies();
                case 2 -> addMovie(scanner);
                case 3 -> searchByAuthor(scanner);
                case 4 -> deleteMovie(scanner);
                case 5 -> {
                    saveToFile();
                    System.out.println("Изменения сохранены. Выход.");
                    return;
                }
                default -> System.out.println("Неверный выбор.");
            }
        }
    }

    // Вывод всех фильмов
    private static void printAllMovies() {
        System.out.println("\n=== Все фильмы ===");
        movieArray.forEach(movie -> {
            JSONObject movieObj = (JSONObject) movie;
            System.out.printf("Название: %s%n", movieObj.get("title"));
            System.out.printf("Автор: %s%n", movieObj.get("author"));
            System.out.printf("Год: %d%n", movieObj.get("year"));
            System.out.println("-".repeat(30));
        });
    }

    // Добавление нового фильма
    private static void addMovie(Scanner scanner) {
        System.out.print("Введите название фильма: ");
        String title = scanner.nextLine();
        System.out.print("Введите автора (режиссёра): ");
        String author = scanner.nextLine();
        System.out.print("Введите год выпуска: ");
        int year = Integer.parseInt(scanner.nextLine());

        JSONObject newMovie = new JSONObject();
        newMovie.put("title", title);
        newMovie.put("author", author);
        newMovie.put("year", year);

        movieArray.add(newMovie);
        System.out.println("Фильм добавлен (сохранится при выходе).");
    }

    // Поиск фильмов по автору
   private static void searchByAuthor(Scanner scanner) {
    System.out.print("Введите автора для поиска: ");
    String author = scanner.nextLine().trim().toLowerCase();

    System.out.printf("\n=== Результаты поиска по автору '%s' ===\n", author);

    // Временный список для хранения найденных фильмов
    boolean found = false;

    for (Object obj : movieArray) {
        if (obj instanceof JSONObject) {
            JSONObject movie = (JSONObject) obj;
            Object authorObj = movie.get("author");

            if (authorObj != null && author.equals(authorObj.toString().trim().toLowerCase())) {
                Object titleObj = movie.get("title");
                Object yearObj = movie.get("year");

                System.out.printf("Название: %s%n", titleObj != null ? titleObj.toString() : "не указано");
                System.out.printf("Автор: %s%n", authorObj.toString());
                System.out.printf("Год: %s%n", yearObj != null ? yearObj.toString() : "не указан");
                System.out.println("-".repeat(30));

                found = true;
            }
        }
    }

    if (!found) {
        System.out.println("Фильмы не найдены.");
    }
}

    // Удаление фильма по названию
    private static void deleteMovie(Scanner scanner) {
        System.out.print("Введите название фильма для удаления: ");
        String title = scanner.nextLine().trim().toLowerCase();

        boolean removed = movieArray.removeIf(movie -> {
            JSONObject movieObj = (JSONObject) movie;
            return title.equals(movieObj.get("title").toString().toLowerCase());
        });

        if (removed) {
            System.out.println("Фильм с названием '" + title + "' удалён.");
        } else {
            System.out.println("Фильм не найден.");
        }
    }

    // Сохранение в файл
    private static void saveToFile() {
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(jsonObject.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}