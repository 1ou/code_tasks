package test;

abstract class Food {
     abstract double getCalories();
}

class JunkFood extends Food {
    double getCalories() {
        return 200.0;
    }

    public static void main(String[] args) {
        System.out.println(new JunkFood().getCalories());
    }
}

