/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class RobotTemplate extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    Talon motor_l1 = new Talon(2);
    Talon motor_l2 = new Talon(3);
    Talon motor_r1 = new Talon(8);
    Talon motor_r2 = new Talon(9);
    Victor liftmotor1 = new Victor(1);
    Victor liftmotor2 = new Victor(10);
    Joystick joystick1 = new Joystick(1);
    Button shiftup = new DigitalIOButton(6);
    Button shiftdown = new DigitalIOButton(5);
    int gear=1;
    int gearval=4;
    
    public void autonomous() {
         
    }
    
    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        while(true){
            
            
            double leftside, rightside;
            leftside=(joystick1.getX() + joystick1.getY());
            rightside=-(-joystick1.getX() + joystick1.getY());
            if (Math.abs(leftside) < 0.25){
                leftside=0;
            }
            if (Math.abs(rightside) < 0.25){
                rightside=0;
            }
            if (joystick1.getRawButton(6)== true && gear<3){
                gear=gear+1;
                gearval=gearval-1;
                Timer.delay(0.15);
            }
            if (joystick1.getRawButton(5)== true && gear>1){
                gear=gear-1;
                gearval=gearval+1;
                Timer.delay(0.15); 
            }
            double lift = joystick1.getZ();
           
            double tomotorl=(leftside/gearval);
            double tomotorr=(rightside/gearval);
            System.out.println(tomotorl+"\t"+tomotorr);
            motor_l1.set(tomotorl);
            motor_l2.set(tomotorl);
            motor_r1.set(tomotorr);
            motor_r2.set(tomotorr);
            liftmotor1.set(lift);
            liftmotor2.set(-lift);
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
