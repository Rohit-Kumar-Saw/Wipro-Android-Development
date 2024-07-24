package com.example;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.AssertEquals;


import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * 
     */
   
        @Test
        public void addTest()
        {
            int sum=App.add(5,5);
            AssertEquals(10, sum);
        }

        @Test
        public void isEvenTest() {
            boolean isEven = App.isEven(7);
            assertFalse(isEven);
        }    

   
}
