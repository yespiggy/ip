package lilybot;

import java.io.IOException;


public class LilyBot {

    private Storage storage;
    private TaskList ls;
    private Ui ui;


    /**
     * Constructor for Duke
     *
     * @param filePath For file duke.txt.
     * @throws IOException For input error.
     */
    public LilyBot(String filePath) throws IOException{
        ui = new Ui();
        storage = new Storage(filePath);
        ls = new TaskList(storage.loadFile());
    }


    /**
     * Initialize LilyBot
     *
     * @throws IOException For input error.
     */
    public String getResponse(String command, String lastCommand) throws IOException{
        ui.sayHi();


        while (!command.equals("bye")) {
            if (command.equals("list")) {
                return ui.listTask(ls);
            } else if (command.equals("undo")) {
                if (lastCommand.equals(null)) {
                    return ui.noLasCommand();
                } else {
                    return ui.undoTask(lastCommand, ls);
                }
            } else if (command.startsWith("unmark")) {
                try {
                    return ui.markNotDone(command, ls);
                } catch (Exception exc) {
                    return ui.invalidInputNumber();
                }

            } else if (command.startsWith("mark")) {
                try {
                    return ui.markDone(command, ls);
                } catch (Exception exc) {
                    return ui.invalidInputNumber();
                }

            } else if (command.startsWith("delete")) {
                try {
                    return ui.taskRemoved(command, ls);
                } catch (Exception exc) {
                    return ui.invalidInputNumber();
                }
            } else if (command.startsWith("find")) {
                try {
                    String keyWord = (Parser.parseCommand(command))[1];
                    return ui.findMatchingTask(keyWord, ls);

                } catch (Exception exc) {
                    return ui.invalidKeyWord();

                }
            } else {

                return ui.addTask(command, ls);
            }
        }

        if (command.equals("bye")) {
            //Update the file
            Storage.saveFile(storage.getFile(), ls);

            return ui.sayBye();
        }
        return "";
    }







}
