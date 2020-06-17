package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
   @Test
    public void test(){
       int result=Main.isCriteria(5);
       assertEquals(2,result);
   }
}