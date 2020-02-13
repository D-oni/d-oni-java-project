package d.oni.animal.handler;
import java.sql.Date;
import java.util.Scanner;
import d.oni.animal.domain.Board;
import d.oni.animal.util.ArrayList;

public class BoardHandler {

  ArrayList<Board> boardList;

  Scanner input;


  public BoardHandler(Scanner input) {
    this.input = input;
    this.boardList = new ArrayList<>();
  }

  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    this.boardList = new ArrayList<>(capacity);
  }

  public void listBoard() {
    // BoardList의 보관된 값을 받을 배열을 준비한다.
    Board[] arr = new Board[this.boardList.size()];

    // toArray()에게 빈 배열을 넘겨서 복사 받는다.
    this.boardList.toArray(arr);

    for (Board b : arr) {
      System.out.printf("%d, %s, %d, %s, %d\n",
          b.getNum(), b.getText(), b.getScrap(), b.getDate(), b.getViewCount());
    }
  }

  public void addBoard() {
    Board board = new Board();

    System.out.println("번호: ");
    board.setNum(input.nextInt());
    input.nextLine();

    System.out.println("내용: ");
    board.setText(input.nextLine());

    System.out.println("스크랩 수: ");
    board.setScrap(input.nextInt());

    input.nextLine();

    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    this.boardList.add(board);

    System.out.println("저장하였습니다.");
  }


  public void detailBoard() {
    System.out.print("번호? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Board board = this.boardList.get(index);

    if (board == null) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
      }

    System.out.printf("번호: %d\n", board.getNum());
    System.out.printf("내용: %s\n", board.getText());
    System.out.printf("스크랩 수: %d\n", board.getScrap());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회수: %d\n", board.getViewCount());
  }

  public void updateBoard() {
    System.out.print("번호? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Board oldBoard = this.boardList.get(index);

    if (oldBoard == null) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }

    System.out.printf("내용(%s)? ", oldBoard.getText());
    String text = input.nextLine();

    if (text.length() == 0) {
      System.out.println("게시글 변경을 취소했습니다.");
      return;
    }

    Board newBoard = new Board();
    newBoard.setNum(oldBoard.getNum());
    newBoard.setText(oldBoard.getText());
    newBoard.setScrap(oldBoard.getScrap());
    newBoard.setDate(new Date(System.currentTimeMillis()));
    newBoard.setViewCount(oldBoard.getViewCount());

    this.boardList.set(index, newBoard);

    System.out.println("게시글을 변경했습니다.");
  }

  public void deleteBoard() {
    System.out.print("번호? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Board board = this.boardList.get(index);

    if (board == null) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }

    this.boardList.remove(index);

    System.out.println("게시물을 삭제했습니다.");
  }

}
