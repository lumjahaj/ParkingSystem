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
public class NumriTargesValidator {
    private Pattern pattern;
    private Matcher matcher;
    
    private static final String nrTargesPattern ="[0-7]{2}\\-[0-9]{3}\\-[A-Z]{2}";
    
    public NumriTargesValidator(){
        pattern = Pattern.compile(nrTargesPattern);
    }
    
    public boolean validate(final String hex){
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }   
}