/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.Badge;
import edu.jsu.mcis.cs310.tas_fa22.EventType;
import edu.jsu.mcis.cs310.tas_fa22.Punch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 *
 * @author Tony
 */
public class EmployeeDAO {
   private static final String QUERY_FIND = "SELECT * FROM department WHERE id = ?";

    private final DAOFactory daoFactory;

        EmployeetDAO(DAOFactory daoFactory) {

        this.daoFactory = daoFactory;
        }
        
        
        public Employee find(int id) {

        Employee employee = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_FIND);
                ps.setString(1, Integer.toString(id));

                boolean hasresults = ps.execute();

                if (hasresults) {

                    rs = ps.getResultSet();

                    while (rs.next()) {
                        String badgeid = rs.getString("badgeid");
                        String firstname = rs.getString("firstname");
                        String middlename = rs.getString("middlename");
                        String lastname = rs.getString("lastname");
                        int employeetypeid = rs.getInt("employeetypeid");
                        int departmentid = rs.getInt("departmentid");
                        int shiftid = rs.getInt("shiftid");
                        LocalDateTime active = rs.getTimestamp("active").toLocalDateTime();
                        LocalDateTime inactive = rs.getTimestamp("inactive").toLocalDateTime();
                        
                        Employee = new employee(id, badgeid, firstname, middlename, lastname, employeetypeid, departmentid, shiftid, active, inactive);
                    }

                }

            }

        } catch (SQLException e) {

            throw new DAOException(e.getMessage());

        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }

        }

        return employee;

    }
        public Employee find(Badge badge) {

        Employee employee = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_FIND);
                ps.setString(1, Integer.toString(id));

                boolean hasresults = ps.execute();

                if (hasresults) {

                    rs = ps.getResultSet();

                    while (rs.next()) {
                        String id = rs.getString("id");
                        String firstname = rs.getString("firstname");
                        String middlename = rs.getString("middlename");
                        String lastname = rs.getString("lastname");
                        int employeetypeid = rs.getInt("employeetypeid");
                        int departmentid = rs.getInt("departmentid");
                        int shiftid = rs.getInt("shiftid");
                        LocalDateTime active = rs.getTimestamp("active").toLocalDateTime();
                        LocalDateTime inactive = rs.getTimestamp("inactive").toLocalDateTime();
                        
                        Employee = new employee(id, badgeid, firstname, middlename, lastname, employeetypeid, departmentid, shiftid, active, inactive);
                    }

                }

            }

        } catch (SQLException e) {

            throw new DAOException(e.getMessage());

        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }

        }

        return employee;

    }
}
