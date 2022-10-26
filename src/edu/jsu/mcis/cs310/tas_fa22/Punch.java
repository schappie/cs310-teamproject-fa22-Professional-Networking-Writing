
package edu.jsu.mcis.cs310.tas_fa22;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    
    private final Integer id;
    private final Integer terminalid;
    private final Badge badge;
    private final LocalDateTime originaltimestamp;
    private final EventType punchtype;
    private PunchAdjustmentType adjustmenttype;
    
    
    
    
    
    public Punch(int terminalid, Badge badge, EventType punchtype) {
        this.id = null;
        this.terminalid = terminalid;
        this.badge = badge;
        this.punchtype = punchtype;
        this.adjustmenttype = null;
        this.originaltimestamp = null;
    }
            
            
    public Punch(int id, int terminalid, Badge badge, LocalDateTime originaltimestamp, EventType punchtype) {
        this.id = id;
        this.terminalid = terminalid;  
        this.originaltimestamp = originaltimestamp;
        this.badge = badge;
        this.punchtype = punchtype;
    }   
      

    
  
    
    public int getId() {
        return id;
    }

    public int getTerminalid() {
        return terminalid;
    }


    public LocalDateTime getOriginaltimestamp()  {
        return originaltimestamp;
    }
    
    public EventType getPunchtype(){
        return punchtype;
    }
    
    public Badge getBadge(){
        return badge;
    }
    
       

    public String printOriginal() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEE MM/dd/yyyy HH:mm:ss");
        StringBuilder s = new StringBuilder();
        
        s.append('#');
        s.append(badge.getId());
        s.append(" ");
        s.append(punchtype);
        s.append(": ");
        s.append(originaltimestamp.format(format).toUpperCase());
       

        return s.toString();
        


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
