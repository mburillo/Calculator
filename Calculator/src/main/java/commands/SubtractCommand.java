package commands;

import java.math.BigDecimal;

import command.UndoableCommand;
import requester.Calculator;

public class SubtractCommand implements UndoableCommand{
	private BigDecimal numberToSubtract;
	public SubtractCommand(String[] numberToSubtract) {
		if(numberToSubtract.length==1) {
			try {
				this.numberToSubtract = new BigDecimal(numberToSubtract[0]);
			} catch(Exception e) {
				this.numberToSubtract=null;
			}	
		}
    }
	@Override
	public void execute(Calculator calc) {
		calc.subtract(numberToSubtract);
	}

	@Override
	public void undo(Calculator calc) {
		calc.sum(numberToSubtract);
	}

}
