package com.lectopia.quinque.view.bean;

import java.awt.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class Markers {
	private ArrayList<Marker> markers;
	
	public Markers() {
		this(new ArrayList<Marker>());
	}
	
	public Markers(ArrayList<Marker> markers) {
		if (markers == null) markers = new ArrayList<Marker>();
		else this.markers = markers;
	}
	
	public ArrayList<Marker> searchMarker(int tileNum) {
		ArrayList<Marker> resultList = new ArrayList<Marker>();
		ListIterator<Marker> lis = markers.listIterator();
		while(lis.hasNext()) {
			if (lis.next().getMapTitleNum() == tileNum) {
				lis.previous();
				resultList.add(lis.next());
			}
		}
		return resultList;
	}
	
	public int battle(int tileNum) {
		return 0;
	}
	
	public void merge(int tileNum) {
		
	}
	
	
}