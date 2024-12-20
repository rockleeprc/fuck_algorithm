package com.example.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private static final float factory = 0.75F;
    private final int CAPACITY;

    public LRUCache(int capacity) {
        // 向上取整 ceil floor round
        // true：最近访问的在头部
        super((int) (Math.ceil(capacity / factory) + 1), factory, true);
        this.CAPACITY = capacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // map中数据量大于CAPACITY时，删除
        return size() > CAPACITY;
    }

    public static void main(String[] args) {
        double random = Math.random();
        System.out.println(random);
        System.out.println(2+random*10000);
    }
}
