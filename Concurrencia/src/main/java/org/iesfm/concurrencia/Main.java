package org.iesfm.concurrencia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        Thread holaThread = new Thread(new HolaAdiosTask("hola", semaphore, 10));
        Thread adiosThread = new Thread(new HolaAdiosTask("adios", semaphore, 5));


        holaThread.start();
        try {
            holaThread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Ya ha saludado");

        adiosThread.start();
        try {
            adiosThread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            holaThread.join();
            adiosThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Terminado");
    }

}
