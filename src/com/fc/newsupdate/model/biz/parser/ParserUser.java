package com.fc.newsupdate.model.biz.parser;
import com.fc.newsupdate.model.enity.BaseEntity;
import com.fc.newsupdate.model.enity.Register;
import com.fc.newsupdate.model.enity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**解析用户模块的返回数据*/
public class ParserUser {

	
	/**
	 * 解析用户注册返回信息
	 * @param json 
	 * @return BaseEntity<Register>对象
	 */
	public static BaseEntity<Register> parserRegister(String json){
		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<BaseEntity<Register>>(){}.getType());
	}
	
	/**
	 * 解析用户中心数据
	 * @param json
	 * @return BaseEntity<User> 对象
	 */
	public static BaseEntity<User> parserUser(String json){
		return new Gson().fromJson(json, new TypeToken<BaseEntity<User>>(){}.getType());
	}
	
	/**
	 * 解析上传用户头像
	 * @param json
	 * @return  BaseEntity<Register>
	 */
	public static BaseEntity<Register> parserUploadImage(String json){
		return new Gson().fromJson(json, new TypeToken<BaseEntity<Register>>(){}.getType());
	}
	
}
