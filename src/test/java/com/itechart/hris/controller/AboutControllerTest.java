package com.itechart.hris.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class AboutControllerTest {

  @Autowired private MockMvc mvc;

  @Test
  public void testAbout() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/about").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("name").value("hris"))
        .andExpect(MockMvcResultMatchers.jsonPath("group").value("com.itechart"))
        .andExpect(MockMvcResultMatchers.jsonPath("artifact").value("hris"))
        .andExpect(MockMvcResultMatchers.jsonPath("version").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("time").exists());
  }
}
