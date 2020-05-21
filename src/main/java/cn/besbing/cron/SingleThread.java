package cn.besbing.cron;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SingleThread {

    /**
     * cron：cron表达式，指定任务在特定时间执行;
     * fixedDelay：表示上一次任务执行完成后多久再次执行，参数类型为long，单位ms;
     * fixedDelayString：与fixedDelay含义一样，只是参数类型变为String;
     * fixedRate：表示按一定的频率执行任务，参数类型为long，单位ms;
     * fixedRateString: 与fixedRate的含义一样，只是将参数类型变为String;
     * initialDelay：表示延迟多久再第一次执行任务，参数类型为long，单位ms;
     * initialDelayString：与initialDelay的含义一样，只是将参数类型变为String;
     */

    private Logger logger = LoggerFactory.getLogger(SingleThread.class);
    private int cronCount = 1;
    private int cronCount1 = 1;

    @Scheduled(cron = "0/5 * * * * ?")
    @Async
    public void testCron(){
        logger.info("===initialDelay: 第{}次执行方法",cronCount++);
    }

    @Scheduled(cron = "0/10 * * * * ?")
    @Async
    public void testCron1(){
        logger.info("===initialDelay: 第{}次执行方法",cronCount1++);
    }

}
