package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PunchDAO {

    private static final String QUERY_FIND = "SELECT * FROM event WHERE id = ?";

    private static final String QUERY_FIND_TERMINALID = "SELECT * FROM department WHERE terminalid = ?";

    private static final String QUERY_LIST = "SELECT * FROM event WHERE badgeid = ? AND timestamp = ?";

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
        Punch punch = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {

            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_FIND_TERMINALID);
                ps.setObject(1, punch);

                boolean hasresults = ps.execute();

                if (hasresults) {

                    rs = ps.getResultSet();

                    while (rs.next()) {
                        
                        //int id = rs.getInt("id");
                        int terminalid = rs.getInt("terminalid");
                        String badgeid = rs.getString("badgeid");
                        BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
                        Badge badge = badgeDAO.find(badgeid);
                        EventType punchtype = EventType.values()[rs.getInt("eventtypeid")];
                        LocalDateTime originaltimestamp = rs.getTimestamp("timestamp").toLocalDateTime();
                        
                        punch = new Punch(terminalid, badge, punchtype);
                        punch.getTerminalid();
                        punch.getBadge();
                        punch.getPunchtype();
                        
                        
                        
                        
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