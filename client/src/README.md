#  LMS 명령을 입력 받는 기능을 추가하기

- 사용자로부터 명령을 입력 받을 수 있다.

## 소스 및 결과

- src/main/java/d/oni/util 패키지 추가
- src/main/java/d/oni/util/Prompt.java 추가
- src/main/java/d/oni/animal/handler 패키지 추가
- src/main/java/d/oni/animal/handler/Command.java 추가
- src/main/java/d/oni/animal/ClientApp.java 변경

## 실습  

### 1. 31번 프로젝트의 App 클래스에서 명령을 입력 받는 부분을 가져오라.

- d.oni.util 패키지 생성한다.
- d.oni.util.Prompt 클래스를 가져온다.
- d.oni.animal.handler 패키지 생성한다.
- d.oni.animal.handler.Command 인터페이스 가져온다.
- ClientApp.java 변경한다.
  - 사용자가 입력한 명령을 처리하는 코드를 가져온다.
