package com.sky.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.ssm.common.JsonResult;


@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
    public JsonResult toIndex() {     
		
        return JsonResult.successMessage("保存成功");
    }
}
