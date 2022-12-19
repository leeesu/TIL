## Stack (스택)

---

- Stack 영어로 쌓다. 스택은 가방과 같은 구조라고 생각하면 된다. **입구가 하나라서 제일 먼저 넣은 물건(객체)가 가장 아래에 위치**하므로 꺼낼 때는 가장 나중에 나온다.
- 나중에 넣은 데이터가 먼저 나오니까 Last In First Out (LIFO) 후입선출
- 바로 넣었다가 거꾸로 정렬된 데이터를 사용하고 꺼내 쓰고 싶을 때 유용하다.
- 자바는 기본적으로 Stack클래스를 지원해준다.
- 예) 가방에 물건을 넣고 꺼낼 쓸때를 생각하면 이해하기 쉽다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7a3d9921-df1c-4541-904e-bd1f583154a6/Untitled.png)

  

### 자바에서 지원하는 Stack클래스로 스택 활용

```jsx
import java.util.Stack;

public class StackBasic {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("s.empty() : "+ s.empty());
        for (int a : array) {
            s.push(a);
            System.out.println("s.peek() run : "+s.peek()); // 1,2,3,4,5,6,7,8,9,10 출력
        }
        System.out.println("s.pop() run : "+s.pop()); //10
        System.out.println("s.peek() run : "+s.peek()); //9
        System.out.println("s.empty() : "+ s.empty()); //false
        System.out.println(s.search(1)); //9

    }
}
```

### 배열로 스택 구현하기

```java
public class StackArray {

    int[] stack;
    int top;
    int size;

    public StackArray(int maxSize){
        top = -1;
        size = maxSize;
        stack = new int[size];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == (size -1));
    }

    public void push(int data){
        if(isFull()){
            System.out.println("stack overflow");
        }else {
            stack[++top] = data;
            System.out.println("add : "+ data);
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("stack underflow");
            return -1;
        } else {
            return stack[top];
        }
    }

    public int pop(){
        int pop = stack[top];
        top--;
        return pop;
    }
}

public class StackTest {

    public static void main(String[] args) {
        StackArray st = new StackArray(20);
        //push;
        System.out.println("push run");
        for(int i=1; i<11; i++){
            st.push(i);
        }
        //peek
        System.out.println("pop() run: "+st.pop());
        System.out.println("pop() run: "+st.pop());
        System.out.println("pop() run: "+st.pop());
        System.out.println("peek() run: "+st.peek());
        System.out.println("peek() run: "+st.peek());
    }
}

/* 출력값
push run
add : 1
add : 2
add : 3
add : 4
add : 5
add : 6
add : 7
add : 8
add : 9
add : 10
pop() run: 10
pop() run: 9
pop() run: 8
peek() run: 7
peek() run: 7
*/
```

- 데이터를 담을 배열을 선언해주고, 담겨진 데이터의 갯수를 알려줄 stack의 마지막 데이터의 인덱스 top를 -1로 선언한다.
- isEmpty() : top를 -1로 초기화 했기 때문에 변동없이 -1이라면 stack에 데이터가 비어 있음을 확인 할 수 있다.
- isFull() :  stack의 마지막 데이터의 인덱스인 top와 선언된 배열(0부터 시작하므로 -1)의 크기가 동일하다면 stack이 가득찬 상태임을 알 수 있다.
- push() : stack의 공간을 확인하고 top를 증가시킨 인덱스에 파라미터를 통해 받아온 데이터를 저장한다.
- pop(): 해당하는 데이터를  pop변수에 담아 출력시키고,  데이터를 삭제해준다.
- peek() : 데이터가 비어있는지 확인해본다음, 가장 위에 있는 데이터 top를 출력해준다.

## 회고

---

프로젝트를 하면서 써본건 List나 HashSet정도였는데 스택이라… 알고리즘 공부하면서 배우는 것라고만 생각했던 것 같은데. 이번 공부를 하면서 자료구조도 열심히 공부해야 학쎼다는 필요성을 느꼈다. 

코드를 작성하면서 제일 어려웠던 점은 기본 개념 자체는 아주 쉽게 숙지가 되었다. 스택이란 가방처럼 물건이 위로 쌓여지는 구조여서, 나중에 꺼낼때는 위에 있는 물건부터 나오게 되는 구조인 후입선출이라는 것.

개념은 빠삭하게 이해할 수 있었지만 이걸 직접 구현한다는게 막상 쉬운 거 같으면서도 하려니까 더없이 막막했다. 

앞으로 이런식의 구현을 자주 해봐야겠다… 그냥 막연하게 외우고 그때 그때 알고리즘에 활용하는 것 보다는 더 많이 생각해 볼 수 있는 기회가 되는 거 같다. 

## 🔗Reference

---

자바프로그래밍바이블