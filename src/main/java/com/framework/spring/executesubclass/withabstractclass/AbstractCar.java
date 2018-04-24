package com.framework.spring.executesubclass.withabstractclass;

import com.framework.spring.executesubclass.withabstractclass.service.CarInfoPrinterService;

public abstract class AbstractCar implements Car {

	CarInfoPrinterService carInfoPrinterService;

	public abstract String getCarBand();

	public abstract void setCarInfoPrinterService(CarInfoPrinterService carInfoPrinterService);

	public void didi() {
		carInfoPrinterService.print(getCarBand() + "--> didi.");
	}
}
