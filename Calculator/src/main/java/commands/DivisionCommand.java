package commands;

import java.math.BigDecimal;

import command.UndoableCommand;
import requester.Calculator;

public class DivisionCommand implements UndoableCommand{

	private BigDecimal numberToDivide;
	public DivisionCommand(String[] numberToDivide) {
		if(numberToDivide.length==1) {
			try {
				this.numberToDivide = new BigDecimal(numberToDivide[0]);
			} catch(Exception e) {
				this.numberToDivide=null;
			}		
		}
    }
	
	@Override
	public void execute(Calculator calc) {
		calc.divide(numberToDivide);
	}

	@Override
	public void undo(Calculator calc) {
		calc.multiply(numberToDivide);
	}
}
