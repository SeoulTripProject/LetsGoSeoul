package com.sist.model;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller
public class MainModel {
	@RequestMapping("main/main.do")
	public String main_main(HttpServletRequest request,HttpServletResponse response)
	{
/*		String result="";
		int[] com=new int[(int)(Math.random()*6)+5]; 
		int su=0;
		boolean bCheck=false;
		for(int i=0; i<com.length; i++)
		{
			bCheck=true; 
			while(bCheck)
			{
				su=(int)(Math.random()*6)+1;
				bCheck=false; 
				for(int j=0; j<i; j++) 
				{
					if(com[j]==su) 
					{
						bCheck=true;
						break;
					}
				}
			}
			com[i]=su;
		}
		Arrays.sort(com);
		for(int i=0; i<com.length; i++)
		{
			result+=com[i]+",";
		}
		result=result.substring(0, result.lastIndexOf(","));
		request.setAttribute("result", result); */
		request.setAttribute("main_jsp", "../main/home.jsp");
		return "../main/main.jsp";
	}
}
