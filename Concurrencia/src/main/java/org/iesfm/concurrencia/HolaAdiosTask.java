package org.iesfm.concurrencia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

public class HolaAdiosTask implements Runnable{

    private static final Logger log = LoggerFactory.getLogger(HolaAdiosTask.class);

    private String mensage;

    private Semaphore semaphore;

    private int times;

    public HolaAdiosTask(String mensage, Semaphore semaphore, int times) {
        this.mensage = mensage;
        this.semaphore = semaphore;
        this.times = times;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            for (int i = 0; i < times; i++) {
                log.info(mensage);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
