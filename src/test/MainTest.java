package test;


import main.Service;
import main.Words;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Modkram on 30.09.2017.
 */
public class MainTest {

    private Service service;
    private Map<String, Words> map;

    @Before
    public void before(){
        service = new Service();
        map = new HashMap<>();
    }

    @Test
    public void test(){
        String s = "This is a test.Calculate count of words. THIS SHOULD WORKS,WITH COMMA AND DOT.";
        service.processLine(s, map);
        service.printWords(Integer.MAX_VALUE, map);
        Assert.assertTrue(Objects.equals(2, map.get("this").getCount()));
    }


    @After
    public void after(){
        service = null;
        map = null;
    }
}
