package com.openfaas.function.repository;

import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import com.openfaas.function.entity.Station;

import java.util.UUID;

import java.util.ArrayList;

public class StationRepositoryImpl implements StationRepository {

    private ArrayList<Station> stations = new ArrayList<>();

    @Override
    public boolean init(){

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
                .host("10.97.152.242")
                .port(ConfigurationProperties.DEFAULT_HOTROD_PORT);

        LibraryInitializer initializer = new LibraryInitializerImpl();
        builder.addContextInitializer(initializer);

        builder.remoteCache("station-ispn")
                .configuration("<infinispan><cache-container><distributed-cache mode=\"SYNC\" name=\"station-ispn\" owners=\"2\" statistics=\"true\"><encoding media-type=\"application/x-protostream\"/><persistence><file-store/></persistence></distributed-cache></cache-container></infinispan>");

        try (RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build())) {

            Station info1 = new Station();
            info1.setId("shanghai");
            info1.setName("Shang Hai");
            info1.setStayTime(10);
            stations.add(info1);

            Station info2 = new Station();
            info2.setId("shanghaihongqiao");
            info2.setName("Shang Hai Hong Qiao");
            info2.setStayTime(10);

            Station info3 = new Station();
            info3.setId("taiyuan");
            info3.setName("Tai Yuan");
            info3.setStayTime(5);

            Station info4 = new Station();
            info4.setId("beijing");
            info4.setName("Bei Jing");
            info4.setStayTime(10);

            Station info5 = new Station();
            info5.setId("nanjing");
            info5.setName("Nan Jing");
            info5.setStayTime(8);

            Station info6 = new Station();
            info6.setId("shijiazhuang");
            info6.setName("Shi Jia Zhuang");
            info6.setStayTime(8);

            Station info7 = new Station();
            info7.setId("xuzhou");
            info7.setName("Xu Zhou");
            info7.setStayTime(7);

            Station info8 = new Station();
            info8.setId("jinan");
            info8.setName("Ji Nan");
            info8.setStayTime(5);

            Station info9 = new Station();
            info9.setId("hangzhou");
            info9.setName("Hang Zhou");
            info9.setStayTime(9);

            Station info10 = new Station();
            info10.setId("jiaxingnan");
            info10.setName("Jia Xing Nan");
            info10.setStayTime(2);

            Station info11 = new Station();
            info11.setId("zhenjiang");
            info11.setName("Zhen Jiang");
            info11.setStayTime(2);

            Station info12 = new Station();
            info12.setId("wuxi");
            info12.setName("Wu Xi");
            info12.setStayTime(3);

            Station info13 = new Station();
            info13.setId("suzhou");
            info13.setName("Su Zhou");
            info13.setStayTime(3);


            RemoteCache<String, Station> cache = cacheManager.getCache("station-ispn");

            cache.put("shanghai", info1);
            cache.put("shanghaihongqiao", info2);
            cache.put("taiyuan", info3);
            cache.put("beijing", info4);
            cache.put("nanjing", info5);
            cache.put("shijiazhuang", info6);
            cache.put("xuzhou", info7);
            cache.put("xuzhou", info8);
            cache.put("hangzhou", info9);
            cache.put("jiaxingnan", info10);
            cache.put("zhenjiang", info11);
            cache.put("wuxi", info12);
            cache.put("suzhou", info13);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
