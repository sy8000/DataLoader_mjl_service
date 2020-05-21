package cn.besbing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@EnableScheduling
//@MapperScan(basePackages = "cn.besbing.*")
public class MjlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MjlApplication.class, args);
    }

}
