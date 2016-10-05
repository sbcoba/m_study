package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("test", request.getRequestURI() + ": forward test입니다. ^^");			
		return "/member.jsp";
	}
}