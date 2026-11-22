class Car {
    int position;
    int speed;
    Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}

class CarComparator implements Comparator<Car> {
    @Override 
    public int compare (Car a, Car b) {
        return b.position-a.position;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int ans = 1;
        Car cars[] = new Car[position.length];
        for (int i=0;i<position.length;i++) {
            cars[i] = new Car(position[i], speed[i]);
        }  
        Arrays.sort(cars, new CarComparator());
        double prevTime = (double)(target - cars[0].position) / cars[0].speed;
        for (int i=1;i<position.length;i++) {
            double currTime = (double)(target - cars[i].position) / cars[i].speed;
            if (currTime > prevTime) {
                ans++;
                prevTime = currTime;
            }
        }
        return ans;
    }
}
