package com.dmall.viewcontroller.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.dmall.viewcontroller.R;
import com.dmall.viewcontroller.base.ViewController;
import com.dmall.viewcontroller.dto.HouseInfo;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 房屋基本信息组件
 * Created by yelong on 2016/11/7.
 * mail:354734713@qq.com
 */

public class HouseInfoViewController extends ViewController<HouseInfo.BaseInfo> {

    @Bind(R.id.infoOwner)
    TextView mInfoOwner;
    @Bind(R.id.infoArea)
    TextView mInfoArea;
    @Bind(R.id.infoYear)
    TextView mInfoYear;
    @Bind(R.id.infoCity)
    TextView mInfoCity;
    @Bind(R.id.infoAddress)
    TextView mInfoAddress;
    @Bind(R.id.infoCreateTime)
    TextView mInfoCreateTime;

    public HouseInfoViewController(Context context) {
        super(context);
    }

    @Override
    protected int resLayoutId() {
        return R.layout.view_house_info;
    }

    @Override
    protected void onCreatedView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    protected void onBindView(HouseInfo.BaseInfo data) {
        mInfoOwner.setText(data.owner);
        mInfoArea.setText(data.area);
        mInfoYear.setText(data.year);
        mInfoCity.setText(data.city);
        mInfoAddress.setText(data.address);
        mInfoCreateTime.setText(data.createTime);
    }

}
