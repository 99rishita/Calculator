import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import com.Calculator;
import com.ICalculator;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Calculator Operations")
public class CalculatorTest {

	static Calculator c1;
	boolean flag = true;
	private ICalculator calculator;
	
	//by default one object/instance is created for each test case
	public CalculatorTest() {
		
	}
	
//	@BeforeEach
//	public void createCalculator() {
//		c1 = new Calculator();
//		System.out.println("----Before Each test case---------");
//	}
	
	//Does not belong to instance, therefore only once this method is called
	@BeforeAll
	public static void createCalculator() {
		c1 = new Calculator();
		System.out.println("*************Started Testing*************");
	}
	
	@AfterAll
	public static void removeCalculator() {
		c1 = null;
		System.out.println("***********Finished Testing****************");
	}
	
	@BeforeEach
	public void abc()
	{
		System.out.println("-------------Before Each called---------------");
	}
	
	@BeforeEach
	public void xyz()
	{
		System.out.println("-------------After Each called---------------");
	}

	@Test
	@DisplayName("Testing for Addition Operation")
	@Tag("Math")
	public void testAdd(){

	Calculator c2 = new Calculator();
	int actual = c2.add(10, 20);
	int expected = 30;
	assertEquals(expected, actual);
	System.out.println("testAdd()");
	
//	assertAll(
//				
//	()->assertEquals(30, c1.add(10, 20)),
//	()->assertEquals(50, c1.add(30, 20)),
//	()->assertEquals(60, c1.add(40, 20)),
//	()->assertEquals(110, c1.add(20, 90)),
//	()->assertEquals(10, c1.add(-10, 20)),
//	()->assertEquals(-30, c1.add(-10, -20))
//				);
	}
	
	@Test
	@DisplayName("Testing for Multiplication Operation")
	@Tag("Math")
	public void testMul(){
		Calculator c2 = new Calculator();
		
		//test is executed but not the logic inside the method
		//assumeTrue(flag);
		int actual = c2.mul(10, 20);
		int expected = 200;
		assertEquals(expected, actual);
		System.out.println("testMul()");
	}
	
	@Test
	//@Disabled
	@Tag("Math")
	void testSub() {
		//Calculator c1 = new Calculator();
		assertEquals(40, c1.sub(50,10));
		System.out.println("testSub1()");
		assertEquals(20, c1.sub(90,70));
		System.out.println("testSub2()");
		assumeTrue(flag); // all the code below this will not execute if assumption is wrong
		assertEquals(10, c1.sub(30,20));
		System.out.println("testSub3()");
		
	}
	
	@Test
	@Tag("Demo")
	void testDemo() {
		System.out.println("Dummy Test Case");
		System.out.println("demo()");
	}
	
	@Test
	@Tag("Math")
	void testDiv() {
		//Calculator c1 = new Calculator();
		assertThrows(ArithmeticException.class, ()->c1.div(5, 0));
		System.out.println("testDiv()");
	}
	
	@Test
	@EnabledOnOs(OS.WINDOWS)
	@Tag("OS")
	void testWindows() {
		System.out.println("For Windows OS only");
	}
	
	@Test
	@EnabledOnOs(OS.LINUX)
	@Tag("OS")
	void testLinux() {
		System.out.println("For Linux OS only");
	}
	
	@Test
	@EnabledOnJre(JRE.JAVA_8)
	@Tags(value = {@Tag("Demo"), @Tag("Java")})
	void testJava() {
		System.out.println("For Java Only");
	}
	
	@Test
	@EnabledForJreRange(min= JRE.JAVA_8, max=JRE.JAVA_15)
	@Tag("Demo")
	void testMethodJava() {
		System.out.println("For Java Only");
	}
	
	@Test
	void testDisplay( ) {
		Calculator c2 = mock(Calculator.class);
		doNothing().when(c2).display(10,20);
		c2.display(10, 20);
		verify(c2, times(1)).display(10, 20);
	}
	
	@Test
	void testDisplayArgs( ) {
		calculator = mock(ICalculator.class);
		doNothing().when(calculator).displayArgs(10,20);
		calculator.displayArgs(10, 20);
		verify(calculator, times(1)).displayArgs(10, 20);
	}
	
	

}
