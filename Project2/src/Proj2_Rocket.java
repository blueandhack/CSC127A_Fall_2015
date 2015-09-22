/* Proj2_Rocket
 *
 * CSc 127A Fall 15, Project 02
 *
 * Author:  Yujia Lin
 * SL Name: David Lamparter
 *
 * ---
 *
 * This class calculates the performance of a three-stage rocket, using
 * extremely inaccurate equations provided by the instructor.
 */

public class Proj2_Rocket {

	public static void main(String[] args) {

		//Payload
		double payload = Double.parseDouble(args[0]);

		//Bottom stage engine and fuel
		double bottomStage1 = Double.parseDouble(args[1]);
		double bottomStageFuel = Double.parseDouble(args[2]);

		//Middle stage engine and fuel
		double middleStage2 = Double.parseDouble(args[3]);
		double middleStageFuel = Double.parseDouble(args[4]);

		//Top stage engine and fuel
		double topStage3 = Double.parseDouble(args[5]);
		double topStageFuel = Double.parseDouble(args[6]);

		//Thrust
		double firstThrust = Total_Thrust(bottomStage1);
		double secondThrust = Total_Thrust(middleStage2);
		double thirdThrust = Total_Thrust(topStage3);

		//Stage Stacks
		double firstStageStack = payload + bottomStage1 * 100 + bottomStageFuel + middleStage2 * 100 + middleStageFuel
				+ topStage3 * 100 + topStageFuel;
		double secondStageStack = payload + middleStage2 * 100 + middleStageFuel + topStage3 * 100 + topStageFuel;
		double thirdStageStack = payload + topStage3 * 100 + topStageFuel;

		//Computing speed and altitude
		double firstStageSpeedAndAltitude[] = Speed_And_Altitude_After_This_Stage(firstThrust, firstStageStack,
				bottomStageFuel, bottomStage1, 0, 0);

		double secondStageSpeedAndAltitude[] = Speed_And_Altitude_After_This_Stage(secondThrust, secondStageStack,
				middleStageFuel, middleStage2, firstStageSpeedAndAltitude[0], firstStageSpeedAndAltitude[1]);

		double thirdStafeSpeedAndAltitude[] = Speed_And_Altitude_After_This_Stage(thirdThrust, thirdStageStack,
				topStageFuel, topStage3, secondStageSpeedAndAltitude[0], secondStageSpeedAndAltitude[1]);

		//Computing apogee
		double apogee = Apogee(thirdStafeSpeedAndAltitude[0], thirdStafeSpeedAndAltitude[1]);

		//Show something
		System.out.println("Weight of the first stage stack: " + firstStageStack);
		System.out.println("  First stage thrust: " + firstThrust);

		System.out.println("Weight of the second stage stack: " + secondStageStack);
		System.out.println("  Second stage thrust: " + secondThrust);

		System.out.println("Weight of the third stage stack: " + thirdStageStack);
		System.out.println("  Third stage thrust: " + thirdThrust);
		System.out.println();
		System.out.println("After the first stage: ");
		System.out.println("  Speed: " + firstStageSpeedAndAltitude[0]);
		System.out.println("  Altitude: " + firstStageSpeedAndAltitude[1]);
		System.out.println();
		System.out.println("After the second stage: ");
		System.out.println("  Speed: " + secondStageSpeedAndAltitude[0]);
		System.out.println("  Altitude: " + secondStageSpeedAndAltitude[1]);
		System.out.println();
		System.out.println("After the third stage: ");
		System.out.println("  Speed: " + thirdStafeSpeedAndAltitude[0]);
		System.out.println("  Altitude: " + thirdStafeSpeedAndAltitude[1]);
		System.out.println();
		System.out.println("Apogee: " + apogee);

		System.out.println("");
		if (firstStageSpeedAndAltitude[0] <= 0)
			System.out.println("STALL!  The speed after the first stage is <= 0.");
		if (secondStageSpeedAndAltitude[0] <= 0)
			System.out.println("STALL!  The speed after the second stage is <= 0.");
		if (thirdStafeSpeedAndAltitude[0] <= 0)
			System.out.println("STALL!  The speed after the third stage is <= 0.");
		if (firstStageSpeedAndAltitude[1] <= 0)
			System.out.println("CRASH!  The altitude after the first stage is <= 0.");
		if (secondStageSpeedAndAltitude[1] <= 0)
			System.out.println("CRASH!  The altitude after the second stage is <= 0.");
		if (thirdStafeSpeedAndAltitude[1] <= 0)
			System.out.println("CRASH!  The altitude after the third stage is <= 0.");

	}


	//Computing thrust
	public static double Total_Thrust(double engines_this_stage) {

		double total_thrust = engines_this_stage * 1000;

		return total_thrust;
	}

	//Computing speed and altitude
	public static double[] Speed_And_Altitude_After_This_Stage(double thrust, double stageStack, double fuelWeight,
			double stage, double speed_before_this_stage, double altitude_before_this_stage) {
		double acceleration = thrust - stageStack;
		double burnout_time = fuelWeight / (100 * stage);
		double delta_v = acceleration * burnout_time;
		double speed_after_this_stage = speed_before_this_stage + delta_v;

		double altitude_after_this_stage = altitude_before_this_stage
				+ burnout_time * ((2 * speed_before_this_stage + delta_v) / 2);

		double speed_and_altitude[] = new double[2];

		speed_and_altitude[0] = speed_after_this_stage;
		speed_and_altitude[1] = altitude_after_this_stage;

		return speed_and_altitude;
	}

	//Computing apogee 
	public static double Apogee(double speed_after_stage_3, double altitude_after_stage_3) {
		double time_to_apogee = speed_after_stage_3 / 9.8;
		double apogee = altitude_after_stage_3 + speed_after_stage_3 * time_to_apogee
				- 4.9 * time_to_apogee * time_to_apogee;

		return apogee;
	}

}
