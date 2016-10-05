package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AbcController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("test", request.getRequestURI() + ": forward abc test입니다. ^^");			
		return "/abc.jsp";
	}
}	