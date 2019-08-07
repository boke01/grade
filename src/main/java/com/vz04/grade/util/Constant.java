package com.vz04.grade.util;

/**
 * 常量池
 *
 * @author vz04
 * @date 7/27/2019 12:45 PM
 **/

public final class Constant {
    private Constant() {

    }

    /**
     * 登录相关常量
     */
    public static final String USER_NOT_EXIST = "用户不存在";
    public static final String LOGIN_SUCCESS = "登录成功";
    public static final String WRONG_PASSWORD = "密码错误";
    public static final String EXIT_SUCCESS = "退出成功";
    public static final String HAVE_NO_RIGHT = "没有权限";
    public static final String PLEASE_LOGIN = "请登录";

    /*
     * Meg状态码
     */
    /**成功*/
    public static final int SUCCESS = 200;
    /**未授权*/
    public static final int UNAUTHORIZED = 401;
    /**失败*/
    public static final int DEFEATED = 400;

    /**
     * 操作常量
     */
    public static final String ADD_OPERATION_SUCCESSFUL = "添加操作成功";
    public static final String ADD_OPERATION_DEFEATED = "添加操作失败，传入值有误，或添加值已存在";
    public static final String ADD_NOTICE_DEFATED = "添加操作失败，传入值有误，或班级不存在";

    public static final String DELETE_OPERATION_SUCCESSFUL = "删除操作成功";
    public static final String DELETE_OPERATION_DEFEATED = "删除操作失败";

    public static final String ALTER_OPERATION_SUCCESSFUL = "修改操作成功";
    public static final String ALTER_OPERATION_DEFEATED = "修改操作失败，传入值有误，或修改值已存在";

    public static final String CHECK_OPERATION_SUCCESSFUL = "查询操作成功";

}
