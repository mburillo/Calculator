package factory;

import command.Command;
import commands.DivisionCommand;

public class DivisionBuilder implements CommandFactory{

	@Override
	public Command create(String[] arg) {
		return new DivisionCommand(arg);
	}
}
