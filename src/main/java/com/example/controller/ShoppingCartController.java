package com.example.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;

/**
 * ショッピングカートアプリケーションの処理制御を行うコントローラ.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/shopping")
public class ShoppingCartController {

	@Autowired
	private ServletContext application;

	@Autowired
	private HttpSession session;

	/**
	 * トップ画面にフォワードする処理を行います. <br>
	 * 商品一覧の商品表示、ショッピングカート内の商品料金の合計を求める処理を行っています.
	 * 
	 * @param model モデル
	 * @return トップ画面
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("")
	public String index(Model model) {

		List<Item> itemList = (List<Item>) application.getAttribute("itemList");

		if (itemList == null) {
			itemList = new LinkedList<>();
			itemList.add(new Item("手帳ノート", 1000));
			itemList.add(new Item("文房具セット", 1500));
			itemList.add(new Item("ファイル", 2000));
			application.setAttribute("itemList", itemList);
		}

		List<Item> cartItemList = (List<Item>) session.getAttribute("cartItemList");

		int totalPrice = 0;
		if (cartItemList == null) {
			// カートが空なら0件のリストを入れる
			session.setAttribute("cartItemList", new LinkedList<>());
		}

		// 商品合計金額を計算
		totalPrice = calcTotalPrice(cartItemList);

		model.addAttribute("totalPrice", totalPrice);

		return "item-and-cart";
	}

	/**
	 * 商品をショッピングカートに入れる処理を行います.
	 * 
	 * @param index 追加する商品リストのindex番号
	 * @param model モデル
	 * @return トップ画面
	 */
	@PostMapping("/incart")
	public String inCart(String index, Model model) {

		@SuppressWarnings("unchecked")
		List<Item> itemList = (List<Item>) application.getAttribute("itemList");
		Item item = itemList.get(Integer.parseInt(index));

		@SuppressWarnings("unchecked")
		List<Item> cartItemList = (List<Item>) session.getAttribute("cartItemList");
		if (cartItemList != null) {
			cartItemList.add(item);
		} else {
			throw new RuntimeException("ショッピングカートが存在しません");
		}

		return "redirect:/shopping";
	}

	/**
	 * ショッピングカート内の商品を削除する処理を行います.
	 * 
	 * @param index 削除するショッピングカート内商品のindex番号
	 * @param model モデル
	 * @return トップ画面
	 */
	@PostMapping("/delete")
	public String delete(String index, Model model) {
		@SuppressWarnings("unchecked")
		List<Item> cartItemList = (List<Item>) session.getAttribute("cartItemList");
		if (cartItemList != null) {
			cartItemList.remove(Integer.parseInt(index));
		} else {
			throw new RuntimeException("ショッピングカートが存在しません");
		}

		return "redirect:/shopping";
	}

	/*
	 * 商品料金の合計を求める処理を行います.
	 * 
	 * @param itemList 商品情報
	 * 
	 * @return 商品料金の合計
	 */
	private Integer calcTotalPrice(List<Item> itemList) {
		Integer totalPrice = 0;

		for (Item item : itemList) {
			totalPrice += item.getPrice();
		}

		return totalPrice;
	}

}
