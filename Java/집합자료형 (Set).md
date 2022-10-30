# Set

`Set<E> 객체명 = new HashSet<E>();`

Set 자료형에는 `HashSet`, `TreeSet`, `LinkedHashSet`등이 있습니다. Set은 List와 다르게 객체(데이터)를 중복해서 저장할 수 없습니다. 더불어 저장된 데이터를 인덱스로 관리하지 않아 저장 순서가 순서대로 저장되지 않습니다 대신 TreeSet은 오름차순으로 값을 정렬하여 저장하며, LinkedHashSet은 입력한 순서대로 값을 정렬하여 저장하는 특징이 있습니다.

- 중복 저장이 되지 않습니다.
- 순서가 지켜지지 않습니다. 데이터가 출력될때 뒤죽박죽으로 나오게 됩니다.
    - 반면에 리스트나 배열은 인덱스로 순서가 관리 되어 값을 얻을 수 있습니다.
    - Set과 마찬가지로 Map역시 인덱싱으로 관리되지 않아 순서대로 자료를 출력 할 수 없습니다.
- Set은 중복을 허용하지 않는 특징 땜누에, 자료형의 중복을 제거할때 필터로 종종 사용됩니다.
- 데이터를 검색하기 위해서는 iterator로 반복자를 생성하고 데이터를 가져와야 합니다.

```java
import java.util.Arrays;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>(Arrays.asList("안", "녕", "하", "시", "안"));
        System.out.println(set);  //  [녕, 안, 하, 시] 출력
    }
}
```

### 1. 두 집합의 교집합 구하기

```java
import java.util.Arrays;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet<Integer> number1 new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        HashSet<Integer> number2 new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));

        HashSet<Integer> intersection = new HashSet<>(number1);  // number1으로 iintersection을 생성하였습니다.
        intersection.retainAll(number2);  // 교집합 수행
        System.out.println(intersection);  // [4, 5, 6] 출력
    }
}
```

- `retainAll(Collection)`는 HashSet의 요소들을 Collection 인자의 요소들과 비교하여 동일한 요소는 HashSet에 남기고 그 외의 요소들은 제거합니다

### 2. **두 집합의 합집합 구하기**

```java
import java.util.Arrays;
import java.util.HashSet;

public class Test{
    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet(Arrays.asList(1,2,3,4,5,6));
        HashSet<Integer> s2 = new HashSet(Arrays.asList(4,5,6,7,8,9));
        
        HashSet<Integer> union = new HashSet<>(s1);
        union.addAll(s2);
        System.out.println(union);
                                      
    }
}
```

- addAll() : 합집합을 구할 수 있다. 두 집합의 원소들을 합한 집합을 만든다. 집합이므로 중복된 원소는 1개만 포함된다.

### 3. 두 집합의 차집합 구하기

```java
import java.util.Arrays;
import java.util.HashSet;

public class Sample {
    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6));
        HashSet<Integer> s2 = new HashSet<Integer>(Arrays.asList(4,5,6,7,8,9));
        
        HashSet<Integer> union = new HashSet<>(s1); //s1으로 union생성
        union.removeAll(s2);
        System.out.println(union);
                                                 
    }
}

```

- removeAll() : 차집합을 구할 수 있다. 인수로 주는 집합이 포함된 동일한 원소들을 제거한다.

### 4. **부분 집합여부 구하기**

```java
import java.util.Arrays;
import java.util.HashSet;

public class Sample {
    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6));
        HashSet<Integer> s2 = new HashSet<Integer>(Arrays.asList(4,5,6));
				HashSet<Integer> s3 = new HashSet<Integer>(Arrays.asList(9,8,7,6));
        
        System.out.println(s1.containsAll(s2)); //true
				System.out.println(s1.containsAll(s3)); //false
                                                 
    }
}
```

- containsAll() : 부분집합인지 여부를 구할 수 있다.
    - 인수로 주는 집합(s2, s3)이 부분 집합이면 true이다.

### 관련 메소드

---

- 값을 추가 할 때는 add 메소드를 사용한다.
- 값 여러개를 추가 할때는 위와 같이 addAll(Arrays.asList(1,2,3,4,5,6)) or addAll(Arrays.asList(”안녕”,”하세요”)) addAll메소드를 사용한다.
- 특정 값을 제거 할 때는 remove 메소드를 사용 한다.

```java
import java.util.Arrays;
import java.util.HashSet;

public class Sample {
    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet<Integer>(Arrays.asList(1,2,3,4,5));

        s1.add(9);
        s1.addAll(Arrays.asList(99,88,77));
        System.out.println("add + addAll : "+s1); //add + addAll : [1, 2, 3, 99, 4, 5, 88, 9, 77]
        s1.remove(99);
        System.out.println("remove : "+s1); //remove : [1, 2, 3, 4, 5, 88, 9, 77]
                                                 
    }
}
```

## 🔗 Reference

[https://wikidocs.net/157108](https://wikidocs.net/157108)

[https://godog.tistory.com/entry/Java-HashSet-합집합-차집합-교집합-부분집합](https://godog.tistory.com/entry/Java-HashSet-%ED%95%A9%EC%A7%91%ED%95%A9-%EC%B0%A8%EC%A7%91%ED%95%A9-%EA%B5%90%EC%A7%91%ED%95%A9-%EB%B6%80%EB%B6%84%EC%A7%91%ED%95%A9)