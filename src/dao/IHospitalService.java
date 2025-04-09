package dao;
import entity.Appointment;
import exception.PatientNumberNotFoundException;

import java.util.List;

public interface IHospitalService {
	 Appointment getAppointmentById(int id);
	 List<Appointment> getAppointmentsForPatient(int id) throws PatientNumberNotFoundException;
	 List<Appointment> getAppointmentsForDoctor(int id);
	 boolean scheduleAppointment(Appointment a);
	 boolean updateAppointment(Appointment a);
	 boolean cancelAppointment(int id);

}
