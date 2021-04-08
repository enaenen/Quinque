package com.lectopia.quinque.view.bean;

import java.awt.Rectangle;

/**
 * ��Ű����(Quinque Stone) ���ӿ��� �� Ÿ��(Map Tile)�� ���õ� ������ ��� �ִ� Ŭ�����̴�.
 * <br>- ���� �̷�� �ִ� Ÿ�� ������ ���� ���� �⺻ �����Ͱ� �Ǵ� Ŭ�����̴�.
 * <br>- Ÿ�Ͽ� ���� �⺻ �������� Ÿ���� ��ġ ����(index)�� ��Ÿ���� tileNum ������
 * Ÿ���� ���� �̵��� �� �ִ� ���·� Ȱ��ȭ�� ���������� ��Ÿ���� available ����,
 * �׸��� Ÿ���� �������� �����ϴ��� ���θ� �Ǵ��ϴ� scFlag ������ �����Ѵ�. 
 * @author QuinqueBliss
 *
 */

public class MapTile {
	/**
	 * �� Ÿ���� Index ��ȣ�� ����� �����̴�.
	 */
	private int tileNum;
	
	private String image;
	private Rectangle rectangle;
	
//	/**
//	 * �� Ÿ���� ���°� ��Ű������ ��(Marker)�� �̵��� �� �ִ� �������� ���ο� ���� ������ ��� �ִ� �����̴�.
//	 * <br>- default ���� false�� ���� �̵��� �� ���� �� Ÿ������ �ǹ��Ѵ�.
//	 * <br>- ���� true�� �� Ÿ���� ��(Marker)�� �̵��� �� �ִ� �� Ÿ������ �ǹ��Ѵ�.
//	 */
//	private boolean available;
	
	
	/**
	 * �� Ÿ�Ͽ��� ��(Marker)�� �̵��� �� �ִ� �������� ���� ������ �Ǵ��ϴ� Flag �����̴�.
	 * <br>- default ���� false�� ���� �̵��� �� �ִ� �������� �������� ������ �ǹ��Ѵ�.
	 * <br>- ���� true ������ �� Ÿ���� ��(Marker)�� �̵��� �� �ִ� �������� �������� �ǹ��Ѵ�.
	 */
	private boolean scFlag;
	
	/**
	 * MapTile Ŭ������ null �Ķ���� �������̴�.
	 */
	public MapTile() {
		
	}
	/**
	 * Ÿ���� Index ��ȣ�� �������� ������ �Ǵ��ϴ� scFlag ������ ���� boolean Ÿ���� �Ķ���ͷ� �޴� �������̴�.
	 * @param tileNum Ÿ���� Index ��ȣ (int)
	 * @param scFlag �������� ���� ���� (boolean)
	 */
	public MapTile(int tileNum, boolean scFlag) {
		this.tileNum = tileNum;
		this.scFlag = scFlag;
	}
	
	public MapTile(int tileNum, String image, Rectangle rectangle, boolean scFlag) {
		this.tileNum = tileNum;
		this.image = image;
		this.rectangle = rectangle;
		this.scFlag = scFlag;
	}
	
	/**
	 * �� Ÿ�� Ŭ������ �ν��Ͻ� ��ü�� Index ��ȣ�� ��ȯ�ϴ� �޼����̴�.
	 * @return Ÿ���� Index ��ȣ
	 */
	public int getTileNum() {
		return this.tileNum;
	}
	
	/**
	 * �� Ÿ�� Ŭ������ �ν��Ͻ� ��ü�� Index ��ȣ�� �����ϴ� �޼����̴�.
	 * @param tileNum ������ �� Ÿ���� Index ��ȣ (int)
	 */
	public void setTileNum(int tileNum) {
		this.tileNum = tileNum;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public void setRectangle(Rectangle rectangle) { 
		this.rectangle = rectangle;
	}
	
//	/**
//	 * �� Ÿ�� Ŭ������ �ν��Ͻ� ��ü�� ���� �̵��� �� �ִ� Ÿ������ ����(boolean)�� ��ȯ�ϴ� �޼����̴�.
//	 * @return �� Ÿ���� ���� �̵��� �� �ִ� Ÿ������ ���� (boolean)
//	 */
//	public boolean getAvailable() {
//		return this.available;
//	}
//	
//	/**
//	 * �� Ÿ�� Ŭ������ �ν��Ͻ� ��ü�� ���� �̵��� �� �ִ� Ÿ������ ����(boolean)�� �����ϴ� �޼����̴�.
//	 * @param available �� Ÿ�Ͽ� ���Ͽ� ������ ���� �̵��� �� �ִ� Ÿ������ ���ο� ���� �� (boolean)
//	 */
//	public void setAvailable(boolean available) {
//		this.available = available;
//	}
}