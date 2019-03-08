package com.barry.sensorCapture.BO;

import com.barry.sensorCapture.SensorData;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component("SensorData")
public class SensorDataImpl implements SensorData {
    private int data;

/*    public SensorDataImpl(int data) {
        this.data = data;
    }*/

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
