import java.util.ArrayList;
import java.util.List;

// Observer interface
interface WeatherObserver {
    void update(float temperature, float humidity);
}

// Concrete observer for Phone app
class PhoneDisplay implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Phone Display - Temperature: " + temperature + "°C, Humidity: " + humidity + "%");
    }
}

// Concrete observer for Digital Display
class DigitalDisplay implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Digital Display - Temperature: " + temperature + "°C, Humidity: " + humidity + "%");
    }
}

// Subject class that manages observers
class WeatherStation {
    private List<WeatherObserver> observers = new ArrayList<>();
    private float temperature;
    private float humidity;

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    public void setWeatherData(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature, humidity);
        }
    }
}

// Demonstration of Observer Pattern
public class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        // Adding observers
        PhoneDisplay phoneDisplay = new PhoneDisplay();
        DigitalDisplay digitalDisplay = new DigitalDisplay();

        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(digitalDisplay);

        // Changing weather data
        weatherStation.setWeatherData(28.5f, 65);
        weatherStation.setWeatherData(30.0f, 70);
    }
}
