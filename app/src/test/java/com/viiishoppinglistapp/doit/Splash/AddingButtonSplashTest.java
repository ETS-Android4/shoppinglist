package com.viiishoppinglistapp.doit.Splash;

        import static org.junit.Assert.assertEquals;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.junit.runners.JUnit4;

public class AddingButtonSplashTest {
    AddingButtonSplash ageCalculator = new AddingButtonSplash();

    @Test
    public void calculateAgeTest(){
        String age = ageCalculator.calculateAge("31-03-2000");

        assertEquals(age,"21");

    }


}