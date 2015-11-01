package bashComandEmulator.commands;

import bashComandEmulator.ParseStringLogic;

/**
 * Created by ro on 06.10.2015.
 */
public class ContentCommand implements Command {
    ParseStringLogic logic;

    public ContentCommand(ParseStringLogic logic) {
        this.logic = logic;
    }

    @Override
    public void execute() {
        logic.contentCommand();
    }
}
