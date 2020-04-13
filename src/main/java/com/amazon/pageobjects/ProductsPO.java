package com.amazon.pageobjects;

public class ProductsPO {
	
	public String[] searchTextBox = new String[] {"xpath","//android.widget.EditText[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_src_text']"};
	public String[] parentProductSearch = new String[] {"id","com.amazon.mShop.android.shopping:id/search_suggestions_frame_layout"};
	public String[] childProductsSearchList = new String[] {"css","android.widget.ListView"};
	public String[] searchList = new String[] {"xpath","//div[@id='suggestions2']/div"};
	public String[] firstSearchOption = new String[] {"id","com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text"};
	public String[] productIndex = new String[] {"xpath","//android.view.View[@resource-id='search']"};
	public String[] cloudWalker = new String[] {"id","bylineInfo"};
	
	public String[] addToCartButton = new String[] {"xpath","//android.widget.Button[@resource-id='add-to-cart-button']"};
	public String[] buyButton = new String[] {"id","a-autoid-3"};
	public String[] miniCart = new String[] {"id","com.amazon.mShop.android.shopping:id/action_bar_cart_image"};
	
	public String[] productTitle = new String[] {"xpath","//android.view.View[@resource-id='title_feature_div']"};
	public String[] priceToPay = new String[] {"xpath","//android.view.View[@resource-id='priceblock_ourprice']"};
	public String[] imageBlock = new String[] {"id","image-block-row"};
	public String[] cartPageContent = new String[] {"xpath","//android.view.View[@resource-id='content']"};
}
