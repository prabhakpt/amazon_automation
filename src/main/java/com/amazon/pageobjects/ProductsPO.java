package com.amazon.pageobjects;

public class ProductsPO {
	
	public String[] searchTextBox = new String[] {"id","in.amazon.mShop.android.shopping:id/rs_search_src_text"};
	public String[] parentProductSearch = new String[] {"id","in.amazon.mShop.android.shopping:id/search_suggestions_frame_layout"};
	public String[] childProductsSearchList = new String[] {"css","android.widget.ListView"};
	public String[] searchList = new String[] {"xpath","//div[@id='suggestions2']/div"};
	public String[] firstSearchOption = new String[] {"id","in.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text"};
	//public String[] productIndex = new String[] {"xpath","//android.view.View[@index='"};
	public String[] productIndex = new String[] {"id","search"};
	//public String[] productListLinearLayout = new String[] {"xpath","//android.widget.LinearLayout"};
	//public String productFrame = "[@resource-id='com.amazon.mShop.android.shopping:id/item_title'][@index=";///FrameLayout
	public String[] cloudWalker = new String[] {"id","bylineInfo"};
	
	public String[] addToCartButton = new String[] {"xpath","//android.widget.Button[@text='Add to Cart']"};
	public String[] buyButton = new String[] {"id","a-autoid-3"};
	public String[] miniCart = new String[] {"id","in.amazon.mShop.android.shopping:id/action_bar_cart_image"};
	
	public String[] productTitle = new String[] {"id","title_feature_div"};
	public String[] priceToPay = new String[] {"id","atfRedesign_priceblock_priceToPay"};
	public String[] imageBlock = new String[] {"id","image-block-row"};
	
}
