package com.example.jenkinsprototype;

import android.test.InstrumentationTestCase;

/**
 * Created by hemant.bareja on 17-07-2014.
 */
public class DeckTest extends InstrumentationTestCase {
    public void test() throws Exception {
        final int expected = 5;
        final int reality = 5;
        assertEquals(expected, reality);
    }

}
