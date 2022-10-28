package cn.monitor4all.logRecord.test;

import cn.monitor4all.logRecord.configuration.LogRecordAutoConfiguration;
import cn.monitor4all.logRecord.test.service.OperatorIdGetService;
import cn.monitor4all.logRecord.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;

/**
 * 单元测试：异常测试
 */
@Slf4j
@SpringBootTest
@ContextConfiguration(classes = {
        LogRecordAutoConfiguration.class,
        OperatorIdGetService.class,
        TestService.class,})
@PropertySource("classpath:testException.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LogOperationErrorTest {

    @Autowired
    private TestService testService;

    @Test
    public void logRecordFuncTest() {
        testService.testRetryTimesAndOperationLogGetErrorHandler();
    }

}
