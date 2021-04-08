package com.lectopia.quinque.service;

import java.util.ArrayList;

import com.lectopia.quinque.view.bean.Map;
import com.lectopia.quinque.view.bean.Marker;
import com.lectopia.quinque.view.bean.MarkerList;
import com.lectopia.quinque.view.bean.Player;
import com.lectopia.quinque.view.bean.QuinqueStone;

public class GameServiceManager {
	private static GameServiceManager instance;
	private Map map;
	private Player[] player;
	private QuinqueStone quinqueStone;
	private MarkerList markerList; 
	private int currentTurn;
	
	static {
		instance = new GameServiceManager(); 
	}
	
	private GameServiceManager() {
		map = new Map();
		player = new Player[4];
		player[0] = new Player(1, "empty");
		player[1] = new Player(2, "empty");
		
		quinqueStone = new QuinqueStone();
		markerList = new MarkerList();
		currentTurn = 1;
	}
	
	static public GameServiceManager getInstance() {
		return instance;
	}
	
	public int rollStone() {
		return quinqueStone.roll();
	}
	
	public int rollStone(int cp) {
		return quinqueStone.roll(cp);
	}
	
	public int[] calcDestination(int num) {
		return null;
	}
	
	public int[][] moveMarker(int num) {
		return null;
	}
	
	public String changeTurn() {
		return null;
	}
	
	public int checkLeftAction() {
		return 0;
	}
	
	public void resetGame() {
		
	}
	
	public void setPlayerMarker(String name1, String name2) {
		player[0].setSelectedMarker(name1);
		player[1].setSelectedMarker(name2);
		
		markerList.setMarkerList();
	}
	
	public ArrayList<ArrayList<Object>> getCompSource() {
		return null;
	}
	
	public ArrayList<ArrayList<Object>> getMarkerResource() {
		return markerList.getResource();
	}
	
	public ArrayList<ArrayList<Object>> getMapResource() {
		return map.getResource();
	}
	
	public Marker selectMarker(String name) {
		return null;
	}
	
	public Marker searchMarker(String name) {
		return null;
	}
	
	public int characterTurn(String character) {
		int res = 0;
		for (int i = 0; i < player.length && player[i] != null; i++) {
			if (character.equals(player[i].getSelectedMarker())) {
				res = i;
			}
		}
		return res + 1;
	}
	
	
	
//	public int getPlayerNum() {
//		int i = 0;
//		while(player[i] != null) {
//			i++;
//		}
//		return (i - 1);
//	}
}