package lr10.ex1;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class ex1json {
    public static void main(String[] args) {
        JSONObject library = new JSONObject();
        JSONArray books = new JSONArray();

        JSONObject book1 = new JSONObject();
        book1.put("title","War and Peace");
        book1.put("author","Лев Толстой");
        book1.put("year",1869);

        JSONObject book2 = new JSONObject();
        book2.put("title","Master & Margarita");
        book2.put("author","Михаил Булгаков");
        book2.put("year",1967);

        books.add(book1);
        books.add(book2);

        library.put("books", books);

        try(FileWriter file = new FileWriter("src/main/java/lr10/ex1/ex1json-json.json")) {
            file.write(library.toJSONString());
            System.out.println("JSON file is created");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
