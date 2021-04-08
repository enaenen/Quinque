package com.lectopia.quinque.view.bean;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * ��Ű����(Quinque Stone) ���ӿ��� ���� �����ϰ� �ִ� �� Ÿ��(Map Tile)���� �����ϴ� Ŭ�����̴�.
 * <br>- �� Ÿ�ϵ鿡 ���� ��Ű���� ��(Marker)�� �̵� ���ɼ��� �����ϴ� �޼����
 *���� �̵� ������ �� Ÿ�ϵ��� �迭�� ��ȯ�Ͽ� �ִ� �޼��带 �����ϰ� �ִ�.
 * @author QuinqueBliss
 *
 */
public class Map {
	/**
	 * �� Ÿ�� ����Ʈ�� ����Ǿ� �ִ� �÷���(Collection)�� ���� ���� �����̴�.
	 */
	private ArrayList<MapTile> mapTiles;
	
	/**
	 * Map Ŭ������ null �Ķ���� �������̴�.
	 */
	public Map() {
		mapTiles = new ArrayList<MapTile>();
		
		mapTiles.add(new MapTile(1, "/playUI/blueBlock.png", new Rectangle(596, 504, 157, 167), false));
		mapTiles.add(new MapTile(4, "/playUI/blackBlock.png", new Rectangle(606, 437, 129, 125), false));
		mapTiles.add(new MapTile(5, "/playUI/blackBlock.png", new Rectangle(606, 381, 129, 125), false));
		mapTiles.add(new MapTile(22, "/playUI/blueBlock.png", new Rectangle(596, 306, 157, 167), false));
		mapTiles.add(new MapTile(23, "/playUI/blackBlock.png", new Rectangle(606, 238, 129, 125), false));
		mapTiles.add(new MapTile(24, "/playUI/blackBlock.png", new Rectangle(606, 175, 129, 125), false));
		mapTiles.add(new MapTile(13, "/playUI/blackBlock.png", new Rectangle(848, 238, 129, 125), false));
		mapTiles.add(new MapTile(14, "/playUI/blackBlock.png", new Rectangle(771, 192, 129, 125), false));
		mapTiles.add(new MapTile(15, "/playUI/blackBlock.png", new Rectangle(698, 149, 129, 125), false));	
		mapTiles.add(new MapTile(6, "/playUI/blackBlock.png", new Rectangle(848, 394, 129, 125), false));
		mapTiles.add(new MapTile(7, "/playUI/blackBlock.png", new Rectangle(717, 327, 129, 125), false));
		mapTiles.add(new MapTile(8, "/playUI/blackBlock.png", new Rectangle(806, 327, 129, 125), false));
		mapTiles.add(new MapTile(12, "/playUI/blueBlock.png", new Rectangle(912, 306, 157, 167), true));
		mapTiles.add(new MapTile(10, "/playUI/blackBlock.png", new Rectangle(489, 327, 129, 125), false));
		mapTiles.add(new MapTile(2, "/playUI/blackBlock.png", new Rectangle(504, 477, 129, 125), false));
		mapTiles.add(new MapTile(3, "/playUI/blackBlock.png", new Rectangle(432, 431, 129, 125), false));
		mapTiles.add(new MapTile(20, "/playUI/blackBlock.png", new Rectangle(698, 483, 129, 125), false));
		mapTiles.add(new MapTile(21, "/playUI/blackBlock.png", new Rectangle(771, 442, 129, 125), false));
		mapTiles.add(new MapTile(9, "/playUI/blackBlock.png", new Rectangle(363, 381, 129, 125), false));
		mapTiles.add(new MapTile(16, "/playUI/blueBlock.png", new Rectangle(274, 291, 157, 167), false));
		mapTiles.add(new MapTile(17, "/playUI/blackBlock.png", new Rectangle(363, 238, 129, 125), false));
		mapTiles.add(new MapTile(18, "/playUI/blackBlock.png", new Rectangle(436, 197, 129, 125), false));
		mapTiles.add(new MapTile(19, "/playUI/blackBlock.png", new Rectangle(513, 149, 129, 125), false));
		mapTiles.add(new MapTile(25, "/playUI/blueBlock.png", new Rectangle(596, 69, 157, 167), true));
		mapTiles.add(new MapTile(11, "/playUI/blackBlock.png", new Rectangle(396, 327, 129, 125), false));
		
	}
	
	/**
	 * �� Ÿ�� ����Ʈ�� ����Ǿ� �ִ� �÷���(Collection)�� �Ķ���ͷ� �޾Ƽ� Ÿ�� ����Ʈ�� �ʱ�ȭ �����ִ� Map Ŭ������ �������̴�.
	 * @param mapTiles �� Ÿ�� ����Ʈ�� ����Ǿ� �ִ� �÷��� (ArrayList<MapTile>)
	 */
	public Map(ArrayList<MapTile> mapTiles) {
		if (mapTiles == null) mapTiles = new ArrayList<MapTile>();
		this.mapTiles = mapTiles;
	}
	
	/**
	 * �� Ÿ�� ����Ʈ �÷����� �����ϰ� �ִ� mapTiles ���������� �������� ��ȯ�Ͽ� �ִ� �޼����̴�.
	 * @return ���� �����Ǿ� �ִ� �� Ÿ�� ����Ʈ �÷����� ������
	 */
	public ArrayList<MapTile> getMapTiles() {
		return mapTiles;
	}
	
	/**
	 * ���� �� Ÿ�� ����Ʈ �÷����� �����ϰ� �ִ� ������ ���� �Ķ���ͷ� ������ �� Ÿ�� ����Ʈ �÷����� �����ϵ��� �����ϴ� �޼����̴�.
	 * @param mapTiles ������ �� Ÿ�� ����Ʈ �÷��� (ArrayList<MapTile>)
	 */
	public void setMapTiles(ArrayList<MapTile> mapTiles) {
		this.mapTiles = mapTiles;
	}
	
	/**
	 * ������ �� Ÿ���� Index ���� boolean ���� �Ķ���ͷ� �޾Ƽ� Index ���� �ش��ϴ� �� Ÿ�Ͽ� ���� ��(Marker)�� �̵� ���ɼ���
	 * ������ boolean �� (true: �̵� ������ �� Ÿ��, false: �̵� �Ұ����� �� Ÿ��) ���� �����Ͽ� �ִ� �޼����̴�. 
	 * @param tileNum ���� �̵� ���ɼ��� ������ �� Ÿ���� Index (int)
	 * @param available ������ ���� �̵� ���ɼ� (boolean)
	 */
	public void setAvailable(int tileNum, boolean available) {
	}
	
	/**
	 * ������ �� Ÿ���� Index �迭�� boolean ���� �Ķ���ͷ� �޾Ƽ� Index �迭�� �ش��ϴ� �� Ÿ�Ͽ� ���� ��(Marker)�� �̵� ���ɼ���
	 * ������ boolean �� (true: �̵� ������ �� Ÿ��, false: �̵� �Ұ����� �� Ÿ��) ���� �����Ͽ� �ִ� �޼����̴�.
	 * @param tileNum ���� �̵� ���ɼ��� ������ �� Ÿ���� Index �迭 (int[])
	 * @param available ������ ���� �̵� ���ɼ� (boolean)
	 */
	public void setAvailable(int[] tileNum, boolean available) {
	}
	
	/**
	 * ������ ��(Marker)�� ���� �� Ÿ���� �̵� ���ɼ��� true ���·�, �̵� ������ ������ �� Ÿ�ϵ��� Index ���� �迭�� ��ȯ�Ͽ� �ִ� �޼����̴�.
	 * @return ������ ��(Marker)�� �̵��� �� �ִ� �� Ÿ�ϵ��� Index �迭 (int[])
	 */
	public int[] getAvailable() {
		return null;
	}
	
	public ArrayList<ArrayList<Object>> getResource() {
		ArrayList<ArrayList<Object>> resources = new ArrayList<ArrayList<Object>>();
		int mapTilesSize = mapTiles.size();
		for (int i = 0; i < mapTilesSize; i++) {
			ArrayList<Object> resource = new ArrayList<Object>();
			int resourceSize = resource.size();
			resource.add(mapTiles.get(i).getTileNum());
			resource.add(mapTiles.get(i).getImage());
			resource.add(mapTiles.get(i).getRectangle());
			resources.add(resource);
		}
		return resources;
	}
}