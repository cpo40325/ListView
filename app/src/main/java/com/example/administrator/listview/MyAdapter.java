package com.example.administrator.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

class MyAdapter extends BaseAdapter {
    private int[] data;
    private LayoutInflater mInflater;


    public MyAdapter(Context context, int[] data) {
        super();
        this.data = data;
        this.mInflater = LayoutInflater.from(context);
    }

    /**
     * 回傳共幾筆資料
     */
    @Override
    public int getCount() {
        return data.length;
    }

    /**
     * 回傳該筆資料
     */
    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * List 依值的區間分類
     */
    @Override
    public int getItemViewType(int position) {
        int num = (int) getItem(position);

        if (num <= 10) {

            return 3;

        } else if (50 <= num && num <= 100) {

            return 1;

        } else if (num > 100) {

            return 2;

        } else if (num<=50){

            return 0;

        }else return 0;
    }

    /**
     * 定義分多少類別
     */
    @Override
    public int getViewTypeCount() {
        return 4;
    }

    /**
     * 取得View
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHoder viewHoder;


        //當convertView不為null
        if (convertView == null) {

            viewHoder = new ViewHoder();

            //分類
            int type = getItemViewType(position);

            //依分類創建view
            switch (type) {
                case 0:
                    convertView = mInflater.inflate(R.layout.layout0, parent,false);
                    viewHoder.btn = convertView.findViewById(R.id.button0);
                    break;
                case 1:
                    convertView = mInflater.inflate(R.layout.layout1,parent,false);
                    viewHoder.btn = convertView.findViewById(R.id.button1);
                    break;
                case 2:
                    convertView = mInflater.inflate(R.layout.layout2,parent,false);
                    viewHoder.btn = convertView.findViewById(R.id.button2);
                    break;
                case 3:
                    convertView = mInflater.inflate(R.layout.layout3,parent,false);
                    viewHoder.btn = convertView.findViewById(R.id.button3);
                    break;
            }
            assert convertView != null;
            convertView.setTag(viewHoder);


        } else {
            viewHoder = (ViewHoder) convertView.getTag();
        }

        String text = "index : " + position + " value : " + getItem(position);
        //設定btn的text
        viewHoder.btn.setText(text);



        return convertView;
    }

    private class ViewHoder {
        Button btn;
    }
}
