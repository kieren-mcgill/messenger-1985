
public class Post {
    String postText;
    String userName;

    @Override
    public String toString() {
        return postText;
    }

    public Post(String postText, String userName) {
        this.postText = postText;
        this.userName = userName;
    }

}
