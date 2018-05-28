package it.polito.tdp.babs.model;

import java.util.HashMap;
import java.util.Map;

public class StationIdMap {

	
	private Map<Integer,Station> map = new HashMap<>();
	
	public Station get(int stationId) {
		return map.get(stationId);
	}
	
	public Station get(Station station) {
		Station old = map.get(station.getStationID());
		if(old!=null) {
			return old;
		}
		map.put(station.getStationID(),station);
		return station;
	}
	public void put(Station station) {
		map.put(station.getStationID(),station);
	}
	
}
