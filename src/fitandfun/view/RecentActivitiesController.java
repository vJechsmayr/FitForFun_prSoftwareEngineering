package fitandfun.view;

import java.util.Comparator;

import fitandfun.MainApp;
import fitandfun.model.Activity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RecentActivitiesController {

	// Reference to the main application.
	private MainApp mainApp;
	private String username;
	private ObservableList<Activity> activityList;

	@FXML
	private Label actUserLabel;

	@FXML
	private VBox vbox;

	public RecentActivitiesController() {
	}

	@FXML
	private void initialize() {

	}

	public void showRecentAct() {
		for (Activity act : activityList) {
			Label lbl = new Label();
			lbl.setFont(Font.font("Amble CN", 16));
			lbl.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			lbl.setText(act.getDateString() + ": " + act.getTypeString() + " (" + act.getDistance() + " km, " + act.getHMeter() + " hm)");
			lbl.setPrefWidth(800);
			vbox.getChildren().add(lbl);
			vbox.setPadding(new Insets(5, 10, 10, 10));
			vbox.setSpacing(5);
		}
	}


	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		username = mainApp.getActiveUser().getUsername();
		actUserLabel.setText(username);
		activityList = mainApp.getUserActivity();
		showRecentAct();
	}



	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}

}