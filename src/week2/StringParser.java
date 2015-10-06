package week2;


public abstract class StringParser {
    private String command;
    private String[] commandSignature;
    public static final String ALERT = ">> WRONG COMMAND";
    public static String location = "D:/";
    public static final String ROOT_DIRECTORY = "/";

    public StringParser(String command) {
        this.command = command;
        commandSignature = command.split(" ");
    }

    public int size(){
        int size = 0;
        for (int i = 0; i <commandSignature.length ; i++) {
            if (commandSignature[i]!=null){
                size++;
            }
        }
        return size;
    }
    public String[] getCommandSignature(){
        return commandSignature;
    }

    public String getFromSignature(int index){
        String rez = "";
        for (int i = 0; i <commandSignature.length ; i++) {
            if (i == index){
                rez += commandSignature[i];
            }
        }
        return rez;
    }

    public abstract void choose();
    public abstract String help();
}
