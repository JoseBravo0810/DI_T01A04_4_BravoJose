/*
 * Esta vez la modalidad esta en NONE, es decir, igual que en el ejemplo 2, ya que este es el valor por defecto, como en el ejmplo 2  no definimos la modalidad
 * por defecto era Modality.NONE, es decir, no modal
 * 
 * Las otras dos opciones:
 *      Modality.APPLICATION_MODAL -> Bloquea las demas ventanas de la aplicacion pero no del sistema
 *      Modality.WINDOW_MODAL -> Bloquea TODAS las demas ventanas
 */
package t01a04_4_bravojose;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class T01A04_4_BravoJose extends Application {
    // Lanzador de la app
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(final Stage primaryStage) {
        // Establecemos el titulos del escenario principal
        primaryStage.setTitle("Dialog");
        // Creamos un grupo que será el nodo raiz de la escena
        Group root = new Group();
        // Creamos la escena con nodo raiz el grupo root creado, 400 pixeles de ancho, 300 pixeles de alto, y color de fondo blanco
        Scene scene = new Scene(root, 400, 300, Color.WHITE);

        // Establecemos como la escena activa la escena que acabamos de crear
        primaryStage.setScene(scene);
        // Mostramos el escenario con la escena creada como escena principal
        primaryStage.show();
        
        // Creamos otro escenario, e lconstructor recibe el escenario actual ya que el dialogo pertenece a este escenario
        // el dialogo será no modal, como el del ejemplo 2, es decir, podemos cambiar el foco entre ventanas
        Stage myDialog = new MyDialog(primaryStage);
        // Ajusta el tamaño de la ventana myDialog al contenido que tendra la propia ventana
        myDialog.sizeToScene();
        // Mostramos el dialogo no modal
        myDialog.show();
  
    }
}

class MyDialog extends Stage {

    public MyDialog(Stage owner) {
        // Llamamos al constructor de la clase de la que hereda (la superclase o clase padre), en este caso el constructor de la clase Stage
        super();
        // Establecemos el escenario pasado como argumento como la ventana propietaria del dialogo
        initOwner(owner);
        // Establecemos titulo para el dialogo
        setTitle("title");
        // El dialogo será no modal
        initModality(Modality.NONE);
        // // Creamos el grupo root, el cual será el nodo raiz de la escena
        Group root = new Group();
        // Creamos la escena
        Scene scene = new Scene(root, 250, 150, Color.WHITE);
        // Establecemos la escena creada como la escena activa del dialogo
        setScene(scene);

        // Creamos un contenedor con el layout GridPane donde se ubicaran los componentes
        GridPane gridpane = new GridPane();
        // Establecemos un padding para dicho contenedor
        gridpane.setPadding(new Insets(5));
        // Establecemos separacion entre columnas...
        gridpane.setHgap(5);
        //...y filas
        gridpane.setVgap(5);

        // Creamos la etiqueta para pedir el nombre de usuario
        Label userNameLbl = new Label("User Name: ");
        // Añadimos la etiqueta al GridPane, de nuevo fila 1 para tener separacion con el margen superior
        gridpane.add(userNameLbl, 0, 1);

        // Creamos la etiqueta para pedir la contraseña
        Label passwordLbl = new Label("Password: ");
        // Añadimos la etiqueta de la contraseña en el GridPane
        gridpane.add(passwordLbl, 0, 2);
        
        // Creamos el campo de texto para introducir el usuario, el valor inicial será Admin
        final TextField userNameFld = new TextField("Admin");
        // Añadimos dicho campo de texto al GridPane
        gridpane.add(userNameFld, 1, 1);

        // Creamos el campo de texto para introducir la contraseña
        final PasswordField passwordFld = new PasswordField();
        // Establecemos el valor por defecto del campo de texto
        passwordFld.setText("password");
        // Añadimos el campo al GridPane
        gridpane.add(passwordFld, 1, 2);

        // Creamos el boton de login
        Button login = new Button("Change");
        // Añadimos un manejador al evento de pulsacion del boton, dicho manejador unicamente cierra el dialogo
        login.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                close();
            }
        });
        
        // Añadimos e boton al GridPane
        gridpane.add(login, 1, 3);
        // Alineamos el boton en el eje horizontal, a la derecha
        GridPane.setHalignment(login, HPos.RIGHT);
        // Añadimos el GridPane con los componentes al grupo root, el nodo raiz de la escena
        root.getChildren().add(gridpane);
    }
}

