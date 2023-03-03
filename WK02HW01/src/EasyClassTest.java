/*
 * Author: Vera Boukhonine
 * Date: Feb 6th, 2022
 * Description: This is a lab assignment to learn about Junit testing.
 *
 * */


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class EasyClassTest {
    static Scanner in = new Scanner(System.in);

    EasyClass easy;
    String testName;
    int testCount;
    double testScore;

    @BeforeEach
    void setup(){
        System.out.println("Processing Setup");
        testName = "Palovich";
        testCount = 5;
        testScore = 95.05;
        easy = new EasyClass(testName,testScore);
    }
    @AfterEach
    void tearDown(){
        System.out.println("Processing teardown");
        testName = null;
        testCount = 0;
        testScore = 0;
        easy = null;
    }

    @Test
    void get_testName(){
        assertEquals(testName,easy.getName());
    }
    @Test
    void set_testName(){
        assertEquals(testName,easy.getName());
        easy.setName("Boris");
        assertNotEquals(testName,easy.getName());
    }
    @Test
    void get_testScore(){
        Assertions.assertEquals(testScore, easy.getScore());
    }
    @Test
    void set_testScore(){
        Assertions.assertEquals(testScore, easy.getScore());
        easy.setScore(75.3);
        assertNotEquals(testScore,easy.getScore());
    }
    @Test
    void get_testCount(){
        assertEquals(testCount,easy.getCount());
    }
    @Test
    void set_testCount(){
        easy.setCount(2);
        assertNotEquals(testCount,easy.getCount());
    }
}
