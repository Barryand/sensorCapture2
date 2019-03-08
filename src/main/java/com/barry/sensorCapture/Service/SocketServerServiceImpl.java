package com.barry.sensorCapture.Service;

import com.barry.sensorCapture.BO.SensorDataImpl;
import com.barry.sensorCapture.SocketServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;



//@Service("SensorService")
public class SocketServerServiceImpl implements SocketServerService {
    private int port;
    private String IPAdress;
    private ServerSocket server;
    private Socket client;
    private SensorDataImpl sensorData;

    public void setPort(int port) {
        this.port = port;
    }

    public void setIPAdress(String IPAdress) {
        this.IPAdress = IPAdress;
    }

    public void initService() {
        try {
            server = new ServerSocket(port, 50, InetAddress.getByName(IPAdress));
            //ServerSocket server=new ServerSocket(port);
            System.out.println(server.getLocalSocketAddress());
            client = server.accept();
            System.out.println("connection success");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("connection error");
            System.out.println("connection error");
            System.out.println("connection error");
        }
    }

    public void dataReceive(){
        try {
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            int c = in.read();

            sensorData.setData(c);
            System.out.println(c - '0');
            /*try {
                Thread.currentThread().sleep(1000);
                //out.println("as");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

        } catch (IOException e) {
        e.printStackTrace();
        }

    }

    public void stopService() {
        try {
            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Autowired
    public void setSensorData(SensorDataImpl sensorData) {
        this.sensorData = sensorData;
    }

    public SensorDataImpl getSensorData() {
        return sensorData;
    }
}
