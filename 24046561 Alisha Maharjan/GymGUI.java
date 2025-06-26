import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;
import javax.swing.border.Border;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;

public class GymGUI
{
    private JFrame frame;
    private JPanel panel,buttonPanel;
    private JLabel titleLabel,nameLabel,phoneLabel,genderLabel,dobLabel,addressLabel;
    private JTextField nameField,phoneField;
    private JRadioButton maleButton,femaleButton;
    private JComboBox<String> daysCombo,monthsCombo,yearCombo;
    private JTextArea addressField;
    private JCheckBox termCheckBox;
    private JButton submitButton,resetButton;
    
    public static void main(String[] args)
    {
        //creating an array list to store object pf type regular member and premium member
        ArrayList<GymMember>members=new ArrayList<GymMember>();
        ArrayList<RegularMember>regularMembers=new ArrayList<RegularMember>();
        ArrayList<PremiumMember>premiumMembers=new ArrayList<PremiumMember>();
        
        //creating JFrame
        JFrame frame=new JFrame("Gym Membership");
        frame.setSize(1500,1500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        // Regular Member Panel
        JPanel regularPanel = new JPanel();
        regularPanel.setBounds(20, 20, 650, 370);
        regularPanel.setLayout(null);
        regularPanel.setBorder(BorderFactory.createTitledBorder("Add a Regular Member"));
        frame.add(regularPanel);

        // Regular Member Fields
        // Name
        JLabel regularNameLabel = new JLabel("Name:");
        regularNameLabel.setBounds(20, 30, 100, 25);
        regularPanel.add(regularNameLabel);

        JTextField regularNameField = new JTextField();
        regularNameField.setBounds(120, 30, 200, 25);
        regularPanel.add(regularNameField);
        
        // ID
        JLabel regularIdLabel = new JLabel("ID:");
        regularIdLabel.setBounds(340, 30, 100, 25);
        regularPanel.add(regularIdLabel);

        JTextField regularIdField = new JTextField();
        regularIdField.setBounds(440, 30, 200, 25);
        regularPanel.add(regularIdField);

        // Location
        JLabel regularLocationLabel = new JLabel("Location:");
        regularLocationLabel.setBounds(20, 70, 100, 25);
        regularPanel.add(regularLocationLabel);

        JTextField regularLocationField = new JTextField();
        regularLocationField.setBounds(120, 70, 200, 25);
        regularPanel.add(regularLocationField);

        // Mobile
        JLabel regularMobileLabel = new JLabel("Mobile:");
        regularMobileLabel.setBounds(340, 70, 100, 25);
        regularPanel.add(regularMobileLabel);

        JTextField regularMobileField = new JTextField();
        regularMobileField.setBounds(440, 70, 200, 25);
        regularPanel.add(regularMobileField);

        // Email
        JLabel regularEmailLabel = new JLabel("Email:");
        regularEmailLabel.setBounds(20, 110, 100, 25);
        regularPanel.add(regularEmailLabel);

        JTextField regularEmailField = new JTextField();
        regularEmailField.setBounds(120, 110, 200, 25);
        regularPanel.add(regularEmailField);

        // DOB
        JLabel regularDobLabel = new JLabel("DOB:");
        regularDobLabel.setBounds(20, 150, 100, 25);
        String[] days={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","31"};
        String[] months={"Jan","Feb","Mar","Apr","May","Jun","Jul", "Aug", "Sep","Oct","Nov","Dec"};
        String[] year={"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};
        
        JComboBox<String> dayCombo = new JComboBox<>(days);
        dayCombo.setBounds(120, 150, 60, 25);
        regularPanel.add(dayCombo);

        JComboBox<String> monthCombo = new JComboBox<>(months);
        monthCombo.setBounds(190, 150, 60, 25);
        regularPanel.add(monthCombo);

        JComboBox<String> yearCombo = new JComboBox<>(year);
        yearCombo.setBounds(260, 150, 80, 25);
        regularPanel.add(yearCombo);
        regularPanel.add(regularDobLabel);

        // Gender
        JLabel regularGenderLabel = new JLabel("Gender:");
        regularGenderLabel.setBounds(340, 110, 100, 25);
        regularPanel.add(regularGenderLabel);

        JRadioButton regularFemaleButton = new JRadioButton("Female");
        regularFemaleButton.setBounds(440, 110, 70, 25);
        regularPanel.add(regularFemaleButton);

        JRadioButton regularMaleButton = new JRadioButton("Male");
        regularMaleButton.setBounds(520, 110, 60, 25);
        regularPanel.add(regularMaleButton);

        JRadioButton regularOtherButton = new JRadioButton("Other");
        regularOtherButton.setBounds(590, 110, 140, 25);
        regularPanel.add(regularOtherButton);

        ButtonGroup regularGenderGroup = new ButtonGroup();
        regularGenderGroup.add(regularFemaleButton);
        regularGenderGroup.add(regularMaleButton);
        regularGenderGroup.add(regularOtherButton);

        // Membership Start Date
        JLabel regularStartDateLabel = new JLabel("Membership Start Date:");
        regularStartDateLabel.setBounds(20, 190, 200, 25);
        regularPanel.add(regularStartDateLabel);
    
        String[] startDays={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","31"};
        String[] startMonths={"Jan","Feb","Mar","Apr","May","Jun","Jul", "Aug", "Sep","Oct","Nov","Dec"};
        String[] startYear={"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};
        
        JComboBox<String> regularStartDayCombo = new JComboBox<>(days);
        regularStartDayCombo.setBounds(190, 200, 60, 25);
        regularPanel.add(regularStartDayCombo);

        JComboBox<String> regularStartMonthCombo = new JComboBox<>(months);
        regularStartMonthCombo.setBounds(260, 200, 60, 25);
        regularPanel.add(regularStartMonthCombo);

        JComboBox<String> regularStartYearCombo = new JComboBox<>(year);
        regularStartYearCombo.setBounds(330, 200, 80, 25);
        regularPanel.add(regularStartYearCombo);

        // Referral Source
        JLabel referralLabel = new JLabel("Referral Source:");
        referralLabel.setBounds(20, 230, 200, 25);
        regularPanel.add(referralLabel);

        JTextField referralField = new JTextField();
        referralField.setBounds(220, 230, 200, 25);
        regularPanel.add(referralField);

        // Add Regular Member Button
        JButton addRegularButton = new JButton("Add a Regular Member");
        addRegularButton.setBounds(220, 280, 200, 30);
        regularPanel.add(addRegularButton);
        
        // Add Regular Member ActionListener
        addRegularButton.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent e) 
        {            
            String id=regularIdField.getText();
            String name=regularNameField.getText();
            String location=regularLocationField.getText();
            String mobile=regularMobileField.getText();
            String email=regularEmailField.getText();
            String referralSource=referralField.getText();
            
            //Get selected gender
             String gender = "";
            if (regularMaleButton.isSelected()) {
                gender = "Male";
            } else if (regularFemaleButton.isSelected()) {
                gender = "Female";
            } else if (regularOtherButton.isSelected()) {
                gender = "Other";
            }
                
            String dob=dayCombo.getSelectedItem() + "-" + monthCombo.getSelectedItem() + "-" + yearCombo.getSelectedItem();
            String startDate = regularStartDayCombo.getSelectedItem() + "-" + regularStartMonthCombo.getSelectedItem() + "-" + regularStartYearCombo.getSelectedItem();
            
            //Validation
            if (regularIdField.getText().isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "The ID field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (regularNameField.getText().isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "The Name field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (regularLocationField.getText().isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "The Location field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (regularMobileField.getText().isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "The Mobile field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (regularEmailField.getText().isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "The Email field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (referralField.getText().isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "The Referral field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int Id;
            try {
                Id = Integer.parseInt(regularIdField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric ID.");
                return;
            }
            
            if (!isIdUnique(Id))
            {
                JOptionPane.showMessageDialog(frame,"Member ID already exists.");
                return;
            }
            
        
            RegularMember member = new RegularMember(Id,name,location,mobile,email,gender,dob,startDate,referralSource);
            members.add(member);
            JOptionPane.showMessageDialog(frame,"Regular member is added succesfully.");
            
            //Clear Inputs
            regularIdField.setText("");
            regularNameField.setText("");
            regularLocationField.setText("");
            regularMobileField.setText("");
            regularEmailField.setText("");
            referralField.setText("");
            regularGenderGroup.clearSelection();
            yearCombo.setSelectedIndex(0);
            monthCombo.setSelectedIndex(0);
            dayCombo.setSelectedIndex(0);
            regularStartDayCombo.setSelectedIndex(0);
            regularStartMonthCombo.setSelectedIndex(0);
            regularStartYearCombo.setSelectedIndex(0);
        }
        
        public boolean isIdUnique(int id)
        {
              for (GymMember member : members)
                 {
                     if(member.getId() == id)
                     {
                         return false;
                     }
                 }
                return true;
        }

        });        
        
        // Premium Member Panel
        JPanel premiumPanel = new JPanel();
        premiumPanel.setBounds(20, 400, 650, 420);
        premiumPanel.setLayout(null);
        premiumPanel.setBorder(BorderFactory.createTitledBorder("Add a Premium Member"));
        frame.add(premiumPanel);

        // Premium Member Fields
        // ID
        JLabel premiumIdLabel = new JLabel("ID:");
        premiumIdLabel.setBounds(20, 30, 100, 25);
        premiumPanel.add(premiumIdLabel);

        JTextField premiumIdField = new JTextField();
        premiumIdField.setBounds(120, 30, 200, 25);
        premiumPanel.add(premiumIdField);

        // Name
        JLabel premiumNameLabel = new JLabel("Name:");
        premiumNameLabel.setBounds(340, 30, 100, 25);
        premiumPanel.add(premiumNameLabel);

        JTextField premiumNameField = new JTextField();
        premiumNameField.setBounds(440, 30, 200, 25);
        premiumPanel.add(premiumNameField);

        // Location
        JLabel premiumLocationLabel = new JLabel("Location:");
        premiumLocationLabel.setBounds(20, 70, 100, 25);
        premiumPanel.add(premiumLocationLabel);

        JTextField premiumLocationField = new JTextField();
        premiumLocationField.setBounds(120, 70, 200, 25);
        premiumPanel.add(premiumLocationField);

        // Phone
        JLabel premiumPhoneLabel = new JLabel("Phone:");
        premiumPhoneLabel.setBounds(340, 70, 100, 25);
        premiumPanel.add(premiumPhoneLabel);

        JTextField premiumPhoneField = new JTextField();
        premiumPhoneField.setBounds(440, 70, 200, 25);
        premiumPanel.add(premiumPhoneField);

        // Email
        JLabel premiumEmailLabel = new JLabel("Email:");
        premiumEmailLabel.setBounds(20, 110, 100, 25);
        premiumPanel.add(premiumEmailLabel);

        JTextField premiumEmailField = new JTextField();
        premiumEmailField.setBounds(120, 110, 200, 25);
        premiumPanel.add(premiumEmailField);

        // DOB
        JLabel premiumDobLabel = new JLabel("DOB:");
        premiumDobLabel.setBounds(20, 150, 100, 25);
        premiumPanel.add(premiumDobLabel);

        String[] day={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String[] month={"Jan","Feb","Mar","Apr","May","Jun","Jul", "Aug", "Sep","Oct","Nov","Dec"};
        String[] years={"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};
        
        JComboBox<String> premiumDayCombo = new JComboBox<>(day);
        premiumDayCombo.setBounds(120, 150, 60, 25);
        premiumPanel.add(premiumDayCombo);

        JComboBox<String> premiumMonthCombo = new JComboBox<>(month);
        premiumMonthCombo.setBounds(190, 150, 60, 25);
        premiumPanel.add(premiumMonthCombo);

        JComboBox<String> premiumYearCombo = new JComboBox<>(year);
        premiumYearCombo.setBounds(260, 150, 80, 25);
        premiumPanel.add(premiumYearCombo);
        premiumPanel.add(premiumDobLabel);

        // Gender
        JLabel premiumGenderLabel = new JLabel("Gender:");
        premiumGenderLabel.setBounds(340, 110, 100, 25);
        premiumPanel.add(premiumGenderLabel);

        JRadioButton premiumFemaleButton = new JRadioButton("Female");
        premiumFemaleButton.setBounds(440, 110, 70, 25);
        premiumPanel.add(premiumFemaleButton);

        JRadioButton premiumMaleButton = new JRadioButton("Male");
        premiumMaleButton.setBounds(520, 110, 60, 25);
        premiumPanel.add(premiumMaleButton);

        JRadioButton premiumOtherButton = new JRadioButton("Other");
        premiumOtherButton.setBounds(590, 110, 140, 25);
        premiumPanel.add(premiumOtherButton);

        ButtonGroup premiumGenderGroup = new ButtonGroup();
        premiumGenderGroup.add(premiumFemaleButton);
        premiumGenderGroup.add(premiumMaleButton);
        premiumGenderGroup.add(premiumOtherButton);

        // Membership Start Date
        JLabel premiumStartDateLabel = new JLabel("Membership Start Date:");
        premiumStartDateLabel.setBounds(20, 190, 200, 25);
        premiumPanel.add(premiumStartDateLabel);
        
        String[] startDay={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String[] startMonth={"Jan","Feb","Mar","Apr","May","Jun","Jul", "Aug", "Sep","Oct","Nov","Dec"};
        String[] startYears={"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};
        
        JComboBox<String> premiumStartDayCombo = new JComboBox<>(days);
        premiumStartDayCombo.setBounds(190, 200, 60, 25);
        premiumPanel.add(premiumStartDayCombo);

        JComboBox<String> premiumStartMonthCombo = new JComboBox<>(months);
        premiumStartMonthCombo.setBounds(260, 200, 60, 25);
        premiumPanel.add(premiumStartMonthCombo);

        JComboBox<String> premiumStartYearCombo = new JComboBox<>(year);
        premiumStartYearCombo.setBounds(330, 200, 80, 25);
        premiumPanel.add(premiumStartYearCombo);
        
        // Personal Trainer
        JLabel trainerLabel = new JLabel("Personal Trainer:");
        trainerLabel.setBounds(20, 230, 200, 25);
        premiumPanel.add(trainerLabel);

        JTextField trainerField = new JTextField();
        trainerField.setBounds(220, 230, 200, 25);
        premiumPanel.add(trainerField);

        // Add Premium Member Button
        JButton addPremiumButton = new JButton("Add a Premium Member");
        addPremiumButton.setBounds(220, 280, 200, 30);
        premiumPanel.add(addPremiumButton);
        
        //Action listeners to premium member class
        addPremiumButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String name = premiumNameField.getText();
                String id = premiumIdField.getText();
                String location = premiumLocationField.getText();
                String phone = premiumPhoneField.getText();
                String email = premiumEmailField.getText();
                String trainer = trainerField.getText();
                
                //Get selected gender
                String gender = "";
                if (regularMaleButton.isSelected()) 
                {
                    gender = "Male";
                } 
                else if (regularFemaleButton.isSelected()) 
                {
                    gender = "Female";
                } 
                else if (regularOtherButton.isSelected()) 
                {
                    gender = "Other";
                }
                
                String dob = premiumDayCombo.getSelectedItem() + "-" + premiumMonthCombo.getSelectedItem() + "-" + premiumYearCombo.getSelectedItem();
                String startDate = regularStartDayCombo.getSelectedItem() + "-" + regularStartMonthCombo.getSelectedItem() + "-" + regularStartYearCombo.getSelectedItem();
                
                //Validation
                if (premiumIdField.getText().isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "The ID field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (premiumNameField.getText().isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "The Name field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (premiumLocationField.getText().isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "The Location field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (premiumPhoneField.getText().isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "The Mobile field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (premiumEmailField.getText().isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "The Email field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (trainerField.getText().isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "The Trainer field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                int Id;
                try 
                {
                    Id = Integer.parseInt(premiumIdField.getText());
                } 
                catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid numeric ID.");
                    return;
                }
                
                if (!isIdUnique(Id))
                {
                    JOptionPane.showMessageDialog(frame,"Member ID already exists.");
                    return;
                }
                
                PremiumMember member = new PremiumMember(Id,name,location,phone,email,gender,dob,startDate,trainer);
                members.add(member);
                JOptionPane.showMessageDialog(frame,"Premium member is added succesfully.");
                
                //Clear Inputs
                premiumIdField.setText("");
                premiumNameField.setText("");
                premiumLocationField.setText("");
                premiumPhoneField.setText("");
                premiumEmailField.setText("");
                trainerField.setText("");
                premiumGenderGroup.clearSelection();
                premiumYearCombo.setSelectedIndex(0);
                premiumMonthCombo.setSelectedIndex(0);
                premiumDayCombo.setSelectedIndex(0);
                premiumStartDayCombo.setSelectedIndex(0);
                premiumStartMonthCombo.setSelectedIndex(0);
                premiumStartYearCombo.setSelectedIndex(0);
            }
            
            public boolean isIdUnique(int id)
            {
                  for (GymMember member : members)
                    {
                         if(member.getId() == id)
                         {
                             return false;
                         }
                     }
                     return true;
            }

        });
        
        // Panel for Activate Membership
        JPanel activatePanel = new JPanel();
        activatePanel.setLayout(null);
        activatePanel.setBounds(700, 20, 380, 120);
        activatePanel.setBorder(BorderFactory.createTitledBorder("Activate Membership"));
        frame.add(activatePanel);

        JLabel activateIdLabel = new JLabel("Membership ID:");
        activateIdLabel.setBounds(20, 30, 120, 25);
        activatePanel.add(activateIdLabel);

        JTextField activateIdField = new JTextField();
        activateIdField.setBounds(140, 30, 200, 25);
        activatePanel.add(activateIdField);
        
        //Activate Button
        JButton activateButton = new JButton("Activate");
        activateButton.setBounds(140, 70, 100, 25);
        activatePanel.add(activateButton);
        
        //adding action listener
        activateButton.addActionListener(e -> 
        {
            // Retrieve the entered Member ID from the text field
            String idInput = activateIdField.getText();
        
            // Validate if the ID field is empty
            if (idInput.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Please enter a Member ID!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            try {
                // Parse the input to an integer
                int id = Integer.parseInt(idInput);
        
                // Check if the ID exists in the members list
                boolean found = false;
                for (GymMember member : members) 
                {
                    if (member.getId() == id) 
                    { 
                        member.activeMembership();      // Call the method to activate membership
                        JOptionPane.showMessageDialog(null, "Membership activated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        found = true;
                        break;
                    }
                }
        
                // If the ID is not found in the list
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Member ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
            catch (NumberFormatException ex) 
            {
                // Handle invalid ID format
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric Member ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        
        // Panel for Deactivate Membership
        JPanel deactivatePanel = new JPanel();
        deactivatePanel.setLayout(null);
        deactivatePanel.setBounds(700, 150, 380, 120);
        deactivatePanel.setBorder(BorderFactory.createTitledBorder("Deactivate Membership"));
        frame.add(deactivatePanel);

        JLabel deactivateIdLabel = new JLabel("Membership ID:");
        deactivateIdLabel.setBounds(20, 30, 120, 25);
        deactivatePanel.add(deactivateIdLabel);

        JTextField deactivateIdField = new JTextField();
        deactivateIdField.setBounds(140, 30, 200, 25);
        deactivatePanel.add(deactivateIdField);

        JButton deactivateButton = new JButton("Deactivate");
        deactivateButton.setBounds(140, 70, 100, 25);
        deactivatePanel.add(deactivateButton);
        
        //adding action listener
        deactivateButton.addActionListener(e -> 
            {
            String idInput = deactivateIdField.getText();
        
            if (idInput.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Please enter a Member ID!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            try {
                int id = Integer.parseInt(idInput);
                boolean found = false;
        
                for (GymMember member : members) 
                {
                    if (member.getId() == id) 
                    {
                        if (!member.getActiveStatus()) 
                        {
                            JOptionPane.showMessageDialog(null, "Membership is already inactive!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        } 
                        else 
                        {
                            member.deactivateMembership(); // Use the provided method
                            JOptionPane.showMessageDialog(null, "Membership deactivated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                        found = true;
                        break;
                    }
                }
        
                if (!found) 
                {
                    JOptionPane.showMessageDialog(null, "Member ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
            catch (NumberFormatException ex) 
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric Member ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Panel for Mark Attendance
        JPanel attendancePanel = new JPanel();
        attendancePanel.setLayout(null);
        attendancePanel.setBounds(700, 290, 380, 150);
        attendancePanel.setBorder(BorderFactory.createTitledBorder("Mark Attendance"));
        frame.add(attendancePanel);

        JLabel attendanceIdLabel = new JLabel("Membership ID:");
        attendanceIdLabel.setBounds(20, 30, 120, 25);
        attendancePanel.add(attendanceIdLabel);

        JTextField attendanceIdField = new JTextField();
        attendanceIdField.setBounds(140, 30, 200, 25);
        attendancePanel.add(attendanceIdField);

        JLabel isActiveLabel = new JLabel("Is Member Active:");
        isActiveLabel.setBounds(20, 70, 120, 25);
        attendancePanel.add(isActiveLabel);

        JComboBox<String> isActiveComboBox = new JComboBox<>(new String[]{"Yes", "No"});
        isActiveComboBox.setBounds(140, 70, 200, 25);
        attendancePanel.add(isActiveComboBox);

        JButton markAttendanceButton = new JButton("Mark Attendance");
        markAttendanceButton.setBounds(140, 110, 150, 25);
        attendancePanel.add(markAttendanceButton);
        
        //mark attendance action listener
        markAttendanceButton.addActionListener(e -> 
            {
            String idInput = attendanceIdField.getText();
        
            if (idInput == null || idInput.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Please enter a Member ID!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            try 
            {
                int id = Integer.parseInt(idInput); // Parse the ID directly
                boolean found = false;
        
                for (GymMember member : members) 
                {
                    if (member.getId() == id) 
                    {
                        member.markAttendance(); // Calls the overridden method
                        JOptionPane.showMessageDialog(null, "Attendance marked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        found = true;
                        break;
                    }
                }
        
                if (!found)
                {
                    JOptionPane.showMessageDialog(null, "Member ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
            catch (NumberFormatException ex) 
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric Member ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        
        // Revert Member Panel
        JPanel revertMemberPanel = new JPanel();
        revertMemberPanel.setLayout(null);
        revertMemberPanel.setBorder(BorderFactory.createTitledBorder("Revert Member"));
        revertMemberPanel.setBounds(700, 450, 400, 150); 
        frame.add(revertMemberPanel);
        
        // Member ID Label and Text Field
        JLabel revertMemberIdLabel = new JLabel("Member ID:");
        revertMemberIdLabel.setBounds(20, 30, 100, 25);
        revertMemberPanel.add(revertMemberIdLabel);

        JTextField revertMemberIdField = new JTextField();
        revertMemberIdField.setBounds(120, 30, 200, 25);
        revertMemberPanel.add(revertMemberIdField);

        // Button for Revert Regular Member
        JButton revertRegularMemberButton = new JButton("Revert RegularMember");
        revertRegularMemberButton.setBounds(20, 70, 180, 30);
        revertMemberPanel.add(revertRegularMemberButton);
        
        //adding action listener
        revertRegularMemberButton.addActionListener(e -> 
        {
            String id = revertMemberIdField.getText(); // Get ID from text field
            boolean memberFound = false;
        
            for (GymMember member : members)
            {
                if (String.valueOf(member.getId()).equals(id)) 
                { // Match the member ID
                    memberFound = true;
        
                    if (member instanceof RegularMember) 
                    {
                        String removalReason = JOptionPane.showInputDialog("Enter removal reason:");
                        ((RegularMember) member).revertRegularMember(removalReason); // Cast and call method
                        JOptionPane.showMessageDialog(frame, "Regular membership reverted successfully!");
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(frame, "Member is not a Regular Member!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    return; // Exit the loop once the member is processed
                }
            }
        
            if (!memberFound) 
            {
                JOptionPane.showMessageDialog(frame, "Member ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        // Button for Revert Premium Member
        JButton revertPremiumMemberButton = new JButton("Revert PremiumMember");
        revertPremiumMemberButton.setBounds(210, 70, 180, 30);
        revertMemberPanel.add(revertPremiumMemberButton);
        
        //adding action listener
        revertPremiumMemberButton.addActionListener(e -> 
        {
            String id = revertMemberIdField.getText(); // Get ID from text field
            boolean memberFound = false;
        
            for (GymMember member : members) 
            {
                if (String.valueOf(member.getId()).equals(id)) 
                { // Match the member ID
                    memberFound = true;
        
                    if (member instanceof PremiumMember)
                    {
                        ((PremiumMember) member).revertPremiumMember(); // Cast and call method
                        JOptionPane.showMessageDialog(frame, "Premium membership reverted successfully!");
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(frame, "Member is not a Premium Member!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    return; // Exit the loop once the member is processed
                }
            }
        
            if (!memberFound)
            {
                JOptionPane.showMessageDialog(frame, "Member ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // Panel for Upgrade Plan
        JPanel upgradePanel = new JPanel();
        upgradePanel.setLayout(null);
        upgradePanel.setBounds(1100, 20, 380, 150);
        upgradePanel.setBorder(BorderFactory.createTitledBorder("Upgrade Plan"));
        frame.add(upgradePanel);
        
        JLabel upgradeIdLabel = new JLabel("Membership ID:");
        upgradeIdLabel.setBounds(20, 30, 120, 25);
        upgradePanel.add(upgradeIdLabel);
        
        JTextField upgradeIdField = new JTextField();
        upgradeIdField.setBounds(140, 30, 200, 25);
        upgradePanel.add(upgradeIdField);
        
        JLabel planLabel = new JLabel("Select Plan:");
        planLabel.setBounds(20, 70, 120, 25);
        upgradePanel.add(planLabel);
        
        JComboBox<String> planComboBox = new JComboBox<>(new String[]{"basic", "standard", "deluxe"});
        planComboBox.setBounds(140, 70, 200, 25);
        upgradePanel.add(planComboBox);
        
        JButton upgradeButton = new JButton("Upgrade Plan");
        upgradeButton.setBounds(140, 110, 150, 25);
        upgradePanel.add(upgradeButton);
        
        // Upgrade Plan ActionListener
        upgradeButton.addActionListener(e -> {
            String idInput = upgradeIdField.getText();
            
            if (idInput.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Member ID", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try {
                int id = Integer.parseInt(idInput);
                boolean found = false;
                
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        found = true;
                        
                        if (!(member instanceof RegularMember)) {
                            JOptionPane.showMessageDialog(null, 
                                "Only Regular Members can upgrade plans!", 
                                "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        RegularMember regularMember = (RegularMember) member;
                        String selectedPlan = (String) planComboBox.getSelectedItem();
                        
                        // Show current status before upgrading
                        String statusMessage = "Current Plan: " + regularMember.getPlan() + "\n" +
                                              "Attendance: " + regularMember.getAttendance() + "/" + 
                                              regularMember.getAttendanceLimit() + "\n" +
                                              "Status: " + (regularMember.getActiveStatus() ? "Active" : "Inactive");
                        
                        // Attempt upgrade
                        String upgradeResult = regularMember.upgradePlan(selectedPlan);
                        
                        // Show complete result
                        JOptionPane.showMessageDialog(null, 
                            statusMessage + "\n\n" + upgradeResult,
                            "Upgrade Status", 
                            JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
                
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Member ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Member ID format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

            
        // Panel for Pay Due Amount
        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(null);
        paymentPanel.setBounds(1100, 310, 380, 150);
        paymentPanel.setBorder(BorderFactory.createTitledBorder("Pay Due Amount"));
        frame.add(paymentPanel);
        
        JLabel paymentIdLabel = new JLabel("Membership ID:");
        paymentIdLabel.setBounds(20, 30, 120, 25);
        paymentPanel.add(paymentIdLabel);
        
        JTextField paymentIdField = new JTextField();
        paymentIdField.setBounds(140, 30, 200, 25);
        paymentPanel.add(paymentIdField);
        
        JLabel amountLabel = new JLabel("Amount to Pay:");
        amountLabel.setBounds(20, 70, 120, 25);
        paymentPanel.add(amountLabel);
        
        JTextField amountField = new JTextField();
        amountField.setBounds(140, 70, 200, 25);
        paymentPanel.add(amountField);
        
        JButton paymentButton = new JButton("Pay Due Amount");
        paymentButton.setBounds(140, 110, 150, 25);
        paymentPanel.add(paymentButton);
        
        // Pay Due Amount ActionListener
        paymentButton.addActionListener(e -> {
            String idInput = paymentIdField.getText();
            String amountInput = amountField.getText();
            
            if (idInput == null || idInput.isEmpty() || amountInput == null || amountInput.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter both Member ID and Amount!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try {
                int id = Integer.parseInt(idInput);
                double amount = Double.parseDouble(amountInput);
                boolean found = false;
                
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        found = true;
                        if (member instanceof PremiumMember) {
                            String result = ((PremiumMember) member).payDueAmount(amount);
                            JOptionPane.showMessageDialog(null, result, "Payment Result", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Only Premium Members can make payments!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                }
                
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Member ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values for ID and Amount!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // Panel for Calculate Discount
        JPanel discountPanel = new JPanel();
        discountPanel.setLayout(null);
        discountPanel.setBounds(1100, 180, 380, 120);
        discountPanel.setBorder(BorderFactory.createTitledBorder("Calculate Discount"));
        frame.add(discountPanel);
        
        JLabel discountIdLabel = new JLabel("Membership ID:");
        discountIdLabel.setBounds(20, 30, 120, 25);
        discountPanel.add(discountIdLabel);
        
        JTextField discountIdField = new JTextField();
        discountIdField.setBounds(140, 30, 200, 25);
        discountPanel.add(discountIdField);
        
        JButton discountButton = new JButton("Calculate Discount");
        discountButton.setBounds(140, 70, 150, 25);
        discountPanel.add(discountButton);
        
        // Calculate Discount ActionListener
        discountButton.addActionListener(e -> {
            String idInput = discountIdField.getText();
            
            if (idInput == null || idInput.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a Member ID!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try {
                int id = Integer.parseInt(idInput);
                boolean found = false;
                
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        found = true;
                        if (member instanceof PremiumMember) {
                            ((PremiumMember) member).calculateDiscount();
                            JOptionPane.showMessageDialog(null, "Discount calculated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Only Premium Members can calculate discounts!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                }
                
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Member ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric Member ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Display Button
        JButton displayButton = new JButton("Display Members");
        displayButton.setBounds(500, 900, 140, 30); 
        frame.add(displayButton);
        
        // Display Button ActionListener
        displayButton.addActionListener(e -> {
            if (members.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No members found!", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        
            // Create a text area with scroll pane
            JTextArea textArea = new JTextArea(20, 80);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            
            // Build the display content
            String header = String.format("%-5s %-15s %-10s %-15s %-10s %-15s %-15s\n",
                "ID", "Name", "Type", "Plan", "Status", "Attendance", "Loyalty");
            textArea.append(header + "\n");
            
            for (GymMember member : members) {
                String type = member instanceof RegularMember ? "Regular" : "Premium";
                String plan = member instanceof RegularMember ? 
                    ((RegularMember)member).getPlan() : "Premium";
                String status = member.getActiveStatus() ? "Active" : "Inactive";
                
                String row = String.format("%-5d %-15s %-10s %-15s %-10s %-15d %-15.2f\n",
                    member.getId(), 
                    member.getName(), 
                    type,
                    plan,
                    status,
                    member.getAttendance(),
                    member.getLoyaltyPoints());
                textArea.append(row);
            }
            
            // Show in a dialog
            JOptionPane.showMessageDialog(frame, scrollPane, "All Members", JOptionPane.INFORMATION_MESSAGE);
        });


        // Clear Button
        JButton clearButton = new JButton("Clear Fields");
        clearButton.setBounds(700, 900, 140, 30); 
        frame.add(clearButton);
        
        //Clear Button ActionListener
        clearButton.addActionListener(e -> {
            // Clear all text fields
            regularIdField.setText("");
            regularNameField.setText("");
            regularLocationField.setText("");
            regularMobileField.setText("");
            regularEmailField.setText("");
            referralField.setText("");
            regularGenderGroup.clearSelection();
            
            premiumIdField.setText("");
            premiumNameField.setText("");
            premiumLocationField.setText("");
            premiumPhoneField.setText("");
            premiumEmailField.setText("");
            trainerField.setText("");
            premiumGenderGroup.clearSelection();
            
            // Clear action fields
            activateIdField.setText("");
            deactivateIdField.setText("");
            attendanceIdField.setText("");
            revertMemberIdField.setText("");
            upgradeIdField.setText("");
            discountIdField.setText("");
            paymentIdField.setText("");
            amountField.setText("");
            
            // Reset combo boxes
            dayCombo.setSelectedIndex(0);
            monthCombo.setSelectedIndex(0);
            yearCombo.setSelectedIndex(0);
            regularStartDayCombo.setSelectedIndex(0);
            regularStartMonthCombo.setSelectedIndex(0);
            regularStartYearCombo.setSelectedIndex(0);
            premiumDayCombo.setSelectedIndex(0);
            premiumMonthCombo.setSelectedIndex(0);
            premiumYearCombo.setSelectedIndex(0);
            premiumStartDayCombo.setSelectedIndex(0);
            premiumStartMonthCombo.setSelectedIndex(0);
            premiumStartYearCombo.setSelectedIndex(0);
            planComboBox.setSelectedIndex(0);
            isActiveComboBox.setSelectedIndex(0);
            
            JOptionPane.showMessageDialog(frame, "All fields cleared successfully!", "Clear", JOptionPane.INFORMATION_MESSAGE);
        });
        
        // Save to File Button
        JButton saveToFileButton = new JButton("Save to File");
        saveToFileButton.setBounds(500, 950, 140, 30);
        frame.add(saveToFileButton);
        
        // Save to File Button ActionListener
        saveToFileButton.addActionListener(e -> {
            if (members.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No members to save!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            try (FileWriter writer = new FileWriter("MemberDetails.txt")) {
                // Write header
                writer.write(String.format("%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s %-15s %-15s\n",
                    "ID", "Name", "Location", "Phone", "Email", "Membership Start", "Plan", "Price", 
                    "Attendance", "Loyalty", "Active", "Full Pay", "Discount"));
                
                // Write member details
                for (GymMember member : members) {
                    if (member instanceof RegularMember) {
                        RegularMember rm = (RegularMember) member;
                        writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s %-15s %-15.2f\n",
                            rm.getId(), rm.getName(), rm.getLocation(), rm.getPhone(), rm.getEmail(),
                            rm.MembershipStartDate(), rm.getPlan(), rm.getPrice(), rm.getAttendance(),
                            rm.getLoyaltyPoints(), rm.getActiveStatus() ? "Yes" : "No", "N/A", 0.0));
                    } else if (member instanceof PremiumMember) {
                        PremiumMember pm = (PremiumMember) member;
                        // Ensure discount is calculated if payment is complete
                        if(pm.isFullPayment() && pm.getDiscountAmount() == 0) {
                            pm.calculateDiscount();
                        }
                        
                        writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s %-15s %-15.2f\n",
                            pm.getId(),
                            pm.getName(),
                            pm.getLocation(),
                            pm.getPhone(),
                            pm.getEmail(),
                            pm.MembershipStartDate(),
                            "Premium",
                            pm.getPremiumCharge(),
                            pm.getAttendance(),
                            pm.getLoyaltyPoints(),
                            pm.getActiveStatus() ? "Yes" : "No",
                            pm.isFullPayment() ? "Yes" : "No",
                            pm.getDiscountAmount())); // This will now show the discount
                }
                    
                }
                
                JOptionPane.showMessageDialog(frame, "Member details saved to MemberDetails.txt", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // Read from File Button
        JButton readFromFileButton = new JButton("Read from File");
        readFromFileButton.setBounds(700, 950, 140, 30);
        frame.add(readFromFileButton);
        
        // Read from File Button ActionListener
        readFromFileButton.addActionListener(e -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("MemberDetails.txt"))) {
                // Create text area with scroll pane
                JTextArea textArea = new JTextArea(20, 80);
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                
                // Read file line by line
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                
                // Show in dialog
                JOptionPane.showMessageDialog(frame, scrollPane, "Member Details from File", JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(frame, "File not found: MemberDetails.txt", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        
        
        
        frame.setVisible(true);
        
    }
}