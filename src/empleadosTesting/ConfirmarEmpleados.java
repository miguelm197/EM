package empleadosTesting;

import java.util.ArrayList;
import java.util.Collection;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Entity;
import com.dogma.busClass.object.Identifier;

public class ConfirmarEmpleados extends ApiaAbstractClass {

	@Override
	protected void executeClass() throws BusClassException {

		Entity currEnt = this.getCurrentEntity();

		// Trae todas las instancias de la entiad.
		Collection<Identifier> colEmpleados = this.findEntities("EMPLEADO", null);

		String atUsuario = "EMP_USUARIO_STR";
		String atNombre = "EMP_NOMBREAPELLIDO_STR";
		String atReferente = "EMP_REFERENTE_STR";
		String atPlanilla = "EMP_PLANILLA_STR";
		String atLicencias = "EMP_CANTIDAD_LLICENCIAS_STR";
		
		
		Collection colUsr = currEnt.getAttribute(atUsuario).getValues();
		ArrayList arUsr = new ArrayList();
		arUsr.addAll(colUsr);
		
		this.addMessage(arUsr.size() + "");
		
		Collection colNom = currEnt.getAttribute(atNombre).getValues();
		ArrayList arNom = new ArrayList();
		arNom.addAll(colNom);
		
		
		Collection colRef = currEnt.getAttribute(atReferente).getValues();
		ArrayList arRef = new ArrayList();
		arRef.addAll(colRef);
		
		Collection colPla = currEnt.getAttribute(atPlanilla).getValues();
		ArrayList arPla = new ArrayList();
		arPla.addAll(colPla);
		
		Collection colLic = currEnt.getAttribute(atLicencias).getValues();
		ArrayList arLic = new ArrayList();
		arLic.addAll(colLic);

		
		int contador = 0;
		
		for (Identifier id : colEmpleados) {
			Entity ent = this.getEntity("EMPLEADO", id.getPrefix(), id.getNumber(), id.getPostfix());
			this.addMessage(contador + "");
			String usuario = arUsr.get(contador) + "";
			this.addMessage(usuario);
			String nombre = arNom.get(contador).toString();
			String referente = arRef.get(contador).toString();
			String planilla = arPla.get(contador).toString();
			String licencias = arLic.get(contador).toString();
			
			
			ent.getAttribute(atUsuario).setValue(usuario);
			ent.getAttribute(atNombre).setValue(nombre);
			ent.getAttribute(atReferente).setValue(referente);
			ent.getAttribute(atPlanilla).setValue(planilla);
			ent.getAttribute(atLicencias).setValue(licencias);
			
			contador++;
		}	

	}
}