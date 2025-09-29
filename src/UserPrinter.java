public class UserPrinter implements Formatter<User>{

  @Override
  public void printFormat(User curUser){
    System.out.println(curUser.getName() + " - Role: " + curUser.getSubscription());

    System.out.println();
  }
  
}
