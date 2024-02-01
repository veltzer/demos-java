package exercise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RandomServlet extends HttpServlet {
	private int max;

	public void init() {
		String maxNum = getServletConfig().getInitParameter("maxNum");
		try {
			max = Integer.parseInt(maxNum);
		} catch (NumberFormatException e) {
			throw new RuntimeException(e);
		}
	}

	public void doGet(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Random Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<b>Guess a number from 1 to " + max + ":</b>");
		out.println("<form action='' method=POST>");
		out.println("Your guess: <select name=number>");
		for (int i = 1; i <= max; i++) {
			out.println("<option>" + i);
		}
		out.println("</select>");
		out.println("<input type=submit value=Guess>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		int randNum = createRandomNum();

		String numParam = request.getParameter("number");
		int num = Integer.parseInt(numParam);
		if (num == randNum) {
			out.println("You are a Winner!");
		} else if (num < randNum) {
			out.println("Wrong. Low guess, the correct number is " + randNum);
		} else if (num > randNum) {
			out.println("Wrong. High guess, the correct number is " + randNum);
		}
	}

	private int createRandomNum() {
		int num = (int) Math.ceil(Math.random() * max);
		return num;
	}
}
