package commands;

import command.Command;
import requester.Calculator;

public class UndoCommand implements Command {

	@Override
	public void execute(Calculator calc) {
		calc.undo();
	}
}
