package com.project.world.lean.over;

import java.util.ArrayList;
import java.util.List;

/*TODO set -Xms10m -Xmx10m 否则等好久内容才能被跑满*/
public class HeapOutOfMemoryTest {
    
    public static void main(String[] args) {
        List list = new ArrayList<>();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            list.add(new HeapOutOfMemoryTest());

            if(i % 10000 == 0){
                System.out.println(i);
            }
        }

    }
}
