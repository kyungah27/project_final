package com.uver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.uver.service.EventService;
import com.uver.service.EventServiceImpl;

@Controller("EventController")
public class EventController {

	private static final Logger LOG = LoggerFactory.getLogger(EventController.class);

	@Autowired
	EventService eventService;
	
	
	

}
