package com.example.hh.view7.fragment;


import android.content.Context;

import android.content.Intent;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import android.widget.ScrollView;
import android.widget.ViewFlipper;
import com.example.hh.view7.R;
import com.example.hh.view7.activity.BaseActivity;
import com.example.hh.view7.activity.BrowserActivity;
import com.example.hh.view7.adapter.MyAdapter1;

import java.util.ArrayList;

import java.util.List;


public class MyFragment1 extends BaseFragment {

    private ViewFlipper vflp_help;
    private ScrollView scrollView;

    private ListView listView;
    private List<com.example.hh.view7.bean.Icon> mData = null;
    private Context mContext;
    private MyAdapter1<com.example.hh.view7.bean.Icon> myAdapter = null;

    private BaseActivity parentActivity;


    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_main1;
    }
    @Override
    protected void setUpData() {
        vflp_help.startFlipping();
        mContext = parentActivity;

        //数据初始化
        mData=new ArrayList<com.example.hh.view7.bean.Icon>();
        mData.add(new com.example.hh.view7.bean.Icon(R.mipmap.q1,"语音识别百科","https://baike.baidu.com/item/%E8%AF%AD%E9%9F%B3%E8%AF%86%E5%88%AB/10927133?fr=aladdin"));
        mData.add(new com.example.hh.view7.bean.Icon(R.mipmap.q2,"中国人工智能市场发展","https://baijiahao.baidu.com/s?id=1597595764266974575&wfr=spider&for=pc"));
        mData.add(new com.example.hh.view7.bean.Icon(R.mipmap.q3,"语音识别AI开放平台","http://ai.baidu.com/tech/speech"));
        mData.add(new com.example.hh.view7.bean.Icon(R.mipmap.q4,"讯飞开放平台","https://www.xfyun.cn/?ch=bdpp"));
        mData.add(new com.example.hh.view7.bean.Icon(R.mipmap.q5,"腾讯ai平台情感分析","https://blog.csdn.net/weixin_40638517/article/details/78764795"));
        mData.add(new com.example.hh.view7.bean.Icon(R.mipmap.q6,"阿里云API平台","https://developer.aliyun.com/api"));
        mData.add(new com.example.hh.view7.bean.Icon(R.mipmap.q7,"AliGenie语音开发者平台","https://open.bot.tmall.com/"));
        mData.add(new com.example.hh.view7.bean.Icon(R.mipmap.q8,"Face++人工智能开发平台","https://www.faceplusplus.com.cn/"));
        mData.add(new com.example.hh.view7.bean.Icon(R.mipmap.q9,"YunOS开放平台","http://open.yunos.com/?spm=a2c01.7698728.0001.4.yoUl2O"));


        myAdapter = new MyAdapter1<com.example.hh.view7.bean.Icon>((ArrayList)mData,R.layout.item_grid_icon) {
            @Override
            public void bindView(ViewHolder holder, com.example.hh.view7.bean.Icon obj) {
                holder.setImageResource(R.id.img_icon,obj.getiId());
                holder.setText(R.id.txt_icon,obj.getiName());
            }
        };
        //ListView设置下Adapter：
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getMContext(), BrowserActivity.class);
                intent.putExtra("url", mData.get((int) id).getUrl());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void setUpView() {
        vflp_help = $(R.id.vflp_help);
        listView=$(R.id.list);
        scrollView=$(R.id.scrol);
        parentActivity=(BaseActivity) getActivity();
    }
}
