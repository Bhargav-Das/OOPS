public class Club {
    private static String clubName;
    private String memberName;

    public Club(String memberName) {
        this.memberName = memberName;
    }

    public static void setClubName(String name) {
        clubName = name;
    }

    public static void displayClubName() {
        System.out.println("Club Name: " + clubName);
    }

    public void displayMemberInfo() {
        System.out.println("Member Name: " + memberName + ", Club Name: " + clubName);
    }

    public static void main(String[] args) {
        Club.setClubName("Chess Club");

        Club member1 = new Club("Alice");
        Club member2 = new Club("Bob");
        Club member3 = new Club("Charlie");

        Club.displayClubName();
        member1.displayMemberInfo();
        member2.displayMemberInfo();
        member3.displayMemberInfo();
    }
}
