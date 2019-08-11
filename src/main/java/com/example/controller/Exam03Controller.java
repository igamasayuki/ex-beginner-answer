package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品の合計金額と税込合計金額を求めるコントローラ.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/exam03")
public class Exam03Controller {

	@Autowired
	private ServletContext application;

	/**
	 * 初期画面に遷移.
	 * 
	 * @return 初期画面
	 */
	@RequestMapping("")
	public String index() {
		return "exam03";
	}

	/**
	 * 商品の合計金額と税込合計金額を求める.
	 * 
	 * @param item1 １つ目の商品の値段
	 * @param item2 ２つ目の商品の値段
	 * @param item3 ３つ目の商品の値段
	 * @return 結果画面
	 */
	@RequestMapping("totalMoney")
	public String totalMoney(Integer item1, Integer item2, Integer item3) {

		int totalItem = item1 + item2 + item3;
		application.setAttribute("totalMoney", totalItem);
		application.setAttribute("totalTaxMoney", (int)(totalItem * 1.08));

		return "exam03-result";
	}

}
