# My Todo List Java Jooby

Este projeto visa apresentar a execução de um **REST** em java junto com **API Json**.

# Requerimentos

* A text editor or IDE
* [JDK 8+](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later
* [Maven 3+](http://maven.apache.org/)


# Pronto

Abra o terminal (usuário Windows) e cole:

```bash
mvn archetype:generate -B -DgroupId=com.mycompany -DartifactId=introcloud -Dversion=1.0-SNAPSHOT -DarchetypeArtifactId=jooby-archetype -DarchetypeGroupId=org.jooby -DarchetypeVersion=1.0.0.CR2
```

A aplicaão está pronta para rodar.

```
cd introcloud

mvn jooby:run
```

Abra o navegador e digite:

```
http://localhost:8080
```
## Json

Nossa API será JSON, então vamos adicionar [jackson](https://github.com/jooby-project/jooby/tree/master/jooby-jdbi) dependencia e importar no nosso  ```App.java```:

```java
import org.jooby.json.Jackson;
...
{
  use(new Jackson());
}
```

## App class

```java
package com.mycompany;

import org.jooby.Jooby;
import org.jooby.json.Jackson;

public class App extends Jooby {

 {
	use(new Jackson());
    use(ManipulandoTarefa.class);
  }

  public static void main(final String[] args) throws Exception {
    run(App::new, args);
  }

}

```

## Tarefa class

```java
package com.mycompany;

public class Tarefa {
   
  public int id;

  public String name;

    public Tarefa() {
    }

    public Tarefa(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
}

```

## ManipulandoTarefa class

```java
package com.mycompany;

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

```
