package com.ningyunziying.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "用户信息管理")
public class Controller {
    @ApiOperation("分页查询所有数据")
    public void selectAll() {
    }
}
