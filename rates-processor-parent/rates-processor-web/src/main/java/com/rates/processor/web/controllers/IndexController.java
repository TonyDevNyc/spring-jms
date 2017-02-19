package com.rates.processor.web.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	// rates/api/index.json
	@RequestMapping(value = "/index.json", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> buildHomePage() {

		return null;
	}
}
