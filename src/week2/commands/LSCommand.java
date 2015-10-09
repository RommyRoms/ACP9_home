package week2.commands;

import week2.ParseStringLogic;

/**
 * Класс, который отвечает за отработку и функционал комманды ls,
 * которая в свою очередь должна показывать все папки и файлы,
 * что есть в текущей директории;
 */
public class LSCommand implements Command {
    ParseStringLogic logic;


    public LSCommand(ParseStringLogic logic) {
        this.logic = logic;
    }

    @Override
    public void execute() {
        logic.lsCommand();
    }
}
