package week2;


import java.util.NoSuchElementException;

public class Menu {
    public static final String allCommands = "find, ls,";
    private ParseStringLogic logic;
    private CommandInvoker invoker;
    String command;
    String[] splitedString;


    public Menu() {
        printFAQ();
        run();
    }


    public void run(){
        System.out.println("--------------------");
        command = new String(ScannerTools.keyboardString(">> Введите комманду"));
        logic = new ParseStringLogic(command);
        invoker = new CommandInvoker(new FindCommand(logic), new LSCommand(logic));
        chooser();
        run();
    }

    private String parse(String string){
            if (string != null){
                splitedString = string.split(" ");
                return splitedString[0];
            }
            else throw new NoSuchElementException("Пустая строка");
        }
    private void printFAQ(){
        System.out.println("+-----------------------------------------------------+");
        System.out.println("|command +help to see possible variations of commands |");
        System.out.println("|example : >>ls help    >>find help   etc..           |");
        System.out.printf("|aviable commands: %s                          |\n", allCommands);
        System.out.println("+-----------------------------------------------------+");
    }
    private void chooser(){
        String parseCommand = parse(command);
        if (parseCommand.equals("find")){
            invoker.findByInvoker();
        }else if(parseCommand.equals("ls")){
            invoker.LSByInvoker();

        }else{
            System.out.println(">> No such command");
            run();
        }
    }
}
