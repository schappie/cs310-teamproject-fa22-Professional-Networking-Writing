/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.Badge;
import edu.jsu.mcis.cs310.tas_fa22.Department;
import edu.jsu.mcis.cs310.tas_fa22.Employee;
import edu.jsu.mcis.cs310.tas_fa22.EmployeeType;
import edu.jsu.mcis.cs310.tas_fa22.EventType;
import edu.jsu.mcis.cs310.tas_fa22.Punch;
import edu.jsu.mcis.cs310.tas_fa22.Shift;
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

        EmployeeDAO(DAOFactory daoFactory) {

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
                        BadgeDAO BadgeDAO = daoFactory.getBadgeDAO();
                        Badge badge = BadgeDAO.find(badgeid);
                        String firstname = rs.getString("firstname");
                        String middlename = rs.getString("middlename");
                        String lastname = rs.getString("lastname");
                        int employeetypeid = rs.getInt("employeetypeid");
                        EmployeeType employeetype = EmployeeType.values()[rs.getInt("eventtypeid")];
                        int departmentid = rs.getInt("departmentid");
                        DepartmentDAO departmentdao = daoFactory.getDepartmentDAO();
                        Department department = DepartmentDAO.find(departmentid).getDescription();
                        int shiftid = rs.getInt("shiftid");
                        ShiftDAO ShiftDAO = daoFactory.getShiftDAO();
                        Shift shift = ShiftDAO.find(shiftid);
                        LocalDateTime active = rs.getTimestamp("active").toLocalDateTime();
                        LocalDateTime inactive = rs.getTimestamp("inactive").toLocalDateTime();
                        
                        Employee = new employee(id, firstname, middlename, lastname, active, badge, shift);
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
                         int id = rs.getInt("id");
                        String firstname = rs.getString("firstname");
                        String middlename = rs.getString("middlename");
                        String lastname = rs.getString("lastname");
                        int employeetypeid = rs.getInt("employeetypeid");
                        EmployeeType employeetype = EmployeeType.values()[rs.getInt("eventtypeid")];
                        int departmentid = rs.getInt("departmentid");
                        DepartmentDAO departmentdao = daoFactory.getDepartmentDAO();
                        Department department = DepartmentDAO.find(departmentid).getDescription();
                        int shiftid = rs.getInt("shiftid");
                        ShiftDAO ShiftDAO = daoFactory.getShiftDAO();
                        Shift shift = ShiftDAO.find(shiftid);
                        LocalDateTime active = rs.getTimestamp("active").toLocalDateTime();
                        LocalDateTime inactive = rs.getTimestamp("inactive").toLocalDateTime();
                        
                        Employee = new employee(id, firstname, middlename, lastname, active, badge, shift);

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
