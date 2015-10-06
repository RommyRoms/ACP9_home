package week2;


import java.io.File;

public class CDMaker extends StringParser {

    public CDMaker(String command) {
        super(command);
    }




    @Override
    public void choose() {
        int size = size();
        if (size==2){
            if (getFromSignature(1).equals("..")){
                cdBack();
            }else{
                cdUp();
            }
        }else if (size==1){
            location = ROOT_DIRECTORY;
        }
        else{
            System.out.println(ALERT);
        }
    }


    private void cdUp(){
        File file = new File(getFromSignature(1));
        if (file.exists()){
            location = file.getAbsolutePath();
        }else{
            System.out.println("Неверный путь");
        }
    }

    private void cdBack(){
        File file = new File(location);
        int size = 0;
        String[] path = file.getAbsolutePath().split("/");
        for (int i = 0; i <path.length ; i++) {
            size++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <path.length-1 ; i++) {
            builder.append(path[i]+ "/");
        }
        location = builder.toString().substring(builder.length()-1);

    }


    @Override
    public String help() {
        String result = " command type:cd \n " +
                "performs 3 kinds of signature: \n " +
                "cd       --go to the root catalog \"C:/\"\n " +
                "cd [dir] --go to the some dir  \n " +
                "cd [..]  --go back at one stage \n ";
        return result;
    }
}
