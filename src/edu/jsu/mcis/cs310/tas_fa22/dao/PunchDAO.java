package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PunchDAO {

    private static final String QUERY_FIND = "SELECT * FROM event WHERE id = ?";
    private static final String QUERY_LIST = "SELECT *, DATE(`timestamp`) AS ts FROM event WHERE badgeid = ? HAVING ts = ? ORDER BY `timestamp`";
    private static final String QUERY_LIST2 = "SELECT *, DATE(`timestamp`) AS ts FROM event WHERE badgeid = ? HAVING ts = ? ORDER BY `timestamp1`"
    private static final String QUERY_CREATE = "INSERT INTO event (terminalid, badgeid, `timestamp`, eventtypeid) VALUES(?, ?, ?, ?)";

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
        int newPunchID = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
        Employee employee = employeeDAO.find(p.getBadge());
        
        int employeeTerminalID = employee.getDepartment().getTerminalid();
        // Check the terminal ID of the new punch this will be used to check against the ID of the deginated clock
        // termnial of the employees department. This will lead into an if state checking the two terminal ID's are equal
        if(employeeTerminalID == p.getTerminalid()){
        
        
            try {

                Connection conn = daoFactory.getConnection();
           

                if (conn.isValid(0)) {
               
             
                //QUERY_CREATE: "INSERT INTO event (terminalid, badgeid, timestamp, eventtype) VALUES(?, ?, ?, ?)"
                    ps = conn.prepareStatement(QUERY_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, p.getTerminalid());
                    ps.setString(2, p.getBadge().getId());
                    ps.setTimestamp(3, java.sql.Timestamp.valueOf(p.getOriginaltimestamp()));
                    ps.setInt(4, p.getPunchtype().ordinal());
                
                             
                    int result = ps.executeUpdate();
               

                    if (result == 1) {

                        rs = ps.getGeneratedKeys();

                        if (rs.next()) {
                                newPunchID = rs.getInt(1);


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
        }
        return newPunchID;  
    }


    
    
    
    
   public ArrayList<Punch> list(Badge b, LocalDate ts) {

        ArrayList<Punch> punchlist = new ArrayList<>();
        
        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();


        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Connection conn = daoFactory.getConnection();
            
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_LIST);
                ps.setString(1, b.getId());
                ps.setDate(2, java.sql.Date.valueOf(ts));
                

                boolean hasresults = ps.execute();

                if (hasresults) {

                    rs = ps.getResultSet();

                    while (rs.next()) {
                        
                        int id = rs.getInt("id");
                        int terminalid = rs.getInt("terminalid");
                        Badge badge = badgeDAO.find(rs.getString("badgeid"));
                        EventType eventtype = EventType.values()[rs.getInt("eventtypeid")];
                        LocalDateTime originaltimestamp = LocalDateTime.parse(rs.getString("timestamp"), format);
                        
                        Punch p = new Punch(id, terminalid, badge, originaltimestamp, eventtype);
                        
                        punchlist.add(p);

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

        return punchlist;

    }
    
    public void adjust(Shift s){
       
    }
    
    public ArrayList<Punch> list(Badge b, LocalDate begin, LocalDate end) {

        ArrayList<Punch> punchlistRange = new ArrayList<>();
        
           // Use the other find method to iterate through the local dates passed through
           // the method 

        return punchlistRange;

    }

}
