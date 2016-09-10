package com.fc.newsupdate.model.biz;

import com.fc.newsupdate.common.CommonUtil;
import com.fc.newsupdate.model.httpclient.AsyncHttpClient;
import com.fc.newsupdate.model.httpclient.ResponseHandlerInterface;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * ���۹���
 * 
 * @author qinyq
 * 
 */
public class CommentsManager {

	// cmt_list ?ver=�汾��&nid=����id&type=1&stamp=yyyyMMdd&cid=����id&dir=0&cnt=20
	/**
	 * ��������
	 * 
	 * @param ver
	 *            �汾
	 * @param responseHandler
	 *            �ص��ӿ�
	 * @param args
	 *            ˳��Ҫ������ ������ nid (����id) dir ( ˢ�·��� ��1 ��ʾ������ˢ�£������ظ����xx�� �� 2
	 *            ��ʾ����ˢ�£��������µ�����) cid ����id
	 */
	public static void loadComments(String ver,
			ResponseHandlerInterface responseHandler, int... args) {
		String url = CommonUtil.APPURL + "/cmt_list?ver=" + ver + "&nid="
				+ args[0] + "&dir=" + args[1] + "&cid=" + args[2] + "&type="
				+ 1 + "&stamp=" + "20140707";
		new AsyncHttpClient().get(url, responseHandler);
	}

	/**
	 * cmt?ver=�汾��&nid=���ű��&token=�û�����&imei=�ֻ���ʶ��&ctx=�������� ��������
	 * 
	 * @param context
	 *            ������
	 * @param nid
	 *            ����id
	 * @param responseHandler
	 *            �ص��ӿ�
	 * @param args
	 *            ˳�����£����� ver:�汾 �� token :�û����� imei:�ֻ�IMEI�� �� ctx : ��������
	 */
	public static void sendCommnet(Context context, int nid,
			ResponseHandlerInterface responseHandler, String... args) {
		String url = CommonUtil.APPURL + "/cmt_commit?nid=" + nid + "&ver="
				+ args[0] + "&token=" + args[1] + "&imei=" + args[2] + "&ctx="
				+ args[3];
		new AsyncHttpClient().get(url, responseHandler);
	}

	/*
	 * public static void sendComment(Context context,int nid, String
	 * ccontent,ResponseHandlerInterface responseHandler) { AsyncHttpClient
	 * httpClient=new AsyncHttpClient(); RequestParams params=new
	 * RequestParams(); params.put("cnid", nid); params.put("ccontent",
	 * ccontent); params.put("cip",
	 * SystemUtils.getInstance(context).getPosition()); //--- ������ɶ�λ����+
	 * //params.put("cauthor", SystemUtils.getInstance(context).simType());
	 * SharedPreferences preferences=context.getSharedPreferences("userinfo",
	 * Context.MODE_PRIVATE); params.put("cuserid", preferences.getInt("uid",
	 * 0)); httpClient.post(CommonUtil.APPURL+"/DoCommentAdd", params,
	 * responseHandler); }
	 */
	/**
	 * cmt_num?ver=�汾��& nid=���ű��
	 * @param ver
	 *            �汾��
	 * @param nid
	 *            ����id
	 * @param responseHandlerInterface
	 *            �ص��ӿ�
	 */
	public static void commentNum(int ver, int nid,
			ResponseHandlerInterface responseHandlerInterface) {
		String url = CommonUtil.APPURL + "/cmt_num?nid=" + nid + "&ver="
				+ ver;
		new AsyncHttpClient().get(url, responseHandlerInterface);
	}
}
