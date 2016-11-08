package com.dmall.viewcontroller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.dmall.viewcontroller.dto.HouseInfo;
import com.dmall.viewcontroller.view.HouseDescViewController;
import com.dmall.viewcontroller.view.HouseInfoViewController;
import com.dmall.viewcontroller.view.HousePhotoViewController;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private HousePhotoViewController mHousePhotoViewController;
    private HouseInfoViewController mHouseInfoViewController;
    private HouseDescViewController mHouseDescViewController;

    private LinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContainer = (LinearLayout) findViewById(R.id.mainContainer);

        mHousePhotoViewController = new HousePhotoViewController(this);
        mHousePhotoViewController.attachRoot(mContainer);

        mHouseInfoViewController = new HouseInfoViewController(this);
        mHouseInfoViewController.attachRoot(mContainer);

        mHouseDescViewController = new HouseDescViewController(this);
        mHouseDescViewController.attachRoot(mContainer);

        getData();
    }

    private void getData() {
        mContainer.postDelayed(new Runnable() {
            @Override
            public void run() {
                HouseInfo info = initDefaultData();
                fillData(info);
            }
        }, 2000);
    }

    private void fillData(HouseInfo info) {
        mHousePhotoViewController.fillData(info.photos);
        mHouseInfoViewController.fillData(info.baseInfo);
        mHouseDescViewController.fillData(info.desc);
    }

    private HouseInfo initDefaultData() {
        HouseInfo info = new HouseInfo();

        List<String> photos = new ArrayList<>();
        photos.add("http://cdn.mse.mlwplus.com/avenger/mlw_default_18.jpg@540w.jpg");
        photos.add("http://cdn.mse.mlwplus.com/avenger/mlw_default_02.jpg@540w.jpg");
        info.photos = photos;

        HouseInfo.BaseInfo baseInfo = new HouseInfo.BaseInfo();
        baseInfo.owner = "叶龙";
        baseInfo.area = "115㎡";
        baseInfo.year = "70年";
        baseInfo.city = "武汉";
        baseInfo.address = "保利上城";
        baseInfo.createTime = "2016-11-15";
        info.baseInfo = baseInfo;

        info.desc = "小区离宋家庄地铁站只有100米距离，宋家庄是一个交通枢纽，\n" +
                "有地铁5号线10号线还有亦庄线，所以说交通非常方便\n" +
                "房子是一个三居室，出租主卧，房间里面很干净，家电齐全，可以拎包入住\n" +
                "小区周边有多个大型超市和商场，有首开福茂，美廉美超市，物美超市等等生活和购物都很方便\n" +
                "要求租客有正当工作，下班不要打扰邻居间的休息，别扰民就行";

        return info;
    }
}
