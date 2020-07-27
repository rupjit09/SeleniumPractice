package test1;

import org.testng.annotations.*;


public class TestNgTest1 {

	@BeforeSuite
	public static void test1() {
		System.out.println("Executing Before Suite");
	}
	
	@AfterSuite
	public static void test2() {
		System.out.println("Executing After Suite");
	}
	@BeforeClass
	public static void test3() {
		System.out.println("Executing Before Class");
	}
	@AfterClass
	public static void test4() {
		System.out.println("Executing After Class");
	}
	@BeforeTest
	public static void test5() {
		System.out.println("Executing Before Test");
	}
	@AfterTest
	public static void test6() {
		System.out.println("Executing After Test");
	}
	@BeforeMethod
	public static void test7() {
		System.out.println("Executing Before Method");
	}
	@AfterMethod
	public static void test8() {
		System.out.println("Executing After Method");
	}
	
	@Test(groups= {"Smoke", "Regression"})
	public static void testb() {
		System.out.println("Executing testb");
	}
	@Test
	public static void testa() {
		System.out.println("Executing testa");
	}
	//org.testng.annotations.
}
