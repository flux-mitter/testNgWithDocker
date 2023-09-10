package com.pages;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.enums.Wait;
import com.setup.DriverManager;

import edu.emory.mathcs.backport.java.util.Collections;

public class ProductSearchResult extends BasePage {

	public ProductSearchResult() {
		PageFactory.initElements(DriverManager.getDriver(), this);
		// TODO Auto-generated constructor stub
	}

	// h2/a/span[contains(text(),'iPhone 14') and not(contains(text(),'Pro')) and
	// not(contains(text(),'Plus'))]/../../..
	private By sortByButton() {
		return By.xpath("//span[contains(text(),'Sort by:')]");
	}

	private By sortBy(String SortyBy) {
		return By.xpath("//a[contains(text(),'" + SortyBy + "')]");
	}

	private By priceOfProductsSorted(String product) {
		return By.xpath("//h2/a/span[contains(text(),'"+product+"')and not(contains(text(),'Pro')) and not(contains(text(),'Plus'))]/../../../following-sibling::div//span[@class='a-price']/span[contains(text(),'₹')]");
	}

	public void productDisplaySort(Wait wait, String sortingMechanism) {
		click(sortByButton(), wait, "clicked On SortBy");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(sortBy(sortingMechanism), wait, "Selected sorting Mechansim + " + sortingMechanism);
		// Low to High
	}

	public void validateProductResultSorting(Wait wait,String product) {
		
		System.out.println(priceOfProductsSorted(product));
		List<String> itemPriceString= ListReadText(priceOfProductsSorted(product), wait);
		ArrayList<Integer> priceListDisplayed = new ArrayList<Integer>();
		System.out.println(itemPriceString);
		itemPriceString.forEach(price -> priceListDisplayed.add(Integer.parseInt(price.replace("₹", "").replace(",", ""))));
		ArrayList<Integer> priceListSorted = new ArrayList<Integer>();
		priceListSorted.addAll(priceListDisplayed);
		Collections.sort(priceListSorted);
		System.out.println("priceListDisplayed ;"+priceListDisplayed);
		System.out.println("priceListSorted ;"+priceListSorted);
		assertTrue(getReusableMethods().areArrayListsEqual(priceListDisplayed, priceListSorted));
		
		
		

	}

}
