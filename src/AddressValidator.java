/**
 * Class Name: AddressValidator.java (Solo Extension.)
 * 
 * Purpose: Validates address information for users and orders.
 *
 * Description: This class ensures that addresses are not empty and that
 *              the ZIP code matches a valid US format (5-digit or 5+4).
 *
 * Author: Robbie Bennett 
 * Date Created: 09/28/2025
 * Last Modified: 09/28/2025
 *
 */

public class AddressValidator {

    public static void validate(Address address) {
        //Checks that address details are valid.
        if (address.line1() == null || address.line1().isBlank()) {
            throw new IllegalArgumentException("Address line1 cannot be empty.");
        }
        if (address.city() == null || address.city().isBlank()) {
            throw new IllegalArgumentException("City cannot be empty.");
        }
        if (address.state() == null || address.state().isBlank()) {
            throw new IllegalArgumentException("State cannot be empty.");
        }
        if (address.zip() == null || address.zip().isBlank()) {
            throw new IllegalArgumentException("ZIP code cannot be empty.");
        }
        if (!address.zip().matches("\\d{5}(-\\d{4})?")) {
            throw new IllegalArgumentException("ZIP code must be in 5-digit or 5+4 format.");
        }
        if (address.country() == null || address.country().isBlank()) {
            throw new IllegalArgumentException("Country cannot be empty.");
        }
    }

    public static boolean isValid(Address address) {
        //Returns true or false if the code is valid. 
        try {
            validate(address);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}