package com.code.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.ho.yaml.Yaml;

public class ZKTest1 {

    public static void main(String[] args) {
        try {
            ZooKeeper zkClient = new ZooKeeper("47.96.154.183:2181", 500, new Watcher() {

                @Override
                public void process(WatchedEvent event) {
                    System.out.println("====>"+event.toString());

                }
            });

            byte[] data = zkClient.getData("/orchestration-demo/orchestration-sharding-data-source/config/sharding/rule", false, null);
            System.out.println(new String(data, "utf-8"));
            Yaml yaml = new Yaml();


            while (true) {
                System.out.println("------------");
                Thread.sleep(2 * 1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
