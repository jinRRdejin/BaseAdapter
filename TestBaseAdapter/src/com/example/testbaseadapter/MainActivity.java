package com.example.testbaseadapter;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.Window;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        List<ItemBean> mItembean = new ArrayList<ItemBean>();
        for (int i = 0; i < 20; i++) {
        	
        	mItembean.add(new ItemBean(R.drawable.page01, "好笑新闻"+ i
        			, "好笑内容"+ i));	
		}
        ListView listView = (ListView) findViewById(R.id.lv_main);
        listView.setAdapter(new myAdapter(this, mItembean));//数据源与listview的绑定完成
    }
    
}
