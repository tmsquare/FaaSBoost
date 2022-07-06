package com.openfaas.function.repository;

import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import com.openfaas.function.entity.*;

import java.util.UUID;

import java.util.Date;

public class TripRepositoryImpl implements TripRepository {

    String gaoTieOne = "GaoTieOne";
    String shanghai = "shanghai";
    String suzhou = "suzhou";
    String taiyuan = "taiyuan";

    @Override
    public boolean init(){

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
                .host("10.110.72.158")
                .port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        builder.remoteCache("trip-ispn")
                .configuration("<infinispan><cache-container><distributed-cache mode=\"SYNC\" name=\"trip-ispn\" owners=\"2\" statistics=\"true\"><encoding media-type=\"application/x-protostream\"/><persistence><file-store/></persistence></distributed-cache></cache-container></infinispan>");

        try (RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build())) {

            TravelInfo info1 = new TravelInfo();
            info1.setTripId("G1234");
            info1.setTrainTypeId(gaoTieOne);
            info1.setRouteId("92708982-77af-4318-be25-57ccb0ff69ad");
            info1.setStartingStationId(shanghai);
            info1.setStationsId(suzhou);
            info1.setTerminalStationId(taiyuan);
            info1.setStartingTime(new Date("Mon May 04 09:00:00 GMT+0800 2013")); //NOSONAR
            info1.setEndTime(new Date("Mon May 04 15:51:52 GMT+0800 2013")); //NOSONAR
            Trip trip1 = new Trip(new TripId(info1.getTripId()), info1.getTrainTypeId(), info1.getStartingStationId(),
                    info1.getStationsId(), info1.getTerminalStationId(), info1.getStartingTime(), info1.getEndTime());
            trip1.setRouteId(info1.getRouteId());

            TravelInfo info2 = new TravelInfo();
            info2.setTripId("G1235");
            info2.setTrainTypeId(gaoTieOne);
            info2.setRouteId("aefcef3f-3f42-46e8-afd7-6cb2a928bd3d");
            info2.setStartingStationId(shanghai);
            info2.setStationsId(suzhou);
            info2.setTerminalStationId(taiyuan);
            info2.setStartingTime(new Date("Mon May 04 12:00:00 GMT+0800 2013")); //NOSONAR
            info2.setEndTime(new Date("Mon May 04 17:51:52 GMT+0800 2013")); //NOSONAR
            Trip trip2 = new Trip(new TripId(info2.getTripId()), info2.getTrainTypeId(), info2.getStartingStationId(),
                    info2.getStationsId(), info2.getTerminalStationId(), info2.getStartingTime(), info2.getEndTime());
            trip2.setRouteId(info2.getRouteId());

            TravelInfo info3 = new TravelInfo();
            info3.setTripId("G1236");
            info3.setTrainTypeId(gaoTieOne);
            info3.setRouteId("a3f256c1-0e43-4f7d-9c21-121bf258101f");
            info3.setStartingStationId(shanghai);
            info3.setStationsId(suzhou);
            info3.setTerminalStationId(taiyuan);
            info3.setStartingTime(new Date("Mon May 04 14:00:00 GMT+0800 2013")); //NOSONAR
            info3.setEndTime(new Date("Mon May 04 20:51:52 GMT+0800 2013")); //NOSONAR
            Trip trip3 = new Trip(new TripId(info3.getTripId()), info3.getTrainTypeId(), info3.getStartingStationId(),
                    info3.getStationsId(), info3.getTerminalStationId(), info3.getStartingTime(), info3.getEndTime());
            trip3.setRouteId(info3.getRouteId());

            TravelInfo info4 = new TravelInfo();
            info4.setTripId("G1237");
            info4.setTrainTypeId("GaoTieTwo");
            info4.setRouteId("084837bb-53c8-4438-87c8-0321a4d09917");
            info4.setStartingStationId(shanghai);
            info4.setStationsId(suzhou);
            info4.setTerminalStationId(taiyuan);
            info4.setStartingTime(new Date("Mon May 04 08:00:00 GMT+0800 2013")); //NOSONAR
            info4.setEndTime(new Date("Mon May 04 17:21:52 GMT+0800 2013")); //NOSONAR
            Trip trip4 = new Trip(new TripId(info4.getTripId()), info4.getTrainTypeId(), info4.getStartingStationId(),
                    info4.getStationsId(), info4.getTerminalStationId(), info4.getStartingTime(), info4.getEndTime());
            trip4.setRouteId(info4.getRouteId());

            TravelInfo info5 = new TravelInfo();
            info5.setTripId("D1345");
            info5.setTrainTypeId("DongCheOne");
            info5.setRouteId("f3d4d4ef-693b-4456-8eed-59c0d717dd08");
            info5.setStartingStationId(shanghai);
            info5.setStationsId(suzhou);
            info5.setTerminalStationId(taiyuan);
            info5.setStartingTime(new Date("Mon May 04 07:00:00 GMT+0800 2013")); //NOSONAR
            info5.setEndTime(new Date("Mon May 04 19:59:52 GMT+0800 2013")); //NOSONAR
            Trip trip5 = new Trip(new TripId(info5.getTripId()), info5.getTrainTypeId(), info5.getStartingStationId(),
                    info5.getStationsId(), info5.getTerminalStationId(), info5.getStartingTime(), info5.getEndTime());
            trip5.setRouteId(info5.getRouteId());


            RemoteCache<String, Trip> cache = cacheManager.getCache("trip-ispn");

            cache.put("G1234", trip1);
            cache.put("G1235", trip2);
            cache.put("G1236", trip3);
            cache.put("G1237", trip4);
            cache.put("D1345", trip5);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
