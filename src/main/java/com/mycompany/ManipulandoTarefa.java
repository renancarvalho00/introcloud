
package com.mycompany;
import java.util.List;
import java.util.ArrayList;
import org.jooby.mvc.Path;
import org.jooby.mvc.GET;


/**Classe para a criação da Lista e a alimentação da mesma para o metodo GET.
 * @author Renan Carvalho
 * @version 1.0
 * @since Release 02 da aplicação
 */

public class ManipulandoTarefa {

/** Criação da Lista*/    
public List<String> tarefaLista = new ArrayList<String>();

/** Apontando o path*/ 
@Path("/tarefa")
@GET
/** Alimentando a lista para o GET*/ 
 public List<String> lista() {
     
     tarefaLista.add("1");
     tarefaLista.add("renan");
     tarefaLista.add("cesmac");
     
     return tarefaLista;
     
     
  }


}