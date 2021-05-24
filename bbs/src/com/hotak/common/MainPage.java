package com.hotak.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainPage implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// tiles.xml에 있는 <put-attribute name="body" value="/Web-INF/jsp/.........
									//								   └> 여기에 들어감
		return "main/main.tiles";
	}

}
