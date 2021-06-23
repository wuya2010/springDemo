package com.alibaba.controller;//package com.alibaba;
//
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//
///*
// * 1. 必须是@Controller
// *
// * 2. 处理请求
// * 		①接受请求参数
// * 				request.getParameter("name");
// *
// * 				使用springmvc： 在方法的参数位置，声明和请求参数名一模一样的形参即可！
// *
// * 				或者，使用@RequestParam明确要获取的请求参数名。
// *
// * 		②接受请求头
// * 				request.getHeader();
// * 				使用springmvc： 在方法的参数位置，声明一个参数，使用@RequestHeader(value="key")
// * 				获取key对应的值
// *
// * 		③接受请求中携带的cookie
// *
// * 			Cookie[] cookie=request.getCookies();
// *
// * 			for(){
// * 				cookie.getName();
// * 				cookie.getValue();
// * 			}
// *
// * 			使用springmvc： 在方法的参数位置，声明一个参数，使用@CookieValue(value="key")
// * 				获取key对应的Cookie的值
//
// * 		这三个注解，都有三个属性：
// * 				value：   请求参数名，header的key，cookiename属性
// * 				defaultValue:  如果参数为Null，赋值为默认值
// * 				required：  参数是否必须，如果required=true，但是请求中并没有此参数，报错400(Bad request)
// *
// * 3. 可以使用原生API
// *
// * 4. 解决乱码
// * 			GET请求乱码： 改tomcat的server.xml
// * 			POST请求乱码：
// * 						spring提供了一个字符编码过滤器，这个过滤器自动解决乱码问题！
// *
// * 5. 转发和重定向
// * 			转发：    处理方法的返回值，必须是string.
// * 					return "forward:xxx"
// *
// * 					注意：  forward:/index.jsp
// * 						格式：  /不能丢，必须是绝对路径，使用 forward:，不会再调用
// * 							配置的视图解析器拼接地址。
// *
// * 			重定向：      处理方法的返回值，必须是string.
// * 					return "redirect:xxx"
// *
// * 					注意： "redirect:/hello1"
// * 							格式： /不能丢，必须是绝对路径，使用 redirect:，不会再调用
// * 							配置的视图解析器拼接地址。
// * 								不需要加项目名，系统会自动加上！
// *
// * 6. REST
// *
// *
// *
// */
//
//public class HelloHandler {
//
//
//	@RequestMapping(value="/hello")
//	public String handle1() {
//
//		System.out.println("处理了hello请求！");
//
//		// 将要转发页面的路径，作为string返回即可
//
//		//  /WEB-INF/pages/success.jsp
//		return "success";
//
//	}
//
//	@RequestMapping(value="/testRequestParam")
//	public String handle2(@RequestParam(value="name2",required=false,defaultValue="mike")String name,
//			int age,@RequestHeader(value="Connection")String value,
//			@CookieValue(value="JSESSIONID")String cookieValue) {
//
//		System.out.println("name:"+name);
//		System.out.println("age:"+age);
//
//		System.out.println(value);
//
//		System.out.println(cookieValue);
//
//		return "success";
//	}
//
//	@RequestMapping(value="/testRequestParam1")
//	public void handle3(HttpServletRequest request,HttpServletResponse response) throws IOException {
//
//		HttpSession session = request.getSession();
//
//		ServletContext servletContext = request.getServletContext();
//
//		String name1 = request.getParameter("name1");
//
//		System.out.println("name1:"+name1);
//
//		response.getWriter().print(true);
//
//	}
//
//	// 转发和重定向
//	@RequestMapping(value="/hello1")
//	public String handle4() {
//
//		System.out.println("处理了hello1请求！");
//
//
//		return "forward:/index.jsp";
//
//	}
//
//	@RequestMapping(value="/hello2")
//	public String handle5() {
//
//		System.out.println("处理了hello2请求！");
//
//
//		return "redirect:/hello1";
//
//	}
//
//	//   /hello4/jack
//	// @PathVariable只能获取单层路径
//	@RequestMapping(value="/hello/{name}/{age}")
//	public String handle5(@PathVariable(value="name") String name, @PathVariable(value="age") String age) {
//
//		System.out.println(name);
//		System.out.println(age);
//
//
//		return "success";
//
//	}
//
//
//
//}
