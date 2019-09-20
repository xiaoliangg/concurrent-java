package com.current.jcip.chapter03.sect0302;

import java.util.EventListener;

/**
 * 048_3.2_？？this引用逸出
 * this 引用逸出的错误示例
 * 内部类自动持有外部类的this引用
 */
public class ThisEscape {
    public ThisEscape(EventSource source){
        source.registListner(
                new EventListener(){
                    public void onEvent(Event e){
                        doSomething(e);
                    }
                }
        );
    }
}
