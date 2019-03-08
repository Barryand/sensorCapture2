package com.barry.sensorCapture.Controller;

import com.barry.sensorCapture.BO.SensorDataImpl;
import com.barry.sensorCapture.SensorData;
import com.barry.sensorCapture.SocketServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    private SocketServerService sensorService;

    @Autowired
    @Qualifier("sensorService")
    public void setSensorService(SocketServerService sensorService) {
        this.sensorService = sensorService;
    }

    @RequestMapping("/test")
    public ModelAndView index() {
        sensorService.initService();
        sensorService.dataReceive();
        sensorService.stopService();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("sensorData", sensorService.getSensorData().getData());
        return modelAndView;
    }
}