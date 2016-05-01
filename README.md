# My Todo List Java Jooby

Este projeto visa apresentar a execução de um **My Todo List** no formato **REST** em java junto com **API Json** com o **framework Jooby**.

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
	 assets("/","index.html");
    use(ManipulandoTarefa.class);
  }

  public static void main(final String[] args) throws Exception {
    run(App::new, args);
  }

}

```

## ManipulandoTarefa class

```java
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
```
