package com.itechart.hris.controller.benefits;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/benefits")
@Api
@Slf4j
public class InitController {

  @ApiOperation(value = "Get API greeting")
  @GetMapping(value = "/init")
  public String init() {
    log.trace("Controller: [{}] was called", this.getClass().getSimpleName());
    return "Hello World";
  }
}
