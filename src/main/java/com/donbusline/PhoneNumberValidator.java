package com.donbusline;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class PhoneNumberValidator {

    public  boolean validePhoneNumber (String number) throws NumberParseException, InvalidPhoneNumberException{
        boolean isValid = false;
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

            Phonenumber.PhoneNumber NumberProto  = phoneUtil.parse(number, "UA");
            isValid  = phoneUtil.isValidNumber(NumberProto);
        if(!isValid){
            throw new InvalidPhoneNumberException();
        }
        return isValid;
    }
    class InvalidPhoneNumberException extends Exception{}
}