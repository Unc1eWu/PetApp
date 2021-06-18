package com.project.petApp.util;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.widget.TextView;

/**
 * 字体相关操作工具类
 *
 */
public class TypefaceUtil {
    // 上下文
    private Context mContext;
    private Typeface mTypeface;

    /**
     * 如果ttfPath为null那么mTypeface就为系统默认值
     *
     * @param context
     * @param ttfPath
     */

    public TypefaceUtil(Context context, String ttfPath) {
        mContext = context;
        mTypeface = getTypefaceFromTTF(ttfPath);
    }

    /**
     * 从ttf文件创建Typeface对象
     *
     * @ttfPath "fonts/XXX.ttf"
     */
    public Typeface getTypefaceFromTTF(String ttfPath) {

        if (ttfPath == null) {
            return Typeface.DEFAULT;
        } else {
            return Typeface.createFromAsset(mContext.getAssets(), ttfPath);
        }
    }

    /**
     * 设置TextView的字体
     *
     * @tv TextView对象
     * @ttfPath ttf文件路径
     * @isBold 是否加粗字体
     */
    public void setTypeface(TextView tv, boolean isBold) {
        tv.setTypeface(mTypeface);
        setBold(tv, isBold);
    }

    /**
     * 设置字体加粗
     */
    public void setBold(TextView tv, boolean isBold) {
        TextPaint tp = tv.getPaint();
        tp.setFakeBoldText(isBold);
    }

    /**
     * 设置TextView的字体为系统默认字体
     *
     */
    public void setDefaultTypeFace(TextView tv, boolean isBold) {
        tv.setTypeface(Typeface.DEFAULT);
        setBold(tv, isBold);
    }

    /**
     * 设置当前工具对象的字体
     *
     */
    public void setmTypeface(String ttfPath) {
        mTypeface = getTypefaceFromTTF(ttfPath);
    }

}
