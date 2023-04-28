package requester;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Deque;

import command.Command;
import command.UndoableCommand;
import invoker.CalculatorInvoker;

public class Calculator {
	private Deque<UndoableCommand> previousOpperations;
	private BigDecimal accumulatedValue;	
	private static Calculator instance;
	private Calculator()  {
			accumulatedValue=BigDecimal.ZERO;
			previousOpperations = new ArrayDeque<>();
	}
	public static Calculator get() {		
		if(instance == null) instance = new Calculator();		
		return instance;
	}
	public static void turnOff() {		
		if(instance != null) instance = null;		
	}
	public BigDecimal getValue() {	
		return new BigDecimal(accumulatedValue.toString());
	}	
	public void sum(BigDecimal numberToAdd) {
		accumulatedValue=accumulatedValue.add(numberToAdd);
	}
	public void undo() {
		if(!previousOpperations.isEmpty()) previousOpperations.removeLast().undo(this);
	}
	public void operate(String line) {
		Command c = CalculatorInvoker.processCommand(line);
		if(c!=null) {
			try {
				c.execute(this);
				if(c instanceof UndoableCommand) previousOpperations.offer((UndoableCommand)c);
			} catch(Exception e) {
				//lanzar excepcion
			}			
		}
	}
	public void subtract(BigDecimal numberToSubtract) {
		accumulatedValue=accumulatedValue.subtract(numberToSubtract);		
	}
	public BigDecimal multiply(BigDecimal numberToMultiply) {
		BigDecimal previousValue = accumulatedValue;
		accumulatedValue=accumulatedValue.multiply(numberToMultiply);
		if(numberToMultiply==BigDecimal.ZERO) return previousValue;
		return numberToMultiply;
	}
	public void divide(BigDecimal numberToDivide) {		
		try {
			accumulatedValue=accumulatedValue.divide(numberToDivide, 0, RoundingMode.HALF_UP);	
		} catch(ArithmeticException e) {
			throw new ArithmeticException();
		}		
	}
	public BigDecimal set(BigDecimal numberToSet) {
		if(numberToSet!=null) {
			BigDecimal previousValue = accumulatedValue;
			accumulatedValue=numberToSet;
			return previousValue;
		}
		return null;
	}
}
