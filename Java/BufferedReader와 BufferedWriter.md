# Buffer란?

Buffer란 동작 속도가 크게 다른 입력장치와 출력장치 그 사이에서 속도 차를 조정해주기 위해 사용되는 일시적인 저장장치를 말합니다.

일종의 임시 저장 공간입니다. 

# BufferedReader

## 1. BufferedReader란?

![Untitled (1)](https://user-images.githubusercontent.com/46406965/209471111-230cb073-44f4-4967-8d69-8179df6728f4.png)


- 많은 양의 데이터 처리에 유리합니다.
- 버퍼를 사용하면 키보드의 입력이 있으면 **한 문자씩 버퍼로 전송**되고, 버퍼가 가득 차거나, **개행 문자가 나타나면 내용이 한꺼번에 프로그램으로 전송됩니다**. 중간에 메모리 버퍼를 두고 묶어서 전송시키는 방법입니다. (키보드 → 버퍼 → 프로그램)

![Untitled111](https://user-images.githubusercontent.com/46406965/209471117-a28da10b-97b3-47a7-aa20-19561f0169bb.png)


- 기존에 사용했던 **Scanner**는 다음과 같이 데이터가 입력되면 바로 출력장치로 전달되는 방식입니다.
- **String만 데이터로 인식한다. 정수형으로 받으려면 형변환이 필요합니다 (Integer.parseInt() or Integer.valueOf())**
- Scanner보다 속도 측면에서 훨씬 빨라 알고리즘 시간을 줄일 수 있습니다.
- throws IOException이나 try&catch를 활용해 예외처리를 해줘야 합니다.
    - 대게 IOException을 사용합니다.

## 2. Buffer가 더 효율적인 이유는?

- 위에서 말했듯이 입력이 있으면 바로바로 출력장치로 전달하는 것이 아니라 버퍼에 정해진 용량만큼 모았다가 전달하거나 모으는중 개행문자가 나타나면 모아서 전송하는 방식입니다.
- 예를들면 같은곳에 전달해야 하는 물건들이 여러개 있는데 여러번 계속 전달하기보다는 모아서 한꺼번에 전달하는게 더 효율적인 것과 같습니다.
- 데이터가 입력되더라도 바로 출력장치로 전달되는게 아니라 **입력이후 버퍼로 버퍼링된 이후에 전달됩니**다. 출력도 버퍼를 거쳐서 간접적으로 출력장치로 전달되기에 **시스템의 데이터처리 효율성을 높여줍니다.**
버퍼스트림을 InputStreamReader와 OutputStreamWriter를 같이 사용하여 버퍼링 하게 된다면 **입출력 스트림으로부터 미리 버퍼에 데이터를 가져다 놓기 때문에 보다 효율적이 입출력이 가능합니**다
    - InputStreamReader : InputStream.read()를 통해 입력받으면 1byte만 인식하기에 확장시킨것이 InputStreamReader입니다.
    간단히 InputStream으로 입력을 받아서 BufferedReader로 저장한다고 생각하면 됩니다.

## 3. BufferedReader 사용법

- readLine() : 한줄의 텍스트를 읽습니다. 파일의 바이트를 읽고, 문자로 변환해서 반환하는 방식입니다. 반환값은 String입니다. 다른 데이터 타입으로 사용하고 싶다면 형변환해줘야 합니다.
- 한 줄 씩 읽어오는 방식이 아닌 끊어서 버퍼에 저장하고 싶다면 StringTokenizer이나 split을 사용하면 됩니다.
- 사실상 readLine과 close만 사용하게 된다고 합니다.

### 1. 공백에 맞춰 문자열 잘라서 Buffer에 저장

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception{
	  //java.io패키지에서 BufferedReader를 import해준다.
    //InputStream 클래스로 입력스트림을 생성.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//공백을 기준으로 parsing해서 temp배열에 저장.
    String[] temp = br.readLine().split(" ");
		//temp배열에 저장해둔 데이터 출력
    for(int i=0; i<temp.length; i++){
      System.out.println(temp[i]);
      
    }
		//하지않아도 정상 출력은 되지만, 자원관리의 습관을 들이기 위해서 명시적으로 
		br.close();
  }
}
```

- Split(” “)로 공백으로 문자열을 잘라주었습니다.
- BufferedReader는 Garbage Collector가 내부의 객체를 정리해주기 때문에 **close할 필요 없습니다**. 다만의 자원의 관리의 중요성을 생각해서 쓰는 버릇을 들이는게 좋습니다.

### 2. StirngTokenizer를 이용해서 나누기

- StringTokenizer는 일종의 구분자역할을 해주는 클래스로 사용자가 지정한 설정대로 문자열을 나누어집니다.
- 사용자가 따로 설정하지 않는다면 공백이나, 탭이 구분자 역할을 합니다.
- 2번째 인수로 구분자를 여러개 지정할 수 있습니다.
- nextToken() : StringTokenizer클래스에서 다음 토큰을 읽어옵니다.
- hasMoreTokens() : StringTokenizer클래스에서 더 읽어올 Token이 있으면 true, 없으면 false를 return해줍니다.

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //java.io패키지에서 BufferedReader를 import해준다.
    //InputStream 클래스로 입력스트림을 생성.
    StringTokenizer st = new StringTokenizer(br.readLine());
		//따로 배열을 선언하지 않으면 문자열을 공백기준으로 나눌 수 있다.  
	  //StringTokenizer st = new StringTokenizer(br.readLine(), ",");
	  // 다음과 같이 2번째 인수에 ,를 주면 ,를 기준으로 나누어진다.
    while(st.hasMoreTokens()) {
      System.out.println("nextToken : "+st.nextToken());
    }
		br.close()
  }
}
```

# BufferedWriter

## BufferedWriter 사용법

- System.out.println(””);과 같은 역할을 하는 메서드입니다.
- 위의 BufferedReader처럼 buffer를 사용하므로 **성능에서 더 뛰어납니다.**
- 문자열 출력과 개행이 동시에 되지 않기 때문에 **\n나 newLine() 메서드를 이용해서 개행**해야 합니다.
- 출력하기 위해서는 write()를 사용합니다 .
- 버퍼를 정의해뒀기 때문에 반드시 flush(), cloes()를 호출해야 합니다.
    - flush() 남아있는 데이터를 모두 출력
    - close() 스트림을 close

### BufferedReader로 입력받고, BufferedWriter로 출력하기

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws Exception{
    //java.io패키지에서 BufferedReader를 import해준다.
    //InputStream 클래스로 입력스트림을 생성.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //java.io패키지에서 BufferedWriter를 import해준다.
    //OutputStreamWriter클래스로 출력스트림을 생성.
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer를 이용해서 문자열을 나눠준다. 구분자는 ,
    StringTokenizer st = new StringTokenizer(br.readLine(), ",");
		//st에 다음 Token이 없어서 false가 나올때까지 While문을 돌려준다.
    while(st.hasMoreTokens()) {
      bw.write(st.nextToken()+"\n");
		//buffer 비워주기
      bw.flush();
    }
		//buffer 닫기
    bw.close();
    
  }
}
```

- BufferedWriter은 버퍼를 끝내는 마무리를 해줘야 하므로 flush(), close()를 해주고 마무리 해야한다.
- write() : 버퍼에 담긴 **데이터를 출력**할때 사용한다.
- flush() : 버퍼에 남은 데이터를 출력시켜 **비워주는 메소드**
- close() : BufferedWriter을 **닫아준다.**
- BufferedWriter는 개행을 해주지 않으므로 “\n”을 write()에 입력해준다.
    - “\n”을 지워주고 아래 bw.newLine();를 넣어줘도 개행된다.
