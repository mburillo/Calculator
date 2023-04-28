package commands;

import java.math.BigDecimal;

import command.UndoableCommand;
import requester.Calculator;

public class SetCommand implements UndoableCommand{
	private BigDecimal numberToSet;
	public SetCommand(String[] numberToSet) {
		if(numberToSet.length==1) {
			try {
				this.numberToSet = new BigDecimal(numberToSet[0]);
			} catch(Exception e) {
				this.numberToSet=null;
			}		
		}
    }
	@Override
	public void execute(Calculator calc) {
		numberToSet = calc.set(numberToSet);
	}

	@Override
	public void undo(Calculator calc) {
		calc.set(numberToSet);
	}
}
