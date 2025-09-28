/**
 * Class Name: Address.java
 * 
 * Purpose: Encapsulates address information for users and orders, including 
 *          formatting for display on shipping labels.
 *
 * Description: This class stores common address fields such as line1, line2, 
 *              city, state, zip code, and country. It provides getters and 
 *              setters for each field and includes a utility method to 
 *              format the address for label printing.
 *
 * Author: Robbie Bennett
 * Date Created: 09/27/2025
 * Last Modified: 09/28/2025
 *
 */

public class Address {
    //Declare variables.

    private final String line1;
    private final String line2;
    private final String city;
    private final String state;
    private final String zip;
    private final String country;

    public Address(String line1, String line2, String city, String state, String zip, String country) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public String getLine1() { 
        //Geter method for first address.
        return line1; 
    }

    public String getLine2() { 
        //Getter method for second address.
        return line2; 
    }
    
    public String getCity() { 
        //Getter method for city
        return city; 
    }

    public String getState() { 
        //Getter method for state
        return state; 
    }

    public String getZip() { 
        //Getter method for Zip.
        return zip; 
    }

    public String getCountry() { 
        //Getter method for country. 
        return country; 
    }

    public String formatForLabel() {
        //Formats the address fields into a single line for a mailing label.

        StringBuilder stringBuilder = new StringBuilder();

        // Add the first line of the address
        stringBuilder.append(line1);

        // Add the second line (if applicable.)
        if (line2 != null && !line2.isEmpty()) {
            stringBuilder.append(" ").append(line2);
        }

        // Add city, state, and ZIP code
        stringBuilder.append(", ")
        .append(city)
        .append(", ")
        .append(state)
        .append(" ")
        .append(zip);

        // Add country at the end
        stringBuilder.append(", ").append(country);

        return stringBuilder.toString();
    }
}