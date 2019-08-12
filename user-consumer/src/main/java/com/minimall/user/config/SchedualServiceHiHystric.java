package com.minimall.user.config;

import com.minimall.user.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/8/12
 * @mail jiangbo.ge@kuwo.cn
 */
@Component
public class SchedualServiceHiHystric  implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne() {
        return "sorry,error";
    }
}
