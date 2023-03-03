import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/*
Title: ATMTest.java
Abstract: This file contains all the Junit testing for ATM.java
It tests all functions unique to ATM.
Author: Vera Boukhonine
Date: 03/06/2022
* */
public class ATMTest {
    ATM atmTester1;
    ATM atmTester2;
    @Before
    public void setup(){
        atmTester1 = new ATM("OtterUnion");
        atmTester2 = new ATM(100,"OtterUnion","Library");
    }
    @Test
    public void constructorTest1(){
        ATM constructorTest = null;
        assertNull(constructorTest);
        constructorTest =  new ATM("OtterUnion");
        assertNotNull(constructorTest);
    }
    @Test
    public void constructorTest2(){
        ATM constructorTest = null;
        assertNull(constructorTest);
        constructorTest = new ATM(100,"OtterUnion","Library");
        assertNotNull(constructorTest);
    }
    @Test
    public void withdrawalTest(){
        assertEquals("Succeed – withdrawal",atmTester1.withdrawal("Alice",1234,10.50));
    }
    @Test
    public void depositTest(){
        assertEquals("Succeed – deposit",atmTester1.deposit("Alice",1234,5.25));
    }
    @Test
    public void transferTest(){
        assertTrue(atmTester2.transfer("Alice",1234,12.25,"Tom",2000));
    }
    @Test
    public void statusTest(){
        String test = "Serial Number:0\n" +
                "Bank Name: OtterUnion\n" +
                "Location: UNKNOWN\n" +
                "Balance: 100.0\n" +
                "0 Transactions so far:\n" +
                "Withdrawal: 0( 0 success, 0 fail)\n" +
                "Deposit: 0( 0 success, 0 fail)\n" +
                "Transfer: 0( 0 success, 0 fail)";
        assertEquals(test,atmTester1.status());
    }
    @Test
    public void isCustomerTest(){
        assertTrue(atmTester1.isCustomer("Alice"));
    }
    @Test
    public void getCustomerTest(){
        atmTester1.getCustomer("Alice");
        System.out.println(atmTester1.getCustomer("Alice"));
        assertNotNull(atmTester1.getCustomer("Alice"));
    }
    @Test
    public void setATMTest(){
        atmTester1.setATM(100,"Library");
        assertSame(atmTester1.getSerialNumber(),atmTester2.getSerialNumber());
    }
    @Test
    public void addFundTest(){
        atmTester1.setATM(100,"Library");
//        assertSame(atmTester1.getAtmBalance(),atmTester2.getAtmBalance());
        atmTester1.addFund(400);
        assertNotEquals(atmTester1.getAtmBalance(),atmTester2.getAtmBalance());
    }
    @Test
    public void toStringTest(){
//        System.out.println(atmTester2.toString());
        String test="Serial Number: 100\n" +
                "Bank Name: OtterUnion\n" +
                "Location: Library\n" +
                "Balance: 100.0";
        assertEquals(test,atmTester2.toString());
    }
    @Test
    public void displayMenuTest(){
        String test = "===== ATM Transaction Menu =====\n" +
                "1. Withdrawal\n" +
                "2. Deposit\n" +
                "3. Transfer\n";
        assertEquals(test,atmTester1.displayMenu());
    }
    @After
    public void tearDown(){
        atmTester1 = null;
        atmTester2 = null;
    }
}
