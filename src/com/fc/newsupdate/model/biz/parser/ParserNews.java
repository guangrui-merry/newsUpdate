package com.fc.newsupdate.model.biz.parser;

import java.util.List;

import com.fc.newsupdate.model.enity.BaseEntity;
import com.fc.newsupdate.model.enity.News;
import com.fc.newsupdate.model.enity.NewsType;
import com.fc.newsupdate.model.enity.SubType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ParserNews {

	/**
	 * gson解析新闻分类
	 * @param json
	 * @return list
	 */
	public static List<SubType> parserTypeList(String json){
		Gson gson = new Gson();
		BaseEntity<List<NewsType>> typeEntity = gson.fromJson(json, new TypeToken<BaseEntity<List<NewsType>>>() {}.getType());
		for(NewsType type: typeEntity.getData()) {
			System.out.println(type.getSubgrp());
		}
		//第一版没有分类列表,暂且返回默认主分类的子分类
 		return typeEntity.getData().get(0).getSubgrp();
	}
	
	/**
	 * gson解析新闻列表
	 * @param json
	 * @return list
	 */
	public static List<News> parserNewsList(String json){
		Gson gson = new Gson();
		BaseEntity<List<News>> newsEntity = gson.fromJson(json, new TypeToken<BaseEntity<List<News>>>() {}.getType());
 		return newsEntity.getData();
	}
}
