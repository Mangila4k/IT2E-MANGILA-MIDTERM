package feedback;

import java.util.Scanner;

public class Feedback {
    public void addFeeback() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("\nID: ");
        int id = sc.nextInt();
        
        System.out.print("Feedback: ");
        String feedback = sc.next();
        System.out.print("Feedback Ratings (1-5): ");
        String rating = sc.next();
        System.out.print("Status: ");
        String status = sc.next();

        String sql = "INSERT INTO Feedbacks (f_id, f_feedback, f_ratings, f_status) VALUES (?, ?, ?, ?)";

        conf.addRecord(sql, id, feedback, rating, status);
    }

    private void viewFeedback() {
        config conf = new config();
        String Feedbackqr = "SELECT * FROM Feedbacks";
        String[] FeedbackHeaders = {"ID", "Feedback", "Rating", "Status"};
        String[] FeedbackColumns = {"f_id", "f_feedback", "f_ratings", "f_status"};

        // Corrected to pass FeedbackColumns instead of FeedbackHeaders
        conf.viewRecords(Feedbackqr, FeedbackHeaders, FeedbackColumns);
    }

    public void updateFeedback() {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter ID to Update: ");
        int fid = s.nextInt();
        
        System.out.print("Feedback: ");
        String f_feedback = s.next();
        
        System.out.print("Ratings (1-5): ");
        String f_rating = s.next();
        
        String qry = "UPDATE Feedbacks SET f_feedback = ?, f_ratings = ? WHERE f_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, f_feedback, f_rating, fid);
    }

    public void deleteCitizen() {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter ID to Delete: ");
        int fid = s.nextInt();
        
        String qry = "DELETE FROM Feedbacks WHERE f_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, fid);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String response;

        do {
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("\nEnter action: ");
            int action = sc.nextInt();
            sc.nextLine();
            
            Feedback fb = new Feedback();

            switch(action) {
                case 1:
                    fb.addFeeback();
                    break;

                case 2:
                    fb.viewFeedback();
                    break;

                case 3:
                    fb.viewFeedback();
                    fb.updateFeedback();
                    break;

                case 4:
                    fb.viewFeedback();
                    fb.deleteCitizen();
                    fb.viewFeedback();
                    break;

                case 5:
                    System.out.println("Exiting....");
                    break;

                default:
                    System.out.println("Invalid Action!");
            }

            System.out.print("Want to add another transaction? (yes/no): ");
            response = sc.nextLine();

        } while (response.equalsIgnoreCase("yes"));

        sc.close();
    }
}
