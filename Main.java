import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static ArrayList<Post> postStore = new ArrayList<>();
    public static String userName;
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Messenger - 1985");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            login();
    }

    public static void login() {
        System.out.println("Please enter your username:");
        userName = input.nextLine();
        menu();
    }

    public static void newPost() {
        System.out.println("What would you like to say?:");
        String postText = input.nextLine();
        Post newPost = new Post(postText, userName);
        postStore.add(newPost);
    }

    public static void showPosts() {
        int i;
        for (i = postStore.size() -1; i >= 0; i--) {
            String postInfo = "Post id: " + i + " User: " + postStore.get(i).userName;
            System.out.println(postInfo);
            System.out.println(postStore.get(i));
            System.out.println(" ");
            System.out.println("----------------------------------------------------------------");
        }
        menu();
    }

    public static void deletePost() {
        int postId;
        System.out.println("Which post do you want to delete? Enter the post's ID number:");
        postId = input.nextInt();
        if (postId < 0 || postId > postStore.size() -1) {

            //delete

            menu();
        } else {
            System.out.println("Please enter a valid ID number");
            menu();
        }
    }

    public static void menu() {
        System.out.println("MENU: (Please choose and type: POST  |  DELETE  |  LOGOUT  |  QUIT");
        Menu menuChoice = Menu.valueOf(input.nextLine());
        try {
            if (menuChoice == Menu.POST) {
                newPost();
                showPosts();
            } else if (menuChoice == Menu.LOGOUT) {
                login();
            } else if (menuChoice == Menu.QUIT) {
                System.out.println("Goodbye!");
            } else {
                throw new InvalidMenuOptionException();
            }
        } catch (InvalidMenuOptionException e) {
            System.out.println("Please enter a valid menu option");
            menu();
        }
    }
}
