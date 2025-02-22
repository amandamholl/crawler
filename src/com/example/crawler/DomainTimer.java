/*
 * DomainTimer.java
 *
 * Authors: Amanda Holl and Paige Rogalski
 *
 * Copyright 2016
 */

package com.example.crawler;

import java.util.Timer;
import java.util.TimerTask;

import static com.example.crawler.Crawler.hosts_visited;

public class DomainTimer {
    Timer timer;
    final String host;

    public DomainTimer(String domain) {
        timer = new Timer();
        host = domain;
        timer.schedule(new RemoveHost(), 1000);
    }

    class RemoveHost extends TimerTask {
        public void run() {
            if(!hosts_visited.isEmpty())
                hosts_visited.remove(host);

            timer.cancel(); // Terminate the timer thread
        }
    }

}
