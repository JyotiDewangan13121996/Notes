package cust_excs;

public class BrowserNotSupportedException extends Exception {

	private static final long serialVersionUID = 1L;

	public BrowserNotSupportedException(String errMesg) {
		super(errMesg);// invokes Exception cls's constr(super cls constr)
		//, to supply error mesg
	}

}
