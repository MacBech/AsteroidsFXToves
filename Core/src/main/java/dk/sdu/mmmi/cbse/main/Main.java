package dk.sdu.mmmi.cbse.main;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {

    public static void main(String[] args) {
        // Launch of application class
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Spring configuration setup
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ModuleConfig.class);

        // Prints out all Spring Beans
        for (String bean : ctx.getBeanDefinitionNames()) {
            System.out.println(bean);
        }

        // Starting Game object trough Bean
        Game game = ctx.getBean(Game.class);
        game.start(stage);
    }


}
