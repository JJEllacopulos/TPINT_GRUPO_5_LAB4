package Negocio;

import Dao.Dao_Transferencia;
import Entidad.Transferencias;
import Interface.InterfaceTransferencia;

public class NegocioTransferencia implements InterfaceTransferencia{

	private Dao_Transferencia daoTransferencia = new Dao_Transferencia();
	
	@Override
	public void SPAltaTransferencia(Transferencias transferencia, String fecha) {
		// TODO Auto-generated method stub
		daoTransferencia.SPAltaTransferencias(transferencia,fecha);
		
	}
	
	
}
