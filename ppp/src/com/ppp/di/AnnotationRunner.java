package com.ppp.di;

import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.util.*;

import javax.servlet.http.*;

import org.slf4j.*;

import ch.qos.logback.core.net.*;

public class AnnotationRunner {
	private static ArrayList<HashMap<String, Object>> mapping = new ArrayList<HashMap<String, Object>>();
	private static Logger logger = LoggerFactory.getLogger(AnnotationRunner.class);
	public static void getRequestMapping(String path, String packageName) {
		String pName = packageName.replaceAll("[.]", "\\\\");
		// 패키지 이름의 .을 /로 바꾸면 경로가 된다
		try {
			Enumeration<URL> en = AnnotationRunner.class.getClassLoader().getResources(pName);
			while (en.hasMoreElements()) {
				URL url = en.nextElement();
				File file = new File(url.toURI());
				File[] files = file.listFiles();
				for (File f : files) {
					if (f.isFile()) {
						String controllerName = packageName + "."
								+ f.getName().substring(0, f.getName().lastIndexOf("."));
						Class clz = Class.forName(controllerName);
						Method[] mz = clz.getDeclaredMethods();
						for (Method m : mz) {
							if (m.isAnnotationPresent(RequestMapping.class)) {
								RequestMapping rm = m.getAnnotation(RequestMapping.class);
								HashMap<String, Object> map = new HashMap<>();
								map.put("uri", rm.value());
								map.put("name", m);
								map.put("method", rm.method());
								logger.info("매핑 추가 : " + rm.value() + " " + m.getName() + " " + rm.method());
								mapping.add(map);
							}
						}
					}
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	private static ModelAndView invoke(String uri, HttpServletRequest req) {
		System.out.println(uri);
		Method method = null;
		Object returnObject = null;
		String requestMethod = req.getMethod();
		if(req.getHeader("X-Requested-With")!=null && (req.getHeader("X-Requested-With").toLowerCase()=="xmlhttprequest" || req.getHeader("ORIGIN") != null))
			requestMethod="AJAX";
		for(int i=0; i<mapping.size(); i++) {
			HashMap<String,Object> map = mapping.get(i);
			if(map.get("uri").equals(uri) && map.get("method").equals(requestMethod))
				method = (Method) map.get("name");
			else
				continue;
			logger.info("메소드 호출 : " + method.getName());
			try {
				returnObject = method.invoke(null, req);
				break;
			}  catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return (ModelAndView)returnObject;
	}
	public static ModelAndView execute(HttpServletRequest req) {
		String uri = req.getRequestURI();
		System.out.println("anota excute uri : "+uri);
		uri = uri.substring(uri.indexOf("/")+1); 	// 루트 경로 "/" 제거
		uri = uri.substring(uri.indexOf("/"));
		return invoke(uri, req);
	}
}
