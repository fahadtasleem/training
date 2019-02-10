package org.training.training_main.collections;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Iterating {
	static interface Cache{
    void set(String k,Integer v);
    Integer get(String key);
    
}

    static class CacheImpl implements Cache{
    private int capacity;
    private int occupied;
    private Map<String,Value> cacheMap;
    
    public CacheImpl(int capacity){
        this.capacity = capacity;
        cacheMap = new HashMap<String,Value>();
        occupied = 0;
    }
    
    private void removeLeastUsedItem(){
        Date d = null;
        String leastKey = null;
        for(String key: cacheMap.keySet()){
            Value v = cacheMap.get(key);
            if(d == null || d.getTime()<v.getUpdatedAt().getTime()){
                d = v.getUpdatedAt();
                leastKey = key;
            }
        }
        cacheMap.remove(leastKey);
        --occupied;
    }
    
    
    public void set(String k,Integer v){
        if(!cacheMap.containsKey(k)){
            if(occupied >= capacity){
            // TODO clear
                removeLeastUsedItem();
            }  
            ++occupied;
        }
        cacheMap.put(k,new Value(v));
        
    }
    
    public Integer get(String key){
        Value v = cacheMap.get(key);
        if(v == null){
            return -1;
        }
        return v.getValue();
    }
    
    class Value{
        private int value;
        private Date usedAt;
        
        Value(int value){
            this.value = value;
            usedAt = new Date();
        }
        
        private void updatedAt(){
            usedAt = new Date();
        }
        
        void setValue(int value){
            this.value = value;
            updatedAt();
        }
        int getValue(){
            updatedAt();
            return this.value;
        }
        Date getUpdatedAt(){
            return usedAt;
        }
    }
}

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Cache c = new CacheImpl(2);
        System.out.println(c.get("a"));
        c.set("a", 12);
        c.set("b", 14);
        System.out.println(c.get("a"));
        c.set("c", 15);
        c.set("c", 16);
    }
}