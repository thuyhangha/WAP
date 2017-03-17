package edu.mum.cs472;

/**
 *
 * @author SOKLY
 */
public class RadioState {
    private String yesCheck = "checked";
    private String noCheck = "";
    public RadioState(String yesCheck, String noCheck){
        this.yesCheck = yesCheck;
        this.noCheck = noCheck;
    }
    
    public String getYesCheck(){
        return yesCheck;
    }
    public String getNoCheck(){
        return noCheck;
    }
}
