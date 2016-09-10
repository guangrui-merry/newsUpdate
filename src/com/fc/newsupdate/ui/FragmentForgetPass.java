package com.fc.newsupdate.ui;

import org.apache.http.Header;

import com.fc.newsupdate.R;
import com.fc.newsupdate.common.CommonUtil;
import com.fc.newsupdate.common.LogUtil;
import com.fc.newsupdate.model.biz.UserManager;
import com.fc.newsupdate.model.biz.parser.ParserUser;
import com.fc.newsupdate.model.enity.BaseEntity;
import com.fc.newsupdate.model.enity.Register;
import com.fc.newsupdate.model.httpclient.TextHttpResponseHandler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentForgetPass extends Fragment {
	/** ����༭�� */
	private EditText editEmail;
	/** ȷ�ϰ�ť */
	private Button btnCommit;
	/** �û������� */
	private UserManager userManager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_forgetpass, container,
				false);
		editEmail = (EditText) view.findViewById(R.id.edit_email);
		btnCommit = (Button) view.findViewById(R.id.btn_commit);
		btnCommit.setOnClickListener(listener);
		return view;
	}

	private View.OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// ���ȷ�ϰ�ť�������������������������
			if (arg0.getId() == R.id.btn_commit) {
				String email = editEmail.getText().toString();
				if (!CommonUtil.verifyEmail(email)) {
					Toast.makeText(getActivity(), "����������ȷ�������ʽ",
							Toast.LENGTH_SHORT).show();
					return;
				}
				if (userManager == null)
					userManager = UserManager.getInstance(getActivity());
				userManager.forgetPass(new MyResponseHandlerInterface(),
						CommonUtil.VERSION_CODE + "", email);
			}
		}
	};

	private class MyResponseHandlerInterface extends TextHttpResponseHandler {

		@Override
		public void onFailure(int statusCode, Header[] headers,
				String responseString, Throwable throwable) {
			Toast.makeText(getActivity(), "����ʧ��", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onSuccess(int statusCode, Header[] headers,
				String responseString) {
			if (statusCode == 200) {
				LogUtil.d(LogUtil.TAG, "ִ���������������������Ϣ��" + responseString);
				BaseEntity<Register> register = ParserUser
						.parserRegister(responseString);
				int status = Integer.parseInt(register.getStatus());
				String result = "";
				if (status == 0) {
					Register entity = register.getData();
					result = entity.getExplain();
					if (entity.getResult().trim().equals("0")) {
						((ActivityMain) getActivity()).showFragmentLogin();
						// ���Ӷ���=======
						getActivity().overridePendingTransition(
								R.anim.anim_activity_right_in,
								R.anim.anim_activity_bottom_out);
					}else if(entity.getResult().trim().equals("-2")){
						editEmail.requestFocus();
					}
					Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT)
							.show();
				}

			}

		}

	}
}
