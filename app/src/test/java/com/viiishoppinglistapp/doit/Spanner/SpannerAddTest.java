package com.viiishoppinglistapp.doit.Spanner;

import static org.junit.Assert.*;

import com.viiishoppinglistapp.doit.Lists.AddList;

import org.junit.Test;

public class SpannerAddTest {

    SpannerAdd ageCalculator = new SpannerAdd();

    @Test
    public void calculateAgeTest() {
        String age = ageCalculator.calculateAge("31-03-2000");

        assertEquals(age, "21");
    }

}