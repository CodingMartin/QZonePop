package com.jhd.mq.blur;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author:Martin
 * Date:2016/9/26
 */

public class Bean {


    public String text;

    public int image;

    public Bean(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public static List<Bean> getData() {
        List<Bean> list = new ArrayList<>();
        list.add(new Bean(R.mipmap.skin_tabbar_btn_popup_camera, "拍照"));
        list.add(new Bean(R.mipmap.skin_tabbar_btn_popup_photo_story, "相册"));
        list.add(new Bean(R.mipmap.skin_tabbar_btn_popup_place, "位置"));
        list.add(new Bean(R.mipmap.skin_tabbar_btn_popup_qzcamera, "说说"));
        list.add(new Bean(R.mipmap.skin_tabbar_btn_popup_video_upload, "视屏"));
        list.add(new Bean(R.mipmap.skin_thirdparty_btn_popup_2dbarcode, "直播"));
        list.add(new Bean(R.mipmap.skin_thirdparty_btn_popup_camera, "签到"));
        list.add(new Bean(R.mipmap.skin_thirdparty_btn_popup_photostory, "动感影集"));
//        list.add(new Bean(R.mipmap.skin_thirdparty_btn_popup_place, "日志"));
//        list.add(new Bean(R.mipmap.skin_thirdparty_btn_popup_videocamera, "动效相机"));
//        list.add(new Bean(R.mipmap.skin_thirdparty_btn_popup_videoupload, "贴纸相机"));
//        list.add(new Bean(R.mipmap.skin_tabbar_btn_popup_camera, "语音相机"));
//        list.add(new Bean(R.mipmap.skin_tabbar_btn_popup_camera, "二维码"));
        return list;
    }
}
