/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class IntakeConstants {
        public static final int kIntakeMotorPort = 0;
    }

    public static final class JoystickConstants {
        public static final int kDriverControllerPort = 0;
    }

    public static final class ShooterConstants {
        public static final int kShooterFirstMotorPort = 1;
        public static final int kShooterSecondMotorPort = 2;
    }

    public static final class DriveTrainConstants {
        public static final int kLeftRearMotorPort = 3;
        public static final int kLeftFrontMotorPort = 4;
        public static final int kRightRearMotorPort = 5;
        public static final int kRightFrontMotorPort = 6;
    }

    public static final class ClimbConstants {
        public static final int kDoubleSolenoidForwardPort = 0;
        public static final int kDoubleSolenoidReversePort = 1;
        public static final int kCompressorPort = 0;
    }
}
