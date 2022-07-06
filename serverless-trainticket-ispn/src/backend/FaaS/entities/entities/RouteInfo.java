package entities;


import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class RouteInfo {
    @ProtoField(number = 1)
    private String id;

    @ProtoField(number = 2)
    private String startStation;

    @ProtoField(number = 3)
    private String endStation;

    @ProtoField(number = 4)
    private String stationList;

    @ProtoField(number = 5)
    private String distanceList;

    public RouteInfo() {
        //Default Constructor
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public String getStationList() {
        return stationList;
    }

    public void setStationList(String stationList) {
        this.stationList = stationList;
    }

    public String getDistanceList() {
        return distanceList;
    }

    public void setDistanceList(String distanceList) {
        this.distanceList = distanceList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
