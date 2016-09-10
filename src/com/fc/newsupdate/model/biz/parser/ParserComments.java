package com.fc.newsupdate.model.biz.parser;

import java.lang.reflect.Type;
import java.util.List;

import junit.framework.TestCase;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import com.fc.newsupdate.common.LogUtil;
import com.fc.newsupdate.model.enity.BaseEntity;
import com.fc.newsupdate.model.enity.Comment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ParserComments extends TestCase{
	/**
	 * 解析评论列表
	 * @param json
	 * @return
	 */
	public static List<Comment> parserComment(String json){
		Type type = new TypeToken<BaseEntity<List<Comment>>>(){}.getType();
		BaseEntity<List<Comment>> entity = new Gson().fromJson(json,type);
		return entity.getData();
	}
	/**
	 * 解析评论数量
	 * @param json
	 * @return
	 */
	public static int parserCommentNum(String json){
		Type type = new TypeToken<BaseEntity>(){}.getType();
		BaseEntity entity = new Gson().fromJson(json,type);
		return Integer.parseInt(entity.getStatus());
	}
	/**
	 * 发送评论后解析
	 * @param json
	 * @return
	 */
	public static int parserSendComment(String json){
		LogUtil.d(LogUtil.TAG, "解析发表评论后返回json==="+json);
		Type type = new TypeToken<BaseEntity>(){}.getType();
		BaseEntity entity = new Gson().fromJson(json,type);
		return Integer.parseInt(entity.getStatus());
	}
}
