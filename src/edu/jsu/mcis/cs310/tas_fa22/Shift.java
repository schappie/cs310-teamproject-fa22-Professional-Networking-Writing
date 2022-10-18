/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jsu.mcis.cs310.tas_fa22;

import java.util.HashMap;
import java.time.LocalTime;

/**
 *
 * @author Tony
 */

public class Shift {
    
    
   
    private final String description;
    private final Integer id, roundinterval, graceperiod, dockpenalty, lunchthreshold;
    private final LocalTime shiftstart, shiftstop, lunchstart, lunchstop;             //id, description, shiftstart, shiftstop, roundinterval, graceperiod, dockpenalty, lunchstart, lunchstop,lunchthreshold;
    
    
    public Shift(HashMap map){
        
        this.id = Integer.parseInt((String)map.get("id"));
        this.description = map.get("description").toString();
        this.roundinterval = Integer.parseInt((String) map.get("roundinterval"));
        this.graceperiod = Integer.parseInt((String) map.get("graceperiod"));
        this.dockpenalty = Integer.parseInt((String)map.get("dockpenalty"));
        this.lunchthreshold = Integer.parseInt((String)map.get("lunchthreshold"));
        this.shiftstart = LocalTime.parse((String)map.get("shiftstart"));
        this.shiftstop = LocalTime.parse((String)map.get("shiftstop"));
        this.lunchstart = LocalTime.parse((String)map.get("lunchstart"));
        this.lunchstop = LocalTime.parse((String)map.get("lunchstop"));

        /*
        this.description = description;
        map.put("id", this.id = id);
        map.put("roundinterval", this.roundinterval = roundinterval );
        map.put("graceperiod", this.graceperiod = graceperiod);
        map.put("dockpenalty", this.dockpenalty = dockpenalty);
        map.put("lunchthreshold", this.lunchthreshold = lunchthreshold);
        this.shiftstart = shiftstart;
        this.shiftstop = shiftstop;
        this.lunchstart = lunchstart;
        this.lunchstop = lunchstop;
        */   
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
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

    public Integer getLunchthreshold() {
        return lunchthreshold;
    }

    public LocalTime getShiftstart() {
        return shiftstart;
    }

    public LocalTime getShiftstop() {
        return shiftstop;
    }

    public LocalTime getLunchstart() {
        return lunchstart;
    }

    public LocalTime getLunchstop() {
        return lunchstop;
    }
}
