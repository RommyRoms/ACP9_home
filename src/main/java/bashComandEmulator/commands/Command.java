package bashComandEmulator.commands;

/**
 * Интерфейс, который по принципам SOLID удет задавать общее поведение
 * для всех входящих комманд, которые будут реализовывать его через свои классы;
 */
public interface Command {
    void execute();
}
