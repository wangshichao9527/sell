package com.wangsc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * @author wangsc
 * @date 2019-9-13 15:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    @Test
    public void test1() {
        log.error("ERROR============================");
        log.warn("WARN============================");
        log.info("INFO============================");
        log.debug("DEBUG============================");
        log.trace("TRACE============================");
    }
}
