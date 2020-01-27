package com.itechart.hris.controller.benefits;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/benefits")
@Api(value = "/benefits")
public class InitController {

    @ApiOperation(value = "Get API greeting")
    @GetMapping(value = "/init")
    public String init() {
        return "Hello World";
    }
}