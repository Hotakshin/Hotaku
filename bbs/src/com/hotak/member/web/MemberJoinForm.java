package com.hotak.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotak.common.DbCommand;

public class MemberJoinForm implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		return "member/memberJoinForm.tiles";
	}

}