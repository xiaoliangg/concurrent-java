package com.current.jcip.chapter04.sect040301;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 068_4.3.1_srcCode_！！！？？基于委托的车辆追踪器_版本二
 * 1、为什么是 ConcurrentHashMap？答:因为有并发读写
 * 2、线程安全性委托给了线程安全类ConcurrentHashMap
 */
//@ThreadSafe
public class DelegatingVehicleTracker {
    private final ConcurrentMap<String,Point> locations;
    private final Map<String,Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        this.locations = new ConcurrentHashMap<>(points);
        this.unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String,Point> getLocations(){
        //返回实时视图
        return unmodifiableMap;
        //返回不动态变化的车辆视图
//        return Collections.unmodifiableMap(new HashMap<String,Point>(locations));
    }
    public Point getLocation(String id){
        return locations.get(id);
    }

    public void setLocation(String id,int x,int y){
        if(locations.replace(id,new Point(x,y)) == null){
            throw new IllegalArgumentException("invalid vehicle name:" + id);
        }
    }
}
