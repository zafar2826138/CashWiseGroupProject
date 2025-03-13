package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgIntro {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("This is Before class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("this is before method");
    }
    @Test
    public void test1(){
        System.out.println("I am test1 ");
    }

    @Test
    public void test2(){
        Assert.assertTrue(2<5);
        System.out.println("Test 2 ");
    }
}
