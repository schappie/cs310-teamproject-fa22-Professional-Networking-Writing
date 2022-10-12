/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jsu.mcis.cs310.tas_fa22;

import java.util.logging.Logger;

/**
 *
 * @author Tony
 */
public class Shift {

   
    private final String id, description, shiftstart, shiftstop, roundinterval, graceperiod, dockpenalty, lunchstart, lunchstop,lunchthreshold;

    public Shift(String id, String description, String shiftstart, String shiftstop, String roundinterval, String graceperiod, String dockpenalty, String lunchstart, String lunchstop, String lunchthreshold) {
        this.id = id;
        this.description = description;
        this.shiftstart = shiftstart;
        this.shiftstop = shiftstop;
        this.roundinterval = roundinterval;
        this.graceperiod = graceperiod;
        this.dockpenalty = dockpenalty;
        this.lunchstart = lunchstart;
        this.lunchstop = lunchstop;
        this.lunchthreshold = lunchthreshold;
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
