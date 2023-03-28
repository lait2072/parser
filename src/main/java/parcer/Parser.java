package parcer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {
    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 44; i++){
            Document doc = Jsoup.connect("https://www.vidal.ru/drugs/molecules?p=" + i).get();
            Elements elements = doc.getElementsByClass("products-table").select("tr").select("td").select("a");
            int count = 0;
            for (var element: elements) {
                if (count != 2) {
                    ++count;
                    System.out.print(element.text() + '\t' + '\t');
                } else {
                    count = 0;
                    System.out.println();
                }
            }
        }
    }
}
