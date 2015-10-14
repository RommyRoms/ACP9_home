package week3.exUaDownloader.model;


import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class AudioDownloader extends AbstractDownloader {

    @Override
    public void download(String path,Map<String, String> map) throws IOException {
        downLoadHelper(path,map);

    }


}
