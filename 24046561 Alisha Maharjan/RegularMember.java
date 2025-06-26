//class to track the regular memeber of gym
public class RegularMember extends GymMember
{
    //private attributes of regular member class
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    
    //constrcutor to intialize the regular member fields
    public RegularMember(int id,String name,String location,String phone,String email,String gender,String DOB,String membershipStartDate,String referralSource)
    {
        super(id,name,location,phone,email,gender,DOB,membershipStartDate);
        this.isEligibleForUpgrade=false;
        this.attendanceLimit=30;
        this.plan="basic";
        this.price=6500;
        this.removalReason=" ";
        this.referralSource=referralSource;
    }
    
    //corresponding accessor method of attributes of regular member class
    public int getAttendanceLimit()
    {
        return attendanceLimit;
    }
    public boolean isEligibleForUpgrade()
    {
        return isEligibleForUpgrade;
    }
    public String getPlan()
    {
        return plan;
    }
    public double getPrice()
    {
        return price;
    }
    public String getRemovalReason()
    {
        return removalReason;
    }
    public String getReferralSource()
    {
        return referralSource;
    }
    
    //method to mark the attendance of regular class
    @Override
    public void markAttendance()
    {
        attendance++; //increament in attendance by 1 
        loyaltyPoints += 5; //increament in loyalty point by 5 points
    }
    
    //method to get plan price based on plan type
    public double getPlanPrice(String plan)
    {
        switch(plan)
        {
            case "Basic":
                return 6500;
            case "Standard":
                return 12500;
            case "Deluxe":
                return 18500;
            default:
                return -1;
        }
    }
    
    //method to upgrade the plan subscribed by member
        public String upgradePlan(String newPlan) 
        {
        // Check if member is active
        if (!getActiveStatus()) 
        {
            return "Cannot upgrade - membership is inactive!";
        }
        
        // Check attendance requirement
        if (attendance < attendanceLimit) 
        {
            return String.format("Need %d more attendances to upgrade", 
                               attendanceLimit - attendance);
        }
        
        // Check if already on this plan
        if (newPlan.equalsIgnoreCase(plan)) 
        {
            return "Already subscribed to " + plan + " plan";
        }
        
        // Validate and set new plan
        switch(newPlan.toLowerCase()) 
        {
            case "standard":
                this.plan = "Standard";
                this.price = 12500;
                isEligibleForUpgrade = false; // Reset eligibility
                return "Upgraded to Standard plan (Rs. 12,500/month)";
                
            case "deluxe":
                this.plan = "Deluxe";
                this.price = 18500;
                isEligibleForUpgrade = false; // Reset eligibility
                return "Upgraded to Deluxe plan (Rs. 18,500/month)";
                
            case "basic":
                return "Cannot downgrade to Basic plan";
                
            default:
                return "Invalid plan selection!";
        }
    }
    
    //method to revert regular member details
    public void revertRegularMember(String removalReason)
    {
        super.resetMember();
        this.isEligibleForUpgrade=false;
        this.plan="basic";
        this.price=6500;
        this.removalReason=removalReason;
    }
    
    //method to display regular memeber details
    @Override
    public void display()
    {
        super.display(); //displays all the common member details
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if(!removalReason.isEmpty())
        {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}