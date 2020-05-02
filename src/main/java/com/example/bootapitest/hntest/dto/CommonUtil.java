package com.example.bootapitest.hntest.dto;

public class CommonUtil {

    private CommonUtil() {
    }

    private static CommonUtil instance = new CommonUtil();

    public static CommonUtil getInstance() {
        return instance;
    }


    /**
     * 关闭资源或数据库连接
     * 2018-03-28 add
     *
     * @param resource
     * @return
     */
    public static void closeResources(AutoCloseable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (Throwable e) {
            }
        }
    }
}
