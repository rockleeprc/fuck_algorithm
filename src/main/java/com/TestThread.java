package com;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @see java-juc
 */
@Deprecated
public class TestThread {

    public static void main(String[] args) throws Exception {
        Queue<String> q = new LinkedList<>();
        q.poll();
    }
}
