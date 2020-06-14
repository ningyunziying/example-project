package com.ny.common.consumer;

import com.ny.common.api.CommonService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @DubboReference
    CommonService commonService;

    public String getName() {
        return commonService.getName();
    }
}
