//package com.tc.tccp.core.annotation; 
//
//import java.lang.annotation.Documented;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Inherited;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//import com.tc.tccp.core.enumtype.AuthorityType;
//
///** 
// * @author wangpei 
// * @version 
// *创建时间：2017年3月1日 下午9:26:15 
// * 类说明 
// */
//@Documented
//@Inherited
//@Target(ElementType.METHOD)//指示注释类型所适用的程序元素的种类,此处用于描述方法
//@Retention(RetentionPolicy.RUNTIME)//类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用.
//public @interface Authority {
//	AuthorityType authority() default AuthorityType.TOURIST;
//}
// 