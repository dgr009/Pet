/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.41
 * Generated at: 2017-03-29 06:50:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admins;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminHome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Bootstrap Example</title>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("   href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("<script\r\n");
      out.write("   src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("   src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("   position: relative;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#section1  {\r\n");
      out.write("   padding-top: 50px;\r\n");
      out.write("   height: 770px;\r\n");
      out.write("   color: black;\r\n");
      out.write("   background-color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#section2 {\r\n");
      out.write("   padding-top: 50px;\r\n");
      out.write("   height: 770px;\r\n");
      out.write("   color: black;\r\n");
      out.write("   background-color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#section3 {\r\n");
      out.write("   padding-top: 50px;\r\n");
      out.write("   height: 770px;\r\n");
      out.write("   color: black;\r\n");
      out.write("   background-color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#section41 {\r\n");
      out.write("   padding-top: 50px;\r\n");
      out.write("   height: 770px;\r\n");
      out.write("   color: black;\r\n");
      out.write("   background-color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#section42 {\r\n");
      out.write("   padding-top: 50px;\r\n");
      out.write("   height: 770px;\r\n");
      out.write("   color: black;\r\n");
      out.write("   background-color: white;\r\n");
      out.write("}\r\n");
      out.write("#section43 {\r\n");
      out.write("   padding-top: 50px;\r\n");
      out.write("   height: 770px;\r\n");
      out.write("   color: black;\r\n");
      out.write("   background-color: white; \r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body data-spy=\"scroll\" data-target=\".navbar\" data-offset=\"50\"> \r\n");
      out.write("\r\n");
      out.write("   <nav class=\"navbar navbar-inverse navbar-fixed-top\">\r\n");
      out.write("      <div class=\"container-fluid\">\r\n");
      out.write("         <div class=\"navbar-header\">\r\n");
      out.write("        \r\n");
      out.write("            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" \r\n");
      out.write("               data-target=\"#myNavbar\">\r\n");
      out.write("               <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\r\n");
      out.write("                  class=\"icon-bar\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <a ><img  src=\"image/logos.png\"></a>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div>\r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\r\n");
      out.write("               <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                  <li class=\"dropdown\"><a class=\"dropdown-toggle\"\r\n");
      out.write("                     data-toggle=\"dropdown\" href=\"#\">회원리스트 <span class=\"caret\"></span></a>\r\n");
      out.write("                     <ul class=\"dropdown-menu\">\r\n");
      out.write("                     <li><a href=\"user/allList.jsp\">회원 리스트</a></li>\r\n");
      out.write("                     <li><a href=\"company/companyList.jsp\">기업회원 리스트</a></li>\r\n");
      out.write("               \r\n");
      out.write("                        <li><a href=\"admin/adminList.jsp\">관리자회원 리스트</a></li>\r\n");
      out.write("                        \r\n");
      out.write("                     </ul>\r\n");
      out.write("                               <li class=\"dropdown\"><a class=\"dropdown-toggle\"\r\n");
      out.write("                     data-toggle=\"dropdown\" href=\"#\">회원상세보기 <span class=\"caret\"></span></a>\r\n");
      out.write("                     <ul class=\"dropdown-menu\">\r\n");
      out.write("                     \r\n");
      out.write("                        <li><a href=\"company/HotelDetailList.jsp\">호텔회원 상세보기</a></li>\r\n");
      out.write("                        <li><a href=\"company/SalonDetailList.jsp\">미용회원 상세보기</a></li>\r\n");
      out.write(" \t\t\t\t\t\t<li><a href=\"company/HospitalDetailList.jsp\">병원회원 상세보기</a></li>  \r\n");
      out.write(" \t\t\t\t\t\t<li><a href=\"admin/adminDetailList.jsp\">관리자 상세보기</a></li>                     \r\n");
      out.write("                     </ul>\r\n");
      out.write("                      <li class=\"dropdown\"><a class=\"dropdown-toggle\"\r\n");
      out.write("                     data-toggle=\"dropdown\" href=\"#\">비활성화 회원리스트 <span class=\"caret\"></span></a>\r\n");
      out.write("                     <ul class=\"dropdown-menu\">\r\n");
      out.write("                     \r\n");
      out.write("                        <li><a href=\"activation/normalActivate.jsp\">일반회원보기</a></li>\r\n");
      out.write("                        <li><a href=\"activation/companyActivate.jsp\">기업회원보기</a></li>\r\n");
      out.write(" \t\t\t\t\t\t                 \r\n");
      out.write("                     </ul>\r\n");
      out.write("                     <li class=\"dropdown\"><a class=\"dropdown-toggle\"\r\n");
      out.write("                     data-toggle=\"dropdown\" href=\"#\">쪽지함<span class=\"caret\"></span></a>\r\n");
      out.write("                     <ul class=\"dropdown-menu\">\r\n");
      out.write("                     \r\n");
      out.write("                        \r\n");
      out.write("                        <li><a href=\"Message/sendMessage.jsp\">보낸쪽지함</a></li>\r\n");
      out.write(" \t\t\t\t\t\t                \r\n");
      out.write("                     </ul>\r\n");
      out.write("                      <li class=\"dropdown\"><a class=\"dropdown-toggle\"\r\n");
      out.write("                     data-toggle=\"dropdown\" href=\"#\">쿠폰<span class=\"caret\"></span></a>\r\n");
      out.write("                     <ul class=\"dropdown-menu\">\r\n");
      out.write("                     \r\n");
      out.write("                        <li><a href=\"coupon.html\">쿠폰선물함</a></li>\r\n");
      out.write("                        \r\n");
      out.write(" \t\t\t\t\t\t                \r\n");
      out.write("                     </ul>\r\n");
      out.write("                     <li><a href=\"#section3\">고객센터</a></li>\r\n");
      out.write("                  <li><a href=\"#\" data-toggle=\"modal\" data-target=\"#myModall\" ><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>\r\n");
      out.write("                  <li><a href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\" ><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>\r\n");
      out.write("               </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("      </div>\r\n");
      out.write("   </nav>\r\n");
      out.write("   \r\n");
      out.write("      <!-- 로그인 -->\r\n");
      out.write("      <div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\r\n");
      out.write("         <div class=\"modal-dialog\">\r\n");
      out.write("            <!-- Modal content-->\r\n");
      out.write("            <div class=\"modal-content\">\r\n");
      out.write("               <div class=\"modal-header\">\r\n");
      out.write("                  <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("                  <h4 class=\"modal-title\">Modal Header</h4>\r\n");
      out.write("               </div>\r\n");
      out.write("                <form action=\"/ppp/member/login\" method=\"post\">\r\n");
      out.write("                  <div class=\"modal-body\">\r\n");
      out.write("                  \r\n");
      out.write("                     <div class=\"form-group\" >\r\n");
      out.write("                        <label for=\"usr\">I D:</label> <input type=\"text\"\r\n");
      out.write("                           class=\"form-control\" id=\"usr\" name=\"member_id\">\r\n");
      out.write("                     </div>\r\n");
      out.write("                     <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"pwd\">Password:</label> <input type=\"password\"\r\n");
      out.write("                           class=\"form-control\" id=\"pwd\" name=\"member_pwd\">\r\n");
      out.write("                     </div>\r\n");
      out.write("                     \r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"modal-footer\">\r\n");
      out.write("                     <input type=\"submit\" class=\"btn btn-default\" value=\"Login\"> \r\n");
      out.write("                  </div>\r\n");
      out.write("                 \r\n");
      out.write("               </form>\r\n");
      out.write("              \r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("         <!-- 회원가입 -->\r\n");
      out.write("      <div class=\"modal fade\" id=\"myModall\" role=\"dialog\">\r\n");
      out.write("         <div class=\"modal-dialog\">\r\n");
      out.write("            <!-- Modal content-->\r\n");
      out.write("            <div class=\"modal-content\">\r\n");
      out.write("               <div class=\"modal-header\">\r\n");
      out.write("                  <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("                  <h4 class=\"modal-title\">Modal Header</h4>\r\n");
      out.write("               </div>\r\n");
      out.write("               <form action=\"/ppp/member/memberregister\" method=\"post\">\r\n");
      out.write("               <div class=\"modal-body\">\r\n");
      out.write("               \r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                     <label for=\"usr\">Name:</label> <input type=\"text\"\r\n");
      out.write("                        class=\"form-control\" id=\"usr\" name='member_name'>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                     <label for=\"usr\">I D:</label> <input type=\"text\"\r\n");
      out.write("                        class=\"form-control\" id=\"usr\" name='member_id'>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                     <label for=\"pwd\">Password:</label> <input type=\"password\"\r\n");
      out.write("                        class=\"form-control\" id=\"pwd\" name='member_pwd'>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                     <label for=\"pwd\">PasswordCheck:</label> <input type=\"password\"\r\n");
      out.write("                        class=\"form-control\" id=\"pwd\" >\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                     <label for=\"usr\">phone:</label> <input type=\"text\"\r\n");
      out.write("                        class=\"form-control\" id=\"usr\" name='member_phone'>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                     <label for=\"usr\">mail:</label> <input type=\"text\"\r\n");
      out.write("                        class=\"form-control\" id=\"usr\" name='member_mail'>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                     <label for=\"usr\">address:</label> <input type=\"text\"\r\n");
      out.write("                        class=\"form-control\" id=\"usr\" name='member_address'>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                     <label for=\"usr\">Gender:</label>\r\n");
      out.write("                        <select class=\"form-group\" name=\"member_gender\" id=\"usr\">\r\n");
      out.write("                          <option value=\"M\">남자</option>\r\n");
      out.write("                          <option value=\"F\">여자</option>\r\n");
      out.write("                       </select>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  \r\n");
      out.write("               </div>\r\n");
      out.write("               <div class=\"modal-footer\">\r\n");
      out.write("                  <button type=\"submit\" class=\"btn btn-default\">가입하기</button> \r\n");
      out.write("               </div>\r\n");
      out.write("               </form>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("      </div>\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   <div id=\"section1\" class=\"container-fluid\">\r\n");
      out.write("    <img src=\"image/papapets.png\" width=1230px height=850px>\r\n");
      out.write("     \r\n");
      out.write("   </div>\r\n");
      out.write("   \r\n");
      out.write("      \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("             \r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("   \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("<!-- 페이지 타이틀 -->\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("        \r\n");
      out.write("   \r\n");
      out.write("  \r\n");
      out.write("   \r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("   \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
