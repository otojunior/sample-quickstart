/**
 * 
 */
package org.otojunior.sample.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

import org.otojunior.sample.util.Sequence;

/**
 * @author 01456231650
 *
 */
public class MyRecursiveTask extends RecursiveTask<Long> {
	private static final long serialVersionUID = 7621086916912807318L;

	private int id;
	private long carga;
	
	/**
	 * Construtor padrão.
	 */
	public MyRecursiveTask(int id, long carga) {
		this.id = id;
		this.carga = carga;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Long compute() {
		if (carga <= 10) {
			System.out.println("Processando a carga na action atual id: " + id + "\t::\tcarga: " + carga);
			return Long.valueOf(carga * 3);
		} else {
			System.out.println("Redistribuindo carga para action id: " + id);

			List<MyRecursiveTask> subtasks = new ArrayList<MyRecursiveTask>();
            subtasks.add(new MyRecursiveTask(Sequence.nextInt(), this.carga / 2));
            subtasks.add(new MyRecursiveTask(Sequence.nextInt(), this.carga / 2));

            for(MyRecursiveTask subtask : subtasks) {
                subtask.fork();
            }
            
            long resultado = 0;
            for(MyRecursiveTask subtask : subtasks) {
                Long join = subtask.join();
                resultado += join.longValue();
            }
            return Long.valueOf(resultado);
		}
	}
}
