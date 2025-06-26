//abstract class for gym member
public abstract class GymMember
{
    //protected access modifier for the attributes
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
    //constructor to initialize Gym member fields
    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate)
    {
        this.id=id;
        this.name=name;
        this.location=location;
        this.phone=phone;
        this.email=email;
        this.gender=gender;
        this.DOB=DOB;
        this.membershipStartDate=membershipStartDate;
        this.attendance=0;
        this.loyaltyPoints=0;
        this.activeStatus=false;
    }
    //corresponding accessor methods
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getLocation()
    {
        return location;
    }
    public String getPhone()
    {
        return phone;
    }
    public String getEmail()
    {
        return email;
    }
    public String getDOB()
    {
        return DOB;
    }
    public String MembershipStartDate()
    {
        return membershipStartDate;
    }
    public int getAttendance()
    {
        return attendance;
    }
    public double getLoyaltyPoints()
    {
        return loyaltyPoints;
    }
    public boolean getActiveStatus()
    {
        return activeStatus;
    }
    
    //an abstract method markAttendance to track the attendance of gym member
    public abstract void markAttendance();
    //method to track active status of the member
    public void activeMembership()
    {
        this.activeStatus=true;
    }
    public void deactivateMembership()
    {
        if(activeStatus)
        {
            this.activeStatus = false;
        }
        else
        {
            System.out.println("The membership is already inactive");
        }
    }
    //method to set 
    public void resetMember()
    {
        this.activeStatus=false;
        this.attendance=0;
        this.loyaltyPoints=0;
    }
    //method to display the output
    public void display()
    {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("DOB: " + DOB);
        System.out.println("Memebership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + activeStatus);
    }
}