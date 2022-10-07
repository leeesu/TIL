## ⭕ 참고

- 동적쿼리는 BooleanExpression을 많이 사용합니다. null반환시 자동으로 조건절에서 제거됩니다.
- exsist 메소드 금지. 데이터를 있냐 없냐를 체크하는데는 좋은 성능을 보이는데 querydsl은 count()>0로 실행됩니다.
- JPQL은 from없이 쿼리를 수행 할 수 없기 때문입니다. 가장 쉬운방법은 limit 1로 조회를 제한 하는 것. 조회결과가 없으면 null이라서 null이나 아니냐은 판단조건만 마지막에 넣어주면 exsist랑 거의 비슷한 성능을 낼 수 있습니다.
- Cross Join 회피
    - cross join은 모든걸 대상으로 하기 때문에 성능이 잘 안나와서 피하는게 좋은데 이때 묵시적 조인이라고해서 where문에서 join에 대해서 선언하면 기능 사용에는 문제가 없지만 묵시적 조인을 사용하면 cross join이 발생.
    - 피하는 방법은 명시적 Join을 선언하면 Inner Join으로 발생한다.
- Entity보다 Dto우선
    - Entity조회하면 불필요한 컬럼이 조회되고 oneToone에서 N+1쿼리가 터지는 문제가 있다.
    - 단순한 조회기능인데도 성능이슈가 될 요소가 많다.
    - **Entity조회가 실시간으로 변경이 필요한 경우**
    - **Dto조회 고강도 or 대량의 데이터 조회가 필요한 경우**
        - Dto가 성능상으로 이점이 훨씬 많다.
        - 조회컬럼 최소화하기 as number등으로 대체할 수 있다.
        - select에 entity선언하면 모든 컬럼이 조회됨
        - entitiy간 연관관계를 맺으려면 반대entity 있어여하지 않나?
            - 연관된 entity의 save를 위해서는 entity의 id만 있으면 된다.
            - .post(new Post(postId)이런식으로 넣어 줄 수 있음.
    - JPQL은 from절의 서브쿼리를 지원하지 않는다. 그러므로 querydsl도 지원하지 않는다.
        - 커버링 인덱스 : 쿼리를 충복시키는데 필요한 모든 컬럼을 가지고 있는 인덱스
            - select/where/order by/group by등에서 사용되는 모든 컬럼이 인덱스에 포함도
        - pk를 커버링 인덱스로 조회하고, 조회된 키로 select컬럼들을 후속 조회한다.
    

## **QueryDSL문법**

▶ **결과반환**

- **fetch** :fetch를 이용해서 querydsl의 결과를 반환 할 수 있습니다. 조회대상이 여러간이 경우. 컬랙션을 반환합니다.
- **fetchOne** : 조회대상이 1건일 경우에 generic에서 지정된 타입으로 반환합니다. (1건이 넘는다면 에러가 발생)
- **fetchFirst** : 조회대상이 1건이든 1건 이상이든 무조건 1건만 반환합니다. return limit(1).fetchOne()의 방식
- **fetchCount** : 개수 조회. long 타입 반환
- **fechResults** : 조회한 리스트와 개수를 함께 반환합니다. List가 아닌 QueryResult를 반환합니다. count쿼리가 추가로 실행됩니다.

▶ **프로젝션(Projection)**

select절에서 어떤 컬럼을 조회할지 대상을 지정하는 것을 의미합니다. 테이블에서 조회하고자 하는 컬럼만 선택해서 조회하는 것을 의미합니다.

프로젝션 대상이 하나라면, Genteric Type이 해당 컬럼 타입에 맞게 지정됩니다.

- 프로젝션은 select 대상을 지정한다.
- 프로젝션이 하나일 경우
    - 단일 타입이라서 반환타입이 명확.

```java
List<String> result = queryFactory
					.select(user.nickname)
					.from(user)
					.fetch();
```

- 프로젝션이 두개이상일 경우, Tuple이나 DTO로 값을 조회합니다.
- 튜플(Tuple)**로 조회**

```java
List<Tuple> resultValue = queryFactory
					.select(member.username, member.age)
					.from(member)
					.fetch();

for(Tuple tuple : resultValue) {
String username = tuple.get(user.name);
String age = tuple.get(user.age);
```

Tuple로 출력하게 되면 배열 형태로 출력이 되고, 데이터에 접근하기 위해서는 get메서드의 파타미터로 Q Type의 필드를 넘겨주게 됩니다. Tuple 자체를 return값으로 사용하게 되면 JPA를 사용하면서 Response가 아닌 Entity를 그대로 반환하는 것과 같이 외부로 그대로 DB가 노출될 가능성이 있으므로 되도록 DTO를 사용하는 것이 좋습니다.

- **DTO조회에는 세가지 방법이 있습니다.**
    - 프로퍼티 접근 Projections.bean
    - 필드 직접 접근 Projections.fields
    - 생성자 사용 Projection.constructor
    - `@QueryProjection` 어노테이션 달기

**PostResponseDto.java**

```java
@Getter
Public class PostResponseDto {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String title;
		private Stirng contetent;
```

**PostRespositoryCustom.java**

1. Bean() - > getter,setter등 디폴트 생성자가 필요합니다. 

```java
private JPAQueryFactory jpaQueryFactory;

List<PostResponseDto> result = jpaQueryFactory
			.select(Projections.bean(PostReponseDto.class,
									post.title,
									post.content))
			.from(post)
			.fetch();
	
```

1. **fields() → 필드 접근, getter상관없이 바로 주입하는 방식입니다.**
- 필드와 타입이 일치해야 합니다.

```java
private JPAQueryFactory jpaQueryFactory;

List<PostResponseDto> result = jpaQueryFactory
			.select(Projections.fields(PostReponseDto.class,
									post.title.as("postTitle"),
									post.content))
			.from(post)
			.fetch();

	for(PostResponseDto responseDto : result) {
			System.out.println("postResponseDto = " +responseDto);
	
```

- 필드명과 데이터명이 다를 경우에는 null이 뜨므로, 프로퍼티나 필드 접근 생성방식에서 Dto에서의 이름이 postTitle이고 Entity에서의 이름이

1. **constructor 생성자 사용**

```java
private JPAQueryFactory jpaQueryFactory;

List<PostResponseDto> result = jpaQueryFactory
			.select(Projections.constructor(PostReponseDto.class,
									post.title,
									post.content))
			.from(post)
			.fetch();
	
```

- 생성자 이용시에는 생성자 파라미터와 순서가 같아야 합니다.

1. `@QueryProjection`어노테이션 Dto에 달기
- 생성자에 QueryProjection을 사용하면 Querydsl을 compile했을때와 마찬가지로 Dto로 Q-Type이 생성됩니다.
- 컴파일러로 타입을 체크 할 수 있습니다.
- 다만, DTO를 Q파일을 생성해야 하며, DTO가 Querydsl에 대한 의존성을 가지게 된다는 단점이 있습니다.

```java
@Getter
Public class PostResponseDto {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String title;
		private Stirng contetent;

@QueryProjection // QueryProjection 어노테이션 달기
public PostResponseDto(String title, String content) {
		this.title = title;
		this.content = content'
}
```

```java
private JPAQueryFactory jpaQueryFactory;

List<PostResponseDto> result = jpaQueryFactory
			.select(new QPostResponseDto(PostReponseDto.class,
									post.title,
									post.content))
			.from(post)
			.fetch();
	
```

### 🔗 Reference

---

[https://joont92.github.io/jpa/QueryDSL/](https://joont92.github.io/jpa/QueryDSL/)

[https://doing7.tistory.com/129](https://doing7.tistory.com/129)