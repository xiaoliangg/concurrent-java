package com.current.jcip.chapter03.sect0302;

/**
 * 048_3.2_？？this引用逸出
 * 使用工厂方法防止this引用在构造过程中逸出
 *
 */
public class SafeListener {
    private final EventListener listener;

    //构造函数
    private SafeListener(){
        listener = new EventListener(){
            public void onEvent(Event e){
                doSomething(e)
            }
        };
    }

    public static SafeListener newInstance(EventSource source){
        SafeListener safeListener = new SafeListener();
        source.registerListener(safeListener.listener);
        return safeListener;
    }

}
