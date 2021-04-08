package com.lectopia.quinque.view.bean;

import java.awt.Rectangle;

enum Cane {
	ROCK("Rock"), SCISSORS("Scissors"), PAPER("Paper"), QUESTIONMARK("Questionmark");
	
	private String cane;
	Cane(String cane) {
		this.cane = cane;
	}
	
	public String getCane() {
		return cane;
	}
}

/**
 * 말에 대한 정보를 가지고 있는 클래스다.
 * @author QuinqueBliss
 *
 */
public class Marker {
   /**
    * 가위, 바위, 보, 물음표, 와일드카드 가위, 와일드카드 바위, 와일드카드 보, 와일드카드 물음표의
    * 정보를 가지고 있다.
    */
   private Cane cane;
   /**
    * 타일에 지정된 번호다.
    */
   private int mapTileNum;
   /**
    * 버튼의 actionCommand와 일치하는 이름이다.
    */
   private String character;
   private String name;
   /**
    * url
    */
   private String image;
   /**
    * 말이 선택 되었는지 표시해주는 역할을 한다.
    */
   private boolean selected;
   /**
    * 상대방 턴인지 내턴인지 알려주는 역할을 한다.
    */
   private int turn;
   /**
    * 골인했는지 알려주는 역할을 한다.
    */
   private boolean goalFlag;
   private boolean hiddenFlag;
   private Rectangle rectangle;
   
   /**
    * null parameter 생성자다.
    */
   public Marker() {}
   
   public Marker(Cane cane, String character, String name) {
	   this.cane = cane;
	   this.character = character;
	   this.name = name;
   }
   
   /**
    * 
    * @param cane 지팡이 정보
    * @param name 이름
    * @param image url
    * @param turn 턴정보
    */
   public Marker(Cane cane, String character, String name, String image, Rectangle rectangle) {
	   this.cane = cane;
	   this.character = character;
	   this.name = name; 
	   this.image = image;
	   this.turn = 0;
	   this.rectangle = rectangle;
	   this.mapTileNum = 0;
	   this.goalFlag = false;
	   this.hiddenFlag = false;
	   this.selected = false;
   }
   
   public Cane getCane() {
	   return cane;
   }
   
   public String getName() {
	   return name;
   }
   
   public void setName(String name) {
	   this.name = name;
   }
   
   public String getCharacter() {
	   return character;
   }
   
   public void setCharacter(String character) {
	   this.character = character;
   }
   
   /**
    * getter()
    * @return 타일에 지정된 번호를 리턴한다.
    */
   public int getMapTitleNum() {
      return mapTileNum;
   }
   /**
    * setter()
    * @param mapTitleNum 타일에 지정된 번호를 리턴한다.
    */
   public void setMapTitleNum(int mapTitleNum) {
      this.mapTileNum = mapTitleNum;
   }
   /**
    * getter()
    * @return url
    */
   public String getImage() {
      return image;
   }
   /**
    * setter()
    * @param image url
    */
   public void setImage(String image) {
      this.image = image;
   }
   /**
    * getter()
    * @return 선택되었으면 true, 아니면 false를 리턴한다.
    */
   public boolean getSelected() {
      return selected;
   }
   /**
    * setter()
    * @param selected 선택여부를 리턴한다.
    */
   public void setSelected(boolean selected) {
      this.selected = selected;
   }
   /**
    * getter()
    * @return 턴 정보를 리턴한다.
    */
   public int getTurn() {
      return turn;
   }
   /**
    * setter()
    * @param turn 턴 정보
    */
   public void setTurn(int turn) {
      this.turn = turn;
   }
   /**
    * getter()
    * @return 골인했는지 여부를 리턴한다.
    */
   public boolean getGoalFlag() {
      return goalFlag;
   }
   
   public Rectangle getRectangle() {
	   return rectangle;
   }
   
   public void setRectangle(Rectangle rectangle) {
	   this.rectangle = rectangle;
   }
   
   /**
    * setter()
    * @param goalFlag 골인 여부
    */
   public void setGoalFlag(boolean goalFlag) {
      this.goalFlag = goalFlag;
   }
   
   /**
    * 배틀(가위,바위,보)에서 패배한 말을 본래의 진영(home)으로 이동시키는 메소드다.
    */
   public void backHome() {}
   /**
    * 배틀(가위,바위,보) 후에 지팡이를 공개하는 매소드다. 
    * @param image url
    */
   public void reveal(String image) {}
}