package week2;


import java.io.File;


/**
 * реализация логики команды ls;
 * TODO: !!!!!!!!!!!!Вынести работу со строками в абстарктный класс и унаследовать все обработчики команд от него
 * TODO:   чтобы забрать и не повторять распарсивание строки каджый раз снова!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
public class LSMaker {
    private String command;
    private String[] commandSignature;
    private final String ALERT = "WRONG COMMAND";
    public static final String LOCATION = "D:/";

    public LSMaker(String command) {
        this.command = command;
        commandSignature = command.split(" ");

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
    public void choose(){
        if (size()==2){
            if (commandSignature[1].equals("help")){
                System.out.println(help());
            }else if (commandSignature[1].equals("dir")) {
                System.out.println(showDirs());
            }else if (commandSignature[1].equals("f")){
                System.out.println(showFiles());
            }else{
                System.out.println(ALERT);
            }
        }else if (size()==1){
            System.out.println(showPosition());
        }else {
            System.out.println(ALERT);
        }
    }

    //show files in directory with command ls;
    private String showPosition(){
        StringBuilder builder = new StringBuilder();
        File file = new File(LOCATION);
        File[] list = file.listFiles();
        for (File f : list) {
            if (f.isDirectory()) {
                builder.append(f.getName() + "/    ");
            }else{
                builder.append(f.getName()+ "    ");
            }
        }
        return builder.toString();
    }
//show directories realization
    private String showDirs(){
        StringBuilder builder = new StringBuilder();
        File file = new File(LOCATION);
        File[] list = file.listFiles();
        for (File f : list) {
            if (f.isDirectory()) {
                builder.append(f.getName() + "/    ");
            }
        }
        return builder.toString();
    }
//show files realization
    private String showFiles(){
        StringBuilder builder = new StringBuilder();
        File file = new File(LOCATION);
        File[] list = file.listFiles();
        for (File f : list) {
            if (!f.isDirectory()) {
                builder.append(f.getName() + "    ");
            }
        }
        return builder.toString();
    }

    //help realization
    private String help(){
        String result = " command type: ls \n " +
                "performs 3 kinds of signature: \n " +
                "ls  \n " +
                "ls [dir]  \n " +
                "ls [f] \n ";
        return result;
    }
}
