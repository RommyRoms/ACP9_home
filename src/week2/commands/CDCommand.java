package week2.commands;

import week2.ParseStringLogic;

public class CDCommand implements Command {
    ParseStringLogic logic;

    public CDCommand(ParseStringLogic logic) {
        this.logic = logic;
    }

    @Override
    public void execute() {
        logic.CDCommand();
    }
}
