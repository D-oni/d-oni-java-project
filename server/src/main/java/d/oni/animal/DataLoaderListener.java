package d.oni.animal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import d.oni.animal.context.ApplicationContextListener;
import d.oni.animal.domain.Animal;
import d.oni.animal.domain.Board;
import d.oni.animal.domain.Infomation;

public class DataLoaderListener implements ApplicationContextListener{
	
	List<Animal> animalList = new ArrayList<>();
	List<Board> boardList = new ArrayList<>();
	List<Infomation> infoList = new ArrayList<>();

	@Override
	public void contextInitialized(Map<String, Object> context) {
		System.out.println("데이터를 로딩합니다.");	
		loadAnimalData();
		loadInfoData();
		loadBoardData();
		
		context.put("boardList",boardList);
		context.put("infoList",infoList);
		context.put("animalList",animalList);
	}

	@Override
	public void contextDestroyed(Map<String, Object> context) {
		System.out.println("데이터를 저장합니다.");	

		saveAnimalData();
		saveInfoData();
		saveBoardData();

	}

	@SuppressWarnings("unchecked")
	private void loadBoardData() {
		File file = new File("./board.ser2");

		try (ObjectInputStream in = 
				new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){
			boardList = (List<Board>) in.readObject();
			System.out.printf("총 %d 개의 게시물 데이터를 로딩했습니다.\n", boardList.size());

		} catch (Exception e) {
			System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
		} 
	}
	private void saveBoardData() {

		File file = new File("./board.ser2");

		try (ObjectOutputStream out 
				= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
			out.writeObject(boardList);
			System.out.printf("총 %d개의 게시물 데이터를 저장했습니다.\n",boardList.size());

		} catch (IOException e) {
			System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
		} 
	}
	@SuppressWarnings("unchecked")
	private void loadInfoData() {

		File file = new File("./info.ser2");

		try(ObjectInputStream in =
				new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){
			infoList = (List<Infomation>) in.readObject();
			System.out.printf("총 %d 개의 회원 데이터를 로딩했습니다.\n", infoList.size());

		} catch (Exception e) {
			System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
		} 
	}

	private void saveInfoData() {
		File file = new File("./info.ser2");

		try (ObjectOutputStream out =
				new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
			out.writeObject(infoList);
			System.out.printf("총 %d 개의 회원 데이터를 저장했습니다.\n", infoList.size());

		} catch (IOException e) {
			System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
		}  
	}
	@SuppressWarnings("unchecked")
	private void loadAnimalData() {
		File file = new File("./animal.ser2");

		try (ObjectInputStream in = 
				new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){
			animalList = (List<Animal>) in.readObject();
			System.out.printf("총 %d 개의 동물 데이터를 로딩했습니다.\n", animalList.size());

		} catch (Exception e) {
			System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
		} 
	}

	private void saveAnimalData() {
		File file = new File("./animal.ser2");

		try (ObjectOutputStream out = 
				new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){ 
			out.writeObject(animalList);
			System.out.printf("총 %d 개의 동물 데이터를 저장했습니다.\n", animalList.size());

		} catch (IOException e) {
			System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

		} 
	}

}
