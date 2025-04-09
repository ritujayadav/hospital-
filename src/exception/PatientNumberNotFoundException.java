package exception;


	public class PatientNumberNotFoundException extends Exception {
	    public PatientNumberNotFoundException() {
	        super("Invalid patient number.so there is no appointments found.");
	    }
	
}
