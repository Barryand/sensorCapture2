package com.barry.sensorCapture;

import com.barry.sensorCapture.BO.SensorDataImpl;

public interface SocketServerService {
    public void initService();
    public void dataReceive();
    public void stopService();
    public SensorDataImpl getSensorData();
}
