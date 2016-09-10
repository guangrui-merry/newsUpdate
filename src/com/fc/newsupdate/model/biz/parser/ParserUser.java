package com.fc.newsupdate.model.biz.parser;
import com.fc.newsupdate.model.enity.BaseEntity;
import com.fc.newsupdate.model.enity.Register;
import com.fc.newsupdate.model.enity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**�����û�ģ��ķ�������*/
public class ParserUser {

	
	/**
	 * �����û�ע�᷵����Ϣ
	 * @param json 
	 * @return BaseEntity<Register>����
	 */
	public static BaseEntity<Register> parserRegister(String json){
		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<BaseEntity<Register>>(){}.getType());
	}
	
	/**
	 * �����û���������
	 * @param json
	 * @return BaseEntity<User> ����
	 */
	public static BaseEntity<User> parserUser(String json){
		return new Gson().fromJson(json, new TypeToken<BaseEntity<User>>(){}.getType());
	}
	
	/**
	 * �����ϴ��û�ͷ��
	 * @param json
	 * @return  BaseEntity<Register>
	 */
	public static BaseEntity<Register> parserUploadImage(String json){
		return new Gson().fromJson(json, new TypeToken<BaseEntity<Register>>(){}.getType());
	}
	
}
