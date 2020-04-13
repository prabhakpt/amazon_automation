package com.amazon.pages;

import com.amazon.base.BasePOM;
import com.amazon.pageobjects.ProductsPO;

public class ProductsPage extends BasePOM{
	
	ProductsPO products = new ProductsPO();
	
	public void enterProductinSearchBar(String product) {
		appHelper().clickByElement(products.searchTextBox[0], products.searchTextBox[1]);
		appHelper().enterTextWithKeyPad(products.searchTextBox[0], products.searchTextBox[1], product);
	}
	
	public void getListofProducts() {
		appHelper().verifySizeofSearResults(products.searchList[0], products.searchList[1]);
	}
	
	public void accessFirstProductInSearchResults() {
		appHelper().clickWithoutScroll(products.firstSearchOption[0], products.firstSearchOption[1]);
	}
	
	public void selectGetProductNamefromResults(String productName) {
		appHelper().captureScreenShots();
		appHelper().selectProductByName(products.productIndex[0], products.productIndex[1], productName);
	}
	
	public void verifySearchBarInHomePage() {
		appHelper().isElementEnabled(products.searchTextBox[0], products.searchTextBox[1]);
	}
	
	public void clickOnAddtoCartButton() {
		appHelper().scrollDowntoXPath(products.addToCartButton[1]);
		appHelper().clickByElement(products.addToCartButton[0], products.addToCartButton[1]);
	}
	
	public void navigateToSoppingCartPage() {
		appHelper().clickByElement(products.miniCart[0], products.miniCart[1]);
	}
	
	public void isImagePresentInProductPage() {
		System.out.println("Product page validation for image");
		appHelper().isLocatorDisplayed(products.imageBlock[0], products.imageBlock[1]);
		System.out.println("Product page validation for image - success");
	}
}
