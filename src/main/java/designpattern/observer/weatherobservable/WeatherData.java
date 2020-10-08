package designpattern.observer.weatherobservable;
	
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;
	
public class WeatherData extends Observable implements If {
	private float temperature;
	private float humidity;
	private float pressure;
	private BigDecimal big;
	private String str;
	
	public WeatherData() { }
	
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}

	@Override
	public void originalMethod(String s) {
		System.out.println("----");
	}


	static class Handler implements InvocationHandler {
		private final If original;
		public Handler(If original) {
			this.original = original;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("BEFORE");
			method.invoke(original, args);
			System.out.println("AFTER");
			return null;
		}
	}

	public static void main(String[] args) throws IOException {
		WeatherData weatherData = new WeatherData();
		Handler handler = new Handler(weatherData);
//		If f = (If) Proxy.newProxyInstance(WeatherData.class.getClassLoader(),
//				new Class[] { WeatherData.class },
//				handler);
//		f.originalMethod("Hallo");
		for(Field field : weatherData.getClass().getDeclaredFields()){
			System.out.println(field.getName()+" "+field.getType().isPrimitive()+" "+field.getGenericType());
		}
	}
}
