package cuiyi.itsource.hrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cuiyi.itsource.hrm.mapper")
public class SystemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemServiceApplication.class,args);
    }
}
