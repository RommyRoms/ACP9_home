package bashComandEmulator.commands;

import bashComandEmulator.ParseStringLogic;

public class CDCommand implements Command {
    ParseStringLogic logic;

    public CDCommand(ParseStringLogic logic) {
        this.logic = logic;
    }

    @Override
    public void execute() {
        logic.cdCommand();
    }
}
