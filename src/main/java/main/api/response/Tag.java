package main.api.response;

public class Tag {
  private String name;
  private double weight;

  public Tag(String name, double weight) {
    this.name = name;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

}
