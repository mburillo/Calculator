package factory;

import command.Command;
import commands.SubtractCommand;

public class SubtractBuilder implements CommandFactory{

	@Override
	public Command create(String[] arg) {
		return new SubtractCommand(arg);
	}
}
