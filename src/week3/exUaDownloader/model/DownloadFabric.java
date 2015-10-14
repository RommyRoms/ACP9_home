package week3.exUaDownloader.model;

import java.util.Map;

public class DownloadFabric {
    private static AbstractDownloader result = null;


    public static AbstractDownloader getDownloader(String format){
        Downloads.ALL_FORMATS.entrySet().stream().filter(entry -> entry.getKey().equals(format)).forEach(entry -> {
            result = entry.getValue();
        });
        return result;
    }
}
