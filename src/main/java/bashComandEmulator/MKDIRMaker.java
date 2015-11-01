package bashComandEmulator;


import java.io.File;

public class MKDIRMaker extends StringParser{

    public MKDIRMaker(String command) {
        super(command);
    }

    @Override
    public void choose() {
        if (size()==2){
            if (!getFromSignature(1).contains("/")) {
                if (getFromSignature(1).equals("help")){
                    System.out.println(help());
                }else mkdir(location+"\\"+getFromSignature(1));
            }else mkdir(getFromSignature(1));
        }else System.out.println(ALERT);
    }

    private void mkdir(String path){
        File file = new File(path);
        if (!file.exists()){
            file.mkdir();
            System.out.println(">> directory is created");
        }else System.out.println(">> directory is exists");
    }

    @Override
    public String help() {
        String result = " command type: mkdir \n " +
                "performs signature: \n " +
                "mkdir <dirName> | mkdir <dirAbsolutePath>  \n " +
                "Example: mkdir MyDirectory --in this folder \n" +
                "         mkdir D:/Movies/MyDirectory";
        return result;
    }
}
