package com.example.bootapitest.jdknew.two;

import com.google.common.collect.Maps;

import java.util.Map;


/**
 * 全局配置类
 * huang
 */
public class Global {

    /**
     * 订单间隔分钟数未支付自动取消
     */
    public static final Integer ORDER_WAIT_BUYER_PAY_MINUTES = 0;
    /**
     * 订单间隔小时未支付自动取消
     */
    public static final Integer ORDER_WAIT_BUYER_PAY_HOUR = 4;

    public static boolean isProduct = false;    // true 正式     false 测试

    /**
     * 当前对象实例
     */
    private static Global global = new Global();

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = Maps.newHashMap();

    /**
     * 属性文件加载对象
     */

    /**
     * 显示/隐藏
     */
    public static final String SHOW = "1";
    public static final String HIDE = "0";

    /**
     * 是/否
     */
    public static final String YES = "1";
    public static final String NO = "0";

    /**
     * 对/错
     */
    public static final String TRUE = "true";
    public static final String FALSE = "false";

    /**
     * 获取当前对象实例
     */
    public static Global getInstance() {
        return global;
    }



    /**
     * 页面获取常量
     */
    public static Object getConst(String field) {
        try {
            return Global.class.getField(field).get(null);
        } catch (Exception e) {
            // 异常代表无配置，这里什么也不做
        }
        return null;
    }
}
