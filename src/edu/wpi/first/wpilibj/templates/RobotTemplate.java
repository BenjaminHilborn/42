/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;
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
    Talon motor1 = new Talon(1);
    Talon motor2 = new Talon(2);
    Joystick joystick1 = new Joystick(1);
    //Joystick.ButtonType shiftup = new Joystick.ButtonType(7);
    Button shiftup = new DigitalIOButton(6);
    Button shiftdown = new DigitalIOButton(5);
    
    public void autonomous() {
        
    }
    int gear=1;
    int gearval=3;
    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        while(true){
            double leftside, rightside;
            leftside=(joystick1.getX() + joystick1.getY());
            rightside=-(-joystick1.getX() + joystick1.getY());
            if (Math.abs(leftside) < 0.18){
                leftside=0;
            }
            if (Math.abs(rightside) < 0.18){
                rightside=0;
            }
            if (shiftup.get()== true && gear<=3){
                gear++;
                gearval--;
            }
            if (shiftdown.get()== true && gear>=1){
                gear--;
                gearval++;
            }
            leftside=(leftside*leftside*leftside);
            rightside=(rightside*rightside*rightside);
            System.out.println(leftside+"\t"+rightside);
            motor1.set(leftside/gearval);
            motor2.set(rightside/gearval);
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
