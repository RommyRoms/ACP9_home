package week2.commands;

import week2.ParseStringLogic;


public class MKDIRCommand implements Command{
    ParseStringLogic logic;

    public MKDIRCommand(ParseStringLogic logic) {
        this.logic = logic;
    }

    @Override
    public void execute() {
        logic.mkdirCommand();
    }
}
