/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(String el) {
        super("The element " + el + "was not found in the collection.");
    }
    
}
