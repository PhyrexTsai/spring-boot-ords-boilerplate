package com.phyrextsai.boilerplate.controller;

import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;	
import org.springframework.web.servlet.view.RedirectView;	

@Controller	
@Api(value = "Index",
  tags="Index Controller",
  description = "Root Path", 
  hidden = true)
@ApiIgnore
public class IndexController {	
  //透過 @RequestMapping 指定從 / 會被對應到此 index() 方法，直接轉跳到 Swagger UI	
  @ApiOperation(value = "Redirect URL to Swagger UI", hidden = true)
  @RequestMapping("/")	
  public RedirectView index(HttpServletRequest request){	
    return new RedirectView("/swagger-ui.html");
  }	

} 
