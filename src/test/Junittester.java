package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dao.HospitalServiceImpl;
import entity.Appointment;

class Junittester {
static HospitalServiceImpl h;

		@BeforeAll
		public static void init() {
			h=new HospitalServiceImpl();
		}

		@Test
		public void testScheduleAppointment() {
			Appointment a=new Appointment(500,101,201,"2025-06-10","testing the checkup");
			boolean b=h.scheduleAppointment(a);
			assertTrue(b);
		}

		@Test
		public void testGetAppointmentById() {
			Appointment a=h.getAppointmentById(500);
			assertNotNull(a);
		}

		@Test
		public void testGetAppointmentsForDoctor() {
			List<Appointment> l=h.getAppointmentsForDoctor(201);
			assertTrue(l.size()>0);
		}
	

}
