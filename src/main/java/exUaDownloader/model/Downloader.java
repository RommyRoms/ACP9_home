package exUaDownloader.model;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public interface Downloader {

    void download(String path,Map<String,String> map) throws IOException;
    Map<String,String > parse(String url,List<String> formats, Map<String ,String > map) throws IOException;
}
