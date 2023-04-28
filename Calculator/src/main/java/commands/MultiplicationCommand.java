package commands;

import java.math.BigDecimal;

import command.UndoableCommand;
import requester.Calculator;

public class MultiplicationCommand implements UndoableCommand {

	private BigDecimal numberToMultiply;
	private BigDecimal re= null;
	
	public MultiplicationCommand(String[] numberToMultiply) {
		if(numberToMultiply.length==1) {
			try {
				this.numberToMultiply = new BigDecimal(numberToMultiply[0]);
			} catch(Exception e) {
				this.numberToMultiply=null;
			}		
		}		
    }
    
	@Override
	public void execute(Calculator calc) {
		re =calc.multiply(numberToMultiply);
	}

	@Override
	public void undo(Calculator calc) {
		if(re.compareTo(numberToMultiply)!=0)
			calc.divide(numberToMultiply);
		else
			calc.set(re);
	}

}
