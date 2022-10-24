
package edu.jsu.mcis.cs310.tas_fa22;

import java.time.LocalDateTime;

public class Punch {
    
    //adjustmenttype
    // Punch(int terminalid, Badge badge, EventType punchtype); constructor for punch class
    // Punch(int id, int terminalid, Badge badge, LocalDateTime originaltimestamp, EventType punchtype);
    
    /*
    
In addition to the information about punches given in the database (in the "event" table), 
including the original timestamp, this class should include an extra instance field for the adjusted timestamp, as well as a PunchAdjustmentType field called "adjustmenttype"; 
these will become important in later features.  
(The PunchAdjustmentType data type has already been provided for you in the initial team repository, 
in the form of a simple enumeration.)
    
    
    
    */
    
    private int id;
    private final int terminalid;
    private final Badge badge;
    private LocalDateTime originaltimestamp;
    private final EventType punchtype;
    private final PunchAdjustmentType adjustmenttype;
    
    
    
    
    
    Punch(int terminalid, Badge badge, EventType punchtype, PunchAdjustmentType adjustmenttype) {
        this.terminalid = terminalid;
        this.badge = badge;
        this.punchtype = punchtype;
        this.adjustmenttype = adjustmenttype;
    }
            
            
    Punch(int id, int terminalid, Badge badge, LocalDateTime originaltimestamp, EventType punchtype, PunchAdjustmentType adjustmenttype) {
        this.id = id;
        this.terminalid = terminalid;  
        this.originaltimestamp = originaltimestamp;
        this.badge = badge;
        this.punchtype = punchtype;
        this.adjustmenttype = adjustmenttype;
    
    }

    public Punch(int id, Integer terminalid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    

    public int getId() {
        return id;
    }

    public int getTerminalid() {
        return terminalid;
    }

    public Badge getBadge() {
        return badge;
    }

    public LocalDateTime getOriginaltimestamp() {
        return originaltimestamp;
    }

    public EventType getPunchtype() {
        return punchtype;
    }

    public PunchAdjustmentType getAdjustmenttype() {
        return adjustmenttype;
    }
    
    
    
    @Override
    public String toString() {
        
        StringBuilder s = new StringBuilder();

        s.append('#').append(id).append(' ');
        s.append('(').append(terminalid).append(')');
        s.append('#').append(originaltimestamp).append(' ');
        s.append('(').append(badge).append(')');
        s.append('#').append(punchtype).append(' ');
        s.append('(').append(adjustmenttype).append(')');
       

        return s.toString();
        

//return "Punch{" + "id=" + id + ", terminalid=" + terminalid + '}';
    }
    
    
    
    
    
    /*
    
    Objects of the Shift class will contain information about a single shift rule set 
    (that is, the starting time, stopping time, and other parameters of a single shift).  
    In addition to the information about a shift rule set given in the database, 
    the Shift class should also include instance fields called "lunchduration" and "shiftduration", 
    which should indicate the scheduled length of the lunch break and of an entire work shift 
    (respectively), given in minutes.  
    These values will become relevant when we begin calculating the employee's total accrued hours in later features.

(Because of the large number of fields, the constructor for the Shift class should not accept these field values as individual arguments, 
    as this would needlessly complicate the interface.  Instead, I recommend providing these values as a single collection in the form of a map, such as a HashMap.  
    The parameter values can be stored in the map as strings and passed as a single argument to the Shift constructor; 
    the constructor can then retrieve these values from the map and convert them to their native types.)
    */
    


    
}
