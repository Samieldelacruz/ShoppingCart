import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] stock = {"Apple", "Rice", "Ipad", "Detergent", "Books", "Baby clothes", "office supplies", "Home Decor", "Wine", "Beer"};

        System.out.println("Are you part of our loyalty program?");
        System.out.println("If you are, please enter the level. If you are not, please enter 0");
        String member = sc.next();
        membershipStatus(member);

        System.out.println("What would you like to purchase today?");
        String item = sc.next();

        if (checkItemInStock(item, stock)) {
            int isle = isleNumber(item, stock);
            if(isle == 8 || isle == 9){
                System.out.println("You are trying to purchase alcohol! Please enter your age below:");
                int age = sc.nextInt();
                if (checkAge(age)) {
                    System.out.println("Available for purchase in isle: " + isle);
                } else{
                    System.out.println("Too young to purchase alcohol");
                }
            } else {
                System.out.println("Available for purchase in isle: " + isle);
            }


        } else {
            System.out.println("Unfortunately we do not have this item available at the moment");
        }

    }

    static void membershipStatus(String lvl) {
        if (lvl.equals("0")) {
            System.out.println("Become a member to get your loyalty points");
        } else if (lvl.equals("1")) {
            System.out.println("You get 1 loyalty point(s)");
        } else if (lvl.equals("2")) {
            System.out.println("You get 2 loyalty point(s)");
        } else if (lvl.equals("3")) {
            System.out.println("You get 3 loyalty point(s)");
        } else {
            System.out.println(lvl + " is not a valid membership level");
        }
    }

    static Boolean checkItemInStock(String item, String[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(item)) {
                return true;
            }
        }
        return false;
    }

    static int isleNumber(String item, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(item)) {
                return i;
            }
        }
        return -1;
    }

    static Boolean checkAge(int ageEligible){
        if (ageEligible>=21){
           return true;
        } else{
            return false;
        }
    }



}
