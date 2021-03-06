package fitandfun.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.XmlElement;
import fitandfun.Sex;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * User-Class for creating Users
 *
 * @author Viktoria Jechsmayr
 * @version 1.0
 */
public class User {

	/**
	 * User data
	 */
	private final StringProperty username;
	private final ObjectProperty<LocalDate> birthday;
	// WEIGHT in kg
	private final FloatProperty weight;
	// HEIGHT in cm
	private final IntegerProperty height;
	private final ObjectProperty<Sex> sex;
	private final FloatProperty BMI;
	private final BooleanProperty isNew;

	/**
	 * Constructor
	 */

	public User() {
		this(null);
	}

	public User(String username) {
		this(username, Sex.None);
	}

	public User(String username, Sex sex) {
		this(username, sex, null);
	}

	public User(String username, Sex sex, LocalDate birthday) {
		this(username, sex, birthday, 0, 0);
	}

	public User(String username, Sex sex, LocalDate birthday, float w, int h) {
		this.username = new SimpleStringProperty(username);
		this.sex = new SimpleObjectProperty<>(sex);
		this.birthday = new SimpleObjectProperty<>(birthday);
		this.weight = new SimpleFloatProperty(w);
		this.height = new SimpleIntegerProperty(h);
		this.BMI = new SimpleFloatProperty(0);
		this.isNew = new SimpleBooleanProperty(true);
		this.weight.addListener((value) -> updateBMI());
		this.height.addListener((value) -> updateBMI());

		updateBMI();
	}

	/*
	 * Get- and Set-Methods & Property for username
	 */
	public StringProperty usernameProperty() {
		return this.username;
	}

	@XmlElement(name = "Username")
	public String getUsername() {
		return username.get();
	}

	public void setUsername(String username) {
		this.username.set(username);
	}

	/*
	 * Get- and Set-Methods & Property for sex
	 */
	public ObjectProperty<Sex> sexProperty() {
		return this.sex;
	}

	@XmlElement(name = "Sex")
	public Sex getSex() {
		return sex.get();
	}

	public void setSex(Sex sex) {
		this.sex.set(sex);
	}

	/*
	 * Get- and Set-Methods & Property for birthday
	 */
	public ObjectProperty<LocalDate> birthdayProperty() {
		return this.birthday;
	}

	public LocalDate getBirthday() {
		return birthday.get();
	}

	public void setBirhtday(LocalDate birthday) {
		this.birthday.set(birthday);
	}

	@XmlElement(name = "Birthday")
	public String getBirthdayString() {
		if (birthday.get() == null) {
			return "";
		}
		return birthday.get().format(DateTimeFormatter.ISO_DATE);
	}

	public void setBirthdayString(String birthdayString) {
		if (birthdayString != null) {
			this.birthday.set(LocalDate.parse(birthdayString));
		} else {
			this.birthday.set(null);
		}
	}

	/*
	 * Get- and Set-Methods & Property for weight
	 */
	public FloatProperty weightProperty() {
		return this.weight;
	}

	@XmlElement(name = "Weight")
	public float getWeight() {
		return weight.get();
	}

	public void setWeight(float weight) {
		this.weight.set(weight);
	}

	/*
	 * Get- and Set-Methods & Property for height
	 */
	public IntegerProperty heightProperty() {
		return this.height;
	}

	@XmlElement(name = "Height")
	public int getHeight() {
		return height.get();
	}

	public void setHeight(int height) {
		this.height.set(height);
	}

	/*
	 * Get- and Set-Methods & Property for bmi
	 */
	public FloatProperty bmiProperty() {
		return this.BMI;
	}

	public float getBMI() {
		return BMI.get();
	}

	/*
	 * Get- and Set-Methods & Property for isNEW
	 */
	public BooleanProperty newProperty() {
		return this.isNew;
	}

	@XmlElement(name = "IsNew")
	public boolean getIsNew() {
		return isNew.get();
	}

	public void setIsNew(boolean val) {
		this.isNew.set(val);
	}

	/**
	 * Update BMI when values are available
	 */
	public void updateBMI() {
		if (height.get() > 0 && weight.get() > 0) {
			float meterHeight = (float) (height.get() / 100.0);
			this.BMI.set((float) (weight.get() / (meterHeight * meterHeight)));
		} else {
			this.BMI.set(0);
		}
	}
}