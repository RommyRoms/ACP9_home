package exUaParser;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.net.URL;
import java.util.*;


public class ParserByJsoup {
    public static final String DIRECTORY = "D:/def/";
    public static String url = "http://www.ex.ua/94704559?r=3,23776";
    public static Map<String,String> map = new TreeMap<>();

    public static void main(String[] args) {

        try {
            Document document = Jsoup.connect(url).get();
            Elements links = document.select("a[href*=/get]");

            for (Element link : links) {
                String href = link.attr("href");
                String title = link.text();
                if (title.contains(".mp3")) {
                    map.put(href,title);
                }
            }

            for (Map.Entry<String ,String > entry: map.entrySet()){
                byte[] arr = IOUtils.getByteArr(new URL("http://www.ex.ua"+entry.getKey()).openStream());
                IOUtils.writeBytes(arr,DIRECTORY+entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
