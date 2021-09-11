package com.sist.model;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class FoodModel {
	@RequestMapping("food/food_main.do")
	public String food_main(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("main_jsp", "../food/food_main.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("food/food_list.do")
	public String food_list(HttpServletRequest request, HttpServletResponse response)
	{
//		// 카테고리 번호받기
//		String rno=request.getParameter("rno");
//		// FoodDAO를 통해서 해당 카테고리의 맛집을 갖고 온다
//		FoodDAO dao=FoodDAO.newInstance();
//		FoodVO vo=dao.foodCategoryInfoData(Integer.parseInt(rno));
//		List<FoodVO> list=dao.foodCategoryListData(Integer.parseInt(rno));
//		// food_list.jsp로 데이터를 전송 => 출력=> main.jsp에서 출력된 내용을 읽어간다
//		request.setAttribute("vo", vo);
//		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../food/food_list.jsp");
		return "../main/main.jsp";
	}
}
