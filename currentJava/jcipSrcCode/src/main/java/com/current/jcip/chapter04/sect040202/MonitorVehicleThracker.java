package com.current.jcip.chapter04.sect040202;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * locations 属性是非线程安全的，但是会被进行实例封闭，且所有的相关操作都需要MonitorVehicleThracker的内置锁保护
 * 缺点:1、车辆容器非常大时会降低性能
 * 2、由于每次调用getLocation就要副号数据，因此将出现一种错误情况:实际位置发生变化时，但返回的信息保持不变
 */
//@ThreadSafe
public class MonitorVehicleThracker {

    private final Map<String,MutablePoint> locations;

    public MonitorVehicleThracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String,MutablePoint> getLocations(){
        return deepCopy(locations);
    }
    public synchronized MutablePoint getLocation(String id){
        MutablePoint loc = locations.get(id);
        return loc == null?null:new MutablePoint(loc);
    }
    public synchronized void setLocation(String id,int x,int y){
        MutablePoint loc = locations.get(id);
        if(loc == null){
            throw new IllegalArgumentException("no such id:" + id);
        }
        loc.x = x;
        loc.y = y;
    }

    private Map<String,MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String,MutablePoint> result = new HashMap<>();
        for(String id:m.keySet()){
            result.put(id,new MutablePoint(m.get(id)));
        }
        //返回指定映射的不可修改视图。
        //理解:标记不可修改，防止修改，对安全性无影响
        return Collections.unmodifiableMap(result);
    }
}
