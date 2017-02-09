package com.cyb.mbean;

import java.lang.reflect.Field;

import sun.misc.Unsafe;
/***
 * 本机直接内存溢出
 * Java虚拟机可以通过参数-XX:MaxDirectMemorySize设定本机直接内存可用大小，
 * 如果不指定，则默认与java堆内存大小相同。JDK中可以通过反射获取Unsafe类(Unsafe的getUnsafe()方法只有启动类加载器Bootstrap才能返回实例)直接操作本机直接内存。
 * 通过使用-XX:MaxDirectMemorySize=10M，限制最大可使用的本机直接内存大小为10MB，例子代码如下
 * @author DHUser
 *
 */

public class DirectMemoryOOM {
	private static final int _1MB = 1*1024 * 1024;
	public void directMemoryOOM() throws IllegalArgumentException, IllegalAccessException{
		int i=0;
	    Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            // unsafe直接想操作系统申请内存
            unsafe.allocateMemory(_1MB);
            System.out.println(i+++"MB");
        }
	}
    public static void main(String[] args) throws Exception {
       new DirectMemoryOOM().directMemoryOOM();
       
    }

}