public class Proj1Car extends BaseCar {
	/*
	 * This method is called over and over by main(). The job of this method is
	 * to decide whether the car should speed up (return 1), slow down (return
	 * -1), or coast (return 0).
	 *
	 * There are two basic requirements: - Don't exceed the speed limit of 35 -
	 * Don't crash into another car
	 *
	 * To decide what to do, you have several methods you can call to query the
	 * state of your car: getSpeed() - gives the speed of your own car
	 * distToNextCar() - gives the dist to the car in front of you
	 * speedOfNextCar() - gives the speed of the car in front of you
	 */
	public int getPedal() {
		// you must implement this method from scratch. For a first pass,
		// how about using the rule "speed up if we are too far behind,
		// and slow down if we are too close". This will work poorly - and
		// often result in crashes - but it's a good starting point.

		System.out.println("Speed " + getSpeed() + " mile/h");
		System.out.println("Next Car's Speed " + speedOfNextCar() + " mile/h");
		System.out.println("Dist to Next Car " + distToNextCar() + " mile");
		System.out.println("--------------------------------------------------");

		//Distance of the vehicle is greater than 100.3
		if (distToNextCar() > 100.3) {

			if (speedOfNextCar() == getSpeed()) {
				return 1;
			}

			// -----------------------------------
			if (distToNextCar() - 100 > 48) {

				if ((speedOfNextCar() - getSpeed()) < -13) {
					return -1;
				}

			} else if (distToNextCar() - 100 > 39) {

				if ((speedOfNextCar() - getSpeed()) < -12) {
					return -1;
				}

			} else if (distToNextCar() - 100 > 31) {

				if ((speedOfNextCar() - getSpeed()) < -11) {
					return -1;
				}

			} else if (distToNextCar() - 100 > 24) {

				if ((speedOfNextCar() - getSpeed()) < -10) {
					return -1;
				}

			} else if (distToNextCar() - 100 > 18) {

				if ((speedOfNextCar() - getSpeed()) < -9) {
					return -1;
				}

			} else if (distToNextCar() - 100 > 13) {

				if ((speedOfNextCar() - getSpeed()) < -7) {
					return -1;
				}

			} else if (distToNextCar() - 100 > 9) {

				if ((speedOfNextCar() - getSpeed()) < -6) {
					return -1;
				}

			} else if (distToNextCar() - 100 > 6) {

				if ((speedOfNextCar() - getSpeed()) < -4) {
					return -1;
				}

			} else if (distToNextCar() - 100 > 4) {

				if ((speedOfNextCar() - getSpeed()) < -2) {
					return -1;
				}

			} else {
				if ((speedOfNextCar() - getSpeed()) < -1) {
					return -1;
				}
			}
			// ----------------------------------

			if (speedOfNextCar() > getSpeed()) {
				return 1;
			}

			return 1;
		}
		
		//  99.7 <= distance <= 100.3
		if (distToNextCar() >= 99.7 && distToNextCar() <= 100.3) {
			
			if(distToNextCar() <= 100.1 && distToNextCar() >= 99.9){
				return 0;
			}

			if (speedOfNextCar() > getSpeed()) {
				return 1;
			}

			if (speedOfNextCar() < getSpeed()) {
				return -1;
			}

			return 0;
		}

		//Distance of the vehicle is less than 99.7
		if (distToNextCar() < 99.7) {

			if (speedOfNextCar() == getSpeed()) {
				return -1;
			}

			//--------------------------------------
			if (100 - distToNextCar() > 48) {
				if ((speedOfNextCar() - getSpeed()) > 13) {
					return 1;
				}
			} else if (100 - distToNextCar() > 39) {
				if ((speedOfNextCar() - getSpeed()) > 12) {
					return 1;
				}
			} else if (100 - distToNextCar() > 31) {
				if ((speedOfNextCar() - getSpeed()) > 11) {
					return 1;
				}
			} else if (100 - distToNextCar() > 24) {
				if ((speedOfNextCar() - getSpeed()) > 10) {
					return 1;
				}
			} else if (100 - distToNextCar() > 18) {
				if ((speedOfNextCar() - getSpeed()) > 9) {
					return 1;
				}
			} else if (100 - distToNextCar() > 13) {
				if ((speedOfNextCar() - getSpeed()) > 7) {
					return 1;
				}
			} else if (100 - distToNextCar() > 9) {
				if ((speedOfNextCar() - getSpeed()) > 6) {
					return 1;
				}
			} else if (100 - distToNextCar() > 6) {
				if ((speedOfNextCar() - getSpeed()) > 4) {
					return 1;
				}
			} else if (100 - distToNextCar() > 4) {
				if ((speedOfNextCar() - getSpeed()) > 2) {
					return 1;
				}
			} else {
				if ((speedOfNextCar() - getSpeed()) > 1) {
					return 1;
				}
			}
			//-------------------------------------

			if (speedOfNextCar() < getSpeed()) {
				return -1;
			}

			return -1;
		}

		return 0;
	}
}
