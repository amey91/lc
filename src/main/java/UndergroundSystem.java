package main.java;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // customer to station, entryTime
    Map<Integer, Pair<String, Integer>> customersInFlight;
    // stations to pair of total traveltime and number of samples
    Map<Pair<String, String>, Pair<Double, Integer>> stationTimes;

    public UndergroundSystem() {
        customersInFlight = new HashMap<>(50);
        stationTimes = new HashMap<>(50);
    }

    public void checkIn(int id, String stationName, int t) {
        customersInFlight.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> pair = customersInFlight.get(id);
        Double totalTime = t * 1.0 - pair.getValue();
        Pair<String, String> stationPair = new Pair<>(pair.getKey(), stationName);
        if (stationTimes.containsKey(stationPair)) {
            Pair<Double, Integer> stationTime = stationTimes.get(stationPair);
            stationTimes.put(stationPair, new Pair<>(stationTime.getKey() + totalTime, stationTime.getValue() + 1));
        } else {
            stationTimes.put(stationPair, new Pair<>(totalTime, 1));
        }
        customersInFlight.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        Pair<Double, Integer> s = stationTimes.get(new Pair<>(startStation, endStation));

        return s.getKey() * 1.0 / s.getValue();
    }

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
}
