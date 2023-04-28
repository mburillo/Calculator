package command;

import requester.Calculator;

public interface UndoableCommand extends Command {
	void undo(Calculator calc);
}
