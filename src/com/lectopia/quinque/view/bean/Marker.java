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
 * ���� ���� ������ ������ �ִ� Ŭ������.
 * @author QuinqueBliss
 *
 */
public class Marker {
   /**
    * ����, ����, ��, ����ǥ, ���ϵ�ī�� ����, ���ϵ�ī�� ����, ���ϵ�ī�� ��, ���ϵ�ī�� ����ǥ��
    * ������ ������ �ִ�.
    */
   private Cane cane;
   /**
    * Ÿ�Ͽ� ������ ��ȣ��.
    */
   private int mapTileNum;
   /**
    * ��ư�� actionCommand�� ��ġ�ϴ� �̸��̴�.
    */
   private String character;
   private String name;
   /**
    * url
    */
   private String image;
   /**
    * ���� ���� �Ǿ����� ǥ�����ִ� ������ �Ѵ�.
    */
   private boolean selected;
   /**
    * ���� ������ �������� �˷��ִ� ������ �Ѵ�.
    */
   private int turn;
   /**
    * �����ߴ��� �˷��ִ� ������ �Ѵ�.
    */
   private boolean goalFlag;
   private boolean hiddenFlag;
   private Rectangle rectangle;
   
   /**
    * null parameter �����ڴ�.
    */
   public Marker() {}
   
   public Marker(Cane cane, String character, String name) {
	   this.cane = cane;
	   this.character = character;
	   this.name = name;
   }
   
   /**
    * 
    * @param cane ������ ����
    * @param name �̸�
    * @param image url
    * @param turn ������
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
    * @return Ÿ�Ͽ� ������ ��ȣ�� �����Ѵ�.
    */
   public int getMapTitleNum() {
      return mapTileNum;
   }
   /**
    * setter()
    * @param mapTitleNum Ÿ�Ͽ� ������ ��ȣ�� �����Ѵ�.
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
    * @return ���õǾ����� true, �ƴϸ� false�� �����Ѵ�.
    */
   public boolean getSelected() {
      return selected;
   }
   /**
    * setter()
    * @param selected ���ÿ��θ� �����Ѵ�.
    */
   public void setSelected(boolean selected) {
      this.selected = selected;
   }
   /**
    * getter()
    * @return �� ������ �����Ѵ�.
    */
   public int getTurn() {
      return turn;
   }
   /**
    * setter()
    * @param turn �� ����
    */
   public void setTurn(int turn) {
      this.turn = turn;
   }
   /**
    * getter()
    * @return �����ߴ��� ���θ� �����Ѵ�.
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
    * @param goalFlag ���� ����
    */
   public void setGoalFlag(boolean goalFlag) {
      this.goalFlag = goalFlag;
   }
   
   /**
    * ��Ʋ(����,����,��)���� �й��� ���� ������ ����(home)���� �̵���Ű�� �޼ҵ��.
    */
   public void backHome() {}
   /**
    * ��Ʋ(����,����,��) �Ŀ� �����̸� �����ϴ� �żҵ��. 
    * @param image url
    */
   public void reveal(String image) {}
}