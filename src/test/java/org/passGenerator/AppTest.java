package org.passGenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    App app = new App();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void sizeIsCorrect() {
        String password = app.generatePassword(12,'y','y','y');
        assertEquals(12, password.length());
    }

}
