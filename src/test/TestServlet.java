package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.MemberController;
import controller.TestController;
import controller.UrlController;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_PREFIX = "/WEB-INF/views";
	
	private Map<String, Controller> conts = new HashMap<>();
	
	public TestServlet() {
		Properties prop = new Properties();
		try {
			prop.load(TestServlet.class.getResourceAsStream("controller.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<Entry<Object, Object>> entrySet = prop.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			String clazz = entry.getValue().toString();
			Class<?> controllerClass = null;
			try {
				controllerClass = Class.forName(clazz);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				conts.put(entry.getKey().toString(), (Controller) controllerClass.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
//		conts.put("/member", new MemberController());
//		conts.put("/test", new TestController());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String requestURI = request.getRequestURI();
		Controller controller = null;
		for (Controller c : conts.values()) {
			if (c instanceof UrlController) {
				if (((UrlController) c).getUrl().equals(requestURI)) {
					controller = c;
				}
			}
		}
		if (controller == null) {
			controller = conts.get(requestURI);	
		}

		String viewString = null;
		try {
			viewString = controller.execute(request, response);	
		} catch (Throwable e) {
			System.out.println(e.getMessage());			
		}
		
		if (viewString != null) {
			request.getRequestDispatcher(VIEW_PREFIX + viewString).forward(request, response);	
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/views/404.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
