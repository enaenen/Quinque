package com.lectopia.quinque.view.bean;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.lectopia.quinque.service.GameServiceManager;

public class MarkerList {
	private ArrayList<ArrayList<Marker>> markerList;
	
	public MarkerList() {
		markerList = new ArrayList<ArrayList<Marker>>();
		
		ArrayList<Marker> marker1 = new ArrayList<Marker>();
		marker1.add(new Marker(Cane.ROCK, "Rabbit", "Rabbit Rock"));
		
		ArrayList<Marker> marker2 = new ArrayList<Marker>();
		marker2.add(new Marker(Cane.SCISSORS, "Rabbit", "Rabbit Scissors"));
		
		ArrayList<Marker> marker3 = new ArrayList<Marker>();
		marker3.add(new Marker(Cane.PAPER, "Rabbit", "Rabbit Paper"));
		
		ArrayList<Marker> marker4 = new ArrayList<Marker>();
		marker4.add(new Marker(Cane.QUESTIONMARK, "Rabbit", "Rabbit Questionmark"));
		
		ArrayList<Marker> marker5 = new ArrayList<Marker>();
		marker5.add(new Marker(Cane.ROCK, "Turtle", "Turtle Rock"));
		
		ArrayList<Marker> marker6 = new ArrayList<Marker>();
		marker6.add(new Marker(Cane.SCISSORS, "Turtle", "Turtle Scissors"));
		
		ArrayList<Marker> marker7 = new ArrayList<Marker>();
		marker7.add(new Marker(Cane.PAPER, "Turtle", "Turtle Paper"));
		
		ArrayList<Marker> marker8 = new ArrayList<Marker>();
		marker8.add(new Marker(Cane.QUESTIONMARK, "Turtle", "Turtle Questionmark"));
		
		markerList.add(marker1);
		markerList.add(marker2);
		markerList.add(marker3);
		markerList.add(marker4);
		markerList.add(marker5);
		markerList.add(marker6);
		markerList.add(marker7);
		markerList.add(marker8);
		
	}
	
	public MarkerList(ArrayList<ArrayList<Marker>> markerList) {
		if (markerList == null) markerList = new ArrayList<ArrayList<Marker>>();
		else this.markerList = markerList;
	}
	
	public void setMarkerList() {
		int turn1 = GameServiceManager.getInstance().characterTurn("Rabbit");
		
		if (turn1 == 1) {
			for (int i = 0; i < markerList.size(); i++) {
				for (int j = 0; j < markerList.get(i).size(); j++) {
					Marker marker = markerList.get(i).get(j);
					if (marker.getCharacter().equals("Rabbit")) {
						marker.setTurn(1);
						marker.setImage("/playUI/localrabbit.png");
						switch (marker.getCane()) {
							case ROCK : 
								marker.setRectangle(new Rectangle(382, 468, 119, 169));
								break;
							case SCISSORS :
								marker.setRectangle(new Rectangle(316, 417, 81, 150));
								break;
							case PAPER :
								marker.setRectangle(new Rectangle(229, 366, 99, 161));
								break;
							case QUESTIONMARK :
								marker.setRectangle(new Rectangle(137, 286, 114, 197));
								break;
						}
					}
				}
			}
		}
		else {
			for (int i = 0; i < markerList.size(); i++) {
				for (int j = 0; j < markerList.get(i).size(); j++) {
					Marker marker = markerList.get(i).get(j);
					if (marker.getCharacter().equals("Rabbit")) {
						marker.setTurn(2);
						marker.setImage("/playUI/localrabbit.png");
						switch (marker.getCane()) {
							case ROCK : 
								marker.setRectangle(new Rectangle(437, -16, 99, 161));
								break;
							case SCISSORS :
								marker.setRectangle(new Rectangle(363, 34, 99, 161));
								break;
							case PAPER :
								marker.setRectangle(new Rectangle(281, 85, 99, 161));
								break;
							case QUESTIONMARK :
								marker.setRectangle(new Rectangle(169, 128, 122, 169));
								break;
						}
					}
				}
			}
		}
		
		int turn2 = GameServiceManager.getInstance().characterTurn("Turtle");
		
		
		if (turn2 == 1) {
			for (int i = 0; i < markerList.size(); i++) {
				for (int j = 0; j < markerList.get(i).size(); j++) {
					Marker marker = markerList.get(i).get(j);
					if (marker.getCharacter().equals("Turtle")) {
						marker.setTurn(1);
						marker.setImage("/playUI/localturtle.png");
						switch (marker.getCane()) {
							case ROCK : 
								marker.setRectangle(new Rectangle(382, 468, 119, 169));
								break;
							case SCISSORS :
								marker.setRectangle(new Rectangle(316, 417, 81, 150));
								break;
							case PAPER :
								marker.setRectangle(new Rectangle(229, 366, 99, 161));
								break;
							case QUESTIONMARK :
								marker.setRectangle(new Rectangle(137, 286, 114, 197));
								break;
						}
					}
				}
			}
		}
		else {
			for (int i = 0; i < markerList.size(); i++) {
				for (int j = 0; j < markerList.get(i).size(); j++) {
					Marker marker = markerList.get(i).get(j);
					if (marker.getCharacter().equals("Turtle")) {
						marker.setTurn(2);
						marker.setImage("/playUI/localturtle.png");
						switch (marker.getCane()) {
							case ROCK : 
								marker.setRectangle(new Rectangle(437, -16, 99, 161));
								break;
							case SCISSORS :
								marker.setRectangle(new Rectangle(363, 34, 99, 161));
								break;
							case PAPER :
								marker.setRectangle(new Rectangle(281, 85, 99, 161));
								break;
							case QUESTIONMARK :
								marker.setRectangle(new Rectangle(169, 128, 122, 169));
								break;
						}
					}
				}
			}
		}
	}
	
	public ArrayList<Marker> searchMarkers(int tileNum) {
		ArrayList<Marker> resultList = new ArrayList<Marker>();
		int size = markerList.size();
		for (int i = 0; i < size; i++) {
			ArrayList<Marker> markers = markerList.get(i);
			int markersSize = markers.size();
			for (int j = 0; j < markersSize; j++) {
				if (markers.get(j).getMapTitleNum() == tileNum) {
					resultList.add(markers.get(j));
				}
			}
		}
		return resultList;
	}
	
	public int battle(int tileNum) {
		return 0;
	}
	
	public void merge(int tileNum) {
		
	}
	
	public ArrayList<ArrayList<Object>> getResource() {
		ArrayList<ArrayList<Object>> resources = new ArrayList<ArrayList<Object>>();
		int markerListSize = markerList.size();
		for (int i = 0; i < markerListSize; i++) {
			ArrayList<Object> resource = new ArrayList<Object>();
			ArrayList<Marker> markers = markerList.get(i);
			int markersSize = markers.size();
			for (int j = 0; j < markersSize; j++) {
				resource.add(markers.get(j).getName());
				resource.add(markers.get(j).getImage());
				resource.add(markers.get(j).getRectangle());
			}
			resources.add(resource);
		}
		return resources;
	}
	

}