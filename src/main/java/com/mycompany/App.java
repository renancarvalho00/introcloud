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
