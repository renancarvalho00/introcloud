
package com.mycompany;

/**
 *
 * @author renan
 */
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;
import java.util.ArrayList;
import org.jooby.mvc.Path;
import org.jooby.mvc.GET;
import org.jooby.mvc.POST;
import org.jooby.mvc.DELETE;
import org.jooby.mvc.PUT;

@Path("/tarefa")

public class ManipulandoTarefa {

  static AtomicInteger idgen = new AtomicInteger();
  public List tarefaList = new ArrayList<Tarefa>();
  private int position;

  @GET
  public List getTarefaList() {
	return tarefaList;
  }
  @POST
  public List postTarefa(String name) {
	tarefaList.add(new Tarefa(idgen.incrementAndGet(), name));
	return tarefaList;
  }
  @DELETE
  public List deleteTarefa(int id) {
	tarefaList.remove(position);
	return tarefaList;
  }
  @PUT
  public List updateTarefa(Tarefa tarefa, int position) {
	tarefaList.remove(position);
	return tarefaList;
  }
}