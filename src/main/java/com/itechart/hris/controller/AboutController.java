package com.itechart.hris.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
public class AboutController {

  private final BuildProperties buildProperties;

  @Autowired
  public AboutController(final BuildProperties buildProperties) {
    this.buildProperties = buildProperties;
  }
  @ApiOperation(value = "Get build properties")
  @GetMapping("/about")
  public BuildProperties about() {
    return buildProperties;
  }
}
