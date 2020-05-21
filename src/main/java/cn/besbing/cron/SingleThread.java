package cn.besbing.cron;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SingleThread {

    private Logger logger = LoggerFactory.getLogger(SingleThread.class);
    private int cronCount = 1;
    private int cronCount1 = 1;

    @Scheduled(cron = "0/5 * * * * ?")
    public void testCron(){
        logger.info("===initialDelay: 第{}次执行方法",cronCount++);
    }

    @Scheduled(cron = "0/10 * * * * ?")
    public void testCron1(){
        logger.info("===initialDelay: 第{}次执行方法",cronCount1++);
    }

}
