package top.knos.jdk21.SequencedCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class SequencedCollectionsExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // 添加元素
        list.add("A");
        list.add("B");
        list.add("C");

        // 遍历SequencedArrayList
        System.out.println("Sequenced List");
        for (String element : list) {
            System.out.println(element);
        }

        SortedMap<Integer,String> map = new TreeMap<>() ;

        // 添加元素
        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");

        // 遍历SequencedArrayList
        System.out.println("Sequenced map");
        for (var element : map.entrySet()) {
            System.out.println(element);
        }
    }
}
