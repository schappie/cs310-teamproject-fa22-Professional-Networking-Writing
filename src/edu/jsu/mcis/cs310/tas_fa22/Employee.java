/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jsu.mcis.cs310.tas_fa22;

import java.time.LocalDateTime;

/**
 *
 * @author Tony
 */
/*
Changes made by Sawyer:
Added the Department and EmployeeType.
Changed names to Strings.
Changed Badge badge to String Badgeid.
Changed the 'ToString' to fit the format in the test class.
*/
public class Employee {
    
    private final Integer id;
    private final String firstname,middlename,lastname;
    private final LocalDateTime  active;
    private final String badgeid;
    private final Shift shift;
    private final Department department;
    private final EmployeeType employeetype;

    public Employee(Integer id, String firstname, String middlename, String lastname, LocalDateTime active, String badgeid, Department department, Shift shift, EmployeeType employeetype) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.active = active;
        this.badgeid = badgeid;
        this.shift = shift;
        this.department = department;
        this.employeetype = employeetype;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDateTime getActive() {
        return active;
    }

    public String getBadgeid() {
        return badgeid;
    }
    public Department getDepartment(){
        return department;
    }

    public Shift getShift() {
        return shift;
    }

    @Override
    public String toString() {
        return "ID #" + id + ": " + lastname + ", " + firstname + " " + middlename + " (#" + badgeid + "), " + "Type: " + employeetype + ", Department: " + department + ", Active: " + active;
    }
    
    
    
}
/*
Test Class Format (Sawyer)
ID #93: Leist, Rodney J (#C1E4758D), Type: Temporary / Part-Time, Department: Warehouse, Active: 10/09/2015
*/