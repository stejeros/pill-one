package com.minsait.practicas.service.util;

import com.liferay.osgi.util.ServiceTrackerFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.lang.reflect.Method;

import com.minsait.car.service.integration.proxy.PildoraInterfaceService;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.util.tracker.ServiceTracker;

@Component(
        immediate = true,
        property = {
        },
        service = CustomServiceTracker.class
)
public class CustomServiceTracker<T> {

    T service;

    public CustomServiceTracker() {
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public CustomServiceTracker(Class<T> type, String methodName) {

        try {
            _serviceTracker = ServiceTrackerFactory.open(
                    FrameworkUtil.getBundle(PildoraInterfaceService.class), PildoraInterfaceService.class);
            _serviceTracker.getService();

            Class<?> invocationHandlerClass = PildoraInterfaceService.class;

            Method method = invocationHandlerClass.getMethod(methodName);
            this.service = (T) method.invoke(_serviceTracker.getService());

        } catch (Exception e) {
            LOG.debug("Error activando servicios, seguramente sea un problema de redeploy", e);
        }
    }

    public T getService() throws InterruptedException {
        return service;
    }

    private static final Log LOG = LogFactoryUtil.getLog(CustomServiceTracker.class);

    private static ServiceTracker<PildoraInterfaceService, PildoraInterfaceService> _serviceTracker;
}
