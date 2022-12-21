# Queue(큐)란

---

Queue는 자료구조의 한가지로 간단히 말하면, **들어간 순서대로 빠져나오는 자료구조**이다. 앞과 뒤가 뚫려서 한쪽 방향으로는 넣고 다른 한쪽 방향으로는 꺼내는 통에 비유할 수 있다. Queue의 구조는 도로의 일정구간인 일방통행과 같다고 보면 된다. 요소가 들어가는 입구와 요소가 나오는 출구가 따로 준비되어 가장 먼저 들어간 요소가 가장 먼저 나온다. first-in-first-out FIFO 선입선출방식으로 구성된다

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1add3d0c-a412-49e6-8bf9-fff0a230384a/Untitled.png)

<aside>
🤖 FIFO (first-int-first-out) → 먼저 저장된 데이터가 **먼저 빠져나간다**.

</aside>

- 스택과 반대의 구조다. 스택이 후입선출이라면 큐는 선입 선출의 구조를 가진다.
- 큐에는 front(앞쪽)와 rear(뒤쪽)이라는 포인터가 있는데 문자 그대로 front원소는 가장 먼저 큐에 들어온 첫 번 째 원소이고, rear원소는 늦게 들어온 원소를 가리킨다. 다른말로 front를 데이터를 가져 올 수 있는 위치를, rear는 데이터를 넣을 수 있는 위치를

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7f010be8-4d73-433d-a478-e6db08373afd/Untitled.png)

- front와 rear를 -1로 초기화 해준다.
- empty() : front와 rear가 front==rear 상태라면 Queue의 상태는 empty이므로 true가 출력된다.

```java
public class QueueArray {

    int rear;
    int front;
    int[] queue; // 데이터를 담을 배열
    int size; // 배열 길이 

    public QueueArray(int size) {
        this.rear = -1;
        this.front = -1;
        this.size = size;
        this.queue = new int[size];
    }
//empty check
public boolean isEmpty() {
        return (front == rear);
    }
```

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/84752373-6438-4cfd-b5c3-7b1577b7d491/Untitled.png)

- 삽입연산(Enqueue)가 두번 실행되었다. rear는 초기화로 선언되었던 -1에서 0을 거쳐 1로 이동. add(2)
- **Enqueue(int data)** : 큐의 가장 끝에 데이터가 삽입된다.
- isFull() : 삽입연산이 진행되기 전에 Queue에 할당된 영역이 포화 상태(Overflow)가 아닌지 확인한 다음 진행한다. 큐의 포화 상태를 확인하기 위해서는 배열의 마지막 인덱스에서 -1 해서 확인한다. (size -1)

```java
public boolean isFull() {

        return (rear == this.size-1);
    }

    public void enenqueue(int data){
        if(isFull()){
            System.out.println("queue over flow");
        }else {
            queue[rear++] = data;
        }
    }
```

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f4bb04f1-bbd9-4eb6-9831-eee9db797b7b/Untitled.png)

- 삽입연산 Enqueue가 두번 더 실행되었다. 2를 거쳐으로 이동 Queue안에 ABCD가 담겨 있다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3958c215-e6b9-4fe8-a6ac-c22b842c66d2/Untitled.png)

- 삭제연산 Dequeue가 실행되었다. front를 1 증가시켜서 해당 자리의 원소를 삭제한다.

```java
public int dequeue() {
        if (isEmpty()) {
            System.out.println("queue under flow ");
            return -1;
        } else {
            //front로 데이터 제거
            return queue[++front];
        }
    }
```

### 자바에서 지원하는 배열(Array)로 Queue구현 (전체)

```java
public class QueueArray {
    int rear;
    int front;
    int[] queue;
    int size;

    public QueueArray(int maxsize) {
        size = maxsize;
        queue = new int[size];
        rear = -1;
        front = -1;

    }

    //empty check
    public boolean isEmpty() {

        return (front == rear);
    }

    public boolean isFull() {

        return (rear == size - 1);
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("queue over flow");
        } else {
            //rear로 데이터 추가
            //rear를 1증가시킨 인덱스에 해당 데이터를 저장합니다.
            queue[++rear] = data;
            System.out.println("data insert : "+data);
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("queue under flow ");
            return -1;
        } else {
            //front로 데이터 제거
            return queue[++front];
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("queue under flow");
            return -1;
        } else {
            return queue[front];
        }
    }
}

/* 출력값
data insert : 1
data insert : 2
data insert : 3
data insert : 4
data insert : 5
data insert : 6
data insert : 7
data insert : 8
data insert : 9
data insert : 10
get data : 1
get data : 2
get data : 3
*/
```

- peek() : 가장 먼저 출력되는 데이터를 출력한다.

# 회고

---

스택구현과 크게 다르지는 않아서 시간은 훨씬 덜 걸린것 같은데 stack이 맨 마지막에 들어간 데이터를 top으로 잡아서 출력해주거나, 삭제하는 구조라면. Queue는 front는 삭제연산을 담당하고, rear는 삽입연산 담당하는 포인터의 역할을 해주면서 데이터가 추가되면 rear가 1증가하고, 데이터가 삭제될때는 front가 1증가하고, 둘이 서로 만나게 되면 queue가 비어있음을 알려주는 좀 더 구현하기에는 좀 더 머리를 써야하는 부분이 많았던 거 같다. 

큐를 구현한 다른 분들의 예시를 보면 그렇게 크게 다르진 않지만 front를 사용하지 않거나, front를 증가시켜서 인덱스의 증가로 삭제하고는 명시적인 방법뿐만 아니라, 실제 데이터로 0으로 바꿔준다거나, 다양한 방법이 있었던 거 같다. 

항상 알고리즘 풀이 할때 머리로 방법을 생각은 하겠는데 구현은 하기 힘들때가 많은데. 이번에 정말 끈질기게해서 끝낸거 같다.