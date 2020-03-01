#  자바 컬렉션 API 사용하기

## 실습 소스 및 결과

- src/main/java/d/oni/util/List.java 삭제
- src/main/java/d/oni/util/AbstractList.java 삭제
- src/main/java/d/oni/util/ArrayList.java 삭제
- src/main/java/d/oni/util/LinkedList.java 삭제
- src/main/java/d/oni/util/Iterator.java 삭제
- src/main/java/d/oni/util/Stack.java 삭제
- src/main/java/d/oni/util/Queue.java 삭제
- src/main/java/d/oni/lms/handler/LessonHandler.java 변경
- src/main/java/d/oni/lms/handler/MemberHandler.java 변경
- src/main/java/d/oni/lms/handler/BoardHandler.java 변경
- src/main/java/d/oni/lms/App.java 변경


### 1. ArrayList, LinkedList, Stack, Queue 클래스를 자바 컬렉션 API로 교체.

- LessonHandler.java
    - `List` 를 `java.util.List` 인터페이스로 교체.
- MemberHandler.java
    - `List` 를 `java.util.List` 인터페이스로 교체.
- BoardHandler.java
    - `List` 를 `java.util.List` 인터페이스로 교체.
- App.java
    - 핸들러를 생성할 때 자바 컬렉션 API에서 제공하는 `java.util.List`의 구현체를 넘겨준다.
    - 명령 내역을 저장할 때도 자바 컬렉션 API의 Stack과 Queue 구현체를 사용.
