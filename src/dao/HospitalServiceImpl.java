package dao;
import entity.Appointment;
import java.sql.*;
import java.util.*;
import util.DBConnection; 
import util.PropertyUtil; 
import exception.PatientNumberNotFoundException;

public class HospitalServiceImpl implements IHospitalService {
    Connection c;

    public HospitalServiceImpl() {
        String s=PropertyUtil.getPropertyString("db.properties");
        c=DBConnection.getConnection(s);
    }

    
  public Appointment getAppointmentById(int id) {
        Appointment a=null;
        try {
            PreparedStatement p=c.prepareStatement("select * from appointment where appointmentId=?");
            p.setInt(1,id);
            ResultSet r=p.executeQuery();
            
            if(r.next()) {
                a=new Appointment(r.getInt(1),r.getInt(2),r.getInt(3),r.getString(4),r.getString(5));
            }
        } 
        
        catch(Exception e) {
        	System.out.print(e.getMessage());
        }
        return a;
    }

    public List<Appointment> getAppointmentsForPatient(int id) throws PatientNumberNotFoundException {
        List<Appointment> l=new ArrayList<>();
        
        try {
            PreparedStatement p=c.prepareStatement("select * from appointment where patientId=?");
            p.setInt(1,id);
            ResultSet r=p.executeQuery();
            
            while(r.next()) 
            {
                l.add(new Appointment(r.getInt(1),r.getInt(2),r.getInt(3),r.getString(4),r.getString(5)));
            }
            
           
            if(l.size()==0)throw new PatientNumberNotFoundException();

        } 
        
        catch(Exception e) {
        }
        
        return l;
    }

    public List<Appointment> getAppointmentsForDoctor(int id) {
        List<Appointment> l=new ArrayList<>();
        
        try {
            PreparedStatement p=c.prepareStatement("select * from appointment where doctorId=?");
            p.setInt(1,id);
            ResultSet r=p.executeQuery();
            
            while(r.next()) {
                l.add(new Appointment(r.getInt(1),r.getInt(2),r.getInt(3),r.getString(4),r.getString(5)));
            }
        } 
        catch(Exception e) {
        	System.out.print(e.getMessage());
        }
        return l;
    }

    
    
    public boolean scheduleAppointment(Appointment a) {
        boolean f=false;
        try {
            PreparedStatement p=c.prepareStatement("insert into appointment values(?,?,?,?,?)");
            p.setInt(1,a.getAppointmentId());
            p.setInt(2,a.getPatientId());
            p.setInt(3,a.getDoctorId());
            p.setString(4,a.getAppointmentDate());
            p.setString(5,a.getDescription());
            int i=p.executeUpdate();
            
            
            if(i>0) {
            	f=true;
            }
            
        } 
        catch(Exception e) 
        {
        	System.out.print(e.getMessage());
        }
        return f;
    }

    public boolean updateAppointment(Appointment a) {
        boolean f=false;
        try {
            PreparedStatement p=c.prepareStatement("update appointment set patientId=?,doctorId=?,appointmentDate=?,description=? where appointmentId=?");
            p.setInt(1,a.getPatientId());
            p.setInt(2,a.getDoctorId());
            p.setString(3,a.getAppointmentDate());
            p.setString(4,a.getDescription());
            p.setInt(5,a.getAppointmentId());
            int i=p.executeUpdate();
            
            if(i>0) {
            	f=true;
            }
            
            
        } 
        catch(Exception e) {
        	System.out.print(e.getMessage());
        }
        return f;
    }

    public boolean cancelAppointment(int id) {
        boolean f=false;
        try {
            PreparedStatement p=c.prepareStatement("delete from appointment where appointmentId=?");
            p.setInt(1,id);
            int i=p.executeUpdate();
            
            if(i>0) {
            	f=true;
            }
        } 
        catch(Exception e) {
        	System.out.print(e.getMessage());
        }
        return f;
    }
}
