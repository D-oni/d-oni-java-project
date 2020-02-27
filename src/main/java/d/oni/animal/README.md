#`Iterator` 구현체와 스태틱 중첩 클래스(static nested class)


## 실습 소스 및 결과

- src/main/java/d/oni/util/ListIterator.java 삭제
- src/main/java/d/oni/util/AbstractList.java 변경
- src/main/java/d/oni/util/StackIterator.java 삭제
- src/main/java/d/oni/util/Stack.java 변경
- src/main/java/d/oni/util/QueueIterator.java 삭제
- src/main/java/d/oni/util/Queue.java 변경

## 실습

### 훈련1. ListIterator 클래스를 AbstractList 클래스의 중첩클래스로 만들기.

- AbstractList.java
  - ListIterator 클래스를 스태틱 중첩 클래스로 정의.
- ListIterator.java
  - 삭제한다.

### 훈련2. QueueIterator 클래스를 Queue 클래스의 중첩클래스로 만들기.

- Queue.java
  - QueueIterator 클래스를 스태틱 중첩 클래스 정의.
- QueueIterator.java 
  - 삭제한다.

### 훈련3. StackIterator 클래스를 Stack 클래스의 중첩클래스로 만들기.

- Stack.java
  - StackIterator 클래스를 스태틱 중첩 클래스 정의.
- StackIterator.java 
  - 삭제한다.
