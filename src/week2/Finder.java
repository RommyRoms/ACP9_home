package week2;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Finder {
    private String command;
    private String path1 = "C:/";
    private String path2 = "D:/";
    private String fileOrDirectoryName;
    private String[] commandSignature;

    public Finder(String command) {
        this.command = command;
        commandSignature = command.split(" ");
    }
    private String makeArgumentForSearching(){
        return commandSignature[1];
    }

    private int size(){
        int size = 0;
        for (int i = 0; i <commandSignature.length ; i++) {
            if (commandSignature[i]!=null){
                size++;
            }
        }
        return size;
    }
    public void chooseMethodToFind(){
        if (size()==2){
            if (commandSignature[1].equals("help")){
                System.out.println(help());
            }else{
                find();
            }
        }else if (size()==3){
            findWithUserRoot();
        }

    }


    private void find() {
        fileOrDirectoryName = makeArgumentForSearching();
        File file1 = new File(path1);
        File file2 = new File(path2);
        System.out.println(">> start searching ...");
        search(file1);
        search(file2);
        System.out.println(">> end searching");

    }

    private void search(File file) {
        if (file.isDirectory()) {
            if (file.listFiles() != null) {
                for (File temp : file.listFiles()) {
                    if (temp.isDirectory()) {
                        if (temp.getName().toLowerCase().equals(fileOrDirectoryName.toLowerCase())){
                            System.out.println(temp.getAbsolutePath());
                        }
                        search(temp);
                    } else {
                        if (temp.getName().toLowerCase().equals(fileOrDirectoryName.toLowerCase())){
                            System.out.println(temp.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

    private void findWithUserRoot(){
        File file = new File(commandSignature[2]);
        System.out.println(">> start searching in "+ commandSignature[2]+ " ...");
        search(file);
        System.out.println(">> end searching");
    }

    private String help(){
        String result = " command type: find \n " +
                "performs 3 kinds of signature: \n " +
                "find <fileName> \n " +
                "find <help> \n " +
                "find <fileName> [directory]";
        return result;
    }
}
