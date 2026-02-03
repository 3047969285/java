package yufa;

public class yufa011 {
    public static void main(String[] args) {
        
        
        int []a = {1,2,3,4,5,6,7,8,9,10};
        int i = 0;
        switch (a[i]){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
            case 6:
                System.out.println("6");
                break;
            case 7:
                System.out.println("7");
                break;
            case 8:
                System.out.println("8");
        }
        while(i<a.length){
            System.out.println(a[i]);
            i++;
        }
    }

}
