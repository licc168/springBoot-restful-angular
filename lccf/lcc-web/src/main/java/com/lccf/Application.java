
package com.lccf;

import com.lccf.constants.LccfProperties;
import com.lccf.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableConfigurationProperties({ LccfProperties.class })
@Import(SpringUtil.class)
@ServletComponentScan
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
