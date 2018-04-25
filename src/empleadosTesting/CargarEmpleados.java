package empleadosTesting;

import java.util.ArrayList;
import java.util.Collection;

import com.dogma.busClass.ApiaAbstractClass;
import com.dogma.busClass.BusClassException;
import com.dogma.busClass.object.Entity;
import com.dogma.busClass.object.Identifier;

public class CargarEmpleados extends ApiaAbstractClass {

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

//		currEnt.getAttribute(atUsuario).clear();
//		currEnt.getAttribute(atNombre).clear();
//		currEnt.getAttribute(atReferente).clear();
//		currEnt.getAttribute(atPlanilla).clear();
//		currEnt.getAttribute(atLicencias).clear();
		
		Collection colUsr = currEnt.getAttribute(atUsuario).getValues();
		ArrayList arUsr = new ArrayList();
		arUsr.addAll(colUsr);
		
		
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
		
		for (Identifier id : colEmpleados) {
			Entity ent = this.getEntity("EMPLEADO", id.getPrefix(), id.getNumber(), id.getPostfix());

			String usuario = ent.getAttribute(atUsuario).getValueAsString();
			String nombre = ent.getAttribute(atNombre).getValueAsString();
			String referente = ent.getAttribute(atReferente).getValueAsString();
			String planilla = ent.getAttribute(atPlanilla).getValueAsString();
			String licencias = ent.getAttribute(atLicencias).getValueAsString();

//			Collection colUsr = currEnt.getAttribute(atUsuario).getValues();
//			Collection colNom = currEnt.getAttribute(atNombre).getValues();
//			Collection colRef = currEnt.getAttribute(atReferente).getValues();
//			Collection colPla = currEnt.getAttribute(atPlanilla).getValues();
//			Collection colLic = currEnt.getAttribute(atLicencias).getValues();
			
			
			arUsr.add(usuario);
			arNom.add(nombre);
			arRef.add(referente);
			arPla.add(planilla);
			arLic.add(licencias);
			
			
			
		
			currEnt.getAttribute(atUsuario).setValues(arUsr);
			currEnt.getAttribute(atNombre).setValues(arNom);
			currEnt.getAttribute(atReferente).setValues(arRef);
			currEnt.getAttribute(atPlanilla).setValues(arPla);
			currEnt.getAttribute(atLicencias).setValues(arLic);
		}

	}
}