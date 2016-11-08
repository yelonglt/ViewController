package com.dmall.viewcontroller.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.dmall.viewcontroller.R;
import com.dmall.viewcontroller.base.ViewController;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 房屋信息描述组件
 * Created by yelong on 2016/11/7.
 * mail:354734713@qq.com
 */

public class HouseDescViewController extends ViewController<String> {

    @Bind(R.id.houseDesc)
    TextView mHouseDsec;

    public HouseDescViewController(Context context) {
        super(context);
    }

    @Override
    protected int resLayoutId() {
        return R.layout.view_house_desc;
    }

    @Override
    protected void onCreatedView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    protected void onBindView(String data) {
        mHouseDsec.setText(data);
    }
}
