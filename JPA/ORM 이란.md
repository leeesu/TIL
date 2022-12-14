### ORM이란

---

- ORM은 `Object Relational Mapping(객체관계매핑)`의 약자로 객체와 데이터베이스의 `관계`를 매핑해주는 역할을 한다.
    - 객체지향프로그래밍은 클래스를 사용하고, 관계형 데이터베이스는 테이블을 사용한다.
    - ORM은 객체와 관계형 데이터베이스 사이의 중계자이자 통역자 역할을 한다.
    - `객체모델(OOP)과 관계형 모델(RDBMS)` 간에 `불일치`가 존재할 경우를 해결하기 위해 자바가 만들어낸 기술이 ORM이다.
    - ORM을 통해 `객체 간의 관계를 바탕`으로 SQL을 자동으로 생성해 불일치를 해결한다.
    - ORM기술을 구현하기 위해 사용되어온 프레임워크가 `Hibernate`이며, 이외에도 다른 프레임워크(TopLInk, CoCobase)등이 등장하였다.
    - 그 결과 ORM기술을 구현한 프레임워크에 대한 `표준화`가 이루어져 탄생한 것이 `JPA`이다.
    - 즉 단순하게 말해 클래스파일과 데이터베이스를 가운데서 연결(매핑)해주는 역할을 하며, 직접 sql을 작성할 필요없이 내부의 프레임워크가 CRUD를 지원해준다.
    

### ORM의 장단점

---

- **장점**
    - 객체 지향적인 코드로 인해 더 직관적이고, 비즈니스 로직에 더 집중 할 수 있게 도와준다.
    - DBMS에 대한 `종속성`이 줄어들어 `재사용성 및 유지보수`의 `편리성`이 증가한다.
    - 데이터를 가져오고 필요한 경우 `직렬화` 한다.
        - 데이터의 직렬화란 메모리를 디스크에 저장하거나 네트워크 통신에 사용하기 위한 형식으로 변환하는 것을 말한다고 한다.
    - ORM을 사용하기 위해서 `SQL지식이 필요하지 않다`. 복잡한 DML을 배우지 않아도 join, select, insert등을 대신 처리해준다. SQL을 몰라도 사용 할 수 있다는 것 역시 장점.
    - ORM은 모든 유형의 공격에 있어서 쿼리를 보호한다.
- **단점**
    - `완전하게` ORM으로만 서비스를 구현하기 어렵다
        - 돌아다녀보니 ORM의 부족한 부분 때문에 ORM과 DB를 병행 사용하는 경우도 적지 않아보였다.
    - 단순한 시스템의 경우에는 ORM으로만 구현 가능하지만 많은 시스템의 경우 사용시 생산성이 저하되고 리스트크가 발생하므로 사용하기 어렵다.