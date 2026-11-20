package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Util.Gamepad.GamepadInput;

@TeleOp(name = "Main TeleOp", group = "Kickoff")
public class MainTeleOp extends CustomOpMode {
    @Override
    public void onLoop() {
        if (gm1.isJustDown(GamepadInput.LeftBumper))
            robot.intake.toggle();

        if (gm1.isDown(GamepadInput.RightBumper))
            robot.turret.setSpeed(0.5);
        else
            robot.turret.setSpeed(0);

//        if(gm1.isDown(GamepadInput.DpadDown)){
//            robot.turret.adjustHood(-0.1);
//        }
//        if(gm1.isDown(GamepadInput.DpadUp)){
//            robot.turret.adjustHood(+0.1);
//        }
        // asta e acc lucru ca mai jos (note for dodo)

        int mul = (gm1.isDown(GamepadInput.DpadUp) ? 1 : 0) - (gm1.isDown(GamepadInput.DpadDown) ? 1 : 0);
        robot.turret.adjustHood(0.1 * mul);


        if(gm1.isDown(GamepadInput.DpadLeft))
            robot.turret.adjustSpeed(0.1);
        else if(gm1.isDown(GamepadInput.DpadRight))
            robot.turret.adjustSpeed(-0.1);



        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rotation = gamepad1.right_stick_x;
        robot.chassis.drive(y, x, rotation);

        logger.debug(
                "Chassis: y=%.2f x=%.2f rotation=%.2f",
                y, x, rotation
        );
    }
}
