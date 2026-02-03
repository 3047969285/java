package org.javagrammerthinker;

public class java_02 {
    // reuse/PlaceSetting.java
    // (c)2017 MindView LLC: see Copyright.txt
    // We make no guarantees that this code is fit for any purpose.
    // Visit http://OnJava8.com for more book information.
    // Combining composition & inheritance

    static class Plate {
        Plate(int i) {
            System.out.println("Plate constructor, i = " + i);
        }
    }

    static class DinnerPlate extends Plate {
        DinnerPlate(int i) {
            super(i);
            System.out.println("DinnerPlate constructor, i = " + i);
        }
    }

    static class Utensil {
        Utensil(int i) {
            System.out.println("Utensil constructor, i = " + i);
        }
    }

    static class Spoon extends Utensil {
        Spoon(int i) {
            super(i);
            System.out.println("Spoon constructor, i = " + i);
        }
    }

    static class Fork extends Utensil {
        Fork(int i) {
            super(i);
            System.out.println("Fork constructor, i = " + i);
        }
    }

    static class Knife extends Utensil {
        Knife(int i) {
            super(i);
            System.out.println("Knife constructor, i = " + i);
        }
    }

    // A cultural way of doing something:
    static class Custom {
        Custom(int i) {
            System.out.println("Custom constructor, i = " + i);
        }
    }

    static public class PlaceSetting extends Custom {
        private Spoon sp;
        private Fork frk;
        private Knife kn;
        private DinnerPlate pl;
        
        public PlaceSetting(int i) {
            super(i + 1);
            sp = new Spoon(i + 2);
            frk = new Fork(i + 3);
            kn = new Knife(i + 4);
            pl = new DinnerPlate(i + 5);
            System.out.println("PlaceSetting constructor, i = " + i);
        }
        
        public static void main(String[] args) {
            PlaceSetting x = new PlaceSetting(9);
        }
    }
    
    public static void main(String[] args) {
        PlaceSetting.main(args);
    }
}