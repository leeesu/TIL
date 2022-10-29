## Scanner

---

- 자바에서 가장 기본적이고, 대중적으로 사용되는 입출력 방식입니다.
- Scanner는 정수, 실수, 문자열 모두를 읽어 올 수 있습니다.
    - Scanner객체를 생성하고나서 메소드를 사용 할때 .nextInt, nextDoble식으로 데이터 타입에 맞게 사용 할 수 있습니다.
    - 문자열 전체를 받는것은 nextLine(), 공백 이전까지의 문자열을 받는 메소드는 next()입니다.
        - nextLine은 ‘다리 건너 바다 건너’ 라고 입력하면 한 문장 전부를 가져옵니다
        - next는 공백 이전의 문자열이기에 ‘다리’ 한 글자만 가져오게 됩니다.
- 사용하기 위해서는 import를 통해서 외부 클래스를 호출합니다.
    - java.util.Scanner;
- Scanner scan = new Scanner(System.in);
    - 이런 형식으로 객체생성을 하는데 여기서 System.in은 입력한 값을 바이트 단위로 읽는 것을 뜻합니다.

### 예제 :

값을 입력받아서 a+b를 구한다면 다음과 같이 구현할 수 있습니다.

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        System.out.println(a+b);
    }
}
```

## 참고사항

---

- nextLine의 경우 어떤 값을 입력받을 때, 공백까지 저장합니다.
- 이 부분을 유의해서 사용해야하는데 다음의 예제를 살펴보면 next에서 1이 입력되고 Enter를 치면 nextLine은 이 enter를 한줄 읽는다는 특징의 개행으로 인식하고 저장되어 버립니다.
- 그래서 next와 nextLine을 병행해서 사용 할때는 유의해서 써야 하며, 만약 두개를 혼용해서 씁니다.면 둘의 사이에 nextLine을 추가해주도록 합니다.

```java
importjava.util.Scanner;

public classMain{

    public static void main(String[]args) {

Scannerscan = new Scanner(System.in);
Stringnext = scan.next();
StringnextLine = scan.nextLine();

System.out.println(next);
System.out.println(nextLine);
    }

//입력값 3, 3을 입력하고 엔터를 치는순간 한줄 개행으로 인식해 종료되어 버린다.
//출력값 3

}
```

- nextLine  추가

```java
importjava.util.Scanner;

public classMain{

    public static void main(String[]args) {

Scanner scan = new Scanner(System.in);
String next = scan.next();
String n = scan.nextLine();
String nextLine = scan.nextLine();

System.out.println(next+n+nextLine);

    }
/*
입력값 3,1
출력값 31

입력값 대한,민국
출력값 대한민국.

*/
}

```

### 🔗 Reference

[https://st-lab.tistory.com/92](https://st-lab.tistory.com/92)