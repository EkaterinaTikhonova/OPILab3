package lab;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConsoleReadTest  extends junit.framework.TestCase {

    
    public void testType() throws Exception {
        ConsoleRead cr = new ConsoleRead(1);
        assertEquals(1 ,cr.getType());
    }

}
