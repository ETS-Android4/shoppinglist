package com.viiishoppinglistapp.doit.Lists;

import static org.junit.Assert.*;

import com.viiishoppinglistapp.doit.Helper.AddInventoryHelper;

import org.junit.Test;

public class ListAdapterTest {

    ListAdapter ageCalculator = new ListAdapter();

    @Test
    public void calculateAgeTest() {
        String age = ageCalculator.calculateAge("31-03-2000");

        assertEquals(age, "21");
    }

    }