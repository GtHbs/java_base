package com.thinking.innerstudycollection.interfaceimpl.map;

import com.thinking.innerstudycollection.interfaceimpl.testframework.Test;
import com.thinking.innerstudycollection.interfaceimpl.testframework.TestParam;
import com.thinking.innerstudycollection.interfaceimpl.testframework.Tester;

import java.util.*;

/**
 * @Author 李昭
 * @Date 2020/6/30 08/09
 */
public class MapPerformance {
    static List<Test<Map<Integer, Integer>>> tests = new ArrayList<>();

    static {
        tests.add(new Test<Map<Integer, Integer>>("put") {
            @Override
            public int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    map.clear();
                    for (int j = 0; j < size; j++) {
                        map.put(j, j);
                    }
                }
                return loops * size;
            }
        });

        tests.add(new Test<Map<Integer, Integer>>("get") {
            @Override
            public int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size * 2;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < size; j++) {
                        map.get(j);
                    }
                }
                return loops * size;
            }
        });


        tests.add(new Test<Map<Integer, Integer>>("iterate") {
            @Override
            public int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                return loops * map.size();
            }
        });
    }

    public static void main(String[] args) {
        Tester.defaultParams = TestParam.array(4);
        Tester.run(new TreeMap<>(), tests);
        Tester.run(new HashMap<>(), tests);
        Tester.run(new LinkedHashMap<>(), tests);
        Tester.run(new IdentityHashMap<>(), tests);
        Tester.run(new WeakHashMap<>(), tests);
        Tester.run(new Hashtable<>(), tests);
    }
}
