package com.inwin8.sdk.platform;

/**
 * 文件名：JniCallback.java
 * 
 * 文件描述：定义 Java 回调 C++ 的 Native 方法，用于向 C++ 返回 listener 收到的结果。
 * 
 * 创建人：wayne 2013-12-28
 *
 * 版本号: 0.1
 *
 * 修改记录：
 * 
 */

public class JniCallback {

	/**
	 * 函数名：nativeInitResultCallback
	 * 
	 * 功能描述：
	 * 		初始化sdk结束后的回调
	 * 
	 * 返回值：
	 * 
	 * 参数：
	 * 		@param code 返回码
	 * 		@param msg 返回消息
	 * 
	 * 异常：
	 * 
	 * 作者：wayne 2013-12-28
	 * 
	 */
    public static native void nativeInitResultCallback(int code, String msg);
    
	/**
	 * 函数名：nativeLoginResultCallback
	 * 
	 * 功能描述：
	 * 		登录结束后的回调
	 * 
	 * 返回值：
	 * 
	 * 参数：
	 * 		@param code 返回码
	 * 		@param msg 返回消息
	 * 
	 * 异常：
	 * 
	 * 作者：wayne 2013-12-28
	 * 
	 */
    public static native void nativeLoginResultCallback(int code, String msg);
    
	/**
	 * 函数名：nativeLogoutCallback
	 * 
	 * 功能描述：
	 * 		退出登录后的回调
	 * 
	 * 返回值：
	 * 
	 * 参数：
	 * 		@param code 返回码
	 * 		@param msg 返回消息
	 * 
	 * 异常：
	 * 
	 * 作者：wayne 2013-12-28
	 * 
	 */
    public static native void nativeLogoutCallback(int code, String msg);
    
	/**
	 * 函数名：nativePayCallback
	 * 
	 * 功能描述：
	 * 		退出登录后的回调
	 * 
	 * 返回值：
	 * 
	 * 参数：
	 * 		@param code 返回码
	 * 		@param orderId 订单id
	 * 		@param orderAmount 订单数量（因为主要以二级货币兑换为主，故只提供此支付接口）
	 * 		@param payWayId 支付渠道的id
	 * 		@param payWayName 支付渠道的名字
	 * 
	 * 异常：
	 * 
	 * 作者：wayne 2013-12-28
	 * 
	 */
    public static native void nativePayCallback(int code, String orderId, float orderAmount, int payWayId, String payWayName);
    
	/**
	 * 函数名：nativeFloatMenuCallback
	 * 
	 * 功能描述：
	 * 		有些渠道会有一个floatbutton，此为floatbtn显示调用的回调
	 * 
	 * 返回值：
	 * 
	 * 参数：
	 * 		@param code 返回码
	 * 		@param msg 返回消息
	 * 
	 * 异常：
	 * 
	 * 作者：wayne 2013-12-28
	 * 
	 */
    public static native void nativeFloatMenuCallback(int code, String msg);
    
	/**
	 * 函数名：nativeUserCenterCallback
	 * 
	 * 功能描述：
	 * 		有些渠道会有用户中心，此为用户中心显示调用的回调
	 * 
	 * 返回值：
	 * 
	 * 参数：
	 * 		@param code 返回码
	 * 		@param msg 返回消息
	 * 
	 * 异常：
	 * 
	 * 作者：wayne 2013-12-28
	 * 
	 */
    public static native void nativeUserCenterCallback(int code, String msg);

	/**
	 * 函数名：nativeEnterUICallback
	 * 
	 * 功能描述：
	 * 		用户从当前activity切回gl线程时的调用
	 * 		可能出现的情况 
	 * 			1 纹理被卸载，需要再次加载
	 * 			2 声音被暂停，需要再次开启
	 * 			3 欢迎补充
	 * 返回值：
	 * 
	 * 参数：
	 * 		@param code 返回码
	 * 		@param msg 返回消息
	 * 
	 * 异常：
	 * 
	 * 作者：wayne 2013-12-28
	 * 
	 */
    public static native void nativeEnterUICallback(int code, String msg);

    

}