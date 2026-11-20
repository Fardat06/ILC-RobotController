package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.OpModes.Testing.Gamepad;
import org.firstinspires.ftc.teamcode.Util.Gamepad.GamepadInput;

@TeleOp(name = "Main TeleOp")
public class MainTeleOp extends CustomOpMode {
    @Override
    public void onLoop() {
        if (gm1.isJustDown(GamepadInput.LeftBumper))
            robot.intake.toggle();
        logger.debug("Intake: power=%.2f", robot.intake.getPower());

        int speedDir = gm1.getDirectionJustDown(GamepadInput.DpadRight, GamepadInput.DpadLeft);
        robot.turret.adjustSpeed(speedDir * 0.1);
        logger.debug("Turret: speed=%.2f", robot.turret.getSpeed());

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
