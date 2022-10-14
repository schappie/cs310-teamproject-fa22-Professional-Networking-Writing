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
public class Shift {

   
    private final String description;
    private final Integer id, roundinterval, graceperiod, dockpenalty, lunchthreshold;
    private final LocalTime shiftstart, shiftstop, lunchstart, lunchstop;             //id, description, shiftstart, shiftstop, roundinterval, graceperiod, dockpenalty, lunchstart, lunchstop,lunchthreshold;
    
    
    public Shift(HashMap) {
    
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getShiftstart() {
        return shiftstart;
    }

    public String getShiftstop() {
        return shiftstop;
    }

    public String getRoundinterval() {
        return roundinterval;
    }

    public String getGraceperiod() {
        return graceperiod;
    }

    public String getDockpenalty() {
        return dockpenalty;
    }

    public String getLunchstart() {
        return lunchstart;
    }

    public String getLunchstop() {
        return lunchstop;
    }

    public String getLunchthreshold() {
        return lunchthreshold;
    }

    @Override
    public String toString() {
        return "Shift{" + "id=" + id + ", description=" + description + ", shiftstart=" + shiftstart + ", shiftstop=" + shiftstop + ", roundinterval=" + roundinterval + ", graceperiod=" + graceperiod + ", dockpenalty=" + dockpenalty + ", lunchstart=" + lunchstart + ", lunchstop=" + lunchstop + ", lunchthreshold=" + lunchthreshold + '}';
    }
    
    
    

    
    
    
}
