/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jsu.mcis.cs310.tas_fa22;

import java.util.logging.Logger;
import java.util.HashMap;


/**
 *
 * @author Tony
 */
import java.time.LocalTime;
import java.util.List;
//import java.util.Scanner;
public class Shift {

   
    private  String description;
    private Integer id, roundinterval, graceperiod, dockpenalty, lunchthreshold;
    private  LocalTime shiftstart, shiftstop, lunchstart, lunchstop;             //id, description, shiftstart, shiftstop, roundinterval, graceperiod, dockpenalty, lunchstart, lunchstop,lunchthreshold;
    
    
    public Shift(HashMap<String, String> mapst, HashMap<String, Integer> mapt, HashMap<String, LocalTime> map ) {
        //HashMap<String, Integer> map = new HashMap<>(); 
        //HashMap<String, List<String>> mapt = new HashMap<String, List<String>>();
        //Shift
        //id = 1;
        //roundinterval = 2;
        //graceperiod = 3;
        //dockpenalty = 4;
        //lunchthreshold = 5;
        //this.description = description;
        mapst.put("description",description);
        mapt.put("id", id);                           
        mapt.put("roundinterval", roundinterval);                  
        mapt.put("graceperiod", this.graceperiod = graceperiod);     //                   
        mapt.put("dockpenalty", dockpenalty);
        mapt.put("lunchthreshold", this.lunchthreshold = lunchthreshold); //
        map.put("shiftstart", shiftstart);
        map.put("sshiftstop", shiftstop);
        map.put("lunchstart", lunchstart);
        this.lunchstop = lunchstop; //
    }
    

        
    

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getShiftstart() {
        return shiftstart;
    }

    public LocalTime getShiftstop() {
        return shiftstop;
    }

    public Integer getRoundinterval() {
        return roundinterval;
    }

    public Integer getGraceperiod() {
        return graceperiod;
    }

    public Integer getDockpenalty() {
        return dockpenalty;
    }

    public LocalTime getLunchstart() {
        return lunchstart;
    }

    public LocalTime getLunchstop() {
        return lunchstop;
    }

    public Integer getLunchthreshold() {
        return lunchthreshold;
    }

    @Override
    public String toString() {
        return "Shift{" + "id=" + id + ", description=" + description + ", shiftstart=" + shiftstart + ", shiftstop=" + shiftstop + ", roundinterval=" + roundinterval + ", graceperiod=" + graceperiod + ", dockpenalty=" + dockpenalty + ", lunchstart=" + lunchstart + ", lunchstop=" + lunchstop + ", lunchthreshold=" + lunchthreshold + '}';
    }
    
    
    

    

    
    
    
}
