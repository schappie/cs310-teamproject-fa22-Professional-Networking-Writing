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
public class Employee {
    
    private final Integer id;
    private final String firstname,middlename,lastname;
     private final LocalDateTime  active;
    private final Badge badge;
    private final Shift shift;

    public Employee(Integer id, String firstname, String middlename, String lastname, LocalDateTime active, Badge badge, Shift shift) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.active = active;
        this.badge = badge;
        this.shift = shift;
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

    public Badge getBadge() {
        return badge;
    }

    public Shift getShift() {
        return shift;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname + ", active=" + active + ", badge=" + badge + ", shift=" + shift + '}';
    }
    
    
    
}
