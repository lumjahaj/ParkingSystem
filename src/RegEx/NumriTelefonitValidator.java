/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lumi
 */
public class NumriTelefonitValidator {
    private Pattern pattern;
    private Matcher matcher;
    
    private static final String nrTelefonitPattern ="(\\+(38649|37744|37745)[0-9]{6})";
    
    public NumriTelefonitValidator(){
        pattern = Pattern.compile(nrTelefonitPattern);
    }
    
    public boolean validate(final String hex){
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }   
}