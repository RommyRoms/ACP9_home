package bashComandEmulator;


import java.io.File;


/**
 * реализация логики команды ls;
 */
public class LSMaker extends StringParser{



    public LSMaker(String command) {
        super(command);
    }

    @Override
    public void choose(){
        if (size()==2){
            if (getFromSignature(1).equals("help")){
                System.out.println(help());
            }else if (getFromSignature(1).equals("dir")) {
                System.out.println(showDirs());
            }else if (getFromSignature(1).equals("f")){
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
        File file = new File(location);
        File[] list = file.listFiles();
        if (list!=null){
            for (File f : list) {
                if (f!=null){
                    if (f.isDirectory()) {
                        builder.append(f.getName() + "/    \n");
                    }else{
                        builder.append(f.getName()+ "    \n");
                    }
                }
            }
        }
        return builder.toString();
    }
//show directories realization
    private String showDirs(){
        StringBuilder builder = new StringBuilder();
        File file = new File(location);
        File[] list = file.listFiles();
        for (File f : list) {
            if (f.isDirectory()) {
                builder.append(f.getName() + "/  \n");
            }
        }
        return builder.toString();
    }
//show files realization
    private String showFiles(){
        StringBuilder builder = new StringBuilder();
        File file = new File(location);
        File[] list = file.listFiles();
        for (File f : list) {
            if (!f.isDirectory()) {
                builder.append(f.getName() + " \n");
            }
        }
        return builder.toString();
    }

    //help realization
    @Override
    public String help(){
        String result = " command type: ls \n " +
                "performs 3 kinds of signature: \n " +
                "ls  \n " +
                "ls [dir]  \n " +
                "ls [f] \n ";
        return result;
    }
}
