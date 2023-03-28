package com.adaptnxt.model;

public class Product implements Comparable<Product>
{
	private String productName;
    private String productPrice;
    private String productSku;
    private String productModel;
    private String productCategory;
    private String productDescription;
    private String productUrl;
    private String productImageUrl;

    public Product(String productName, String productPrice, String productSku, String productModel, String productCategory, String productDescription, String productUrl, String productImageUrl) 
    {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productSku = productSku;
        this.productModel = productModel;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productUrl = productUrl;
        this.productImageUrl = productImageUrl;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductSku() {
        return productSku;
    }

    public String getProductModel() {
        return productModel;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public String getProductImageUrl() {
        return productImageUrl;

}

	@Override
	public int compareTo(Product o) 
	{
		 double price1 = Double.parseDouble(productPrice.replaceAll("\\$", ""));
            double price2 = Double.parseDouble(o.getProductPrice().replaceAll("\\$", ""));
            return Double.compare(price1, price2);
	}
}
