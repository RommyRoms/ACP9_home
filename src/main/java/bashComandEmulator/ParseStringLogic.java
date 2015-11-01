package bashComandEmulator;

/**
 * Реализация Receiver (получатель) – располагает информацией о способах выполнения операций
 * Для себя: тут пишем реализации всех команд(если че, потом вынести все в свои классы),
 *           после чего в классах, реализующих Command, в методе execute() делаем инстанс этого класса
 *           и выполняем нужный нам метод ресивера;
 */
public class ParseStringLogic {
    private String string;

    public ParseStringLogic(String string) {
        this.string = string;
    }

    public void findCommand(){
        new Finder(string).choose();
    }

    public void lsCommand(){
        new LSMaker(string).choose();
    }

    public void cdCommand(){
        new CDMaker(string).choose();
    }

    public void contentCommand(){
        new ContentMaker(string).choose();
    }

    public void mkdirCommand(){
        new MKDIRMaker(string).choose();
    }
}
