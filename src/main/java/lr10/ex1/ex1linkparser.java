package lr10.ex1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ex1linkparser {
    public static void main(String[] args) {
        String uri = "https://itlearn.ru/first-steps";
        try{
            Document doc  = Jsoup.connect(uri).get();
            Elements links = doc.select("a[href]");
            for (Element link: links){
                System.out.println(link.attr("abs:href"));

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
