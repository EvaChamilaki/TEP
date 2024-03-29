/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEPDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author theodora
 */
public class PatientDB {

    public static Examinations getExam(int amka) throws ClassNotFoundException, SQLException {
        Examinations exam = new Examinations();

        Statement stmt = null;
        Connection con = null;

        try {

            con = TEPDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM examinations")
                    .append(" WHERE ")
                    .append(" amka = ").append("'").append(amka).append("';");

            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                exam.setAMKA(Integer.parseInt(res.getString("amka")));
                exam.setDiagnose(res.getString("diagnose"));
                exam.setExam_order(res.getString("exam_order"));
                exam.setPrescription(res.getString("prescription"));
                exam.setReport(res.getString("report"));
                exam.setTherapy(res.getString("therapy"));

            }

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(UserTepDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            con.close();
        }

        return exam;
    }

    public static void insertExaminations(Examinations exam) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection con = null;
        con = TEPDB.getConnection();
        stmt = con.createStatement();
        try {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" examinations (amka, diagnose, exam_order, prescription, "
                            + "report,therapy) ")
                    .append(" VALUES (")
                    .append("'").append(exam.getAMKA()).append("',")
                    .append("'").append(exam.getDiagnose()).append("',")
                    .append("'").append(exam.getExam_order()).append("',")
                    .append("'").append(exam.getPrescription()).append("',")
                    .append("'").append(exam.getReport()).append("',")
                    .append("'").append(exam.getTherapy()).append("');");

            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString());
            stmtIns.executeUpdate();

            // Get information magically completed from database
            System.out.println("#DB: The exam " + exam.toString() + "  was successfully added in the database.");

        } catch (SQLException ex) {
            System.out.println("sql ex");
            // Log exception
            Logger.getLogger(TEPDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            con.close();
        }

    }


    public static Patient getPatient(String doctor) throws ClassNotFoundException, SQLException {
        Patient patient = new Patient();

        Statement stmt = null;
        Connection con = null;

        try {

            con = TEPDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM patients")
                    .append(" WHERE ")
                    .append(" doctor = ").append("'").append(doctor).append("';");

            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                patient.setAMKA(Integer.parseInt(res.getString("amka")));
                patient.setAddress(res.getString("address"));
                patient.setDiseases(res.getString("diseases"));
                patient.setDoctor(doctor);
                patient.setFull_name(res.getString("full_name"));
                patient.setInsurance(res.getString("insurance"));
                patient.setReport(res.getString("report"));
                patient.setSelectedSymptoms(res.getString("symptoms"));
                patient.setSymptoms(res.getString("symptoms"));

            }

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(UserTepDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            con.close();
        }

        return patient;
    }

    public static void setReport(Examinations exam, String report) throws ClassNotFoundException, SQLException {

        Statement stmt = null;
        Connection con = null;

        try {

            con = TEPDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("UPDATE examinations SET report =").append("'").append(exam.getReport()).append("'")
                    .append(" WHERE ")
                    .append(" amka = ").append("'").append(exam.getAMKA()).append("';");
            System.out.println("report added " + report);
            System.out.println(exam.getReport());
            stmt.executeUpdate(insQuery.toString());
            System.out.println("#DB: The report was successfully updated in the database.");

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(UserTepDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            con.close();
        }
        return;
    }

    public static void setPrescription(Examinations exam, String prescription) throws ClassNotFoundException, SQLException {

        Statement stmt = null;
        Connection con = null;

        try {

            con = TEPDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("UPDATE examinations SET prescription =").append("'").append(prescription).append("'")
                    .append(" WHERE ")
                    .append(" amka = ").append("'").append(exam.getAMKA()).append("';");
            System.out.println("prescription added " + prescription);
            System.out.println(exam.getPrescription());
            stmt.executeUpdate(insQuery.toString());
            System.out.println("#DB: The prescription was successfully updated in the database.");

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(UserTepDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            con.close();
        }
        return;
    }


    public static void setTherapy(Examinations exam, String therapy) throws ClassNotFoundException, SQLException {

        Statement stmt = null;
        Connection con = null;

        try {

            con = TEPDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("UPDATE examinations SET therapy =").append("'").append(therapy).append("'")
                    .append(" WHERE ")
                    .append(" amka = ").append("'").append(exam.getAMKA()).append("';");
            System.out.println("report added " + therapy);
            System.out.println(exam.getTherapy());
            stmt.executeUpdate(insQuery.toString());
            System.out.println("#DB: The therappy was successfully updated in the database.");

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(UserTepDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            con.close();
        }
        return;
    }



    public static void setReportToPatient(Patient patient, String report) throws ClassNotFoundException, SQLException {

        Statement stmt = null;
        Connection con = null;

        try {

            con = TEPDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("UPDATE patients SET report =").append("'").append(report).append("'")
                    .append(" WHERE ")
                    .append(" amka = ").append("'").append(patient.getAMKA()).append("';");
            System.out.println("report added " + report);
            System.out.println(patient.getReport());
            stmt.executeUpdate(insQuery.toString());
            System.out.println("#DB: The report was successfully updated in the database.");

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(UserTepDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            con.close();
        }
        return;
    }


    public static void setDoctor(Patient patient, String doctor) throws ClassNotFoundException, SQLException {

        Statement stmt = null;
        Connection con = null;

        try {

            con = TEPDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("UPDATE patients SET doctor =").append("'").append(patient.getDoctor()).append("'")
                    .append(" WHERE ")
                    .append(" amka = ").append("'").append(patient.getAMKA()).append("';");
            System.out.println("doctor added " + doctor);
            System.out.println(patient.getDoctor());
            stmt.executeUpdate(insQuery.toString());
            System.out.println("#DB: The doctor was successfully updated in the database.");

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(UserTepDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            con.close();
        }
        return;
    }

    public static Patient getPatientWithAmka(int amka) throws ClassNotFoundException, SQLException {
        Patient patient = new Patient();

        Statement stmt = null;
        Connection con = null;

        try {

            con = TEPDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM patients ")
                    .append(" WHERE ")
                    .append(" amka = ").append("'").append(amka).append("';");

            stmt.execute(insQuery.toString());
            ResultSet res = stmt.getResultSet();
            while (res.next() == true) {
                patient.setFull_name(res.getString("full_name"));
                patient.setAMKA(amka);
                patient.setAddress(res.getString("address"));
                patient.setDiseases(res.getString("diseases"));
                patient.setInsurance(res.getString("insurance"));
                patient.setSelectedSymptoms(res.getString("selected_symptoms"));
                patient.setSymptoms(res.getString("symptoms"));
                patient.setDoctor("");
                patient.setReport("");

            }

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(UserTepDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            con.close();
        }
        return patient;
    }

    public static void insertPatient(Patient patient) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection con = null;
        con = TEPDB.getConnection();
        stmt = con.createStatement();
        try {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" patients (amka, full_name, address, diseases, "
                            + "insurance,selected_symptoms,symptoms,doctor,report) ")
                    .append(" VALUES (")
                    .append("'").append(patient.getAMKA()).append("',")
                    .append("'").append(patient.getFull_name()).append("',")
                    .append("'").append(patient.getAddress()).append("',")
                    .append("'").append(patient.getDiseases()).append("',")
                    .append("'").append(patient.getInsurance()).append("',")
                    .append("'").append(patient.getSelectedSymptoms()).append("',")
                    .append("'").append(patient.getSymptoms()).append("',")
                    .append("'").append(patient.getDoctor()).append("',")
                    .append("'").append(patient.getReport()).append("');");

            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString());
            stmtIns.executeUpdate();

            // Get information magically completed from database
            System.out.println("#DB: The member " + patient.toString() + "  was successfully added in the database.");

        } catch (SQLException ex) {
            System.out.println("sql ex");
            // Log exception
            Logger.getLogger(TEPDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            con.close();
        }

    }

    public static void createPatientTable() throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection con = null;
        con = TEPDB.getConnection();
        stmt = con.createStatement();
        try {

            String sql = "CREATE TABLE PATIENTS "
                    + "(amka INTEGER not NULL, "
                    + " full_name VARCHAR(255), "
                    + " address VARCHAR(255), "
                    + " diseases VARCHAR(255), "
                    + " insurance VARCHAR(255), "
                    + " selected_symptoms VARCHAR(255), "
                    + " symptoms VARCHAR(255), "
                    + " doctor VARCHAR(255), "
                    + " report VARCHAR(255), "
                    + " PRIMARY KEY ( amka ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    con.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        System.out.println(
                "Goodbye!");
    }

    public static void createExaminationTable() throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection con = null;
        con = TEPDB.getConnection();
        stmt = con.createStatement();
        try {

            String sql = "CREATE TABLE EXAMINATIONS "
                    + "(amka INTEGER not NULL, "
                    + " diagnose VARCHAR(255), "
                    + " exam_order VARCHAR(255), "
                    + " prescription VARCHAR(255), "
                    + " report VARCHAR(255), "
                    + " therapy VARCHAR(255), "
                    + " PRIMARY KEY ( amka ))";

            stmt.executeUpdate(sql);
            System.out.println("Created examinations table in given database...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    con.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        System.out.println(
                "Goodbye!");
    }

}
