package empleadosTesting;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Entity;

public class claseBase extends ApiaAbstractClass{

	@Override
	protected void executeClass() throws BusClassException {
		
		Entity currEnt = this.getCurrentEntity();
		
	}
}