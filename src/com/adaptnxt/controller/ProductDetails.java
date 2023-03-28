package com.adaptnxt.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.adaptnxt.model.Product;

public class ProductDetails
{

	public static void main(String[] args) throws IOException 
	{
		String url = "https://www.staples.com/Computer-office-desks/cat_CL210795/663ea?icid=BTS:2020:STUDYSPACE:DESKS";
        Document doc = Jsoup.connect(url).get();
        List<Product> productList = new ArrayList<>();

        for (Element product : doc.select(".card-grid__card")) {
            String productName = product.select(".card-grid__title").text();
            String productUrl = product.select(".card-grid__title a").attr("href");
            String productImageUrl = product.select(".card-grid__img img").attr("src");
            String productPrice =product.select(".card-grid__price").text().replaceAll("[^0-9.]", "");
            String productSku = product.attr("data-itemid");
            String productModel = product.attr("data-modelcode");
            String productCategory = "Computer & Office Desks";
            String productDescription = product.select(".card-grid__text").text();
            productList.add(new Product(productName, productPrice, productSku, productModel, productCategory, productDescription, productUrl, productImageUrl));
        }

        Collections.sort(productList);
        List<Product> top10Products = productList.subList(0, Math.min(10, productList.size()));

        FileWriter csvWriter = new FileWriter("staples_products.csv");
        csvWriter.append("Product Name,Product Price,Item Number/SKU/Product Code,Model Number,Product Category,Product Description\n");

        for (Product product : top10Products) {
            csvWriter.append(product.getProductName()).append(",");
            csvWriter.append((product.getProductPrice())).append(",");
            csvWriter.append(product.getProductSku()).append(",");
            csvWriter.append(product.getProductModel()).append(",");
            csvWriter.append(product.getProductCategory()).append(",");
            csvWriter.append(product.getProductDescription()).append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }

	

}
