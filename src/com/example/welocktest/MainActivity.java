package com.example.welocktest;

import Utils.ContextUtil;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.SqlInfo;
import com.lidroid.xutils.exception.DbException;

import dao.PersonalDao;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

import android.content.Context;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DbUtils db = DbUtils.create(ContextUtil.getContext());
		PersonalDao newpersonal=new PersonalDao();
		newpersonal.Name="≤‚ ‘√˚◊÷]";
		newpersonal.Gender=1;
		newpersonal.UpdateTime="2014-12-4";
		try {
			db.saveOrUpdate(newpersonal);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//DeleteData(db,"PersonalDao");  
		
		 
		TextView myTextView=(TextView)findViewById(R.id.myTextView);
		myTextView.setText("")
	}
 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

	public void DeleteData(DbUtils db,String  Key)
	{ 
		String sql = "delete  from " +"dao_"
				+ Key + ""
				+ " Where IsDeleted=1 ";
		try {
			db.findDbModelAll(new SqlInfo(sql));
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
