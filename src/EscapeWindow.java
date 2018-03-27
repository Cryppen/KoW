import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class EscapeWindow{

    private static int menu_option = 0;

    public static int display(String title){

        Stage Escape_window = new Stage();
        Escape_window.initModality(Modality.APPLICATION_MODAL);

        Escape_window.setTitle(title);

        Label menu_label = new Label ("Escape Menu");
        menu_label.setFont(Font.font("Helvetica", FontWeight.BOLD, 22));

        Button Save_quit = new Button("Save and Quit");
        Save_quit.setPrefSize(100, 20);

        Button Save = new Button("Save Game");
        Save.setPrefSize(100, 20);

        Button main_menu_button = new Button("Main Menu");
        main_menu_button.setPrefSize(100, 20);

        Button Resume = new Button("Resume");
        Resume.setPrefSize(100, 20);

        VBox escapewindow_root = new VBox(43);

        Save_quit.setOnAction(event -> {
                    menu_option = 1;
                    Escape_window.close();
                }
        );

        main_menu_button.setOnAction(event -> {
                    menu_option = 2;
                    Escape_window.close();
                }
        );

        Resume.setOnAction(event ->
                Escape_window.close()
        );

        Scene escape_menu_scene = new Scene(escapewindow_root, 250, 375);

        escapewindow_root.getChildren().addAll(menu_label, Save_quit ,Save, main_menu_button, Resume);
        escapewindow_root.setAlignment(Pos.CENTER);

        Escape_window.setScene(escape_menu_scene);
        Escape_window.show();

        return menu_option;
    }
}
