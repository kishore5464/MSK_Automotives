package com.msk.automotive.service.controllers;

import javax.ws.rs.Path;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@PropertySource("classpath:/application_path.properties")
@RestController
@Path("/")
public class DownloadController {

}
