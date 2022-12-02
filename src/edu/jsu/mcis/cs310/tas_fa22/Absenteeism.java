
package edu.jsu.mcis.cs310.tas_fa22;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author sawyerchapman
 */
public class Absenteeism {
    
    private final Employee employee;
    private final LocalDate paystart;
    private final float percentage;

    public Absenteeism(Employee employee, LocalDate paystart, float percentage) {
        this.employee = employee;
        this.paystart = paystart;
        this.percentage = percentage;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDate getPaystart() {
        return paystart;
    }

    public float getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return employee.getBadge() + " (Pay Period Starting " + paystart + "): " + percentage;
    }
      
}

/*
Test Class Format (Sawyer)
#F1EE0555 (Pay Period Starting 08-05-2018): -20.00%
*/
