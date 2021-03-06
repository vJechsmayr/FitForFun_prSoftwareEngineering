package fitandfun.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.ObjectProperty;
//import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * TrainingGoals-Class for creating TrainingGoals
 * 
 * @author Viktoria Jechsmayr
 * @version 1.0
 */
public class TrainingGoals {

	private final StringProperty name;
	private final ObjectProperty<GoalType> type;
	private final FloatProperty goalValue;
	private final ObjectProperty<LocalDate> goalDate;
	private final ObjectProperty<LocalDate> startDate;
	//private final SimpleBooleanProperty completed;


	public TrainingGoals()
	{
		this(null, null, 0, null, null);
	}
	
	/**
	 * Constructor
	 * 
	 */
	public TrainingGoals(String name, GoalType type, float goalValue, LocalDate goalDate, LocalDate startDate) {
		this.name = new SimpleStringProperty(name);
		this.type = new SimpleObjectProperty<>(type);
		this.goalValue = new SimpleFloatProperty(goalValue);
		//this.completed = new SimpleBooleanProperty();
		this.goalDate = new SimpleObjectProperty<>(goalDate);
		this.startDate = new SimpleObjectProperty<>(startDate);
	}
	
	//actName
		public StringProperty nameProperty() {
			return this.name;
		}

		@XmlElement(name = "TrainingGoalName")
		public String getName() {
			return this.name.get();
		}

		public void setName(String name) {
			this.name.set(name);
		}
	
	/**
	 * Property-getter, Getter- and Setter Methods for activityName
	 */
	public ObjectProperty<GoalType> goalTypeProperty() {
		return this.type;
	}

	@XmlTransient
	public String getTypeString() {
		if (type.get() != null) {
			return type.get().toString();
		}
		return "";
	}

	@XmlElement(name = "Type")
	public GoalType getType() {
		return type.get();
	}

	public void setType(GoalType type) {
		this.type.set(type);
	}
	
	/**
	 * Property-getter, Getter- and Setter Methods for startDate
	 */
	public ObjectProperty<LocalDate> startProperty() {
		return this.startDate;
	}

	@XmlElement(name = "StartDate")
	public String getStartDateString() {
		if (startDate.get() == null) {
			return "";
		}
		return startDate.get().format(DateTimeFormatter.ISO_DATE);
	}

	public void setStartDateString(String startDateStr) {
		if (startDateStr != null) {
			this.startDate.set(LocalDate.parse(startDateStr));
		} else {
			this.startDate.set(null);
		}
	}
	
	public LocalDate getStartDate()
	{
		return this.startDate.get();
	}
	
	/**
	 * Property-getter, Getter- and Setter Methods for date
	 */
	public ObjectProperty<LocalDate> dateProperty() {
		return this.goalDate;
	}

	@XmlElement(name = "Date")
	public String getDateString() {
		if (goalDate.get() == null) {
			return "";
		}
		return goalDate.get().format(DateTimeFormatter.ISO_DATE);
	}
	
	public LocalDate getDate()
	{
		return this.goalDate.get();
	}

	public void setDateString(String dateString) {
		if (dateString != null) {
			this.goalDate.set(LocalDate.parse(dateString));
		} else {
			this.goalDate.set(null);
		}
	}
	
	/**
	 * Property-getter, Getter- and Setter Methods for distance
	 */
	public FloatProperty goalValueProperty() {
		return this.goalValue;
	}

	@XmlElement(name = "GoalValue")
	public float getGoalValue() {
		return goalValue.get();
	}

	public void setGoalValue(float goalValue) {
		this.goalValue.set(goalValue);
	}
	

}
