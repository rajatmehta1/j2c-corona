package com.tekshila.helpers;

import com.tekshila.dto.CityHospital;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;

//Pulls real time information from govt websites
@Component
public class HospitalBedHelper {
//
//     public CityHospital pullHospitalInfo(String city) throws IOException {
//         Document doc = null;
//         CityHospital cityHospital = new CityHospital();
//            cityHospital.setCityName(city);
//         switch (city) {
//             case "nd" :
//                    doc = Jsoup.connect("https://coronabeds.jantasamvad.org/beds.html").get();
//                    System.out.println(doc.toString());
//
//                 Element bedVacant =
//                         doc.getElementById("beds_vacant");
//                 Element icuBedVacant =
//                         doc.getElementById("covid_icu_beds_vacant");
//
//                 // get title of the page
//                 String title = doc.title();
//                 System.out.println("Title: " + title);
//                        cityHospital.setCovid19BedsAvl(bedVacant.val());
//                 System.out.println("bed vaccant : " + bedVacant.val());
//                        cityHospital.setCovid19BedsIcuAvl(icuBedVacant.html());
//                 System.out.println("icuBedVacant.html(): " + icuBedVacant.html());
//                        break;
//             default:
//                   cityHospital.setCovid19BedsAvl("default");
//                   break;
//         }
//         return cityHospital;
//     }

    private HashMap<String,String> bedMap = new HashMap<>();


    @PostConstruct
    public void init() {
        bedMap.put("Delhi_normal","https://coronabeds.jantasamvad.org/beds.html");
        bedMap.put("Delhi_icu","https://coronabeds.jantasamvad.org/all-covid-icu-beds.html");

        bedMap.put("Gurgaon_normal","http://covidggn.com/");

        bedMap.put("Thane_normal","https://covidthane.org/availabiltyOfHospitalBeds.html");

        bedMap.put("Bengaluru_normal","https://covidbengaluru.com/");

        bedMap.put("Andhra Pradesh_normal","https://covidaps.com");

        bedMap.put("Telangana_normal","https://covidtelangana.com");

        bedMap.put("West Bengal_normal","https://covidwb.com");

        bedMap.put("Pune_normal","https://covidpune.com");

        bedMap.put("Ahmedabad_normal","https://covidamd.com");
        bedMap.put("Ahmedabad_normal2","https://ahna.org.in/covid19.html");

        bedMap.put("Vadodara_normal","https://covidbaroda.com");

        bedMap.put("Nagpur_normal","http://nsscdcl.org/covidbeds/AvailableHospitals.jsp");

        bedMap.put("Nashik_normal","https://covidnashik.com");

        bedMap.put("Madhya Pradesh_normal","https://covidmp.com");

        bedMap.put("Uttar Pradesh_normal","http://dgmhup.gov.in/en/CovidReport");

        bedMap.put("Rajasthan_normal","https://covidinfo.rajasthan.gov.in/COVID19HOSPITALBEDSSTATUSSTATE.aspx");

        bedMap.put("Bhopal_normal","https://bhopalcovidbeds.in/");

        bedMap.put("Haryana_normal","https://coronaharyana.in/");

        bedMap.put("Tamil Nadu_normal","https://covidtnadu.com");
        bedMap.put("Tamil Nadu_normal2","https://stopcorona.tn.gov.in/beds.php");

        bedMap.put("Beed_normal","https://covidbeed.com");

        bedMap.put("Gandhinagar_normal","https://covidgandhinagar.com");
    }

    public CityHospital pullHospitalInfo(String city) throws IOException {
        CityHospital ch = new CityHospital();
           ch.setCovid19BedsAvl(bedMap.get(city + "_normal"));
           if(null != bedMap.get(city + "_icu"))
               ch.setCovid19BedsIcuAvl(bedMap.get(city + "_icu"));
           if(null != bedMap.get(city + "_normal2"))
               ch.setCovid19BedsIcuAvl(bedMap.get(city + "_icu"));
        return ch;
    }
}
