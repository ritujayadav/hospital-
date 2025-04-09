package main;

import entity.Appointment;
import dao.HospitalServiceImpl;
import dao.IHospitalService;
import exception.PatientNumberNotFoundException;
import java.util.*;


public class Main {

	 public static void main(String[] args) {
	        Scanner sc=new Scanner(System.in);
	        IHospitalService h=new HospitalServiceImpl();
	        
	        while(true) {
	        	 System.out.println("Welcome to Hospital Management System\n");
	        	 
	        	System.out.println("Choose option on what you need to do\n");
	        	
	            System.out.println("1.Schedule Appointment");
	            System.out.println("2.Update Appointment");
	            System.out.println("3.Cancel Appointment");
	            System.out.println("4.View Appointment By ID");
	            System.out.println("5.View Appointments for Patient");
	            System.out.println("6.View Appointments for Doctor");
	            System.out.println("7.Exit");
	            
	            System.out.print("Enter your choice now - ");
	            int c=sc.nextInt();
	            
	            
	            
	            if(c==1) {
	            	System.out.print("You are scheduling your appointment now\n");
	            	
	                System.out.print("Enter appointmentId- ");
	                int id=sc.nextInt();
	                System.out.print("Enter PatientId- ");
	                int pid=sc.nextInt();
	                System.out.print("Enter DoctorId- ");
	                int did=sc.nextInt();
	                sc.nextLine();
	                System.out.print("Enter Appointment Date (yyyy-mm-dd)- ");
	                String d=sc.nextLine();
	                System.out.print("Enter any additional description- ");
	                String desc=sc.nextLine();
	                
	                Appointment a=new Appointment(id,pid,did,d,desc);
	                boolean b=h.scheduleAppointment(a);
	                
	                if(b) {
	                	System.out.println("Your appointment has been scheduled\n");
	                }
	                else {
	                	System.out.println("Failed");
	                }
	            }
	            
	            else if(c==2) {
	            	System.out.print("You are updating your appointment now\n");
	            	
	                System.out.print("Enter appointmentId to Update: ");
	                int id=sc.nextInt();
	                System.out.print("Enter the new PatientId: ");
	                int pid=sc.nextInt();
	                System.out.print("Enter the new DoctorId: ");
	                int did=sc.nextInt();
	                sc.nextLine();
	                System.out.print("Enter new date(yyyy-mm-dd): ");
	                String d=sc.nextLine();
	                System.out.print("Enter new Description: ");
	                String desc=sc.nextLine();
	                
	                
	                Appointment a=new Appointment(id,pid,did,d,desc);
	                boolean b=h.updateAppointment(a);
	                
	                if(b) {
	                	System.out.println("Your appointment has been updated");
	                }
	                else {
	                	System.out.println("Update Failed");
	                }
	            }
	            
	            
	            else if(c==3) {
	            	System.out.print("Enter appointment id to delete your appointment- ");
	            	 int id=sc.nextInt();
	                 boolean b=h.cancelAppointment(id);
	                 if(b) {
	                	 System.out.println("Your appointment has been Cancelled");
	                 }
	                 else {
	                	 System.out.println("Sorry Try again. Cancellation Failed");
	                 }
	            }
	            
	            
	            else if(c==4) {
	                System.out.print("Enter AppointmentId to view the appointments- ");
	                int id=sc.nextInt();
	                Appointment a=h.getAppointmentById(id);
	                
	                if(a!=null) {
	                	System.out.println(a);
	                }
	                else {
	                	System.out.println("Not Found");
	                }
	            }
	            
	            else if(c==5) {
	                System.out.print("Enter PatientId to view list of appointments for patient: ");
	                int id=sc.nextInt();
	                try {
	                    List<Appointment> l=h.getAppointmentsForPatient(id);
	                    
	                    for(Appointment a:l) {
	                    	System.out.println(a);
	                    }
	                } 
	                catch(PatientNumberNotFoundException e) {
	                    System.out.println(e.getMessage());
	                }
	            }
	            

	            else if(c==6) {
	                System.out.print("Enter DoctorId to view list of appointments for the doctor- ");
	                int id=sc.nextInt();
	                
	                List<Appointment> l=h.getAppointmentsForDoctor(id);
	                
	                for(Appointment a:l) {
	                	System.out.println(a);
	                }
	            }
	            
	            else if(c==7) {
	            	System.out.println("Thank you for using our website");
	                break;
	            }
	            else {
	                System.out.println("No such invalid choice");
	            }
	        
	            
	         
	        }
	        
	        
	 }
}
