package com.example.carcompany.service;

import com.example.carcompany.dao.CarDao;
import com.example.carcompany.dao.CarManufacturarDao;
import com.example.carcompany.dao.InsuranceDao;
import com.example.carcompany.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class CarService {

    private final CarDao carDao;
    private final CarManufacturarDao carManufacturarDao;

    private final InsuranceDao insuranceDao;


    public CarService(CarDao carDao, CarManufacturarDao carManufacturarDao, InsuranceDao insuranceDao) {
        this.carDao = carDao;
        this.carManufacturarDao = carManufacturarDao;
        this.insuranceDao = insuranceDao;
    }
    @Transactional
    public void createDb(){

        Car car1=new Car("001","JAPAN",LocalDate.of(2002,3,2),3);
        Car car2=new Car("002","Myanmar",LocalDate.of(2002,5,5),1);
        Car car3=new Car("003","GERMANY",LocalDate.of(2003,3,4),3);

        Person p1=new Person("JOhn", LocalDate.of(2003,4,4));
        Person p2=new Person("JOhn NAthan", LocalDate.of(2003,4,4));
        Person p3=new Person("JOhn Wick", LocalDate.of(2003,4,4));
        Person p4=new Person("JOhn DICk", LocalDate.of(2003,4,4));



        InsuranceCompany insuranceCompany1=new InsuranceCompany("GIG",new Address("Yaw MIn G street"),5);
        InsuranceCompany insuranceCompany2=new InsuranceCompany("Indigo",new Address("Pansodan street"),7);

        CarManufacturar carManufacturar1=new CarManufacturar("Gway g",new Address("Papeldan road"),4,LocalDate.of(2003,3,5));
        CarManufacturar carManufacturar2=new CarManufacturar("Nay toe",new Address("35street "),654,LocalDate.of(2002,2,5));
        CarManufacturar carManufacturar3=new CarManufacturar("Toyata",new Address("36street "),6565,LocalDate.of(2002,2,5));

        Person driver1=new Person("zaw zAW",LocalDate.of(2003,4,5));
        Person driver2=new Person(" ZAW",LocalDate.of(2003,4,5));
        //mapping
        car1.setCarManufacturar(carManufacturar1);
        carManufacturar1.setCar(car1);

        car2.setCarManufacturar(carManufacturar2);
        carManufacturar2.setCar(car2);

        car3.setCarManufacturar(carManufacturar3);
        carManufacturar3.setCar(car3);

        car1.setInsuranceCompany(insuranceCompany1);
        insuranceCompany1.setCar(car1);

        car2.setInsuranceCompany(insuranceCompany2);
        insuranceCompany2.setCar(car2);

        car1.addOwner(p1);
        car2.addOwner(p1);
        car2.addOwner(p3);
        car3.addOwner(p3);
        car3.addOwner(p4);

        car1.addDriver(driver1);
        car1.addDriver(driver2);

        carDao.save(car1);
        carDao.save(car2);
        carDao.save(car3);

        carManufacturarDao.save(carManufacturar1);
        carManufacturarDao.save(carManufacturar2);
        carManufacturarDao.save(carManufacturar3);

        insuranceDao.save(insuranceCompany1);
        insuranceDao.save(insuranceCompany2);






    }

}
