package com.sunmi.testng;

import com.sunmi.testcase.InternalDataTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * @author thliu@credit2go.cn
 * @date 2019/3/31 22:52
 */

public class InternalDataTests extends AbstractMgtTests {

    @Autowired
    private InternalDataTestCase internalDataTestCase;

    @Test
    protected void testCreateInternalData () throws InterruptedException {
        internalDataTestCase.testCreateInternalData();
    }

    @Test
    protected void testDeleteLastInternalDataRow () throws InterruptedException {
        internalDataTestCase.testDeleteLastInternalDataRow();
    }

    @Test
    protected void testEditLastInternalDataRow () throws InterruptedException {
        internalDataTestCase.testEditLastInternalDataRow();
    }

    @Test
    protected void testCreateEditAndDeleteInternalDataRow () throws InterruptedException {
        internalDataTestCase.testCreateEditAndDeleteInternalDataRow();
    }
}
