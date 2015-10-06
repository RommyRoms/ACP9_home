package week2;

import week2.commands.Command;

/**
 * Класс, связывающий клиента и непосредственно команду объектом, а не прямой связью;
 * То есть в команде через execute() прописываем то, что будет делать некий класс, где вся логика,
 * далее передаем все нужные команды инвокеру, который вызывает execute() у каждой, а реализацию методов задаю в
 * psvm main(). Выходит что я не напрямую юзаю метод, а через некий класс посредник, что развязывает руки
 * при расширении программы.
 * Action/Command/Transaction pattern realization
 */
public class CommandInvoker {
    Command findCommand;
    Command lsCommand;
    Command cdCommand;
    Command contentCommand;

    public CommandInvoker(Command findCommand, Command lsCommand, Command cdCommand, Command contentCommand) {
        this.findCommand = findCommand;
        this.lsCommand = lsCommand;
        this.cdCommand = cdCommand;
        this.contentCommand = contentCommand;
    }

    public void findByInvoker(){
        findCommand.execute();
    }

    public void LSByInvoker(){
        lsCommand.execute();
    }

    public void CDByInvoker(){
        cdCommand.execute();
    }

    public void contentByInvoker(){
        contentCommand.execute();
    }
}
