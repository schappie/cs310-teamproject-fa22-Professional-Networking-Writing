/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jsu.mcis.cs310.tas_fa22;

/**
 *
 * @author Tony
 */

public enum EmployeeType {
   PART_TIME("Temporary / Part-Time"),
   FULL_TIME("Full-Time");
   private final String description;
   private EmployeeType(String d) {
      description = d;
   }
   @Override
   public String toString() {
      return description;
   }
}
