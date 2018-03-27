import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    Stage ChooseMode;
    Scene scene_ChooseMode, scene_LoadScreen, scene_certain, scene_fullscreen;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ChooseMode = primaryStage;

        // roots for each scene
        VBox main_menu_root = new VBox(10);
        VBox load_screen_root = new VBox(10);
        VBox start_screen_root = new VBox(10);
        BorderPane fullscreen_root = new BorderPane();
        BorderPane border = new BorderPane();


        // Buttons for selection scene
        Button start_game = new Button("Start");
        start_game.setPrefSize(100, 20);

        Button load_game = new Button("Load");
        load_game.setPrefSize(100, 20);

        Button quit_game = new Button("Quit");
        quit_game.setPrefSize(100, 20);

        // Button for load scene
        Button Load_Game = new Button("Load Game");
        Load_Game.setPrefSize(100, 20);

        Button Return = new Button("Return");
        Return.setPrefSize(100, 20);
        // label for load scene
        Label load_label = new Label("Load game or return to main menu");

        // Buttons for if you're certain if you want to start the game
        Button yes_certain = new Button("Yes");
        yes_certain.setPrefSize(100, 20);

        Button no_certain = new Button("No");
        no_certain.setPrefSize(100, 20);
        //label for certain scene
        Label certain_label = new Label("Are you certain you want to start the game?");

        // scenes
        scene_ChooseMode = new Scene(main_menu_root, 300, 200);
        scene_LoadScreen = new Scene(load_screen_root, 300, 200);
        scene_certain = new Scene(start_screen_root, 300, 200);
        scene_fullscreen = new Scene(fullscreen_root);

        Button Building = new Button("Building");
        Building.setPrefSize(100, 20);

        Button End_Turn = new Button("End Turn");
        End_Turn.setPrefSize(100, 20);

        Button Armory = new Button("Armory");
        Armory.setPrefSize(100, 20);

        // fullscreen scene placement
        fullscreen_root.setLeft(stats_overview_player1());
        fullscreen_root.setTop(ingame_save_quit());
        fullscreen_root.setBottom(select_menu_game());
        fullscreen_root.setRight(stats_overview_player2());

        // Top borderpane for scene selection
        HBox hbox = addHBox();
        border.setTop(hbox);

        // Root for main scene
        main_menu_root.getChildren().addAll(border, start_game, load_game, quit_game);
        main_menu_root.setAlignment(Pos.CENTER);

        // Root for load scene
        load_screen_root.getChildren().addAll(load_label, Load_Game, Return);
        load_screen_root.setAlignment(Pos.CENTER);

        // Root for certain scene
        start_screen_root.getChildren().addAll(certain_label, yes_certain, no_certain);
        start_screen_root.setAlignment(Pos.CENTER);

        //event keys on load screen
        Return.setOnAction(event ->
                ChooseMode.setScene(scene_ChooseMode)
        );

        //event keys on selection screen
        load_game.setOnAction(event ->
                ChooseMode.setScene(scene_LoadScreen)
        );

        start_game.setOnAction(event ->
                ChooseMode.setScene(scene_certain)
        );

        quit_game.setOnAction(event ->
                ChooseMode.close()
        );

        // eventkeys for certain scene
        yes_certain.setOnAction(event -> {
            ChooseMode.setScene(scene_fullscreen);
            ChooseMode.setMaximized(true);
        });
        no_certain.setOnAction(event ->
                ChooseMode.setScene(scene_ChooseMode)
        );



        fullscreen_root.addEventHandler(KeyEvent.KEY_PRESSED, this::onKeyPressed);

        ChooseMode.setScene(scene_ChooseMode);
        ChooseMode.setTitle("Kingdoms of War");
        ChooseMode.show();


    }

    private HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Label hbox_label = new Label("Welcome to Kingdoms of War!");
        hbox_label.setFont(Font.font("Helvetica", FontWeight.BOLD, 17));

        hbox.getChildren().addAll(hbox_label);
        hbox.setAlignment(Pos.CENTER);

        return hbox;
    }

    private VBox stats_overview_player1() {

        VBox stats = new VBox();
        stats.setPadding(new Insets(10, 0, 0, 5)); // Set all sides to 10
        stats.setSpacing(8);              // Gap between nodes

        Text stats_title = new Text("Player 1 Stats");
        stats_title.setFont(Font.font("Calibri", FontWeight.BOLD, 22));
        stats.getChildren().add(stats_title);

        Label options[] = new Label[]{
                new Label("Stone:"),
                new Label("Gold:"),
                new Label("Food:"),
                new Label("Wood:")
        };

        for (int i = 0; i < 4; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            stats.getChildren().add(options[i]);
        }

        Insets spacing_one = new Insets(15, 0, 0, 1.5);

        Label town_stats = new Label("Town Stats");
        town_stats.setFont(Font.font("Calibri", FontWeight.BOLD, 22));
        VBox.setMargin(town_stats, spacing_one);
        stats.getChildren().add(town_stats);

        Label options1[] = new Label[]{
                new Label("Health:"),
                new Label("Population:")
        };

        for (int i = 0; i < 2; i++) {
            VBox.setMargin(options1[i], new Insets(0, 0, 0, 8));
            stats.getChildren().add(options1[i]);
        }

        Label unit_count = new Label("Units");
        unit_count.setFont(Font.font("Calibri", FontWeight.BOLD, 22));
        VBox.setMargin(unit_count, spacing_one);
        stats.getChildren().add(unit_count);

        Label units[] = new Label[]{
                new Label("Workers:"),
                new Label("Swordsmen:"),
                new Label("Archers:"),
                new Label("Spearmen:"),
                new Label("REEE-MEN:")
        };

        for (int i = 0; i < 5; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(units[i], new Insets(0, 0, 0, 8));
            stats.getChildren().add(units[i]);
        }

        return stats;
    }

    private VBox stats_overview_player2() {

        VBox stats = new VBox();
        stats.setPadding(new Insets(10, 5, 0, 0)); // Set all sides to 10
        stats.setSpacing(8);              // Gap between nodes

        Text stats_title = new Text("Player 2 Stats");
        stats_title.setFont(Font.font("Calibri", FontWeight.BOLD, 22));
        stats.getChildren().add(stats_title);

        Label options[] = new Label[]{
                new Label("Stone:"),
                new Label("Gold:"),
                new Label("Food:"),
                new Label("Wood:")
        };

        for (int i = 0; i < 4; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(options[i], new Insets(0, 8, 0, 0));
            stats.getChildren().add(options[i]);
        }

        Insets spacing_one = new Insets(15, 1.5, 0, 0);

        Label town_stats = new Label("Town Stats");
        town_stats.setFont(Font.font("Calibri", FontWeight.BOLD, 22));
        VBox.setMargin(town_stats, spacing_one);
        stats.getChildren().add(town_stats);

        Label options1[] = new Label[]{
                new Label("Health:"),
                new Label("Population:")
        };

        for (int i = 0; i < 2; i++) {
            VBox.setMargin(options1[i], new Insets(0, 8, 0, 0));
            stats.getChildren().add(options1[i]);
        }

        Label unit_count = new Label("Units");
        unit_count.setFont(Font.font("Calibri", FontWeight.BOLD, 22));
        VBox.setMargin(unit_count, spacing_one);
        stats.getChildren().add(unit_count);

        Label units[] = new Label[]{
                new Label("Workers:"),
                new Label("Swordsmen:"),
                new Label("Archers:"),
                new Label("Spearmen:"),
                new Label("REEE-MEN:")
        };

        for (int i = 0; i < 5; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(units[i], new Insets(0, 8, 0, 0));
            stats.getChildren().add(units[i]);
        }

        return stats;
    }

    public Parent select_menu_game() {
        StackPane game_buttons_root = new StackPane();
        game_buttons_root.setPrefSize(245, 100);
        game_buttons_root.setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
        game_buttons_root.setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
        StackPane.setAlignment(game_buttons_root, Pos.BOTTOM_CENTER);

        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(2); //preferred columns
        tilePane.setAlignment(Pos.CENTER);
        tilePane.setHgap(5);
        tilePane.setVgap(5);

        //String IMAGE = "/ensemble/samples/shared-resources/icon-48x48.png";
        //Image ICON_48 = new Image(getClass().getResourceAsStream(IMAGE));
        Button[] buttons = new Button[6];
        for (int j = 0; j < buttons.length; j++) {
            buttons[j] = new Button("button" + (j + 1));
            tilePane.getChildren().add(buttons[j]);
        }
        game_buttons_root.getChildren().add(tilePane);
        return game_buttons_root;
    }

    private HBox ingame_save_quit() {
        HBox save_quit = new HBox();
        save_quit.setPadding(new Insets(15, 12, 15, 12));
        save_quit.setSpacing(10);
        save_quit.setStyle("-fx-background-color: #336699;");

        Button save_ingame = new Button("Save Game");
        save_ingame.setPrefSize(100, 20);

        Button main_menu_ingame = new Button("Main Menu");
        main_menu_ingame.setPrefSize(100, 20);

        Button quit_ingame = new Button("Quit Game");
        quit_ingame.setPrefSize(100, 20);

        main_menu_ingame.setOnAction(event ->
                ChooseMode.setScene(scene_ChooseMode)
        );

        save_quit.getChildren().addAll(save_ingame, main_menu_ingame, quit_ingame);
        save_quit.setAlignment(Pos.TOP_RIGHT);

        return save_quit;
    }

    private void onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            int result_menu = EscapeWindow.display("Menu");
            System.out.println(result_menu);
        }
    }
}

