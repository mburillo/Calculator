package factory;

import command.Command;
import commands.SetCommand;

public class SetBuilder implements CommandFactory{

	@Override
	public Command create(String[] arg){
		return new SetCommand(arg);
	}
}
