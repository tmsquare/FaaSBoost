package entities;

import java.util.List;


import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Route {

    @ProtoField(number = 1)
    public String id;

    @ProtoField(number = 2)
    public List<String> stations;

    @ProtoField(number = 3)
    public List<Integer> distances;

    @ProtoField(number = 4)
    public String startStationId;

    @ProtoField(number = 5)
    public String terminalStationId;

    public Route() {
        //Default Constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public List<Integer> getDistances() {
        return distances;
    }

    public void setDistances(List<Integer> distances) {
        this.distances = distances;
    }

    public String getStartStationId() {
        return startStationId;
    }

    public void setStartStationId(String startStationId) {
        this.startStationId = startStationId;
    }

    public String getTerminalStationId() {
        return terminalStationId;
    }

    public void setTerminalStationId(String terminalStationId) {
        this.terminalStationId = terminalStationId;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", stations=" + stations +
                ", distances=" + distances +
                ", startStationId='" + startStationId + '\'' +
                ", terminalStationId='" + terminalStationId + '\'' +
                '}';
    }
}
