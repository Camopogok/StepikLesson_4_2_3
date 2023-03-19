import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://www.krylatskoye.ru/content/ratings/2021/09/0928.html").get();
        Element table = doc.select("table").first();
        Elements rows = table.select("tr");
        String [] city = new String[rows.size()-2];
        for (int i = 2; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements cols = row.select("td");
            city[i-2] = cols.get(1).text();
        }
        Arrays.sort(city);
        for (int i = 0; i < city.length; i++) {
            System.out.println(city[i]);
        }
    }
}
