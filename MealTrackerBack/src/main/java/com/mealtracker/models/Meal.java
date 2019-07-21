package com.mealtracker.models;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "meals")
public class Meal extends TrackerModel {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(generator = "meal_generator")
  @SequenceGenerator(
          name = "meal_generator",
          sequenceName = "meal_sequence",
          initialValue = 1000
  )
  private Long id;

  @Column( nullable = false )
  private String name;

  private String description;

  // -- Auto generated --

  public Meal() {
  }

  public Meal(Long id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Meal id(Long id) {
    this.id = id;
    return this;
  }

  public Meal name(String name) {
    this.name = name;
    return this;
  }

  public Meal description(String description) {
    this.description = description;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Meal)) {
            return false;
        }
        Meal meal = (Meal) o;
        return Objects.equals(id, meal.id) && Objects.equals(name, meal.name) && Objects.equals(description, meal.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", description='" + getDescription() + "'" +
      "}";
  }

  }