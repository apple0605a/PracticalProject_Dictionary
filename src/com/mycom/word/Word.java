package com.mycom.word;

public class Word {
	
	@Override	//우클릭 - source - override - toString
	public String toString() {
		
		String slevel = "";		//별 받을 문자열, 별 자리에 이거 출력
		for (int i = 0; i < level; ++i) slevel += "*";	//난이도만큼 별 개수 추가
		String str = String.format("%-3s", slevel)		//좌측정렬, 별 개수 최대 세개
			+ String.format("%15s", word)				//우측정렬
			+ " " + meaning;							//뜻은 정렬 할 필요 無
		return str;
	}	//wordCRUD에서 요거 씀
	
	private int id;
	private int level;
	private String word;
	private String meaning;
	
	Word(){}	//생성자 기본형
	Word(int id, int level, String word, String meaning) {
		this.id = id;
		this.level = level;
		this.word = word;
		this.meaning = meaning;  
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	
}
