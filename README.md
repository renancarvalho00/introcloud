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
# Agora vamos criar e alimentar as classes

## APP CLASS
```java
package com.mycompany;

import org.jooby.Jooby;
import org.jooby.json.Jackson;

/**
 * @author jooby generator
 */
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
## ManipulandoTarefa CLASS
```java
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
```

# Agora vamos criar nosso index.html
```html
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>My Todo List</title>
</head>

<body>
<center><h1>My Todo List</h1></center>
<center><a href="\tarefa">GET</a></center>
</body>
</html>
```
#Abra o navegador e digite:

```
http://localhost:8080
```
Depois click em GET
```




