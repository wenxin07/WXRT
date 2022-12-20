package com.demo;

import java.lang.Integer;
import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.demo.domain.Hotel;
import com.demo.domain.Room;
import com.demo.domain.RoomType;
import com.demo.domain.location.Address;
import com.demo.domain.location.City;
import com.demo.persistance.HotelRepository;
//import com.demo.reservation.ExtraRepository;

@Component
@Profile({"!test", "!integration"})
public class DataImporter {
    private HotelRepository hotelRepository;
//    private ExtraRepository extraRepository;

    public DataImporter(HotelRepository hotelRepository) { //ExtraRepository extraRepository
        this.hotelRepository = hotelRepository;
//        this.extraRepository = extraRepository;
    }

    @Bean
    public CommandLineRunner insertTestData() {
        return args -> {
            // For simplicity every hotel will have the same extras.
            System.out.println("-------------------CommandLineRunner, insserting sample data-------------------");
            
            // basic
//            extraRepository.save(new Extra("Foxtel", new Integer("1.20"), Extra.Type.Basic, Extra.Category.General));
//            extraRepository.save(new Extra("Unlimited Internet", new Integer("2.00"), Extra.Type.Basic, Extra.Category.General));
//            extraRepository.save(new Extra("Laundry", new Integer("2.50"), Extra.Type.Basic, Extra.Category.General));
//            extraRepository.save(new Extra("Upgraded mini bar", new Integer("12.00"), Extra.Type.Basic, Extra.Category.General));
//
//            // premium
//            extraRepository.save(new Extra("Foxtel", new Integer("0.20"), Extra.Type.Premium, Extra.Category.General));
//            extraRepository.save(new Extra("Upgraded mini bar", new Integer("1.50"), Extra.Type.Premium, Extra.Category.General));
//            extraRepository.save(new Extra("Massage", new Integer("6.00"), Extra.Type.Premium, Extra.Category.General));

           
//            createHotel1();
//            createHotel2();
//            createHotel3();
//            createHotel4();
//            createHotel5();
//            createHotel6();
//            createHotel7();
//            createHotel8();
//            createHotel9();
//            createHotel10();
//            createHotel11();
//            createHotel12();
//            createHotel13();
//            createHotel14();
//            createHotel15();
//            createHotel16();
//            createHotel17();
//            createHotel18();
//            createHotel19();
//            createHotel20();
//            createHotel21();
//            createHotel22();
        };
    }

    private void createHotel1() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(3000);

        Address address = new Address("信義區忠孝東路五段10號", City.TaipeiCity.getChineseName());

        Hotel grandHotel = new Hotel("W Hotel", address, 4, "WTaipei.com",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("A1", RoomType.Economy.getChineseName(), 1, Integer.valueOf(10107));
        Room room2 = new Room("A2", RoomType.Business.getChineseName(), 2, Integer.valueOf(109500));
        Room room3 = new Room("A3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(228300));
        Room room4 = new Room("A4", RoomType.Economy.getChineseName(), 2, Integer.valueOf(10000));

        grandHotel.addRoom(room1);
        grandHotel.addRoom(room2);
        grandHotel.addRoom(room3);
        grandHotel.addRoom(room4);

        hotelRepository.save(grandHotel);
    }

    private void createHotel2() {
        LocalTime earliestCheckInTime = LocalTime.of(8, 0);
        LocalTime latestCheckInTime = LocalTime.of(19, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(13, 0);
        LocalTime latestCheckOutTime = LocalTime.of(15, 0);
        Integer lateCheckoutFee = Integer.valueOf(2000);

        Address address2 = new Address("中山區中山北路二段39巷3號", City.TaipeiCity.getChineseName());

        Hotel hotel = new Hotel("台北晶華酒店", address2, 3, "regenttaiwan.com",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("B1", RoomType.Economy.getChineseName(), 5, Integer.valueOf(5700));
        Room room2 = new Room("B2", RoomType.Business.getChineseName(), 2, Integer.valueOf(11600));
        Room room3 = new Room("B3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(23700));
        Room room4 = new Room("B4", RoomType.Economy.getChineseName(), 2, Integer.valueOf(6500));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }

    private void createHotel3() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(2500);

        Address address = new Address("板橋區縣民大道二段8號", City.NewTaipeiCity.getChineseName());

        Hotel hotel = new Hotel("板橋凱撒大飯店", address, 5, "cbanqiao.caesarpark.com.tw",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("C1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(3000));
        Room room2 = new Room("C2", RoomType.Business.getChineseName(), 4, Integer.valueOf(5217));
        Room room3 = new Room("C3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(7480));
        Room room4 = new Room("C4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(2900));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }

    private void createHotel4() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(2500);

        Address address = new Address("大園區航站南路1-1號", City.TaoyuanCity.getChineseName());

        Hotel hotel = new Hotel("台北諾富特華航桃園機場飯店", address, 2, "novoteltaipeiairport.com.tw",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("D1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(2000));
        Room room2 = new Room("D2", RoomType.Business.getChineseName(), 5, Integer.valueOf(6615));
        Room room3 = new Room("D3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(8550));
        Room room4 = new Room("D4", RoomType.Economy.getChineseName(), 2, Integer.valueOf(1350));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }

    private void createHotel5() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(1000);

        Address address = new Address("東區中華路二段188號", City.HsinchuCity.getChineseName());

        Hotel hotel = new Hotel("新竹國賓大飯店", address, 4, "ambassador-hotels.com",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("E1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(5500));
        Room room2 = new Room("E2", RoomType.Economy.getChineseName(), 5, Integer.valueOf(7515));
        Room room3 = new Room("E3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(11500));
        Room room4 = new Room("E4", RoomType.Economy.getChineseName(), 2, Integer.valueOf(3350));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    
    private void createHotel6() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(1500);

        Address address = new Address("竹北市光明六路東一段265號", City.HsinchuCounty.getChineseName());

        Hotel hotel = new Hotel("新竹豐邑喜來登大飯店", address, 4, "sheraton-hsinchu.com",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("F1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(2400));
        Room room2 = new Room("F2", RoomType.Economy.getChineseName(), 5, Integer.valueOf(5500));
        Room room3 = new Room("F3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(12150));
        Room room4 = new Room("F4", RoomType.Economy.getChineseName(), 2, Integer.valueOf(3500));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    

    private void createHotel7() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(1500);

        Address address = new Address( "西區健行路1049號", City.TaichungCity.getChineseName());

        Hotel hotel = new Hotel("台中金典酒店", address, 4, "splendor-taichung.com.tw",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("G1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(4300));
        Room room2 = new Room("G2", RoomType.Economy.getChineseName(), 5, Integer.valueOf(9400));
        Room room3 = new Room("G3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(19300));
        Room room4 = new Room("G4", RoomType.Economy.getChineseName(), 2, Integer.valueOf(5090));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    private void createHotel8() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(1500);

        Address address = new Address("魚池鄉中正路23號", City.NantouCounty.getChineseName());

        Hotel hotel = new Hotel("雲品溫泉酒店", address, 5, "fleurdechinehotel.com",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("H1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(6500));
        Room room2 = new Room("H2", RoomType.Business.getChineseName(), 4, Integer.valueOf(10500));
        Room room3 = new Room("H3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(20500));
        Room room4 = new Room("H4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(5500));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    private void createHotel9() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(1500);

        Address address = new Address("員林市中山路二段395號", City.ChanghuaCounty.getChineseName());

        Hotel hotel = new Hotel("昇財麗禧酒店", address, 5, "grand-view.com.tw",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("I1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(5500));
        Room room2 = new Room("I2", RoomType.Business.getChineseName(), 4, Integer.valueOf(10500));
        Room room3 = new Room("I3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(25000));
        Room room4 = new Room("I4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(3500));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    
    private void createHotel10() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(1666);

        Address address = new Address("古坑鄉67之8號", City.YunlinCounty.getChineseName());

        Hotel hotel = new Hotel("劍湖山渡假大飯店", address, 5, "janfusun.com.tw",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("J1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(4500));
        Room room2 = new Room("J2", RoomType.Business.getChineseName(), 4, Integer.valueOf(16500));
        Room room3 = new Room("J3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(20500));
        Room room4 = new Room("J4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(3500));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    
    private void createHotel11() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(1250);

        Address address = new Address("東區忠孝路600號", City.ChiayiCity.getChineseName());

        Hotel hotel = new Hotel("耐斯王子大飯店", address, 5, "niceprincehote.com.tw",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("K1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(3200));
        Room room2 = new Room("K2", RoomType.Business.getChineseName(), 4, Integer.valueOf(5500));
        Room room3 = new Room("K3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(12050));
        Room room4 = new Room("K4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(3500));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    
    private void createHotel12() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(1840);

        Address address = new Address("阿里山鄉16號", City.ChiayiCounty.getChineseName());

        Hotel hotel = new Hotel("阿里山賓館", address, 5, "alishanhotel.com.tw",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("L1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(1140));
        Room room2 = new Room("L2", RoomType.Business.getChineseName(), 4, Integer.valueOf(5405));
        Room room3 = new Room("L3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(10500));
        Room room4 = new Room("L4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(1350));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    
    
    private void createHotel13() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(1650);

        Address address = new Address("東區大學路西段89號", City.TainanCity.getChineseName());

        Hotel hotel = new Hotel("香格里拉台南遠東國際大飯店", address, 5, "shangri-la.com",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("M1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(3000));
        Room room2 = new Room("M2", RoomType.Business.getChineseName(), 4, Integer.valueOf(5500));
        Room room3 = new Room("M3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(11050));
        Room room4 = new Room("M4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(2350));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    private void createHotel14() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(1450);

        Address address = new Address("前金區成功一路266號", City.KaohsiungCity.getChineseName());

        Hotel hotel = new Hotel("漢來大飯店", address, 5, "grand-hilai.com",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("N1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(2400));
        Room room2 = new Room("N2", RoomType.Business.getChineseName(), 4, Integer.valueOf(4500));
        Room room3 = new Room("N3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(17050));
        Room room4 = new Room("N4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(3500));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    private void createHotel15() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(1850);

        Address address = new Address("恆春鎮墾丁路451號", City.PingtungCounty.getChineseName());

        Hotel hotel = new Hotel("墾丁夏都沙灘酒店", address, 5, "ktchateau.com.tw",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("O1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(3100));
        Room room2 = new Room("O2", RoomType.Business.getChineseName(), 4, Integer.valueOf(7705));
        Room room3 = new Room("O3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(15205));
        Room room4 = new Room("O4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(3500));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    
    private void createHotel16() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(1250);

        Address address = new Address("卑南鄉龍泉路113巷23號 ",City.TaitungCounty.getChineseName());

        Hotel hotel = new Hotel("知本老爺酒店", address, 5, "hotelroyal.com.tw",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("P1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(2500));
        Room room2 = new Room("P2", RoomType.Business.getChineseName(), 4, Integer.valueOf(7105));
        Room room3 = new Room("P3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(17050));
        Room room4 = new Room("P4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(2350));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    private void createHotel17() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(1500);

        Address address = new Address("秀林鄉天祥路18號", City.HualienCounty.getChineseName());

        Hotel hotel = new Hotel("太魯閣晶英酒店", address, 5, "taroko.silksplace.com",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("Q1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(2350));
        Room room2 = new Room("Q2", RoomType.Business.getChineseName(), 4, Integer.valueOf(7105));
        Room room3 = new Room("Q3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(19600));
        Room room4 = new Room("Q4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(3500));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    
    private void createHotel18() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(1500);

        Address address = new Address("宜蘭市民權路二段36號", City.YilanCounty.getChineseName());

        Hotel hotel = new Hotel("蘭城晶英酒店", address, 5, "silksplace-yilan.com.tw",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("R1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(7650));
        Room room2 = new Room("R2", RoomType.Business.getChineseName(), 4, Integer.valueOf(9105));
        Room room3 = new Room("R3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(22050));
        Room room4 = new Room("R4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(6500));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    private void createHotel19() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(2510);

        Address address = new Address("東區中華東路三段336巷1號", City.KeelungCity.getChineseName());

        Hotel hotel = new Hotel("長榮桂冠酒店", address, 5, "evergreen-hotels.com",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("S1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(4500));
        Room room2 = new Room("S2", RoomType.Business.getChineseName(), 4, Integer.valueOf(9505));
        Room room3 = new Room("S3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(22205));
        Room room4 = new Room("S4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(5350));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    
    private void createHotel20() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(2400);

        Address address = new Address("馬公市新店路197號", City.PenghuCounty.getChineseName());

        Hotel hotel = new Hotel("澎湖福朋喜來登酒店", address, 5, "fourpoints-penghu.com",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("T1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(6500));
        Room room2 = new Room("T2", RoomType.Business.getChineseName(), 4, Integer.valueOf(11050));
        Room room3 = new Room("T3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(20500));
        Room room4 = new Room("T4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(5350));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    
    private void createHotel21() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(2500);

        Address address = new Address("金湖鎮太湖路二段218號", City.KinmenCounty.getChineseName());

        Hotel hotel = new Hotel("金湖大飯店", address, 5, "goldenlakehotel.com",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("U1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(4500));
        Room room2 = new Room("U2", RoomType.Business.getChineseName(), 4, Integer.valueOf(10500));
        Room room3 = new Room("U3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(14205));
        Room room4 = new Room("U4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(3500));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
    
    
    private void createHotel22() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        Integer lateCheckoutFee = Integer.valueOf(2500);

        Address address = new Address("南竿鄉71號", City.LienchiangCounty.getChineseName());

        Hotel hotel = new Hotel("馬祖享宿海景民宿", address, 5, "goldenlakehotel.com",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);
 
        Room room1 = new Room("V1", RoomType.Economy.getChineseName(), 4, Integer.valueOf(5000));
        Room room2 = new Room("V2", RoomType.Business.getChineseName(), 4, Integer.valueOf(8000));
        Room room3 = new Room("V3", RoomType.Luxury.getChineseName(), 4, Integer.valueOf(22000));
        Room room4 = new Room("V4", RoomType.Economy.getChineseName(), 1, Integer.valueOf(3500));

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);

        hotelRepository.save(hotel);
    }
}
