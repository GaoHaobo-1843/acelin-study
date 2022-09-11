package com.gaohb.hello.study.test.jvmTest;

import java.util.ArrayList;
import java.util.Random;

public class OOMTest {
    public static void main(String[] args) {
        ArrayList<Picture> pictures = new ArrayList<>();
        while (true){
            try {
                Thread.sleep(20);

            }catch (Exception e){
                e.printStackTrace();
            }
            pictures.add(new Picture(new Random().nextInt(1024 * 1024)));
        }
    }


}
class Picture{
    private byte[] pixel;

    public Picture (int length){
        this.pixel = new byte[length];
    }
}