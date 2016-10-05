package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestUrlController implements UrlController{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("test", request.getRequestURI() + ": forward test입니다. ^^");			
		return "/test.jsp";
	}

	@Override
	public String getUrl() {
		return "/abc2";
	}
}