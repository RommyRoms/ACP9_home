package week2;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentMaker extends StringParser {
    private Map<String,String > formatMap;
    private String nullIndicator = "empty";
    private List<String> listOfMusic;
    private List<String> listOfVideo;
    private List<String> listOfDoc;
    private String empty_alert = ">> empty folder";

    int musicCounter = 0;
    int videoCounter = 0;
    int docCounter = 0;
    int otherCounter = 0;

    public ContentMaker(String command) {
        super(command);
        formatMap = new HashMap<>();
        makeLists();
    }


    private void makeLists(){
        listOfMusic = new ArrayList<>();
        listOfMusic.add("mp3");
        listOfMusic.add("wav");
        listOfMusic.add("flac");

        listOfVideo = new ArrayList<>();
        listOfVideo.add("mkv");
        listOfVideo.add("mp4");
        listOfVideo.add("avi");
        listOfVideo.add("swf");
        listOfVideo.add("mpg");
        listOfVideo.add("mov");
        listOfVideo.add("flv");

        listOfDoc= new ArrayList<>();
        listOfDoc.add("doc");
        listOfDoc.add("txt");
        listOfDoc.add("docx");
    }
    @Override
    public void choose() {
        if (size()==1){
            System.out.println(content());
        }else {
            System.out.println(ALERT);
        }
    }

    private String content(){
        makeMap();
        count();
        int allRezult = videoCounter+musicCounter+docCounter+otherCounter;
        StringBuilder builder = new StringBuilder();
        int cof = allRezult/100;
        int other = allRezult-(cof*videoCounter+cof*musicCounter+cof*docCounter);
        builder.append("video    - " + cof*videoCounter+ "%\n");
        builder.append("audio    - " + cof*musicCounter + "%\n");
        builder.append("document - "+ cof*docCounter +"%\n");
        builder.append("other    - "+ other +"%");

        return builder.toString();
    }

    private void count(){
        if (!formatMap.isEmpty()) {
            for (Map.Entry<String, String> entry : formatMap.entrySet()) {
                String value = entry.getValue();
                if (listOfMusic.contains(value)) {
                    musicCounter++;
                } else if (listOfVideo.contains(value)) {
                    videoCounter++;
                } else if (listOfDoc.contains(value)) {
                    docCounter++;
                } else otherCounter++;
            }
        }else System.out.println(empty_alert);
    }
    private void makeMap(){
        File file = new File(location);
        File[] files = file.listFiles();
        if (files!=null) {
            for (File f: files) {
                if (!f.isDirectory()){
                    String s1 =f.getName();
                    String[] str = s1.split("\\.");

                    if (str[0]!=null &&str[1] != null) {
                        formatMap.put(str[0], str[1]);
                    } else {
                        formatMap.put(str[0], nullIndicator);
                    }
                }
            }
        }else System.out.println("");
    }
    @Override
    public String help() {
        String result = " command type: ls \n " +
                "performs 1 kind of signature: \n " +
                "content --shows content in the folder  \n +" +
                "example:   video - 70%\n" +
                "           audio - 10%\n" +
                "           document - 5%\n" +
                "           other - 15%";
        return result;
        }

}
