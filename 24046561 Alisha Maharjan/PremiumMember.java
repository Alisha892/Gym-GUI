//class for premium member of gym
public class PremiumMember extends GymMember
{
    //attributes of permium member class
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    
    //constructor to initialize premium member fields
    public PremiumMember(int id,String name,String location,String phone,String email,String gender,String DOB,String membershipStartDate,String personalTrainer)
    {
        super(id,name,location,phone,email,gender,DOB,membershipStartDate);
        this.premiumCharge=50000;
        this.paidAmount=0;
        this.isFullPayment=false;
        this.discountAmount=0;
        this.personalTrainer=personalTrainer;
    }
    
    //corresponding accessor method of attributes of premium member class
    public double getPremiumCharge()
    {
        return premiumCharge;
    }
    public String getPersonalTrainer()
    {
        return personalTrainer;
    }
    public boolean isFullPayment()
    {
        return isFullPayment;
    }
    public double getPaidAmount()
    {
        return paidAmount;
    }
    public double getDiscountAmount()
    {
        return discountAmount;
    }
    
    //method to mark the attendance of premium class
    @Override
    public void markAttendance()
    {
        attendance++; //increament by 1 
        loyaltyPoints += 10; //increament by 10 points
    }
    
    //method to pay the due amount
    public String payDueAmount(double paidAmount)
    {
        if(this.isFullPayment==true)
        {
            return "Payment is already completed.";
        }
        this.paidAmount += paidAmount;
        if(this.paidAmount > premiumCharge)
        {
            //this.paidAmount -= paidAmount;
            return "Paid Amount exceeds premium charge. Payment unsuccessfull.";
        }
        if(this.paidAmount == premiumCharge)
        {
           isFullPayment = true;
           this.calculateDiscount(); // Automatically calculate discount on full payment
           return "Full payment completed. Payment successfull.Discount applied: " + this.discountAmount;
        }
        else
        {
            double remainingAmount = premiumCharge - this.paidAmount;
            return "Payment successfull. Remaining Amount: " + remainingAmount;
        }
    }
    
    //method to calculate discount amount 
    public void calculateDiscount()
    {
        if(isFullPayment==true)
        {
            discountAmount = 0.1 * premiumCharge;
            System.out.println("Discount : " + discountAmount);
        }
        else
        {
            discountAmount = 0;
            System.out.println("No discount is applied since you have not paid full amount.");
        }
    }
    
    //method to revert premium member details
    public void revertPremiumMember()
    {
        super.resetMember();
        personalTrainer=" " ;
        isFullPayment=false;
        paidAmount=0;
        discountAmount=0;
    }
    
    //method to display premium member details
    @Override
    public void display()
    {
         super.display(); //displays the common member details
         System.out.println("Premium charge : " + premiumCharge);
         System.out.println("Personal Trainer : " + personalTrainer);
         System.out.println("Is Full Payment : " + isFullPayment);
         System.out.println("Paid Amount : " + paidAmount);
         if(isFullPayment==true)
         {
             System.out.println("Discount Amount : " + discountAmount);
         }
    }
}
