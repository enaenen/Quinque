package com.lectopia.quinque.view.bean;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * 퀸키스톤(Quinque Stone) 게임에서 맵을 구성하고 있는 맵 타일(Map Tile)들을 관리하는 클래스이다.
 * <br>- 맵 타일들에 대한 퀸키스톤 말(Marker)의 이동 가능성을 설정하는 메서드와
 *말이 이동 가능한 맵 타일들을 배열로 반환하여 주는 메서드를 제공하고 있다.
 * @author QuinqueBliss
 *
 */
public class Map {
	/**
	 * 맵 타일 리스트가 저장되어 있는 컬렉션(Collection)에 대한 참조 변수이다.
	 */
	private ArrayList<MapTile> mapTiles;
	
	/**
	 * Map 클래스의 null 파라미터 생성자이다.
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
	 * 맵 타일 리스트가 저장되어 있는 컬렉션(Collection)을 파라미터로 받아서 타일 리스트를 초기화 시켜주는 Map 클래스의 생성자이다.
	 * @param mapTiles 맵 타일 리스트가 저장되어 있는 컬렉션 (ArrayList<MapTile>)
	 */
	public Map(ArrayList<MapTile> mapTiles) {
		if (mapTiles == null) mapTiles = new ArrayList<MapTile>();
		this.mapTiles = mapTiles;
	}
	
	/**
	 * 맵 타일 리스트 컬렉션을 참조하고 있는 mapTiles 참조변수의 참조값을 반환하여 주는 메서드이다.
	 * @return 현재 설정되어 있는 맵 타일 리스트 컬렉션의 참조값
	 */
	public ArrayList<MapTile> getMapTiles() {
		return mapTiles;
	}
	
	/**
	 * 현재 맵 타일 리스트 컬렉션이 참조하고 있는 연결을 끊고 파라미터로 보내준 맵 타일 리스트 컬렉션을 참조하도록 설정하는 메서드이다.
	 * @param mapTiles 설정할 맵 타일 리스트 컬렉션 (ArrayList<MapTile>)
	 */
	public void setMapTiles(ArrayList<MapTile> mapTiles) {
		this.mapTiles = mapTiles;
	}
	
	/**
	 * 설정할 맵 타일의 Index 값과 boolean 값을 파라미터로 받아서 Index 값에 해당하는 맵 타일에 대한 말(Marker)의 이동 가능성을
	 * 전달한 boolean 값 (true: 이동 가능한 맵 타일, false: 이동 불가능한 맵 타일) 으로 설정하여 주는 메서드이다. 
	 * @param tileNum 맵의 이동 가능성을 설정할 맵 타일의 Index (int)
	 * @param available 설정할 맵의 이동 가능성 (boolean)
	 */
	public void setAvailable(int tileNum, boolean available) {
	}
	
	/**
	 * 설정할 맵 타일의 Index 배열과 boolean 값을 파라미터로 받아서 Index 배열에 해당하는 맵 타일에 대한 말(Marker)의 이동 가능성을
	 * 전달한 boolean 값 (true: 이동 가능한 맵 타일, false: 이동 불가능한 맵 타일) 으로 설정하여 주는 메서드이다.
	 * @param tileNum 맵의 이동 가능성을 설정할 맵 타일의 Index 배열 (int[])
	 * @param available 설정할 맵의 이동 가능성 (boolean)
	 */
	public void setAvailable(int[] tileNum, boolean available) {
	}
	
	/**
	 * 선택한 말(Marker)에 대한 맵 타일의 이동 가능성이 true 상태로, 이동 가능한 상태인 맵 타일들의 Index 값을 배열로 반환하여 주는 메서드이다.
	 * @return 선택한 말(Marker)이 이동할 수 있는 맵 타일들의 Index 배열 (int[])
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