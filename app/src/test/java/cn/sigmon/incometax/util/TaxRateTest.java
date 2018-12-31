package cn.sigmon.incometax.util;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 * TaxRateTest
 *
 * @author $USER_NAME
 * @date 2018/12/27 11:07 PM
 */
public class TaxRateTest {

    TaxRate mTaxRate;

    @Before
    public void setUp() throws Exception {
        mTaxRate = new TaxRate(10300);
    }

    @Test
    public void getTax() {
        assertEquals(820f, mTaxRate.getTax(), 0);
    }
}