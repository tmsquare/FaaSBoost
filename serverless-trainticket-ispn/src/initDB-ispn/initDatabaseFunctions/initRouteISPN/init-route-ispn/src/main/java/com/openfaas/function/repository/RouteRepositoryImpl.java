package com.openfaas.function.repository;

import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import com.openfaas.function.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class RouteRepositoryImpl implements RouteRepository {

    private String shanghai = "shanghai";
    private String taiyuan = "taiyuan";
    private String nanjing = "nanjing";

    @Override
    public boolean init() {

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
                .host("10.110.72.158")
                .port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        builder.remoteCache("route-ispn")
                .configuration("<infinispan><cache-container><distributed-cache mode=\"SYNC\" name=\"route-ispn\" owners=\"2\" statistics=\"true\"><encoding media-type=\"application/x-protostream\"/><persistence><file-store/></persistence></distributed-cache></cache-container></infinispan>");

        try (RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build())) {

            RouteInfo info1 = new RouteInfo();
            info1.setId("0b23bd3e-876a-4af3-b920-c50a90c90b04");
            info1.setStartStation(shanghai);
            info1.setEndStation(taiyuan);
            info1.setStationList("shanghai,nanjing,shijiazhuang,taiyuan");
            info1.setDistanceList("0,350,1000,1300");

            RouteInfo info2 = new RouteInfo();
            info2.setId("9fc9c261-3263-4bfa-82f8-bb44e06b2f52");
            info2.setStartStation(nanjing);
            info2.setEndStation("beijing");
            info2.setStationList("nanjing,xuzhou,jinan,beijing");
            info2.setDistanceList("0,500,700,1200");

            RouteInfo info3 = new RouteInfo();
            info3.setId("d693a2c5-ef87-4a3c-bef8-600b43f62c68");
            info3.setStartStation(taiyuan);
            info3.setEndStation(shanghai);
            info3.setStationList("taiyuan,shijiazhuang,nanjing,shanghai");
            info3.setDistanceList("0,300,950,1300");

            RouteInfo info4 = new RouteInfo();
            info4.setId("20eb7122-3a11-423f-b10a-be0dc5bce7db");
            info4.setStartStation(shanghai);
            info4.setEndStation(taiyuan);
            info4.setStationList("shanghai,taiyuan");
            info4.setDistanceList("0,1300");

            RouteInfo info5 = new RouteInfo();
            info5.setId("1367db1f-461e-4ab7-87ad-2bcc05fd9cb7");
            info5.setStartStation("shanghaihongqiao");
            info5.setEndStation("hangzhou");
            info5.setStationList("shanghaihongqiao,jiaxingnan,hangzhou");
            info5.setDistanceList("0,150,300");

            RouteInfo info6 = new RouteInfo();
            info6.setId("92708982-77af-4318-be25-57ccb0ff69ad");
            info6.setStartStation(nanjing);
            info6.setEndStation(shanghai);
            info6.setStationList("nanjing,zhenjiang,wuxi,suzhou,shanghai");
            info6.setDistanceList("0,100,150,200,250");

            RouteInfo info7 = new RouteInfo();
            info7.setId("aefcef3f-3f42-46e8-afd7-6cb2a928bd3d");
            info7.setStartStation(nanjing);
            info7.setEndStation(shanghai);
            info7.setStationList("nanjing,shanghai");
            info7.setDistanceList("0,250");

            RouteInfo info8 = new RouteInfo();
            info8.setId("a3f256c1-0e43-4f7d-9c21-121bf258101f");
            info8.setStartStation(nanjing);
            info8.setEndStation(shanghai);
            info8.setStationList("nanjing,suzhou,shanghai");
            info8.setDistanceList("0,200,250");

            RouteInfo info9 = new RouteInfo();
            info9.setId("084837bb-53c8-4438-87c8-0321a4d09917");
            info9.setStartStation("suzhou");
            info9.setEndStation(shanghai);
            info9.setStationList("suzhou,shanghai");
            info9.setDistanceList("0,50");

            RouteInfo info10 = new RouteInfo();
            info10.setId("f3d4d4ef-693b-4456-8eed-59c0d717dd08");
            info10.setStartStation(shanghai);
            info10.setEndStation("suzhou");
            info10.setStationList("shanghai,suzhou");
            info10.setDistanceList("0,50");

            RemoteCache<UUID, RouteInfo> cache = cacheManager.getCache("price-ispn");

            cache.put(UUID.fromString("0b23bd3e-876a-4af3-b920-c50a90c90b04"), info1);
            cache.put(UUID.fromString("9fc9c261-3263-4bfa-82f8-bb44e06b2f52"), info2);
            cache.put(UUID.fromString("d693a2c5-ef87-4a3c-bef8-600b43f62c68"), info3);
            cache.put(UUID.fromString("20eb7122-3a11-423f-b10a-be0dc5bce7db"), info4);
            cache.put(UUID.fromString("1367db1f-461e-4ab7-87ad-2bcc05fd9cb7"), info5);
            cache.put(UUID.fromString("92708982-77af-4318-be25-57ccb0ff69ad"), info6);
            cache.put(UUID.fromString("aefcef3f-3f42-46e8-afd7-6cb2a928bd3d"), info7);
            cache.put(UUID.fromString("a3f256c1-0e43-4f7d-9c21-121bf258101f"), info8);
            cache.put(UUID.fromString("084837bb-53c8-4438-87c8-0321a4d09917"), info9);
            cache.put(UUID.fromString("f3d4d4ef-693b-4456-8eed-59c0d717dd08"), info10);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public Route RouteInfo2Route(RouteInfo info) {
        if (info == null)
            return null;

        String[] stations = info.getStationList().split(",");
        String[] distances = info.getDistanceList().split(",");
        List<String> stationList = new ArrayList<>();
        List<Integer> distanceList = new ArrayList<>();

        if (stations.length != distances.length) {
            return null;
        }

        for (int i = 0; i < stations.length; i++) {
            stationList.add(stations[i]);
            distanceList.add(Integer.parseInt(distances[i]));
        }

        Route route = new Route();
        route.setId(info.getId());
        route.setStartStationId(info.getStartStation());
        route.setTerminalStationId(info.getEndStation());
        route.setStations(stationList);
        route.setDistances(distanceList);
        return route;

    }
}
