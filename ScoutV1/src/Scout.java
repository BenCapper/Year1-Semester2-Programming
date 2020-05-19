     /**
     *This Class creates an instance of a scout with user input information
     *and assigns the scout to a division. A division must exist to create a scout.
      * includes getters and setters to edit information from other classes.
     *@author Ben Capper
     */
public class Scout {
     /**
     *These fields are used to create a scout object and are assigned values by the user.
     */
    private String firstName, Surname, address, gender;
    private int dayOfBirth, monthOfBirth, yearOfBirth;
    private Division division;

     /**
     *This constructor method constructs a Scout object and includes validation to ensure user adheres to Scout creation standards.
      * @param FirstName, Surname, address, dayOfBirth, monthOfBirth, yearOfBirth, gender, division.
     */
    public Scout(String FirstName, String Surname, String address, int dayOfBirth,
                 int monthOfBirth, int yearOfBirth, String gender, Division division){

        this.firstName = FirstName;
        if (this.firstName.length() > 40) {
            this.firstName = "invalid";
        }
        this.Surname = Surname;
        if (this.Surname.length() > 40) {
            this.Surname = "invalid";
        }
        this.address = address;
        if (this.address.length() > 60){
            this.address = "invalid";
        }
        this.dayOfBirth = dayOfBirth;
        if  (this.dayOfBirth < 1 || this.dayOfBirth > 31){
            this.dayOfBirth = 0;
        }
        this.monthOfBirth = monthOfBirth;
        if (this.monthOfBirth < 1 || this.monthOfBirth > 12){
            this.monthOfBirth = 0;
        }
        this.yearOfBirth = yearOfBirth;
        if (this.yearOfBirth < 1990 || this.yearOfBirth > 2020) {
            this.yearOfBirth = yearOfBirth;
        }
        this.gender = gender;
        if(!this.gender.contains("UNSPECIFIED")&&!this.gender.contains("unspecified")&&!this.gender.contains("m")
                &&!this.gender.contains("M")&&!this.gender.contains("f")&&!this.gender.contains("F")){
            this.gender = "invalid";
        }
        this.division = division;
    }

    /**
     * Returns scout first name.
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

         /**
          * Sets scout first name.
          * @param firstName
          */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

         /**
          * Returns scout surname.
          * @return Surname
          */
    public String getSurname() {
        return Surname;
    }

         /**
          * Sets scout surname.
          * @param surname
          */
    public void setSurname(String surname) {
       this.Surname = surname;
    }

         /**
          * Returns scout's address.
          * @return address.
          */
    public String getAddress() {
        return address;
    }

         /**
          * Sets scout address.
          * @param address
          */
    public void setAddress(String address) {
        this.address = address;
    }

         /**
          * Returns scout gender.
          * @return address.
          */
    public String getGender() {
        return gender;
    }

         /**
          * Sets scout first name.
          * @param gender
          */
    public void setGender(String gender) {
        this.gender = gender;
    }

         /**
          * Returns scout day of birth.
          * @return dayOfBirth.
          */
    public int getDayOfBirth() {
        return dayOfBirth;
    }

         /**
          * Sets scout day of birth.
          * @param dayOfBirth
          */
    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

         /**
          * Returns scout month of birth.
          * @return monthOfBirth.
          */
    public int getMonthOfBirth() {
        return monthOfBirth;
    }

         /**
          * Sets scout month of birth.
          * @param monthOfBirth
          */
    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

         /**
          * Returns scout's year of birth.
          * @return yearOfBirth.
          */
    public int getYearOfBirth() {
        return yearOfBirth;
    }

         /**
          * Sets scout's year of birth.
          * @param yearOfBirth
          */
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

         /**
          * Returns scout's division.
          * @return division.
          */
    public Division getDivision() {
        return division;
    }

         /**
          * Sets scout first name.
          * @param division
          */
    public void setDivision(Division division) {
        this.division = division;
    }

         /**
          * Returns scout's toString.
          * @return Scout toString.
          */
    public String toString() {
        return "First Name = " + firstName +
                " | Surname = " + Surname +
                " | Address = " + address +
                " | Gender = " + gender  +
                " | Day Of Birth = " + dayOfBirth +
                " | Month Of Birth = " + monthOfBirth +
                " | YearOfBirth = " + yearOfBirth +
                " | Division ==> " + division;
    }
}
