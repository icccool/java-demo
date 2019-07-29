package com.code.serialize;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author WANG JI BO
 * @Date 2019/7/11 下午7:03
 * @Description
 **/
public class DeepCopy {


    public static void main(String[] args) {
        try {
            Zoo zoo = new Zoo();
            zoo.setName("zhang");
            HashMap hashMap = new HashMap<>();
            hashMap.put("t", "aaaaa");
            hashMap.put("h", "bbbbb");
            zoo.setAnimals(hashMap);

            Zoo zoo2 = (Zoo) copy(zoo);
            System.out.println(zoo2.getName());
            System.out.println(zoo2.getAnimals().get("t"));

        } catch (NotSerializableException e) {
            System.out.println(1);
            e.printStackTrace();
        }
    }

    public static Object copy(Object orig) throws NotSerializableException {
        Object obj = null;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(orig);
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            int i = 1/0;
            obj = in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


}

class Zoo implements Serializable {

    String name;

    Map<String, String> animals;

    public Map<String, String> getAnimals() {
        return animals;
    }

    public void setAnimals(Map<String, String> animals) {
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


