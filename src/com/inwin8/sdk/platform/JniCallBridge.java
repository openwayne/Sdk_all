package com.inwin8.sdk.platform;

import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 文件名：JniCallBridge.java
 * 
 * 文件描述： 为方便进行c++/java/lua/js的调用，提供的一个通用方法，此方法传递为json传递 
 * 			json规则： 
 * 			{ 
 * 				'function':'',
 * 				'params':{} 
 * 			}
 * 
 * function 需要提前进行注册 创建人：wayne 2013-12-28
 * 
 * 版本号: 0.1
 * 
 * 修改记录：
 * 
 */
public class JniCallBridge {
	/**
	 * 一个类似句柄的蛋蛋
	 */
	private static JniCallBridge m_instance;
	
	/**
	 * 缓存函数的地方，key为函数名 value为
	 */
	private static Map<String, IJniCallFunc> m_cacheFunc;
	
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
	private JniCallBridge() {

	}

	/**
	 * 函数名：getInstance
	 * 
	 * 功能描述：
	 * 		获取句柄
	 * 
	 * 返回值：
	 * 		返回那个静态的蛋蛋
	 * 参数：
	 * 
	 * 异常：
	 * 
	 * 作者：wayne 2013-12-28
	 * 
	 */
	public static JniCallBridge getInstance() {
		if (null == m_instance) {
			m_instance = new JniCallBridge();
		}
		return m_instance;
	}
	
	public int callFunc(String jsonStr) {
		Object jsonObj = JSON.parse(jsonStr);
		
		String funcStr = (String) EasyTools.getFieldValueByName("function", jsonObj);
		
		IJniCallFunc jniFunc = m_cacheFunc.get(funcStr);
		
		if (null == jniFunc) {
			return JniCallBridgeEnum.NOFUNC.ordinal();
		}

		try {
			jniFunc.call(EasyTools.getFieldValueByName("params", jsonObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JniCallBridgeEnum.NOERR.ordinal();
	}
	
	public void regFunc(String funcName, IJniCallFunc funcObj) {
		if (null == funcName || null == funcObj) {
			System.out.print("maybe params is null");
			return;
		}
		m_cacheFunc.put(funcName, funcObj);
	}

}
