package com.tekshila.services;

import com.tekshila.dto.TeleHealth;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeleService {


    public List<TeleHealth> getTeles() {

        TeleHealth t1 = new TeleHealth();
           t1.setName("1 MG");
           t1.setTeleUrl("https://www.1mg.com/");

        TeleHealth t2 = new TeleHealth();
            t2.setName("Practo");
            t2.setTeleUrl("https://www.practo.com/");

        TeleHealth t3 = new TeleHealth();
            t3.setName("Lybrate");
            t3.setTeleUrl("https://www.lybrate.com/");

        TeleHealth t4 = new TeleHealth();
            t4.setName("Medlife");
            t4.setTeleUrl("https://www.medlife.com/");

        TeleHealth t5 = new TeleHealth();
            t5.setName("Portea");
            t5.setTeleUrl("https://www.portea.com/");

        List<TeleHealth> teles = new ArrayList<>();
                teles.add(t1);
                teles.add(t2);
                teles.add(t3);
                teles.add(t4);
                teles.add(t5);

            return teles;
    }



}
