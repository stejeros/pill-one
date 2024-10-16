package com.minsait.practicas.service.util;

import com.liferay.expando.kernel.service.ExpandoValueLocalService;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.UserLocalService;

import com.liferay.portal.template.ServiceLocator;


import java.util.Map;

import com.practicas.services.CarService;
import org.osgi.service.component.annotations.*;

@Component(
        immediate = true,
        service = CarServicesUtil.class
)
public class CarServicesUtil {

    @Activate
    protected void activate(Map<String, Object> properties) {

        try {
            CustomServiceTracker<CarService> carServiceCustomServiceTracker = new CustomServiceTracker<>(CarService.class, "getCarService");

            this._carService = carServiceCustomServiceTracker.getService();
            LOG.error((_carService.getTotalCar()));
       /*} catch (SapException e) {
            LOG.info("Se ha producido un error validando los servicios en el arranque", e);
        */} catch (NullPointerException e) {
            LOG.info("Se ha producido un error accediendo a los servicios");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Reference
    private UserLocalService _userLocalService;
    @Reference
    private ObjectEntryLocalService _objectEntryLocalService;
    private CarService _carService;

    @Reference
    private ExpandoValueLocalService _expandoValueLocalService;
    private static final Log LOG = LogFactoryUtil.getLog(CarServicesUtil.class);
}
