import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import requester.Calculator;
class CalculatorTest {
	private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = Calculator.get();
        calculator.set(BigDecimal.ZERO);
    }
    @Test
    void getValueTest() {
        assertEquals(BigDecimal.ZERO, calculator.getValue());
    }    
    @Test 
    void additionTest() {
    	BigDecimal initialValue = calculator.getValue();
        calculator.operate("3 sum");
        BigDecimal result = calculator.getValue();
        assertEquals(initialValue.add(BigDecimal.valueOf(3)), result);
        calculator.operate("sum 3");
        result = calculator.getValue();
        assertEquals(initialValue.add(BigDecimal.valueOf(6)), result);
    }
    @Test
    void subtractionTest() {
    	BigDecimal initialValue = calculator.getValue();
        calculator.operate("3 subtract");
        BigDecimal result = calculator.getValue();
        assertEquals(initialValue.subtract(BigDecimal.valueOf(3)), result);
        calculator.operate("subtract 3");
        result = calculator.getValue();
        assertEquals(initialValue.subtract(BigDecimal.valueOf(6)), result);
    }
    @Test
    void multiplicationTest() {
    	BigDecimal initialValue = calculator.getValue();
        calculator.operate("3 multiply");
        BigDecimal resultado = calculator.getValue();
        assertEquals(initialValue.multiply(BigDecimal.valueOf(3)), resultado);
        calculator.operate("multiply 3");
        resultado = calculator.getValue();
        assertEquals(initialValue.multiply(BigDecimal.valueOf(9)), resultado);
    }
    @Test
    void multiplicationByZeroAndUndoTest() {
    	
    	
    	calculator.operate("3 sum");
    	BigDecimal initialValue = calculator.getValue();
        calculator.operate("0 multiply");
        assertEquals(BigDecimal.ZERO, calculator.getValue());
        calculator.operate("undo");
        assertEquals(initialValue, calculator.getValue());
    }
    @Test
    void divisionTest() {
    	BigDecimal initialValue = calculator.getValue();
        calculator.operate("3 division");
        BigDecimal resultado = calculator.getValue();
        assertEquals(initialValue.divide(BigDecimal.valueOf(3)), resultado);
        calculator.operate("0 division");
        assertEquals(initialValue.divide(BigDecimal.valueOf(3)), resultado);
    }
    @Test
    void setValueTest() {
    	BigDecimal initialValue = calculator.getValue();
        calculator.operate("3 set");
        BigDecimal resultado = calculator.getValue();
        assertEquals(BigDecimal.valueOf(3), resultado);
        assertNotEquals(initialValue, resultado);
    }
    @Test
    void undoTest() {
    	BigDecimal initialValue = calculator.getValue();
        calculator.operate("3 set");
        BigDecimal resultado = calculator.getValue();
        assertEquals(BigDecimal.valueOf(3), resultado);
        assertNotEquals(initialValue, resultado);
        calculator.operate("undo");
        assertEquals(initialValue, calculator.getValue());
    }
    @Test 
    void undoEmptyQueueTest() {
    	for(int i=0;i<100;i++)  calculator.operate("undo");
        assertEquals(BigDecimal.ZERO, calculator.getValue());
    }
    @Test
    void undoMultipleCommandsTest() {
    	BigDecimal initialValue = calculator.getValue();
    	calculator.operate("sum 41");
    	calculator.operate("multiply 301");
    	calculator.operate("41 division");
    	calculator.operate("subtract 12");
    	for(int i=0;i<4;i++) calculator.operate("undo");
    	assertEquals(initialValue, calculator.getValue());
    }
    @Test
    void unusualCommands() {
    	BigDecimal initialValue = calculator.getValue();
    	calculator.operate("  ");
    	assertEquals(initialValue, calculator.getValue());
    	calculator.operate("");
    	assertEquals(initialValue, calculator.getValue());
    	calculator.operate("set set");
    	assertEquals(initialValue, calculator.getValue());
    	calculator.operate("3 3");
    	assertEquals(initialValue, calculator.getValue());
    	calculator.operate("create 3");
    	assertEquals(initialValue, calculator.getValue());
    	calculator.operate("sum 3 2 p a");
    	assertEquals(initialValue, calculator.getValue());
    }
    @Test
    void singletonTest() {
    	BigDecimal initialValue = calculator.getValue();
    	calculator.operate("sum 41");
    	calculator = Calculator.get();
    	assertEquals(initialValue.add(BigDecimal.valueOf(41)), calculator.getValue());
    	Calculator otherCalculator = Calculator.get();
    	assertEquals(initialValue.add(BigDecimal.valueOf(41)), otherCalculator.getValue());  
    	Calculator.turnOff();
    	calculator = Calculator.get();
    	assertEquals(BigDecimal.ZERO, calculator.getValue());  
    }
}
