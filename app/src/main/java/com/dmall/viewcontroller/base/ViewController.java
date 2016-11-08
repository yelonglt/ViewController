package com.dmall.viewcontroller.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 复杂的页面组件化，实现模块开发和修改
 * Created by yelong on 2016/11/7.
 * mail:354734713@qq.com
 */

public abstract class ViewController<T> {
    private Context mContext;
    private View mView;
    private T mData;

    public ViewController(Context context) {
        mContext = context;
    }

    /**
     * 添加视图到根布局，即组件所添加的父视图
     *
     * @param root 父视图
     */
    public void attachRoot(ViewGroup root) {
        int resLayoutId = resLayoutId();
        if (resLayoutId <= 0) {
            throw new IllegalStateException("Please check your layout id in resLayoutId() method");
        }
        mView = LayoutInflater.from(mContext).inflate(resLayoutId, root, true);
        onCreatedView(mView);
    }

    /**
     * 填充数据
     *
     * @param data 数据
     */
    public void fillData(T data) {
        this.mData = data;
        if (mData != null) {
            onBindView(data);
        }
    }

    public Context getContext() {
        return mContext;
    }

    public View getView() {
        return mView;
    }

    public T getData() {
        return mData;
    }

    /**
     * 模块对应的视图
     *
     * @return 资源Id
     */
    protected abstract int resLayoutId();

    /**
     * 创建视图
     *
     * @param view 视图
     */
    protected abstract void onCreatedView(View view);

    /**
     * 数据和视图的绑定
     *
     * @param data 填充的数据
     */
    protected abstract void onBindView(T data);


}
