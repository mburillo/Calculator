package factory;


import command.Command;
import commands.SumCommand;

public class SumBuilder implements CommandFactory{

	@Override
	public Command create(String[] arg) {
		return new SumCommand(arg);
	}

}
