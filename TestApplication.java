package com.suyh;

import com.suyh.async.Application3301;
import com.suyh.async.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author 苏雲弘
 * @since 2020-11-20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application3301.class)
public class TestApplication3301 {
    @Resource
    private TaskService taskService;

    @Test
    public void test() throws Exception {

        taskService.doTaskOne();
        taskService.doTaskTwo();
        taskService.doTaskThree();

        TimeUnit.SECONDS.sleep(10);
    }
}
