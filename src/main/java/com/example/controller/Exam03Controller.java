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
	 * @param itemName1 １つ目の商品の値段
	 * @param itemName2 ２つ目の商品の値段
	 * @param itemName3 ３つ目の商品の値段
	 * @return 結果画面
	 */
	@RequestMapping("/purchase")
	public String totalMoney(Integer itemName1, Integer itemName2, Integer itemName3) {

		int totalPriceWithoutTax = itemName1 + itemName2 + itemName3;
		int totalPriceIncludeTax = (int)(totalPriceWithoutTax * 1.1);
		application.setAttribute("totalPriceWithoutTax", totalPriceWithoutTax);
		application.setAttribute("totalPriceIncludeTax", totalPriceIncludeTax);

		return "exam03-result";
	}

}
