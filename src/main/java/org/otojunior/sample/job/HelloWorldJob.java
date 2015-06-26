/**
 * 
 */
package org.otojunior.sample.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
public class HelloWorldJob implements Job {
	private static final Logger LOG = LoggerFactory.getLogger(HelloWorldJob.class);
	
	/**
	 * Implementação da tarefa a ser executada. 
	 * Pode ser implementada uma classe de serviço ou regra de negócio para separar
	 * o controle da execução da implementação propriamente dita. A implementação
	 * será feita aqui neste método para simplificar.
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LOG.info("Simulação: implementação da regra de negócio.");
	}
}
