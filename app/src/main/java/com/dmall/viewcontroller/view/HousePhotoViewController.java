package com.dmall.viewcontroller.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dmall.viewcontroller.R;
import com.dmall.viewcontroller.base.ViewController;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 房屋图片组件
 * Created by yelong on 2016/11/7.
 * mail:354734713@qq.com
 */

public class HousePhotoViewController extends ViewController<List<String>> {

    @Bind(R.id.housePhotoViewPager)
    ViewPager mViewPager;

    private PhotoAdapter mPhotoAdapter;

    public HousePhotoViewController(Context context) {
        super(context);
    }

    @Override
    protected int resLayoutId() {
        return R.layout.view_house_photo;
    }

    @Override
    protected void onCreatedView(View view) {
        ButterKnife.bind(this, view);
        mPhotoAdapter = new PhotoAdapter();
        mViewPager.setAdapter(mPhotoAdapter);
    }

    @Override
    protected void onBindView(List<String> data) {
        mPhotoAdapter.setData(data);
    }

    private class PhotoAdapter extends PagerAdapter {

        private List<View> mPhotoViews;
        private List<String> mPhotoUrls;

        public PhotoAdapter() {
            mPhotoViews = new ArrayList<>();
            mPhotoUrls = new ArrayList<>();
        }

        private void setData(List<String> photoUrls) {
            mPhotoUrls = photoUrls;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mPhotoUrls.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(getContext()).load(mPhotoUrls.get(position)).into(imageView);
            container.addView(imageView);
            mPhotoViews.add(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mPhotoViews.get(position));
        }
    }
}
