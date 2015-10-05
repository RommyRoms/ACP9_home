package week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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
        new Finder(string).chooseMethodToFind();
    }
    public void LScommand(){
        new LSMaker(string).showPosition();
    }
}
