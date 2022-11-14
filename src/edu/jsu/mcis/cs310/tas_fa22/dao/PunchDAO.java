package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PunchDAO {

    private static final String QUERY_FIND = "SELECT * FROM event WHERE id = ?";


    //private static final String QUERY_FIND_TERMINALID = "SELECT * FROM department WHERE terminalid = ?";

    private static final String QUERY_LIST = "SELECT * FROM event WHERE badgeid = ? AND timestamp = ?";


   
    private static final String QUERY_CREATE = "INSERT INTO event (terminalid, badgeid, timestamp, eventtype) VALUES(?, ?, ?, ?)";

    private final DAOFactory daoFactory;

    PunchDAO(DAOFactory daoFactory) {

        this.daoFactory = daoFactory;

    }

    public Punch find(int id) {

        Punch punch = null;

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
                        int terminalid = rs.getInt("terminalid");
                        String badgeid = rs.getString("badgeid");
                        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
                        Badge badge = badgeDAO.find(badgeid);
                        EventType punchtype = EventType.values()[rs.getInt("eventtypeid")];
                        LocalDateTime originaltimestamp = rs.getTimestamp("timestamp").toLocalDateTime();
  
                        punch = new Punch(id, terminalid, badge, originaltimestamp, punchtype);
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

        return punch;

    }
    



    
    
    
    
    
    
    
    public Integer create(Punch p){
        
        // Check the terminal ID of the new punch this will be used to check against the ID of the deginated clock
        // termnial of the employees department. This will lead into an if state checking the two terminal ID's are equal
        int pTerminalID = p.getTerminalid();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
        Employee employee = employeeDAO.find(p.getBadge());
        
        int employeeTerminalID = employee.getDepartment().getTerminalid();
         
        
        try {

            Connection conn = daoFactory.getConnection();
           

            if (conn.isValid(0)) {
               
                
                int key = 0;
                
                ResultSet keys;
                ps = conn.prepareStatement(QUERY_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1, p.getTerminalid());
                ps.setString(2, p.getBadge().getId());
                ps.setString(3, p.getOriginaltimestamp().toString());
                ps.setInt(4, p.getPunchtype().ordinal());
                
                //QUERY_CREATE: "INSERT INTO event (terminalid, badgeid, timestamp, eventtype) VALUES(?, ?, ?, ?)"
               
                int result = ps.executeUpdate();
               

                if (result == 1) {

                    rs = ps.getResultSet();

                    while (rs.next()) {


                        
                       
                        if (result == 1) {
                            keys = ps.getGeneratedKeys();
                            if (keys.next()) { key = keys.getInt(1); }
                        }

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

        return p.getId();

    }
        
    

    
   public Punch ArrayList(Badge b, Timestamp ts) {

        Punch punch = null;
        ArrayList<Punch> punches = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {

                

                boolean hasresults = ps.execute();

                if (hasresults) {

                    rs = ps.getResultSet();

                    while (rs.next()) {
                        
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

        return punch;

    }
    
    public void adjust(Shift s){
       
    }

}