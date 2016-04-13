/**
 * 
 */
package org.otojunior.sample.forkjoin.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

import org.otojunior.sample.util.Sequence;

/**
 * @author 01456231650
 *
 */
public class MyRecursiveAction extends RecursiveAction {
	private static final long serialVersionUID = 7621086916912807318L;

	private int id;
	private long carga;
	
	/**
	 * Construtor padrão.
	 */
	public MyRecursiveAction(int id, long carga) {
		this.id = id;
		this.carga = carga;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void compute() {
		if (carga <= 10) {
			System.out.println("Processando a carga na action atual id: " + id + "\t::\tcarga: " + carga);
		} else {
			System.out.println("Redistribuindo carga para action id: " + id);

			List<MyRecursiveAction> subtasks = new ArrayList<MyRecursiveAction>();
            subtasks.add(new MyRecursiveAction(Sequence.nextInt(), this.carga / 2));
            subtasks.add(new MyRecursiveAction(Sequence.nextInt(), this.carga / 2));

            for(RecursiveAction subtask : subtasks) {
                subtask.fork();
            }
		}
	}
}
