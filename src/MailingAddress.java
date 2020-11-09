import java.lang.String;

public class MailingAddress {
    private String _PrimaryStreet;
    private String _SecondaryStreet;
    private String _City;
    private String _State;
    private String _Zip;

    public MailingAddress (String primaryStreet, String secondaryStreet, String city, String state, String postalCode){
        _PrimaryStreet = validatePrimaryStreet(primaryStreet);
        _SecondaryStreet = validateSecondaryStreet(secondaryStreet);
        _City = validateCity(city);
        _State = validateState(state);
        _Zip = validatePostalCode(postalCode);
    }

    public String validateState(String state){
        _State = state;

        int length = _State.length();
        if (length == 2){
            return _State;
        }
        switch (_State){
            case "Alabama":
                return "AL";
            case "Alaska":
                return "AK";
            case "Arizona":
                return "AZ";
            case "Arkansas":
                return "AR";
            case "California":
                return "CA";
            case "Colorado":
                return "CO";
            case "Connecticut":
                return "CT";
            case "Delaware":
                return "DE";
            case "Florida":
                return "FL";
            case "Georgia":
                return "GA";
            case "Hawaii":
                return "HI";
            case "Idaho":
                return "ID";
            case "Illinois":
                return "IL";
            case "Indiana":
                return "IN";
            case "Iowa":
                return "IA";
            case "Kansas":
                return "KS";
            case "Kentucky":
                return "KY";
            case "Louisiana":
                return "LA";
            case "Maine":
                return "ME";
            case "Maryland":
                return "MD";
            case "Massachusetts":
                return "MA";
            case "Michigan":
                return "MI";
            case "Minnesota":
                return "MN";
            case "Mississippi":
                return "MS";
            case "Missouri":
                return "MO";
            case "Montana":
                return "MT";
            case "Nebraska":
                return "NE";
            case"Nevada":
                return "NV";
            case "New Hampshire":
                return "NH";
            case "New Jersey":
                return "NJ";
            case "New Mexico":
                return "NM";
            case "New York":
                return "NY";
            case "North Carolina":
                return "NC";
            case "North Dakota":
                return "ND";
            case "Ohio":
                return "OH";
            case "Oklahoma":
                return "OK";
            case "Oregon":
                return "OR";
            case "Pennsylvania":
                return "PA";
            case "Rhode Island":
                return "RI";
            case "South Carolina":
                return "SC";
            case "South Dakota":
                return "SD";
            case "Tennessee":
                return "TN";
            case "Texas":
                return "TX";
            case "Utah":
                return "UT";
            case "Vermont":
                return "VT";
            case "Virginia":
                return "VA";
            case "Washington":
                return "WA";
            case "West Virginia":
                return "WV";
            case "Wisconsin":
                return "WI";
            case "Wyoming":
                return "WY";
            default:
                return null;
        }
    }
    public String validateCity(String city){
        _City = city;
        int length = _City.length();
        if(length < 0 || _City == null){
            return null;
        } else {
            return _City;
        }
    }
    public String validatePrimaryStreet(String street){
        _PrimaryStreet = street;
        if(_PrimaryStreet == null){
            return null;
        }

        int length = _PrimaryStreet.length();
        if(length < 0 || _PrimaryStreet == null){
            return null;
        } else {
            return _PrimaryStreet;
        }
    }
    public String validateSecondaryStreet(String street){
        _SecondaryStreet = street;
        if(_SecondaryStreet == null){
            return null;
        }

        int length = _SecondaryStreet.length();
        if(length < 0 || _SecondaryStreet == null){
            return null;
        } else {
            return _SecondaryStreet;
        }
    }
    public String validatePostalCode(String postalCode){
        _Zip = postalCode;
        int length = _Zip.length();
        if(length < 5){
            return null;
        } else if (length > 5){
            return null;
        } else {
            return _Zip;
        }
    }

    public String getFormattedAddress(){
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(_PrimaryStreet + " ");
        sbuffer.append(_SecondaryStreet + " ");
        sbuffer.append(_City + " ");
        sbuffer.append(_State + " ");
        sbuffer.append(_Zip);
        return sbuffer.toString();
    }
    public String getPrimaryStreet(){
        return _PrimaryStreet;
    }
    public String getSecondaryStreet(){
        return _SecondaryStreet;
    }
    public String getState(){
        return _State;
    }
    public String getCity(){
        return _City;
    }
    public String getPostalCode(){
        return _Zip;
    }


    public void setPrimaryStreet (String primaryStreet){
        _PrimaryStreet = validatePrimaryStreet(primaryStreet);
    }
    public void setSecondaryStreet(String secondaryStreet){
        _SecondaryStreet = validateSecondaryStreet(secondaryStreet);
    }
    public void setCity(String city){
        _City = validateCity(city);
    }
    public void setState(String state){
        _State = validateState(state);
    }
    public void setPostalCode(String postalCode){
        _Zip = validatePostalCode(postalCode);
    }

}
