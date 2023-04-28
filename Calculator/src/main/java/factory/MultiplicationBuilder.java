package factory;

import command.Command;
import commands.MultiplicationCommand;

public class MultiplicationBuilder implements CommandFactory{

	@Override
	public Command create(String[] arg) {
		return new MultiplicationCommand(arg);
	}

}
