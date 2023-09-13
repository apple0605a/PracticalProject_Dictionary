//인터페이스 이름 앞에는 보통 'I' 붙임
package com.mycom.word;

public interface ICRUD {
	public Object add();			//추가
	public int update(Object obj);	//수정
	public int delete(Object obj);	//삭제
	public void selectOne(int id);	//데이터 한 개 조회
	
	/*
	 * 타입이나 파라미터는 원하는 템플릿 구성에 맞춰 알아서
	 * 
	 * 수정/삭제하거나 select한 데이터 출력할 수 있도록 함
	 */
}
