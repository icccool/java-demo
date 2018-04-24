package com.framework.spring.executesubclass.withabstractclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.framework.spring.executesubclass.withabstractclass.service.CarInfoPrinterService;

@Component
public class Bmw  extends AbstractCar{

	@Override
	public String getCarBand() {
		return "Benz";
	}

	@Autowired
	@Override
	public void setCarInfoPrinterService(CarInfoPrinterService carInfoPrinterService) {
		super.carInfoPrinterService = carInfoPrinterService;
	}

}
