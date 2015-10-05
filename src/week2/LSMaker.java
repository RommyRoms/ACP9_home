package week2;


import java.io.File;
//реализация логики команды ls;
public class LSMaker {
    private String command;
    public static final String LOCATION = "D:/";

    public LSMaker(String command) {
        this.command = command;

    }


    public String showPosition(){
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
        System.out.println(builder);
        return builder.toString();
    }
}
