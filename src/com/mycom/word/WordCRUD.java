//WordCRUD : ICURD를 구현한 구현체
package com.mycom.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{		//뒷 내용 입력하고 WordCRUD 자리에 마우스 올리면 ICRUD에서 구현한 함수 불러옴
	ArrayList<Word> list;		//동적으로 데이터 관리할 수 있는 array		얘도 ArrayList import해줌
	Scanner s;	//입력받을거 선언	얘도 import

	/*
	 * 데이터 입력받음
	 * 입력 받은 데이터를 리스트에 저장 
	 */
	
	WordCRUD(Scanner s) {	//WordCRUD 생성자 만들 때 list 객체화
		list = new ArrayList<>();
		this.s = s;
	}

	@Override
	public Object add() {	 
		System.out.print("=> 난이도(1, 2, 3) & 새 단어 입력 : ");
		//예시 : 1 driveway	//?
		int level = s.nextInt();
		String word = s.nextLine();	//버퍼에 남은 엔터 공백 가져감, nextLine() - 엔터 입력 전까지 다 받아서 리턴
		
		System.out.print("뜻 입력 : ");
		//예시 : 차고
		String meaning = s.nextLine();	//nextLine으로 해서 공백 포함
		
		return new Word(0, level, word, meaning);
	}
	
	public void addItem() {		//WordManager에서 호출할 함수 => list에 추가까지 돼야함
		Word one = (Word)add();	//add 리턴 타입 Word로 캐스팅
		list.add(one);			//list에 add로 받은 Word 추가
		System.out.println("새 단어가 단어장에 추가되었습니다.");
	}	//완성한 addItem 함수는 WordManager에서 호출

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void selectOne(int id) {
		// TODO Auto-generated method stub
		
	}	//implements ICURD - ICRUD구현
	
	public void listAll() {		//단어 리스트 전체 출력 함수
		System.out.println("--------------------------------");
		for (int i = 1; i <= list.size(); ++i) {	//리스트 처음에 번호
			System.out.print(i + " ");
			System.out.println(list.get(i-1).toString());
		}
		System.out.println("--------------------------------");
	}
	
	public ArrayList<Integer> listAll(String keyword) {		//overriding, 검색한 내용 포함한 단어만 찾음 (updateItem에서 사용), Integer인 ArrayList을 return
		
		ArrayList<Integer> idlist = new ArrayList<>();		//idlist - 리턴할 ArrayList, list의 번호 받음
		
		System.out.println("--------------------------------");
		for (int i = 0; i < list.size(); ++i) {	//
			int j = 0;		//단어 앞에 붙일 번호
			String word = list.get(i).getWord();	//리스트에서 word 가져옴
			if(!word.contains(keyword)) continue;	//keyword로 받은 단어가 리스트에서 가져온 word에 포함 안돼있으면 continue (포함하면 밑에 내용 실행)
			System.out.print((++j) + " ");			//번호 출력
			System.out.println(list.get(i).toString());		//단어 출력
			idlist.add(i);		//단어 번호 받을 리스트에 번호 추가
		}
		System.out.println("--------------------------------");
 		
		return idlist;
	}

	public void updateItem() {
		System.out.print("=> 수정할 단어 검색 : ");
		String keyword = s.next();		//keyword에 scanner로 받음, next - 공백 허용 X
		ArrayList<Integer> idlist = this.listAll(keyword);	//단어 리스트 돌려서 번호 리스트로 받아옴
		
		System.out.print("=> 수정할 번호 선택 : ");
		int id = s.nextInt();
		s.nextLine();	//엔터 먹어줌

		System.out.print("=> 뜻 입력 : ");
		String meaning = s.nextLine();
		Word word = list.get(idlist.get(id-1));		//id - 찾아서 나온 순서 (보이는 숫자는 index에서 +1 된거)
		word.setMeaning(meaning);		//meaning 재설정
		System.out.println("단어가 수정되었습니다.");
	}

	public void deleteItem() {
		// TODO Auto-generated method stub
		
	}

}
