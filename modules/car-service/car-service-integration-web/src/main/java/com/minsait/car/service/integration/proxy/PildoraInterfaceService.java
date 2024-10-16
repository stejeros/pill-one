package com.minsait.car.service.integration.proxy;

import com.minsait.car.service.integration.base.AbstractSelfRegisteringService;
import com.practicas.services.CarService;
import com.practicas.services.impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("pildoraInterfaceService")
public class PildoraInterfaceService  extends AbstractSelfRegisteringService {

    @Autowired(required = false)
    protected CarServiceImpl carService;

    public CarService getCarService(){
        return carService;
    }

}
