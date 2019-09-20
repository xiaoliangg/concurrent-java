package com.current.jcip.chapter04.sect040305;


import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 072_4.3.5_srcCode_！！？_示例:发布状态的车辆追踪器
 */
//@ThreadSafe
public class PublishingVehicleTracker {
    private final Map<String,SafePoint> locations;
    private final Map<String,SafePoint> unmodifiableMap;

    public PublishingVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }

    public Map<String,SafePoint> getLocations(){
        return unmodifiableMap;
    }
    public SafePoint getLocation(String id){
        return locations.get(id);
    }

    public void setLocation(String id,int x,int y){
        if(!locations.containsKey(id))
            throw new IllegalArgumentException("invalid vehicle name:" + id);
        locations.get(id).set(x,y);
    }
}
