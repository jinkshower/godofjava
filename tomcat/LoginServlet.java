//package tomcat;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class LoginServlet extends GenericServlet {
//
//    public void service(ServletRequest request, ServletResponse response)
//        throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//        String id = request.getParameter("id");
//        String password = request.getParameter("password");
//        checkLogin(id, password, writer);
//        writer.close();
//    }
//
//    private void checkLogin(String id, String password, PrintWriter writer) {
//        if (id != null && password != null) {
//            if (id.equals("basic") && password.equals("java")) {
//                writer.println("<B>Login success.</B>");
//            } else {
//                loginFail(writer);
//            }
//        } else {
//            loginFail(writer);
//        }
//    }
//
//    private void checkLogin2(String id, String password, PrintWriter writer) {
//        if (id != null && password != null) {
//            UserDAO dao = new UserDAO();
//            boolean result = dao.login(id, password);
//            if (result) {
//                writer.println("<B>Login success.</B>");
//            } else {
//                loginFail(writer);
//            }
//        } else {
//            loginFail(writer);
//        }
//    }
//
//    private void loginFail(PrintWriter writer) {
//        writer.println("<FONT color='red'><B>Login failed ! </B></FONT>");
//        writer.println("<BR><a href='/login.jsp'>" +
//            "Back to login page</a>");
//    }
//}
