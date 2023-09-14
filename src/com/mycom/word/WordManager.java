//CRUD기능 구현하는 전체적인 관리 역할
package com.mycom.word;

import java.util.Scanner;					//스캐너 import한거

public class WordManager {
	Scanner s = new Scanner(System.in);		//요 입력하고 import 해줘야함 (자동으로 가능)
	
	WordCRUD wordCRUD;
	
	WordManager() {
		wordCRUD = new WordCRUD(s);
	}
	
	public int selectMenu() {
		System.out.print("*** 영단어 마스터 ***\n"
				+ "***************\n"
				+ "1. 모든 단어 보기\n"
				+ "2. 수준별 단어 보기\n"
				+ "3. 단어 검색\n"
				+ "4. 단어 추가\n"
				+ "5. 단어 수정\n"
				+ "6. 단어 삭제\n"
				+ "7. 파일 저장\n"
				+ "0. 나가기\n"
				+ "***************\n"
				+ "=> 원하는 메뉴는? > ");
		
		return s.nextInt();	//스캐너, nextInt는 표준 입출력
	}
	
	public void start() {	//본 클래스에서 main역할 하는 함수, Main에서 호출
		
		wordCRUD.loadFile();
		while(true) {	//0 입력 전까지 반복
			int menu = selectMenu();
			if (menu == 0) {
				System.out.println("프로그램 종료.");
				break;
			}
			
			if (menu == 4) {	//create
				wordCRUD.addItem();		//addItem 함수는 WordCURD에 있는 함수임	=> WordCRUD 멤버 변수 선언 필요
			}
			
			else if (menu == 1) {	//list
				wordCRUD.listAll();
			}
			
			else if (menu == 2) {	//수준별 단어 보기
				wordCRUD.searchLevel();
			}
			
			else if (menu == 3) {	//단어 검색
				wordCRUD.searchWord();
			}
			
			else if (menu == 5) {	//update
				wordCRUD.updateItem();	//새로운 함수 입력하고 설정하면 함수 자동으로 만들어짐
			}
			
			else if (menu == 6) {	//delete
				wordCRUD.deleteItem();
			}
			
			else if (menu == 7) {	//save data
				wordCRUD.saveFile();
			}
		}
	}
}
 