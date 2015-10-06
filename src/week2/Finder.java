package week2;


import java.io.File;

//реализация логики команды find
public class Finder extends StringParser{
    private String path1 = "C:/";
    private String path2 = "D:/";
    private String fileOrDirectoryName;

    public Finder(String command) {
        super(command);
    }

    private String makeArgumentForSearching(){
        return getFromSignature(1);
    }


    //choose method to operate with command;
    @Override
    public void choose(){
        if (size()==2){
            if (getFromSignature(1).equals("help")) {
                System.out.println(help());
            }else{
                find();
            }
        }else if (size()==3){
            findWithUserRoot();
        }else{
            System.out.println(ALERT);
        }

    }

//find <fileName> realization
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

//find <fileName> [directory] realization
    private void findWithUserRoot(){
        fileOrDirectoryName = makeArgumentForSearching();
        File file = new File(getFromSignature(2));
        System.out.println(">> start searching in "+ getFromSignature(2)+ " ...");
        search(file);
        System.out.println(">> end searching");
    }

//help realization
    @Override
    public String help(){
        String result = " command type: find \n " +
                "performs 3 kinds of signature: \n " +
                "find <fileName> \n " +
                "find <help> \n " +
                "find <fileName> [directory]";
        return result;
    }
}
