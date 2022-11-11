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


   // private static final String QUERY_LIST = "SELECT * FROM event WHERE badgeid = ? AND timestamp = ?";
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
    


/*
    public Integer create(Punch p){
        Punch punch = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
      */  

    
    
    
    
    
    public Integer create(Punch p){
        
        
           
        int punchID = 0;
        // "INSERT INTO event (terminalid, badgeid, timestamp, eventtype) VALUES(?, ?, ?, ?)"
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {

            //Connection conn = daoFactory.getConnection();
            Connection conn = daoFactory.getConnection(/*server, username, password*/);

            if (conn.isValid(0)) {
               
                
                //int key = 0, result = 0;
                //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                //Connection conn = daoFactory.getConnection(/*server, username, password);
                ResultSet keys;
                String sql = "INSERT INTO event (badgeid, originaltimestamp, terminalid, eventtypeid) VALUES (?,?,?,?)";
                ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                //ps.setString(1, badgeid);
                //ps.setString(2, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(originaltimestamp.getTime()));
                //ps.setInt(3, 101);
                //ps.setInt(4, 1);
                //result = ps.executeUpdate();
                //if (result == 1) {
                    //keys = ps.getGeneratedKeys();
                    //if (keys.next()) { key = keys.getInt(1); }
               // }
                
                
                
                //int key = 0, result = 0;
                //Class.forName(QUERY_CREATE).newInstance();
                //String sql = "INSERT INTO event (badgeid, originaltimestamp, terminalid, eventtype) VALUES (?, ?, ?, ?";
                //ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                //ps.setString(1, badgeid);


                
                

                //ps = conn.prepareStatement(QUERY_CREATE);
                //ps.setString(1, badgeid);
                //ps.setObject(1, p);

<<<<<<< HEAD
=======
                ps = conn.prepareStatement(QUERY_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
                // Slide 30 of 30 JavaDatabaseProgramming 
                //ps.setString(1, terminalid);
                //ps.setString(2, badgeid);
                //ps.setString(3, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(originaltimestamp.getTime()));
                //ps.setString(4, eventtype);
                
>>>>>>> e040d99cb67913d902351e0ab061bb041e5461bb

                boolean hasresults = ps.execute();

                if (hasresults) {

                    rs = ps.getResultSet();

                    while (rs.next()) {
<<<<<<< HEAD

                        
                        //int id = rs.getInt("id");
                        int terminalid = rs.getInt("terminalid");
                        String badgeid = rs.getString("badgeid");
                        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
                        Badge badge = badgeDAO.find(badgeid);
                        EventType punchtype = EventType.values()[rs.getInt("eventtypeid")];
                        LocalDateTime originaltimestamp = rs.getTimestamp("timestamp").toLocalDateTime();
                        
                        
                        
                        
                        p = new Punch(terminalid, badge, punchtype);
                        
                        int key = 0, result = 0;
                        //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                        //Connection conn = daoFactory.getConnection(/*server, username, password*/);
                        //ResultSet keys;
                        //String sql = "INSERT INTO event (badgeid, originaltimestamp, terminalid, eventtypeid) VALUES (?,?,?,?)";
                        //PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                        ps.setString(1, badgeid);
                        ps.setString(2, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(originaltimestamp));
                        ps.setInt(3, 101);
                        ps.setInt(4, 1);
                        result = ps.executeUpdate();
                        if (result == 1) {
                            keys = ps.getGeneratedKeys();
                            if (keys.next()) { key = keys.getInt(1); }
                }
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        //p.getTerminalid();
                        //p.getBadge();
                        //p.getPunchtype();
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        //create = new Punch(id,terminalid);
                        //create = new Punch(terminalid, badge, punchtype);
                        
                            //terminalid = punch.getTerminalid();
                            //badge = punch.getBadge();
                            //punchtype = punch.getPunchtype();
                        
                        






                        
                        
                        
                        //punch = new Punch(terminalid,badge, punchtype);
                             
                            //id = punch.getId();
                            //terminalid = punch.getTerminalid();
                            //badge = punch.getBadge();
                            //originaltimestamp = punch.getOriginaltimestamp();
                            //punchtype = punch.getPunchtype();
                            
                            

                     

=======
                        
>>>>>>> e040d99cb67913d902351e0ab061bb041e5461bb
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

        return null;

    }
        
    

    //public Integer punchCreate(){
        //return null;
    //}


     

    
    
    
    
   // public Integer create(Punch p){
        //punch = new Punch(terminalid, badge, punchtype);
        //return null;
    //}
    
    public ArrayList list(Badge b, LocalDate t){
        
        return null;
    }
    
    public void adjust(Shift s){
       
    }

}