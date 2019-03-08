package com.barry.sensorCapture.Service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SocketServerTest {
    public static void main(String[] args) {
        String[] locations = {"application-context.xml"};
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext(locations);
        SocketServerServiceImpl sSS = (SocketServerServiceImpl) ctx.getBean("SensorService");
        sSS.initService();
        sSS.dataReceive();
        sSS.getSensorData();
    }
}
