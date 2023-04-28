package commands;

import java.math.BigDecimal;
import command.UndoableCommand;
import requester.Calculator;

public class SumCommand implements UndoableCommand {
	private BigDecimal numberToAdd;
	public SumCommand(String[] numberToAdd) {
		if(numberToAdd.length==1) {
			try {
				this.numberToAdd = new BigDecimal(numberToAdd[0]);
			} catch(NumberFormatException e) {
				this.numberToAdd=null;
			}	
		}	
    }
	@Override
	public void execute(Calculator calc) {
		calc.sum(numberToAdd);
	}

	@Override
	public void undo(Calculator calc) {
		calc.subtract(numberToAdd);
	}
}
