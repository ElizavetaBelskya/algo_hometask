package src.main.java;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class HospitalQueue {

    public static void main(String[] args) {
        Queue<Patient> hospitalQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            hospitalQueue.add(new Patient(scanner.nextInt(), scanner.nextInt()));
        }
        Patient currentPatient = hospitalQueue.poll();
        for (int i = 0; i < m; i++) {
            int newPatientTime = scanner.nextInt();
            int newPatientId = scanner.nextInt();
            while (currentPatient != null && currentPatient.getTime() < newPatientTime) {
                System.out.print(currentPatient.getId());
                System.out.print(' ');
                currentPatient = hospitalQueue.poll();
            }
            System.out.print(newPatientId);
            System.out.print(' ');
        }
    }


    private static class Patient implements Comparable<Patient> {
        private int time;
        private int id;
        public Patient(int time, int id) {
            this.time = time;
            this.id = id;
        }
        public int getId() {
            return id;
        }
        public int getTime() {
            return time;
        }

        @Override
        public int compareTo(Patient p) {
            return this.time - p.getTime();
        }
    }

}

