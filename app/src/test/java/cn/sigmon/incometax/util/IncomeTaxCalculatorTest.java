package cn.sigmon.incometax.util;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 * IncomeTaxCalculatorTest
 *
 * @author $USER_NAME
 * @date 2018/12/27 11:46 PM
 */
public class IncomeTaxCalculatorTest {
    private IncomeTaxCalculator mTaxCalculator;

    @Before
    public void setUp() throws Exception {
        mTaxCalculator = new IncomeTaxCalculator(15300);
    }

    @Test
    public void getIncomeTax() {
        assertEquals(480.34f, mTaxCalculator.getIncomeTax(), 0.1);
    }
}