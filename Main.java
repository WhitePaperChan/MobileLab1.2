package mobule;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		String studentsStr = "Дмитренко Олександр - ІП-84; Матвійчук Андрій - ІВ-83; Лесик Сергій - ІО-82; Ткаченко Ярослав - ІВ-83; Аверкова Анастасія - ІО-83; Соловйов Даніїл - ІО-83; Рахуба Вероніка - ІО-81; Кочерук Давид - ІВ-83; Лихацька Юлія- ІВ-82; Головенець Руслан - ІВ-83; Ющенко Андрій - ІО-82; Мінченко Володимир - ІП-83; Мартинюк Назар - ІО-82; Базова Лідія - ІВ-81; Снігурець Олег - ІВ-81; Роман Олександр - ІО-82; Дудка Максим - ІО-81; Кулініч Віталій - ІВ-81; Жуков Михайло - ІП-83; Грабко Михайло - ІВ-81; Іванов Володимир - ІО-81; Востриков Нікіта - ІО-82; Бондаренко Максим - ІВ-83; Скрипченко Володимир - ІВ-82; Кобук Назар - ІО-81; Дровнін Павло - ІВ-83; Тарасенко Юлія - ІО-82; Дрозд Світлана - ІВ-81; Фещенко Кирил - ІО-82; Крамар Віктор - ІО-83; Іванов Дмитро - ІВ-82";
		
		// Завдання 1
		// Заповніть словник, де:
		// - ключ – назва групи
		// - значення – відсортований масив студентів, які відносяться до відповідної групи

		HashMap<String, ArrayList<String>> studentsGroups = new HashMap<String, ArrayList<String>>();
		
		// Ваш код починається тут

		String[] studentsArray = studentsStr.split("; ");
		String[] workArray = new String[2];
		for (int i = 0; i < studentsArray.length; i++) {
			workArray = studentsArray[i].split("- ");
			if (workArray[0].endsWith(" ")) {
				workArray[0] = workArray[0].substring(0, workArray[0].length() - 1);
			}
			if(!studentsGroups.containsKey(workArray[1])) {
				studentsGroups.put(workArray[1], new ArrayList<String>());
			}
			studentsGroups.get(workArray[1]).add(workArray[0]);
		}

		// Ваш код закінчується тут
		
		System.out.println("Завдання 1");
		System.out.println(studentsGroups);
		System.out.println();

		// Дано масив з максимально можливими оцінками
		
		int[] points = {12, 12, 12, 12, 12, 12, 12, 16};
		
		// Завдання 2
		// Заповніть словник, де:
		// - ключ – назва групи
		// - значення – словник, де:
		//   - ключ – студент, який відносяться до відповідної групи
		//   - значення – масив з оцінками студента (заповніть масив випадковими значеннями, використовуючи функцію `randomValue(maxValue: Int) -> Int`)
		
		HashMap<String, HashMap<String, ArrayList<Integer>>> studentPoints = new HashMap<String, HashMap<String, ArrayList<Integer>>>();
		
		// Ваш код починається тут

		for(String group : studentsGroups.keySet()) {
			studentPoints.put(group, new HashMap<String, ArrayList<Integer>>());
			for (String student : studentsGroups.get(group)) {
				studentPoints.get(group).put(student, new ArrayList<Integer>());
				for (int i = 0; i < points.length; i++) {
					studentPoints.get(group).get(student).add(Main.randomValue(points[i]));
				}
			}
		}

		// Ваш код закінчується тут
		
		System.out.println("Завдання 2");
		System.out.println(studentPoints);
		System.out.println();
		
		// Завдання 3
		// Заповніть словник, де:
		// - ключ – назва групи
		// - значення – словник, де:
		//   - ключ – студент, який відносяться до відповідної групи
		//   - значення – сума оцінок студента

		HashMap<String, HashMap<String, Integer>> sumPoints = new HashMap<String, HashMap<String, Integer>>();

		// Ваш код починається тут
		int number;
		for(String group : studentsGroups.keySet()) {
			sumPoints.put(group, new HashMap<String, Integer>());
			for (String student : studentsGroups.get(group)) {
				number = 0;
				for (int i = 0; i < points.length; i++) {
					number += studentPoints.get(group).get(student).get(i);
				}
				sumPoints.get(group).put(student, number);
			}
		}

		// Ваш код закінчується тут
		
		System.out.println("Завдання 3");
		System.out.println(sumPoints);
		System.out.println();
		
		// Завдання 4
		// Заповніть словник, де:
		// - ключ – назва групи
		// - значення – середня оцінка всіх студентів групи
		
		HashMap<String, Float> groupAvg = new HashMap<String, Float>();
		
		// Ваш код починається тут

		float average;
		for(String group : studentsGroups.keySet()) {
			average = 0;
			for (String student: sumPoints.get(group).keySet()) {
				average += sumPoints.get(group).get(student);
			}
			average /= sumPoints.get(group).size();
			groupAvg.put(group, average);
		}


		// Ваш код закінчується тут
		
		System.out.println("Завдання 4");
		System.out.println(groupAvg);
		System.out.println();
		
		// Завдання 5
		// Заповніть словник, де:
		// - ключ – назва групи
		// - значення – масив студентів, які мають >= 60 балів
		
		HashMap<String, ArrayList<String>> passedPerGroup = new HashMap<String, ArrayList<String>>();
		
		// Ваш код починається тут

		for(String group : studentsGroups.keySet()) {
			passedPerGroup.put(group, new ArrayList<String>());
			for (String student: sumPoints.get(group).keySet()) {
				if (sumPoints.get(group).get(student) >= 60) {
					passedPerGroup.get(group).add(student);
				}
			}
		}


		// Ваш код закінчується тут
		
		System.out.println("Завдання 5");
		System.out.println(passedPerGroup);
		
		// Приклад виведення. Ваш результат буде відрізнятися від прикладу через використання функції random для заповнення масиву оцінок та через інші вхідні дані.
		//
		//Завдання 1
		//["ІВ-73": ["Гончар Юрій", "Давиденко Костянтин", "Капінус Артем", "Науменко Павло", "Чередніченко Владислав"], "ІВ-72": ["Бортнік Василь", "Киба Олег", "Овчарова Юстіна", "Тимко Андрій"], "ІВ-71": ["Андрющенко Данило", "Гуменюк Олександр", "Корнійчук Ольга", "Музика Олександр", "Трудов Антон", "Феофанов Іван"]]
		//
		//Завдання 2
		//["ІВ-73": ["Давиденко Костянтин": [5, 8, 9, 12, 11, 12, 0, 0, 14], "Капінус Артем": [5, 8, 12, 12, 0, 12, 12, 12, 11], "Науменко Павло": [4, 8, 0, 12, 12, 11, 12, 12, 15], "Чередніченко Владислав": [5, 8, 12, 12, 11, 12, 12, 12, 15], "Гончар Юрій": [5, 6, 0, 12, 0, 11, 12, 11, 14]], "ІВ-71": ["Корнійчук Ольга": [0, 0, 12, 9, 11, 11, 9, 12, 15], "Музика Олександр": [5, 8, 12, 0, 11, 12, 0, 9, 15], "Гуменюк Олександр": [5, 8, 12, 9, 12, 12, 11, 12, 15], "Трудов Антон": [5, 0, 0, 11, 11, 0, 12, 12, 15], "Андрющенко Данило": [5, 6, 0, 12, 12, 12, 0, 9, 15], "Феофанов Іван": [5, 8, 12, 9, 12, 9, 11, 12, 14]], "ІВ-72": ["Киба Олег": [5, 8, 12, 12, 11, 12, 0, 0, 11], "Овчарова Юстіна": [5, 8, 12, 0, 11, 12, 12, 12, 15], "Бортнік Василь": [4, 8, 12, 12, 0, 12, 9, 12, 15], "Тимко Андрій": [0, 8, 11, 0, 12, 12, 9, 12, 15]]]
		//
		//Завдання 3
		//["ІВ-72": ["Бортнік Василь": 84, "Тимко Андрій": 79, "Овчарова Юстіна": 87, "Киба Олег": 71], "ІВ-73": ["Капінус Артем": 84, "Науменко Павло": 86, "Чередніченко Владислав": 99, "Гончар Юрій": 71, "Давиденко Костянтин": 71], "ІВ-71": ["Корнійчук Ольга": 79, "Трудов Антон": 66, "Андрющенко Данило": 71, "Гуменюк Олександр": 96, "Феофанов Іван": 92, "Музика Олександр": 72]]
		//
		//Завдання 4
		//["ІВ-71": 79.333336, "ІВ-72": 80.25, "ІВ-73": 82.2]
		//
		//Завдання 5
		//["ІВ-72": ["Бортнік Василь", "Киба Олег", "Овчарова Юстіна", "Тимко Андрій"], "ІВ-73": ["Давиденко Костянтин", "Капінус Артем", "Чередніченко Владислав", "Гончар Юрій", "Науменко Павло"], "ІВ-71": ["Музика Олександр", "Трудов Антон", "Гуменюк Олександр", "Феофанов Іван", "Андрющенко Данило", "Корнійчук Ольга"]]
		
		
		//Частина 2
		
		CoordinateND coordA = new CoordinateND();
		CoordinateND coordB = new CoordinateND(Direction.N, 45, 30, 36);
		
		System.out.println();
		System.out.println("======Частина 2======");
		System.out.println("coordA.valueString(): " + coordA.valueString());
		System.out.println("coordB.valueString(): " + coordB.valueString());
		System.out.println("coordA.valueStringFloat(): " + coordA.valueStringFloat());
		System.out.println("coordB.valueStringFloat(): " + coordB.valueStringFloat());
		System.out.println("coordA.middle(coordB).valueString()): " + coordA.middle(coordB).valueString());
		System.out.println("CoordinateND.middle(coordA, coordB).valueString(): " + CoordinateND.middle(coordA, coordB).valueString());
	}
	static int randomValue(int maxValue){
	    switch((int)(Math.random() * (5))) {
	    case 1:
	        return (int)Math.ceil(maxValue * 0.7);
	    case 2:
	        return (int)Math.ceil(maxValue * 0.9);
	    case 3, 4, 5:
	        return maxValue;
	    default:
	        return 0;
	    }
	}
}

class CoordinateND {
    Direction direction;
    int degrees;
    int minutes;
    int seconds;
    public CoordinateND(){
        this.direction = Direction.N;
        this.degrees = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
    public CoordinateND(Direction direction, int degrees, int minutes, int seconds){
    	if (seconds < 0) {
    		throw new RuntimeException("Seconds value is too small.");
    	}
    	if (seconds > 59) {
    		throw new RuntimeException("Seconds value is too big.");
    	}
    	if (minutes < 0) {
    		throw new RuntimeException("Minutes value is too small.");
    	}
    	if (minutes > 59) {
    		throw new RuntimeException("Minutes value is too big.");
    	}
    	if (degrees < -180 || (degrees == -180 && (minutes > 0 || seconds > 0))) {
    		throw new RuntimeException("Degrees value is too small.");
    	}
    	if (degrees > 180 || (degrees == 180 && (minutes > 0 || seconds > 0))) {
    		throw new RuntimeException("Degrees value is too big.");
    	}
        if ((direction == Direction.W || direction == Direction.E)) {
        	if (degrees < -90|| (degrees == -90 && (minutes > 0 || seconds > 0))) {
        		throw new RuntimeException("Degrees value is too small for direction " + 
        	direction + ".");
        	}
        	if (degrees > 90 || (degrees == 90 && (minutes > 0 || seconds > 0))) {
        		throw new RuntimeException("Degrees value is too big for direction " + 
        	        	direction + ".");
        	}
        }
        this.direction = direction;
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public String valueString(){
        return this.degrees + "°" + this.minutes + "′" + this.seconds + "″ " + this.direction + "”";
    }

    public String valueStringFloat(){
        return ((float)this.degrees + (float)this.minutes / 60 + (float)this.seconds / 3600) +
                "° " + this.direction + "”";
    }

    public CoordinateND middle(CoordinateND input){
        if (input.direction != this.direction){
            return null;
        }
        int degrees = this.degrees + input.degrees;
        int minutes = this.minutes + input.minutes;
        int seconds = this.seconds + input.seconds;
        if (seconds >= 60) {
        	seconds -= 60;
        	minutes += 1;
        }
        if (minutes >= 60) {
        	minutes -= 60;
        	degrees += 1;
        }
        if (degrees % 2 == 1) {
        	degrees -= 1;
        	minutes += 60;
        }
        if (minutes % 2 == 1) {
        	minutes -= 1;
        	seconds += 60;
        }
        degrees /= 2;
        minutes /= 2;
        seconds /= 2;
        return new CoordinateND(this.direction, degrees, minutes, seconds);
    }
    public static CoordinateND middle(CoordinateND a, CoordinateND b){
    	if (a.direction != b.direction){
            return null;
        }
        int degrees = a.degrees + b.degrees;
        int minutes = a.minutes + b.minutes;
        int seconds = a.seconds + b.seconds;
        if (seconds >= 60) {
        	seconds -= 60;
        	minutes += 1;
        }
        if (minutes >= 60) {
        	minutes -= 60;
        	degrees += 1;
        }
        if (degrees % 2 == 1) {
        	degrees -= 1;
        	minutes += 60;
        }
        if (minutes % 2 == 1) {
        	minutes -= 1;
        	seconds += 60;
        }
        degrees /= 2;
        minutes /= 2;
        seconds /= 2;
    	return new CoordinateND(a.direction, degrees, minutes, seconds);
    }
}
enum Direction{
    N,
    S,
    W,
    E
}

