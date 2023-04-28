package factory;

import command.Command;
import commands.UndoCommand;

public class UndoBuilder implements CommandFactory{

	@Override
	public Command create(String[] arg) {
		return new UndoCommand();
	}
}
