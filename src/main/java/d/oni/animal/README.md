# 19 - CRUD(Create/Retrieve/Update/Delete) 기능 완성

## 학습 목표

- 데이터를 등록/조회/수정/삭제하는 기능(CRUD)을 구현할 수 있다.

## 실습 소스 및 결과

-src/main/java/d/oni/animal/util/ArrayList.java 변경
-src/main/java/d/oni/animal/handler/AnimalHandler.java 변경
-src/main/java/d/oni/animal/handler/InfoHandler.java 변경
-src/main/java/d/oni/animal/handler/BoardHandler.java 변경
-src/main/java/d/oni/animal/domain/Animal.java 변경
-src/main/java/d/oni/animal/domain/Infomation.java 변경
-src/main/java/d/oni/animal/domain/Board.java 변경
-src/main/java/d/oni/animal/App.java 변경

## 실습

### 작업1) ArrayList 클래스에 항목 값을 조회하고 변경하고 삭제하는 기능 추가.

- ArrayList.java
  - 목록의 특정 위치에 저장된 항목을 꺼내주는 get() 정의.
  - 목록의 특정 위치에 저장된 항목을 바꾸는 set() 정의.
  - 목록의 특정 위치에 저장된 항목을 삭제하는 remove() 정의.


### 작업2) 동물정보 데이터의 상세조회, 변경, 삭제 기능 추가.

- AnimalHandler.java (AnimalHandler.java.01)
  - 상세조회 기능을 수행하는 detailAnimal() 정의.
  - 변경 기능을 수행하는 updateAnimal() 정의.
  - 삭제 기능을 수행하는 deleteAnimal() 정의.
- App.java
  - 상세조회, 변경, 삭제 명령에 대한 분기문 추가.

#### 실행 결과

```
명령> /animal/list
1, 나비, 잘 부탁드려요 , 2, y, 2019-01-02 ~ 2019-05-28, 1000
2, 토토, 보호 부탁드려요 , 2, y, 2019-02-01 ~ 2019-02-28,  160
3, olivia, 안녕하세요~ , 3, y, 2019-03-02 ~ 2019-03-30,  160
4, 콜라, 강아지를 입양하고싶습니다. , 1, y, 2019-04-02 ~ 2019-05-30,  150

명령> /animal/detail
번호: 1
이름: 나비
설명: 2살
1.유기동물 입양  2.유기동물 보호  3.반려동물 찾기 : 2
동물등록번호여부(Y/n): y
등록일 : 2020-02-13
조회수: 0

명령> /animal/detail
번호? 20
해당 동물번호를 찾을 수 없습니다.

명령> /animal/update
번호? 2
이름(나비)? 
설명? 입양
1.유기동물 입양  2.유기동물 보호  3.반려동물 찾기 ? 1
동물등록번호여부(Y/n)? y
정보를 변경했습니다.


명령> /animal/update
번호? 20
해당 번호를 찾을 수 없습니다.

명령> /animal/delete
번호? 2
정보를 삭제했습니다.

명령> /animal/delete
번호? 20
해당 수업을 찾을 수 없습니다.
```

### 작업3) AnimalHandler 코드 리팩토링.

- AnimalHandler.java
    - 저장된 목록에서 수업 번호로 항목을 찾는 코드를 indexOfLesson() 메서드로 분리.
- Animal.java
    - 인스턴스 복제를 할 수 있도록 java.lang.Cloneable 인터페이스 구현.
    - clone()을 오버라이딩 한다.


### 작업4) 회원 데이터의 상세조회, 변경, 삭제 기능 추가.

- InfoHandler.java
    - 상세조회 기능을 수행하는 detailInfo() 정의.
    - 변경 기능을 수행하는 updateInfo() 정의.
    - 삭제 기능을 수행하는 deleteInfo() 정의.
    - 저장된 목록에서 회원 번호로 항목을 찾는 indexOfMember() 정의.
- Infomation.java
    - 인스턴스 복제를 할 수 있도록 java.lang.Cloneable 인터페이스 구현.
    - clone()을 오버라이딩 한다.
- App.java
    - 상세조회, 변경, 삭제 명령에 대한 분기문 추가.

#### 실행 결과

```
명령> /info/list
1, 홍길동 , hong@test.com       , 1111-2222      , 2019-01-01
2, 임꺽정 , lim@test.com        , 1111-2223      , 2019-01-01
3, 전봉준 , jeon@test.com       , 1111-2224      , 2019-01-01

명령> /info/detail
번호? 2
이름: 홍길동
동물등록번호: 1234
이메일: hong@test.com
주소: 신림동
사진: hong.png
전화: 1111-2222
가입일: 2019-01-01

명령> /info/detail
번호? 20
해당 학생을 찾을 수 없습니다.

명령> /info/update
번호? 1
이름(홍길동)?     <=== 입력하지 않으면 기존 값 사용
동물등록번호: 1234
이메일: hong@test.com
주소: 신림동
사진(hong.png)?
전화(1111-2222)?
회원을 변경했습니다.

명령> /info/update
번호? 20
해당 회원을 찾을 수 없습니다.

명령> /info/delete
번호? 2
회원을 삭제했습니다.

명령> /info/delete
번호? 20
해당 회원을 찾을 수 없습니다.
```

### 작업5) 게시글 데이터의 상세조회, 변경, 삭제 기능 추가.

- BoardHandler.java
    - 상세조회 기능을 수행하는 detailBoard() 정의.
    - 변경 기능을 수행하는 updateBoard() 정의.
    - 삭제 기능을 수행하는 deleteBoard() 정의.
    - 저장된 목록에서 회원 번호로 항목을 찾는 indexOfBoard() 정의.
- Board.java
    - 인스턴스 복제를 할 수 있도록 java.lang.Cloneable 인터페이스 구현.
    - clone()을 오버라이딩 .
- App.java
    - 상세조회, 변경, 삭제 명령에 대한 분기문 추가.

#### 실행 결과

```
명령> /board/list
1, 게시글입니다., 3				, 2019-01-01, 0
2, 두 번째 게시글입니다.,1      , 2019-01-01, 0
3, 세 번째 게시글입니다.,4      , 2019-01-01, 0

명령> /board/detail
번호? 1
내용: 게시글입니다.
스크랩 수: 3
등록일: 2020-02-13
조회수: 0

명령> /board/detail
번호? 20
해당 게시글을 찾을 수 없습니다.

명령> /board/update
번호? 1
내용?      <=== 입력하지 않으면 기존 값 사용
게시글을 변경했습니다.

명령> /board/update
번호? 20
해당 게시글을 찾을 수 없습니다.

명령> /board/delete
번호? 2
게시글을 삭제했습니다.

명령> /board/delete
번호? 20
해당 게시글을 찾을 수 없습니다.
```
