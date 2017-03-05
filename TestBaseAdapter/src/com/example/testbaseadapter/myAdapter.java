package com.example.testbaseadapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myAdapter extends BaseAdapter {
	
	private LayoutInflater mInflater;
	private List<ItemBean>mList;
	
	public myAdapter(Context context, List<ItemBean>List){
		mList =  List;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		/*通过mInflater找到item文件中的三个控件，并进行初始化
		View view = mInflater.inflate(R.layout.item, null);
		
		//逗逼式~~~~~~~~~~~~~~~~实现方式，没有利用到listview的缓存机制，浪费
		
		ImageView imageView = (ImageView) view.findViewById(R.id.iv_image);
		TextView title = (TextView) view.findViewById(R.id.tv_title);
		TextView context = (TextView) view.findViewById(R.id.tv_context);
		
		ItemBean bean = mList.get(position);
		imageView.setImageResource(bean.itemImage);
		title.setText(bean.itemTitle);
		context.setText(bean.itemContent);
		return view;*/
		//普通式~~~~~~~~~~~~~~~
		
		/*if(convertView == null){//view 未被实例化过，缓存池中也没有缓存
			
			convertView = mInflater.inflate(R.layout.item, null);
		}
		TextView title = (TextView) convertView.findViewById(R.id.tv_title);
		TextView context = (TextView) convertView.findViewById(R.id.tv_context);
		ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_image);
		ItemBean bean = mList.get(position);
		imageView.setImageResource(bean.itemImage);
		title.setText(bean.itemTitle);
		context.setText(bean.itemContent);
		
		return convertView;//避免重复创建convertView
		//findViewByid也是非常浪费时间的
		*/
		
		
		/*
		 * 不仅利用了ListView的缓存，更通过ViewHolder类来实现
		 * 显示数据视图的缓存
		 * 避免多次通过findViewById寻找控件
		 * 
		 */
	 //文艺式~~~~~~~~~~~~~~~~~~~
		ViewHolder viewholder;
		if(convertView == null){
			viewholder = new ViewHolder();//避免重复findViewById
			
			convertView = mInflater.inflate(R.layout.item, null);
			
			viewholder.imageView =  (ImageView) convertView.findViewById(R.id.iv_image);
			viewholder.title = (TextView) convertView.findViewById(R.id.tv_title);
			viewholder.content = (TextView) convertView.findViewById(R.id.tv_context);
			convertView.setTag(viewholder);//通过setTag方法可以快速找到相应的id4			
		}else {
			viewholder = (ViewHolder) convertView.getTag();
			ItemBean bean = mList.get(position);
			viewholder.imageView.setImageResource(bean.itemImage);
			viewholder.title.setText(bean.itemTitle);
			viewholder.content.setText(bean.itemContent);
		}
		return convertView;
	}
	class ViewHolder{
		
        public ImageView imageView;//对应布局中的控件
        public TextView title;
        public TextView content;
		
	}

}
