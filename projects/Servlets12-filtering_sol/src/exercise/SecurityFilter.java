package exercise;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class SecurityFilter implements Filter {
	private String validUser;
	public void init(FilterConfig cfg) {
		validUser = cfg.getInitParameter("validUser");
		if (validUser == null) {
			throw new RuntimeException(new ServletException("Must supply a 'validUser' init-param."));
		}
	}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
		String username = req.getParameter("username");
		if (username != null && username.equals(validUser)) {
			try {
				chain.doFilter(req, res);
			} catch (IOException e) {
				throw new RuntimeException(e);
			} catch (ServletException e) {
				throw new RuntimeException(e);
			}
		} else {
			try {
				((HttpServletResponse) res).sendError(403, "I don't know you!");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	public void destroy() {
	}
}
