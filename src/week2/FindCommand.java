package week2;

/**
 * Класс, который отвечает за отработку и функционал комманды find,
 * которая в свою очередь должна показывать абсолютный путь к найденому файлу,
 */
public class FindCommand implements Command{
    private ParseStringLogic parseStringLogic;

    public FindCommand(ParseStringLogic parseStringLogic) {
        this.parseStringLogic = parseStringLogic;
    }

    @Override
    public void execute() {
        parseStringLogic.findCommand();
    }
}
