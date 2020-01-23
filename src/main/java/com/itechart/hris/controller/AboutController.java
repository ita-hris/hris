package com.itechart.hris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {

  private final BuildProperties buildProperties;

  @Autowired
  public AboutController(final BuildProperties buildProperties) {
    this.buildProperties = buildProperties;
  }

  @GetMapping("/about")
  public BuildProperties about() {
    return buildProperties;
  }
}
