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
		/*ͨ��mInflater�ҵ�item�ļ��е������ؼ��������г�ʼ��
		View view = mInflater.inflate(R.layout.item, null);
		
		//����ʽ~~~~~~~~~~~~~~~~ʵ�ַ�ʽ��û�����õ�listview�Ļ�����ƣ��˷�
		
		ImageView imageView = (ImageView) view.findViewById(R.id.iv_image);
		TextView title = (TextView) view.findViewById(R.id.tv_title);
		TextView context = (TextView) view.findViewById(R.id.tv_context);
		
		ItemBean bean = mList.get(position);
		imageView.setImageResource(bean.itemImage);
		title.setText(bean.itemTitle);
		context.setText(bean.itemContent);
		return view;*/
		//��ͨʽ~~~~~~~~~~~~~~~
		
		/*if(convertView == null){//view δ��ʵ���������������Ҳû�л���
			
			convertView = mInflater.inflate(R.layout.item, null);
		}
		TextView title = (TextView) convertView.findViewById(R.id.tv_title);
		TextView context = (TextView) convertView.findViewById(R.id.tv_context);
		ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_image);
		ItemBean bean = mList.get(position);
		imageView.setImageResource(bean.itemImage);
		title.setText(bean.itemTitle);
		context.setText(bean.itemContent);
		
		return convertView;//�����ظ�����convertView
		//findViewByidҲ�Ƿǳ��˷�ʱ���
		*/
		
		
		/*
		 * ����������ListView�Ļ��棬��ͨ��ViewHolder����ʵ��
		 * ��ʾ������ͼ�Ļ���
		 * ������ͨ��findViewByIdѰ�ҿؼ�
		 * 
		 */
	 //����ʽ~~~~~~~~~~~~~~~~~~~
		ViewHolder viewholder;
		if(convertView == null){
			viewholder = new ViewHolder();//�����ظ�findViewById
			
			convertView = mInflater.inflate(R.layout.item, null);
			
			viewholder.imageView =  (ImageView) convertView.findViewById(R.id.iv_image);
			viewholder.title = (TextView) convertView.findViewById(R.id.tv_title);
			viewholder.content = (TextView) convertView.findViewById(R.id.tv_context);
			convertView.setTag(viewholder);//ͨ��setTag�������Կ����ҵ���Ӧ��id4			
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
		
        public ImageView imageView;//��Ӧ�����еĿؼ�
        public TextView title;
        public TextView content;
		
	}

}
