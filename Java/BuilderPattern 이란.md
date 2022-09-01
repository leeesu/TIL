➡ 생성자를 작성하는데에는 우선 3가지 방법이 있습니다.

1. **점층적 생성자 패턴**
2. **자바빈즈 패턴**
3. **빌더 패턴**

백엔드 프로젝트를 하면서 늘 자바빈즈 패턴방식의 생성자 생성만을 해왔기에 빌더 패턴에 대한 사용법이 익숙치 않아 익히고자 정리해봅니다.

- 예제

```java
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //필수입력
    private String username;

    private String password;

    //선택입력
    private String address;

    private String nickname;
    //자기소개글
    private String introduce;

 
```

1. **점층적 생성자 패턴 (Telescoping Constructor Pattern)**

```java
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //필수입력
    private String username;

    private String password;

    //선택입력
    private String address;

    private String nickname;
    //자기소개글
    private String introduce;

    //생성자 생성

    public Post(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Post(Long id, String username, String password, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public Post(Long id, String username, String password, String address, String nickname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.nickname = nickname;
    }

    public Post(Long id, String username, String password, String address, String nickname, String introduce) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.nickname = nickname;
        this.introduce = introduce;
    }
}
```

- 이 클래스에는 총 4개의 생성자가 있습니다.  생성자는 필수 매개변수만 담는다면 4개, 5개, 6개를 받는 생성자까지도 생성 할 수 있습니다.
- 점층적 생성자 패턴은 매개변수 조합의 생성자를 작성하는 방식입니다.
- 장점 : 객체가 불완전한 상태에 있는 것을 방지 할 수 있습니다.
    - 불완전이랑 객체의 필수 멤버 필드의 값이 없는 경우를 의미합니다. 생성시 필수 멤버 필드 값을 초기화 해주므로 객체가 일관성을 유지합니다.
- 단점 : 코드의 가독성이 떨어집니다.
    - 매개변수가 많아지면 많아질수록 인자가 어떤 값을 나타내는지 알기 어렵습니다.

```java
Post post1 = new Post(1L, "user01","1111111");
Post post2 = new Post(2L, "테스터","12345","어딘가");
```

- 다음과 같이 생성자를 사용해서 인스턴스화 합니다. 만약에 몇가지 인자만 아는 상태에서 객체를 생성하려고 한다면 null또는 0을 전달해야 합니다.
- 인자값이 어떤 값을 나타내는지 알기 어려워 가독성이 떨어집니다.

### 2. ****자바 빈 패턴 (JavaBeens Pattern)****

- 자바 빈 패턴은 매개변수가 없는 생성자를 객체로 만들고, setter 메서드로 멤버의 필드 값을 설정하는 방법입니다.
- 장점 :  setter메서드의 이름에 필드의 이름이 포함되어 있어 어떤 멤버 필드로 어떤값이 들어가는지 쉽게 파악 할 수 있습니다.
- 단점 : 객체의 필수 멤버 필드에 값이 들어가기 전까지는 불완전한 상태에 놓입니다.
    - 기본 생성자로 객체를 생성한 직후에는 필수 멤버 필드에 빈 값이 들어가게 됩니다.
    - 객체 하나를 만들기 위해 여러 메서드가 호출됩니다.
    - 생성자 하나만 호출하면 되는 점층적 패턴과 달리, 여러 setter메서드를 호출하게 됩니다. 더불어 매개변수가 많아질 수록 더 많은 메서드의 호출이 필요시 됩니다.

```java
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //필수입력
    private String username;

    private String password;

    //선택입력
    private String address;

    private String nickname;
    //자기소개글
    private String introduce;

    //생성자 생성

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
```

```java
Postpost1 = new Post();
post1.setId(1L);
post1.setUsername("네임입니다");
post1.setPassword("123455677");
post1.setAddress("어딘가");
post1.setNickname("내닉네임은요");
post1.setIntroduce("자기소개시간");
```

- 자바빈즈 패턴은 매개변수가 없는 기본생성자를 객체로 만들고 setter method로 멤버필드의 값을 설정합니다.
- 생성자를 생성하지 않으면 Java가 자동으로 기본 생성자를 만들어 줍니다.

### 3. **Builder Pattern(빌더 패턴)**

- 빌더 패턴은 점층적 생성자 패턴의 안정성과 자바빈즈 패턴의 가독성을 겸비한 패턴이라고 할 수 있습니다.
- 두패턴을 보완해서 나온 패턴입니다.

```java

public class Post {
    private String username;
    private String password;
    private String nickname;
    private String address;
    private String introduce;

    Post(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.nickname = builder.nickname;
        this.address = builder.address;
        this.introduce = builder.introduce;

    }

    public static class Builder {
        private String username;
        private String password;
        private String nickname;
        private String address;
        private String introduce;

        // 필수적인 필드 : username
        public Builder(String username) {
            this.username = username;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder introduce(String introduce) {
            this.introduce = introduce;
            return this;
        }

        public Post build() {
            return new Post(this);
        }
    }

}
```

- 클래스 내부에 정적클래스 Builder를 만들어서 사용합니다.
    - set메소드는 값을 넣고, Builder를 리턴합니다.
- Builder클래스는 build 메서드를 통해서 새로는 Post 객체를 생성합니다.
- **장점** : 필요한 데이터만 설정 할 수 있습니다
    - 유연성을 확보 할 수 있습니다.
    - 가독성을 높일 수 있습니다.
    - 변경 가능성이 최소화 됩니다.
- **단점** : 변수가 적을 때는 오히려 자바빈즈나 생성자방식이 더 편리 할 수 있습니다.

### 4. **Builder를 사용해야 하는 이유?**

- 생성자가 많을 경우 가독성이 좋지 않으므로 사용이 권장됩니다.
    1. 어떤 값이 들어오고 어떤값을 의미하는지 생성자 파라미터가 많다면 이해하기 힘들어집니다.
    2. 빌터 패턴은 각각 어디로 들어가는지 보여주므로 가독성이 좋습니다.
- 파라미터의 순서가 영향을 주지 않습니다.
    1. 생성자는 파라미터의 순서를 지켜야합니다. 하지만 빌더패턴은 각각 들어갈 곳을 지정해주기 때문에 순서를 신경 쓸 필요가 없습니다.

### 5. `lombok`에서의 @Builder

```java
import lombok.Builder;

@Builder
public class Post {
    private String username;
    private String password;
    private String nickname;
    private String address;
    private String introduce;
    

}
```

- 간단히 `@Builder` 어노테이션을 써주면 됩니다.
- 아래와 같이 객체 생성 역시 손쉽게 이루어집니다.

```java
Post post = Post.builder()
                .username("회원명")
                .password("비밀번호")
                .nickname("닉네임")
                .address("주소")
                .introduce("자기소개")
                .build();
```

> **Reference**
> 

[https://blog.naver.com/qodlgks123/222859901632](https://blog.naver.com/qodlgks123/222859901632)