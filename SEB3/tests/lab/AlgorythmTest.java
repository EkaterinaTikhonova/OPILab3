package lab;

import org.junit.Test;
import static org.junit.Assert.*;

public class AlgorythmTest extends junit.framework.TestCase {
    double arr [][] = {{1,1},{1,1}};
    double rez [] = {0 , 0};
    Algorythm alg = new Algorythm(2,0.1 , arr , rez);
    
    public void testDiag() throws Exception {
        assertFalse(alg.diagChk(arr));
    }

    
    public void testShd() throws Exception {
        assertFalse(alg.chkShd());
    }

}
