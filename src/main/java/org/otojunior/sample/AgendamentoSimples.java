package org.otojunior.sample;

import org.otojunior.sample.job.HelloWorldJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Application Main Class.
 * @author [Author name]
 */
public class AgendamentoSimples {
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 * @throws SchedulerException 
	 */
	public static void main(String[] args) throws SchedulerException {
		/*
		 * 1. TRIGGER: 
		 * Configura o agendamento (schedule). 
		 * Existem 2 tipos de Trigger:
		 * 		- SimpleTrigger: Permite definir o tempo de inicio, fim e o intervalo de repetição.
		 * 		- CronTrigger: Permite definir via expressão UNIX Cron a data de execução do Job.  
		 */
		SimpleScheduleBuilder simple = SimpleScheduleBuilder.repeatSecondlyForever(1);
		
		Trigger trigger = TriggerBuilder.
			newTrigger().
			withIdentity("trigger1").
			withSchedule(simple).
			build();
		
		/*
		 * 2. SCHEDULER
		 * Faz a ligação entre o "Job" a ser executado e o "Trigger"
		 * e o executa.
		 */
		JobDetail job = JobBuilder.
			newJob(HelloWorldJob.class).
			withIdentity("jobHelloWord").
			withDescription("Job de teste hello wolrd.").
			build();
		
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    	scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}
}
