package com.ny.common.provider;

import com.ny.common.api.CommonService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@DubboService
@Component
public class CommonServiceImpl implements CommonService {
    @Override
    public String getName() {
        return "This is a name!";
    }
}
