/*
 * Copyright 2016-2017 Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openo.nfvo.resmanagement.test;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.onap.vfc.nfvo.resmanagement.common.util.restclient.ServiceException;
import org.openo.nfvo.resmanagement.mocoserver.VimDriverSuccessServer;
import org.openo.nfvo.resmanagement.util.MyTestManager;

/**
 * <br>
 * <p>
 * </p>
 * 
 * @author
 * @version VFC 1.0 Sep 28, 2016
 */
public class ITLimitsRoa extends MyTestManager {

    private VimDriverSuccessServer driver = new VimDriverSuccessServer();

    private static final String GET_CPU_PATH =
            "src/integration-test/resources/testcase/limitsroa/querycpulimitssuccess1.json";

    private static final String GET_DISK_PATH =
            "src/integration-test/resources/testcase/limitsroa/querydisklimitssuccess1.json";

    @Before
    public void setup() throws ServiceException, InterruptedException {
        driver.start();
        // Thread.sleep(60 * 1000);
    }

    @After
    public void tearDown() throws ServiceException {
        driver.stop();
    }

    @Test
    public void testGetLimitsSuccess() throws ServiceException {
        execTestCase(new File(GET_CPU_PATH));
        execTestCase(new File(GET_DISK_PATH));
    }
}
