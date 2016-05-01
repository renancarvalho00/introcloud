
package com.mycompany;
import java.util.List;
import java.util.ArrayList;
import org.jooby.mvc.Path;
import org.jooby.mvc.GET;

public class ManipulandoTarefa {
    
public List<String> tarefaLista = new ArrayList<String>();

@Path("/tarefa")
@GET

public List<String> teste(){

tarefaLista.add("1");
tarefaLista.add("renan");
tarefaLista.add("cesmac");
    
return tarefaLista;


}

}