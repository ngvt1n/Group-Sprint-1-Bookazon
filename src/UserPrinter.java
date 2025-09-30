/*
 * Class Name: UserPrinter
 * 
 * Class Description: This class implements the Printer interface. It will be used to format the details for the User that can later be used by the user to view the details. It contains one method: printFormat. 
 */

public class UserPrinter implements Printer<User>{

  @Override
  public void printFormat(User curUser){
    System.out.println(curUser.getName() + " - Role: " + curUser.getSubscription());

    System.out.println();
  }
  
}