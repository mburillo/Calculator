package invoker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import command.Command;
import factory.CommandFactory;
import factory.DivisionBuilder;
import factory.MultiplicationBuilder;
import factory.SetBuilder;
import factory.SubtractBuilder;
import factory.SumBuilder;
import factory.UndoBuilder;

public class CalculatorInvoker {

	@SuppressWarnings("serial")
	private static final Map<String, CommandFactory> commandFactory = new HashMap<String, CommandFactory>() {
		{
		put("sum", new SumBuilder());
		put("subtract", new SubtractBuilder());
		put("multiply", new MultiplicationBuilder());
		put("division", new DivisionBuilder());
		put("set", new SetBuilder());
		put("undo", new UndoBuilder());
		}
	};
	public static Command processCommand(String command) {
		if(command.isBlank() || command.isEmpty()) return null;
		String[] parts = command.split(" ");
		if(commandFactory.get(parts[0])!=null) return commandFactory.get(parts[0]).create(Arrays.copyOfRange(parts, 1, parts.length));
		if(commandFactory.get(parts[parts.length-1])!=null) return commandFactory.get(parts[parts.length-1]).create(Arrays.copyOfRange(parts, 0, parts.length-1));	  	
		return null;
	}
	
}
