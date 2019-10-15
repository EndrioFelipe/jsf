package br.com.caelum.livraria.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LogPhaseListener implements PhaseListener{

	//beforePhase(..) e afterPhase(..) são chamados antes e depois de uma fase e o getPhaseId() define qual fase o listener atende.
	
	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("FASE: "+event.getPhaseId());
		
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.ANY_PHASE; //vamos atender todas as fases
	}
	
	
	//PARA TER UMA MELHOR VISÃO DO LOG DO JSF, VAMOS DESABILITAR O LOG DO hibernate.show_sql EM persistence.xml dentro de META-INF
}
