/**
 * Class Name: Address.java
 * 
 * Description: Container to hold address information 
 *              (utilizing java records.)
 */

public record Address(
    String line1,
    String line2,
    String city,
    String state,
    String zip,
    String country) {
        @Override
        public String toString() {
            //Formats information into a string format.
            return "Shipping Address: " + 
            line1 + "\n" + 
            line2 + "\n" + 
            city + ", " + state + ", " + country +  " " + zip;
        }
    }
