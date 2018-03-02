package com.example.bootapitest.people.service;

import com.example.bootapitest.people.entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BaseRestController {

    @Value("${version}")
    protected String version;    //版本属性配置（application.properties）

    /**
     * 日期类型的绑定方法
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    public static Result success(Object data){
        return success(200, data);
    }

    public static Result success(int status, Object data){
        return success(true, status, data);
    }

    public static  Result success(boolean success, int status, Object data){
        return new Result(success).data(data).status(status);
    }

    public static Result error(Object error){
        return error(400, error);
    }

    public static Result error(int status, Object error){
        return error(false, status, error);
    }

    public static Result error(boolean sucess, int status, Object error){
        return new Result(false).error((String) error).status(status);
    }

    public static List<String> getSkillsAndTags(List<String> source) {
        if (null != source && 0 < source.size()) {
            if (3 < source.size()) {
                return source.subList(0, 3);
            } else {
                return source;
            }
        }
        return new ArrayList<>();
    }


}
