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

public record Address(
    String line1,
    String line2,
    String city,
    String state,
    String zip,
    String country
) {}
