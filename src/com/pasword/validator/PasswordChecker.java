package com.pasword.validator;

public class PasswordChecker {
    public boolean isValidPassword(String password){
        boolean valid=false;
        int count=0;
        boolean passLowerCase=false;
        if(null!=password&!password.isEmpty()){
            count++;
            if(password.length()>=8){
                count++;
            }
            String upperCases = "(.*[A-Z].*)";
            if (password.matches(upperCases))
            {
              count++;
            }
            String lowerCase = "(.*[a-z].*)";
            if (password.matches(lowerCase))
            {
                count++;
                passLowerCase=true;
            }
            String numbers = "(.*[0-9].*)";
            if (password.matches(numbers))
            {
                count++;
            }
        }else{
            System.out.println("Password must not be empty");
        }
        if(count>=3 && passLowerCase){
            valid=true;
        }else{
            if(!passLowerCase){
                System.out.println("Password must have atleast one lowercase character");
            }
            System.out.println("Password must have atleast one uppercase character or Password must be more than 8 characters in length or Password must have atleast one number");
        }

         return valid;
    }
}
