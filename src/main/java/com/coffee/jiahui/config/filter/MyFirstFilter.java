package com.coffee.jiahui.config.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class MyFirstFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String header = request.getHeader("xjh_token");
		if (header == null || !"xujiahui".equals(header)) {

			response.setCharacterEncoding("UTF_8");// 设置Response的编码方式为UTF-8
			response.setHeader("Content-type", "text/html;charset=UTF-8");// 向浏览器发送一个响应头，设置浏览器的解码方式为UTF-8,其实设置了本句，也默认设置了Response的编码方式为UTF-8，但是开发中最好两句结合起来使用
			// response.setContentType("text/html;charset=UTF-8");同上句代码作用一样
			PrintWriter writer = response.getWriter();
			writer.write("权限通不过哦，骚年！");
			writer.flush();
			writer.close();
			return;
		}

		filterChain.doFilter(request, response);

	}

}
