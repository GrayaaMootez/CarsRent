package com.cars.config;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());

	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	        	System.out.println("4000000000004");
	            return "404";
	        }

	        if(statusCode == HttpStatus.FORBIDDEN.value()) {
	            return "403";
	        }

	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            return "500";
	        }
	    }
	    return "error";
	}

    @Override
    public String getErrorPath() {
        return "/error";
    }
}

