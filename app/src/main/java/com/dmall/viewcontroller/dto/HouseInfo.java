package com.dmall.viewcontroller.dto;

import java.util.List;

/**
 * 房屋信息
 * Created by yelong on 2016/11/7.
 * mail:354734713@qq.com
 */

public class HouseInfo extends BaseDto {

    public List<String> photos;
    public List<String> comments;
    public BaseInfo baseInfo;
    public String desc;

    public static class BaseInfo {
        public String owner;
        public String area;
        public String year;
        public String city;
        public String address;
        public String createTime;
    }

}
