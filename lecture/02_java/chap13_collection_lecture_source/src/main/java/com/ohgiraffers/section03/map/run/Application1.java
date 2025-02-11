package com.ohgiraffers.section03.map.run;

import com.ohgiraffers.section01.list.dto.BookDTO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. Map의 자료구조에 대해 이해하고 HashMap을 이용할 수 있다. */
        // key를 통해 value값을 추출
        Map<Object, Object> hMap = new HashMap<>();
        hMap.put(new String("one"), new java.util.Date());
        hMap.put(12, "apple");
        hMap.put(3.14, 159);

        /* 설명. Map은 key를 통해 value를 뽑는 것이 기본적이며 key는 객체의 동등 비교(e, h)를 통해 확인된다. */
        // 객체가 달라도 동등 비교를 통해 같은 키로 받아들이며 value를 반환
        // key값을 동등 비교를 통해 확인
        System.out.println(hMap.get(new String("one")));
        System.out.println("hMap = " + hMap);

        /* 목차. 1. key가 중복되는 경우 */
        /* 설명. 사용자가 만든 객체도 key로 사용할 수 있으며 이때 해당 객체는 e, h가 반드시 오버라이딩 되어 있어야 한다. */
        // -> 키값이 중복되는 것을 막기 위해
        // 동등 비교가 안되면 키값이 동일하여도 들어간다. (e,h 오버라이드가 안되어있기에)
        // 오버라이딩을 하면 동일 키값은 하나만 들어가게 된다.
        // 키는 먼저 들어온 놈이, value는 계속 업데이트
        hMap.put(new BookDTO(1,"홍길동전", "허균", 30000), 10);
        hMap.put(new BookDTO(3,"홍길동전", "허균", 30000), 2);
        System.out.println("hMap = " + hMap);

        /* 목차. 2. value가 중복되는 경우 */
        // key값이 다르면 value는 동일해도 문제 없다.
        hMap.put(4, 159);
        System.out.println("hMap = " + hMap);
        //key 값이 같으면 value를 덮어쓴다.
        hMap.put(3.14, 0);
        System.out.println("hMap = " + hMap);

        /* 설명. Map을 활용해 보자. */
        Map<String, String> hMap2 = new HashMap<>();
        hMap2.put("one", "java17");
        hMap2.put("two", "mariaDB 10");
        hMap2.put("three", "servlet/jsp");
        hMap2.put("four", "springboot 3.0");
        hMap2.put("five", "vue");

        System.out.println("hMap2 = " + hMap2);
        
        /* 설명. Map에 담긴 값을 순회해서 확인하는 방법 */
        /* 목차.  1. keySet()을 활용해 key를 Set으로 바꾸고 iterator를 돌리는 방법 */
        // key를 set으로 바꿔서 조회
        Set<String> keys = hMap2.keySet();
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()){
            String key = iter.next();
            System.out.println("key = " + key + ", value = " + hMap2.get(key));
        }

        /* 목차. 2. entrySet()을 활용하는 방법(key와 value를 묶은 Entry 타입을 통해 key없이도 value만 추출 가능 */
        // entry 타입: <key, value> 쌍
        Set<Map.Entry<String, String>> set = hMap2.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
    }
}
