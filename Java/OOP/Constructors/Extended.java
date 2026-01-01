public class Extended {
  int modelYear;
  String modelName;

  public Extended(int year, String name) {
    modelYear = year;
    modelName = name;
  }

  public static void main(String[] args) {
    Extended myCar = new Extended(1969, "Mustang");
    System.out.println(myCar.modelYear + " " + myCar.modelName);
  }
}

// Outputs 1969 Mustang